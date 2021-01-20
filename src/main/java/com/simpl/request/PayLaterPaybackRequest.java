package com.simpl.request;

public class PayLaterPaybackRequest implements PayLaterRequest {
	
	private String userName;
	private Double amountDouble;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Double getAmountDouble() {
		return amountDouble;
	}

	public void setAmountDouble(Double amountDouble) {
		this.amountDouble = amountDouble;
	}
	
	
	

}
