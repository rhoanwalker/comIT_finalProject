package com.comit.web.classes;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Person {
	private String firstname;
	private String lastname;
	private Date dob;
	private String gender;
	
	public Person(String firstname, String lastname, Date dob, String gender) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.dob = dob;
		this.gender = gender;
	}
	
	public Person(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getFormattedDOB() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		
		return df.format(dob);
	}
	
	public String getFullName( ) {
		return firstname + " " + lastname;
	}
}
