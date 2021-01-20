package com.simpl.domain;

import com.simpl.request.PayLaterUserRequest;

public class User {
	
	public  String name;
	public  String emailId;
	public  Double creditLimit;
	public Double dues;
	
	
	
	public User(String name, String emailId, Double creditLimit,Double dues) {
		super();
		this.name = name;
		this.emailId = emailId;
		this.creditLimit = creditLimit;
		this.dues = dues;
	}
	
	public User(PayLaterUserRequest simplNewUserRequest) {
		
		this.name= simplNewUserRequest.getUserName();
		this.emailId=simplNewUserRequest.getEmail();
		this.creditLimit=simplNewUserRequest.getCreditLimit();
		this.dues=0d;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Double getCreditLimit() {
		return creditLimit;
	}
	public void setCreditLimit(Double creditLimit) {
		this.creditLimit = creditLimit;
	}

	@Override
	public String toString() {
		return "name("+creditLimit+" )";
	}

	public Double getDues() {
		return dues;
	}

	public void setDues(Double dues) {
		this.dues = dues;
	}
	
	
	

}
