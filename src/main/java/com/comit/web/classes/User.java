package com.comit.web.classes;

public class User {
	
	private int uid;
	private int memberId;
	private String uname;
	private String pword;
	private String utype;
	private String fname;
	private String lname;
	private boolean isActive = true;
	
	public User() {}
	
	public User(int uid, int memberId, String uname, String pword, String utype, String fname, String lname, boolean isActive) {
		this.uid = uid;
		this.memberId = memberId;
		this.uname = uname;
		this.pword = pword;
		this.utype = utype;
		this.fname = fname;
		this.lname = lname;
		this.isActive = isActive;
	}
	
	public User (int uid, int memberId, String uname, String pword, String utype, String fname, String lname) {
		this.memberId = memberId;
		this.uname = uname;
		this.pword = pword;
		this.utype = utype;	
		this.fname = fname;
		this.lname = lname;
	}
	
	public User (int memberId, String uname, String pword, String utype) {
		this.memberId = memberId;
		this.uname = uname;
		this.pword = pword;
		this.utype = utype;		
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPword() {
		return pword;
	}

	public void setPword(String pword) {
		this.pword = pword;
	}

	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
