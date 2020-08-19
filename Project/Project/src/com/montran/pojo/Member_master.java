package com.montran.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Member_master")
public class Member_master {
	@Id
	@Column(name = "Member_Id")
	private int memberId;

	@Column(name = "Member_name")
	private String memberName;

	@Column(name = "Member_type")
	private String memberType;

	@Column(name = "No_of_copies")
	private int noofCopies;

	@Column(name = "Book_limit")
	private int bookLimit;

	public Member_master() {
		// TODO Auto-generated constructor stub
	}

	public Member_master(int memberId, String memberName, String memberType, int noofCopies, int bookLimit) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberType = memberType;
		this.noofCopies = noofCopies;
		this.bookLimit = bookLimit;
	}

	public int getMemberId() {
		return memberId;
	}

	public int setMemberId(int memberId) {
		return this.memberId = memberId;
	}

	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public int getNoofCopies() {
		return noofCopies;
	}

	public void setNoofCopies(int noofCopies) {
		this.noofCopies = noofCopies;
	}

		public int getBookLimit() {
		return bookLimit;
	}

	public void setBookLimit(int bookLimit) {
		this.bookLimit = bookLimit;
	}

	@Override
	public String toString() {
		return "Member_master [memberId=" + memberId + ", memberName=" + memberName + ", memberType=" + memberType
				+ ", noofCopies=" + noofCopies + ", bookLimit=" + bookLimit + "]";
	}

	

}
