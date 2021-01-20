package com.simpl.request;

public class PayLaterDiscountReportRequest implements PayLaterRequest{

	private String merchantName;

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	
	
}
