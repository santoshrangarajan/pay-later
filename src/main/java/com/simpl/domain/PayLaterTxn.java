package com.simpl.domain;

public class PayLaterTxn {

	private String referenceNo;
	private User user;
	private Merchant merchant;
	private String dateTime;
	private double perDiscount;
	private double absDiscount;
	private double payBack;
	
	

	public PayLaterTxn(String referenceNo, User user, Merchant merchant, String dateTime, 
			Double perDiscount, Double absDiscount, Double payBack) {
		super();
		this.referenceNo = referenceNo;
		this.user = user;
		this.merchant = merchant;
		this.dateTime = dateTime;
		this.perDiscount = perDiscount;
		this.absDiscount = absDiscount;
		this.payBack = payBack;
		
	}
	
	
	
	public double getPayBack() {
		return payBack;
	}



	public void setPayBack(double payBack) {
		this.payBack = payBack;
	}



	public double getPerDiscount() {
		return perDiscount;
	}



	public void setPerDiscount(double perDiscount) {
		this.perDiscount = perDiscount;
	}



	public double getAbsDiscount() {
		return absDiscount;
	}



	public void setAbsDiscount(double absDiscount) {
		this.absDiscount = absDiscount;
	}



	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Merchant getMerchant() {
		return merchant;
	}
	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
	
}
