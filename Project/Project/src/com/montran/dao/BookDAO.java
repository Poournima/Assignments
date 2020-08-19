package com.montran.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.montran.pojo.Book_issue_return;
import com.montran.pojo.Book_master;
import com.montran.pojo.Member_master;
import com.montran.util.SessionFactoryUtil;

public class BookDAO {
	private Session session;
	private Transaction transaction;
	private SessionFactory factory = SessionFactoryUtil.getFactory();

	public List<Book_issue_return> getAllDetails() {
		session = factory.openSession();
		Query query = session.createQuery("from Book_issue_return");
		List<Book_issue_return> bookList = query.list();
		session.close();
		return bookList;
	}

	public int issueNewBook(Book_issue_return issue) {
		if (SessionFactoryUtil.getFactory() != null) {
			session = SessionFactoryUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			session.save(issue);
			transaction.commit();
			session.close();
		}
		return 0;

	}

	public boolean updateBookdetails(Book_issue_return issue_return) {
		if (SessionFactoryUtil.getFactory() != null) {
			session = SessionFactoryUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(issue_return);
			transaction.commit();
			session.close();
			return true;

		}
		return false;
	}
	
	
	public boolean updateMember(Member_master member) {
		if (SessionFactoryUtil.getFactory() != null) {
			session = SessionFactoryUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(member);
			transaction.commit();
			session.close();
			return true;

		}
		return false;
		
	}

	public boolean updateBook(Book_master book) {
		if (SessionFactoryUtil.getFactory() != null) {
			session = SessionFactoryUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			session.update(book);
			transaction.commit();
			session.close();
			return true;

		}
		return false;
		
	}

	
	public Member_master getMember(int memberId) {
		if (SessionFactoryUtil.getFactory() != null) {
			session = SessionFactoryUtil.getFactory().openSession();
			Member_master member = session.find(Member_master.class, memberId);
			session.close();
			return member;
		}
		return null;
	}

	public Book_master getBookId(String bookId) {
		session = SessionFactoryUtil.getFactory().openSession();
		Book_master book = session.find(Book_master.class, bookId);
		session.close();
		return book;
	}

	public Book_issue_return getIssueId(int issueId) {
		session = SessionFactoryUtil.getFactory().openSession();
		Book_issue_return issue = session.find(Book_issue_return.class, issueId);
		session.close();
		return issue;

	}
	
	public int getMax() {
		session = SessionFactoryUtil.getFactory().openSession();
		Query query = session.createQuery("select max(issueId) from Book_issue_return");
		List<Integer> issueList = query.list();
		int maxCount = issueList.get(0);
		System.out.println("Total Books :: " + maxCount);
		session.close();

		return maxCount + 1;
		
		
	}

	public int deleteIssueBook(String bookId) {
		session = factory.openSession();
		transaction = session.beginTransaction();
		Query query = session.createQuery("delete from Book_issue_return where Book_id=:id");
		query.setParameter("id", bookId);
		int result = query.executeUpdate();
		transaction.commit();
		session.close();
		return result;
	}
}
