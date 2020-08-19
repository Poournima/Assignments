package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="Book_master")
public class Book_master {
	@Id
	@Column(name = "Book_Id")
	private String bookId;
	
	@Column(name = "Book_name")
	private String bookName;
	
	@Column(name = "Book_count")
	private int bookCount;
	
	@Column(name = "Issue_status")
	private String issueStatus;
	
	public Book_master() {
		// TODO Auto-generated constructor stub
	}

	public Book_master(String bookId, String bookName, int bookCount, String issueStatus) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookCount = bookCount;
		this.issueStatus = issueStatus;
	}

	public String getBookId() {
		return bookId;
	}

	public String setBookId(String bookId) {
		this.bookId = bookId;
		return null;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getBookCount() {
		return bookCount;
	}

	public void setBookCount(int bookCount) {
		this.bookCount = bookCount;
	}

	public String getIssueStatus() {
		return issueStatus;
	}

	public void setIssueStatus(String issueStatus) {
		this.issueStatus = issueStatus;
	}

	@Override
	public String toString() {
		return "Book_master [bookId=" + bookId + ", bookName=" + bookName + ", bookCount=" + bookCount
				+ ", issueStatus=" + issueStatus + "]";
	}
	
	
}
