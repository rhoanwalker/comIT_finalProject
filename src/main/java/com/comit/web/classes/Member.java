package com.comit.web.classes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Member extends Person {
	private int memberID;
	private Date memberStartDate;
	private Date memberEndDate;
	private String memberEmail;
	private String memberPhoneNo;
	
	public Member(int memberID, Date memberStartDate, 
			String memberEmail, String memberPhoneNo,
			String firstname, String lastname, Date dob, String gender) {
		
		super(firstname, lastname, dob, gender);
		
		this.memberID = memberID;
		this.memberStartDate = memberStartDate;
		this.memberEmail = memberEmail;
		this.memberPhoneNo = memberPhoneNo;
	}
	
	public Member(Date memberStartDate, 
			String memberEmail, String memberPhoneNo,			
			String firstname, String lastname, Date dob, String gender) {
		
		super(firstname, lastname, dob, gender);

		this.memberStartDate = memberStartDate;
		this.memberEmail = memberEmail;
		this.memberPhoneNo = memberPhoneNo;
	}
	
	public Member(int memberID, String firstname, String lastname) {
		super(firstname, lastname);
		
		this.memberID = memberID;
	}

	public int getMemberID() {
		return memberID;
	}

	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}

	public Date getMemberStartDate() {
		return memberStartDate;
	}

	public void setMemberStartDate(Date memberStartDate) {
		this.memberStartDate = memberStartDate;
	}

	public Date getMemberEndDate() {
		return memberEndDate;
	}

	public void setMemberEndDate(Date memberEndDate) {
		this.memberEndDate = memberEndDate;
	}
	
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	
	public String getMemberEmail() {
		return memberEmail;
	}
	
	public void setMemberPhoneNo(String memberPhoneNo) {
		this.memberPhoneNo = memberPhoneNo;
	}
	
	public String getMemberPhoneNo() {
		return memberPhoneNo;
	}
	
	public String getFormattedMemberStartDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		return df.format(memberStartDate);
	}
	
	public String getFormattedMemberEndDate() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		return df.format(memberEndDate);
	}

}
