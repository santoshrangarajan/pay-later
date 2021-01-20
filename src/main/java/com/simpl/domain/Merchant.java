package com.simpl.domain;

import com.simpl.request.PayLaterMerchantRequest;

public class Merchant {

	public Double discount;
	public String name;
	
	
	
	public Merchant(PayLaterMerchantRequest simplNewMerchantRequest) {
		super();
		this.discount = simplNewMerchantRequest.getDiscount();
		this.name = simplNewMerchantRequest.getName();
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name+"("+discount+"%)";
	}
	

	
}
