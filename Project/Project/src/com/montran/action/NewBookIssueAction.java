package com.montran.action;

import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.montran.dao.BookDAO;
import com.montran.form.BookDetailsForm;
import com.montran.pojo.Book_issue_return;
import com.montran.pojo.Book_master;
import com.montran.pojo.Member_master;

public class NewBookIssueAction extends Action {

	int memberId;
	String bookId;

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("in execute");
		BookDAO dao = new BookDAO();
		BookDetailsForm bookForm = (BookDetailsForm) form;
		Book_issue_return issue = new Book_issue_return();
		Book_master book;
		Member_master member;
		ActionErrors errors = new ActionErrors();
		Date date;
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		Calendar cal = Calendar.getInstance();
		bookForm.setIssueId(dao.getMax());
		System.out.println("Object is created");

		if (request.getParameter("getMemberDetails") != null) {
			if (request.getParameter("getMemberDetails").equals("getMember")) {
				System.out.println("in member");
				System.out.println(bookForm.getBookId());
				member = dao.getMember(bookForm.getMemberId());
				if (member == null) {
					errors.add("common.memberId", new ActionMessage("error.common.memberId.required"));
				} else {
					bookForm.setMemberId(member.getMemberId());
					bookForm.setMemberName(member.getMemberName());
				}
				return mapping.findForward("success");
			}
		}
		if (request.getParameter("getBookDetails") != null) {
			if (request.getParameter("getBookDetails").equals("getBook")) {
				book = dao.getBookId(bookForm.getBookId());
				if (book == null) {
					errors.add("common.bookId", new ActionMessage("error.common.bookId.required"));
				} else {
					bookForm.setBookId(book.getBookId());
					bookForm.setBookName(book.getBookName());
				}
				return mapping.findForward("success");
			}
		}

		if (request.getParameter("getDetails") != null) {
			member = dao.getMember(bookForm.getMemberId());
			book = dao.getBookId(bookForm.getBookId());
			if (book == null) {
				errors.add("common.bookId", new ActionMessage("error.common.bookId.required"));
			}
			if (member == null) {
				errors.add("common.memberId", new ActionMessage("error.common.memberId.required"));

			}
			if (book.getIssueStatus() == "No") {
				errors.add("common.bookIssueStatus", new ActionMessage("error.common.bookNotIssuable.required"));
			} else {
//				if (member.getNoofCopies() >= member.getBookLimit()) {
//					errors.add("common.bookCount", new ActionMessage("error.common.bookCount.required"));
//				} else {
					date = (Date) sdf.parse(String.valueOf(bookForm.getIssueDate()));
					cal.setTime(date);
					int day = cal.get(cal.DATE);
					cal.set(cal.DATE, day);
					day = cal.get(Calendar.DATE) + 10;
					int month = cal.get(Calendar.MONTH);
					int year = cal.get(Calendar.YEAR);
					String issuedate = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
					bookForm.setReturnDate((issuedate));

					member.setMemberId(bookForm.getMemberId());
					member.setNoofCopies(member.getNoofCopies() + 1);

					book.setBookId(bookForm.getBookId());
					issue.setIssueId(bookForm.getIssueId());
					issue.setMember(bookForm.getMember());
					issue.setBook(bookForm.getBook());
					
					issue.setIssueDate(sdf.parse(bookForm.getIssueDate()));
					issue.setReturnDate(sdf.parse(bookForm.getReturnDate()));

					dao.issueNewBook(issue);
					System.out.println(issue);
					return mapping.findForward("success");

				// }
			}
		}

		System.out.println("Data added Successfully");
		return mapping.findForward("success");
	}
}