package com.montran.action;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionRedirect;

import com.montran.dao.BookDAO;
import com.montran.form.BookDetailsForm;
import com.montran.pojo.Book_issue_return;
import com.montran.pojo.Book_master;
import com.montran.pojo.Member_master;

public class UpdateBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BookDAO dao = new BookDAO();
		BookDetailsForm bookForm = (BookDetailsForm) form;
		System.out.println("Object is created");
		Book_issue_return issue = null;
		Book_master book;
		Member_master member = null;

		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		if (request.getParameter("updateBook") != null) {

			issue = dao.getIssueId(bookForm.getIssueId());
			Date issue_date = formatter.parse(String.valueOf(bookForm.getIssueDate()));
			System.out.println("in if condition");
			if (member.getMemberType().equals("Faculty")) {
				{

					calendar.setTime(issue_date);
					int day = calendar.get(Calendar.DATE);
					int month = calendar.get(Calendar.MONTH);
					calendar.set(Calendar.MONTH, month + 4);
					month = calendar.get(Calendar.MONTH);
					int year = calendar.get(Calendar.YEAR);
					String issuedate = String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
					bookForm.setReturnDate((issuedate));
				}
			} else {

				calendar.setTime(issue_date);
				int day = calendar.get(Calendar.DATE);
				calendar.set(Calendar.DATE, day);
				day = calendar.get(Calendar.DATE) + 10;
				int month = calendar.get(Calendar.MONTH);
				int year = calendar.get(Calendar.YEAR);
				String issuedate = String.valueOf(day) + "-" + String.valueOf(month) + "-" + String.valueOf(year);
				bookForm.setReturnDate((issuedate));
			}

			issue.getMember().getMemberId();
			issue.getMember().getMemberName();
			issue.getBook().getBookId();
			issue.getBook().getBookName();
			issue.setReturnDate(formatter.parse(bookForm.getReturnDate()));
			issue.setIssueDate(issue_date);
			dao.updateBookdetails(issue);
			return mapping.findForward("success");

		}
		return null;

	}

}
