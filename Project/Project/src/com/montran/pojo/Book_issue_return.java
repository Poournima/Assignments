package com.montran.pojo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity(name="Book_issue_return")
public class Book_issue_return {
	@Id
	@Column(name = "Issue_Id")
	private int issueId;
	
	@Column(name = "issue_date")
	private Date issueDate;
	
	@Column(name = "return_date")
	private Date returnDate;

	@Column(name = "fine")
	private double fine;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Book_id")
	private Book_master book;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="Member_id")
	private Member_master member;
	
	public Book_issue_return() {
		// TODO Auto-generated constructor stub
	}

	public Book_issue_return(int issueId, Date issueDate, Date returnDate, double fine, Book_master book,
			Member_master member) {
		super();
		this.issueId = issueId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.fine = fine;
		this.book = book;
		this.member = member;
	}

	public int getIssueId() {
		return issueId;
	}

	public int setIssueId(int issueId) {
		return this.issueId = issueId;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public Date setIssueDate(Date issueDate) {
		return this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public Date setReturnDate(Date date) {
		return this.returnDate = date;
	}

	public double getFine() {
		return fine;
	}

	public void setFine(double fine) {
		this.fine = fine;
	}

	public Book_master getBook() {
		return book;
	}

	public Book_master setBook(Book_master book) {
		return this.book = book;
	}

	public Member_master getMember() {
		return member;
	}

	public Member_master setMember(Member_master member) {
		return this.member = member;
	}

	@Override
	public String toString() {
		return "Book_issue_return [issueId=" + issueId + ", issueDate=" + issueDate + ", returnDate=" + returnDate
				+ ", fine=" + fine + ", book=" + book + ", member=" + member + "]";
	}
	
	
	

}
