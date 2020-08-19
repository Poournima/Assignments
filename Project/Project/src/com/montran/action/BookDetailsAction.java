package com.montran.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.montran.dao.BookDAO;
import com.montran.pojo.Book_issue_return;
import com.montran.pojo.Member_master;
import com.montran.pojo.*;

public class BookDetailsAction extends Action{

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
				System.out.println("in execute");
				BookDAO dao = new BookDAO();
				Member_master member=new Member_master();
				Book_master book=new Book_master();
				List<Book_issue_return> bookList = dao.getAllDetails();
				request.setAttribute("books", bookList);
				return mapping.findForward("success");
}
}