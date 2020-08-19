package com.montran.form;

import java.util.Date;

import org.apache.struts.action.ActionForm;

import com.montran.pojo.Book_master;
import com.montran.pojo.Member_master;

public class BookDetailsForm extends ActionForm{
	private int issueId;
	private String issueDate;
	private String returnDate;
	private double fine;
	private int memberId;
	private String bookId;
	private String bookName;
	private String memberName;
	private int noofCopies;
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getIssueId() {
		return issueId;
	}
	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}
	public String getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
	public String getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(String issuedate) {
		this.returnDate = issuedate;
	}
	public double getFine() {
		return fine;
	}
	public void setFine(double fine) {
		this.fine = fine;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	public int getNoofCopies() {
		return noofCopies;
	}
	public void setNoofCopies(int noofCopies) {
		this.noofCopies = noofCopies;
	}
	public Member_master getMember() {
		// TODO Auto-generated method stub
		return null;
	}
	public Book_master getBook() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
