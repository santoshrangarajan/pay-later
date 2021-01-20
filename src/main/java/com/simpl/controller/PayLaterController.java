package com.simpl.controller;

import com.simpl.request.PayLaterDiscountReportRequest;
import com.simpl.request.PayLaterDuesReportRequest;
import com.simpl.request.PayLaterMerchantRequest;
import com.simpl.request.PayLaterPaybackRequest;
import com.simpl.request.PayLaterRequest;
import com.simpl.request.PayLaterTotalDuesReportRequest;
import com.simpl.request.PayLaterTxnRequest;
import com.simpl.request.PayLaterUserRequest;
import com.simpl.request.PayLaterUsersCreditLimitReportRequest;
import com.simpl.response.SimplResponse;
import com.simpl.response.cli.CLIResponse;

public interface PayLaterController {	
	
	default public SimplResponse processRequest(PayLaterRequest payLaterRequest) throws Exception {
		
		if (payLaterRequest instanceof PayLaterUserRequest) {
			return processAddUserRequest(payLaterRequest);
		} else if (payLaterRequest instanceof PayLaterMerchantRequest) {
			return processAddMerchantRequest(payLaterRequest);
		} else if (payLaterRequest instanceof PayLaterTxnRequest) {
			return processTxnRequest( payLaterRequest);
		} else if (payLaterRequest instanceof PayLaterPaybackRequest) {
			return processPayBackRequest(payLaterRequest);
		}  else if (payLaterRequest instanceof PayLaterDiscountReportRequest) {
			return processDiscountReportRequest(payLaterRequest);
		}  else if (payLaterRequest instanceof PayLaterDuesReportRequest) {
			return processDuesReportRequest(payLaterRequest);
		}  else if (payLaterRequest instanceof PayLaterTotalDuesReportRequest) {
			return processTotalDuesReportRequest(payLaterRequest);
		} else if (payLaterRequest instanceof PayLaterUsersCreditLimitReportRequest) {
			return processUserCreditLimitReportRequest(payLaterRequest);
		} else {
			throw new Exception ("Cannot idetify command/request");
		}
		
	}
	
	public SimplResponse processAddUserRequest(PayLaterRequest payLaterRequest);
	public SimplResponse processAddMerchantRequest(PayLaterRequest payLaterRequest);
	public SimplResponse processTxnRequest(PayLaterRequest payLaterRequest);
	public SimplResponse processPayBackRequest(PayLaterRequest payLaterRequest);
	public SimplResponse processDiscountReportRequest(PayLaterRequest payLaterRequest);
	public SimplResponse processTotalDuesReportRequest(PayLaterRequest payLaterRequest);
	public SimplResponse processDuesReportRequest(PayLaterRequest payLaterRequest);
	public SimplResponse processUserCreditLimitReportRequest(PayLaterRequest payLaterRequest);
}
