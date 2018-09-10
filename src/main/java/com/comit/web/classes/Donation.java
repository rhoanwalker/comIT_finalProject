package com.comit.web.classes;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Donation {
	private int id;
	private String type;
	private int donor; //member id
	private Date donDate;
	private Double amount;
	
	public Donation(int id, String type, int donor, Date donDate, Double amount) {
		this.id = id;
		this.type = type;
		this.donor = donor;
		this.donDate = donDate;
		this.amount = amount;
	}
	
	public Donation(String type, int donor, Date donDate, Double amount) {
		this.type = type;
		this.donor = donor;
		this.donDate = donDate;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getDonor() {
		return donor;
	}

	public void setDonor(int donor) {
		this.donor = donor;
	}

	public Date getDonDate() {
		return donDate;
	}

	public void setDonDate(Date donDate) {
		this.donDate = donDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	public String getFormattedAmount( ) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		return df.format(amount);
	}
	
	public String getFormattedDonationDate() {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		
		return df.format(donDate);
	}	
	
}
