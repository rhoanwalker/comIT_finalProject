package com.comit.web.classes;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaxReceipt {
	private int invID;
	private int serialNo;
	private Date issueDate;
	private String name;
	private String address;
	private Double amount;
	private int taxYear;
	private String signedBy;
	
	
	public TaxReceipt(int invID, int serialNo, Date issueDate, String name, String address, Double amount, int taxYear,
			String signedBy) {

		this.invID = invID;
		this.serialNo = serialNo;
		this.issueDate = issueDate;
		this.name = name;
		this.address = address;
		this.amount = amount;
		this.taxYear = taxYear;
		this.signedBy = signedBy;
	}

	public int getInvID() {
		return invID;
	}

	public void setInvID(int invID) {
		this.invID = invID;
	}

	public int getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(int serialNo) {
		this.serialNo = serialNo;
	}


	public Date getIssueDate() {
		return issueDate;
	}


	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public int getTaxYear() {
		return taxYear;
	}

	public void setTaxYear(int taxYear) {
		this.taxYear = taxYear;
	}

	public String getSignedBy() {
		return signedBy;
	}

	public void setSignedBy(String signedBy) {
		this.signedBy = signedBy;
	}
	
	public String getFormattedAmount( ) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		return df.format(amount);
	}
	
	public String getFormattedIssueDate() {
		DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
		
		return df.format(issueDate);
	}
}
