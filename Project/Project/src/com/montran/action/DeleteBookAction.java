package com.montran.action;

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
import com.montran.pojo.Book_master;
import com.montran.pojo.Member_master;

public class DeleteBookAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		BookDetailsForm deleteForm = (BookDetailsForm) form;
		BookDAO dao = new BookDAO();
		Book_master bookId=dao.getBookId(deleteForm.getBookId());
		int result = dao.deleteIssueBook(deleteForm.getBookId());
		if (result > 0) {
			dao.updateBook(bookId);
		} else {
			ActionErrors errors = new ActionErrors();
			errors.add("bookCodeError", new ActionMessage("error.notFound"));
			saveErrors(request, errors);
			return mapping.findForward("failure");
		}
		return mapping.findForward("success");
	}
}