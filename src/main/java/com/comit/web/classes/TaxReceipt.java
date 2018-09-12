package com.comit.web.classes;

import java.text.DecimalFormat;

public class TaxReceipt {
	private int memberId;
	private String memberFName;
	private String memberLName;
	private Double amount;
	private int taxYear;
	
	
	public TaxReceipt(int memberId, String memberFName, String memberLName, Double amount, int taxYear) {

		this.memberId = memberId;
		this.memberFName = memberFName;
		this.memberLName = memberLName;
		this.amount = amount;
		this.taxYear = taxYear;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getMemberFName() {
		return memberFName;
	}

	public void setMemberFName(String memberFName) {
		this.memberFName = memberFName;
	}

	public String getMemberLName() {
		return memberLName;
	}

	public void setMemberLName(String memberLName) {
		this.memberLName = memberLName;
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
	
	public String getFormattedAmount( ) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		
		return df.format(amount);
	}
}
