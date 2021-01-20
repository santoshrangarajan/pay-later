package com.simpl.controller.cli;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.simpl.controller.PayLaterController;
import com.simpl.domain.Merchant;
import com.simpl.domain.User;
import com.simpl.paylater.service.ValidatationService;
import com.simpl.paylater.service.merchant.MerchantService;
import com.simpl.paylater.service.reports.ReportsService;
import com.simpl.paylater.service.txn.TxnService;
import com.simpl.paylater.service.user.UserService;
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

public class CLIController  implements PayLaterController {

	
	private MerchantService merchantService;
	private UserService userService;
	private TxnService txnService;
	private ValidatationService validationService;
	private ReportsService reportsService;
	
	public CLIController(MerchantService merchantService,
	                           UserService userService,
	                           TxnService txnService,
	                           ValidatationService validationService,
	                           ReportsService reportsService) {
		
		this.merchantService = merchantService;
		this.userService =  userService;
		this.txnService = txnService;
		this.validationService=validationService;
		this.reportsService=reportsService;
	}
	
	
	
	
	private boolean addUser(PayLaterUserRequest simplNewUserReqeuest) {
		// TODO Auto-generated method stub
		boolean doesUserExist = validationService.doesUserExist(simplNewUserReqeuest.getUserName());
		if(doesUserExist) {
			return false;
		} else {
			userService.onBoard(simplNewUserReqeuest);
			return true;
		}
	
		
	}

	
	private void addMerchant() {
		// TODO Auto-generated method stub
		
	}

	
	private void processTxn() {
		// TODO Auto-generated method stub
		
	}

	
	private void processReport() {
		// TODO Auto-generated method stub
		
	}



	@Override
	public SimplResponse processRequest(PayLaterRequest payLaterRequest) {
		// TODO Auto-generated method stub
		CLIResponse cliResponse = new CLIResponse();
		
		if (payLaterRequest instanceof PayLaterUserRequest) {
			
			PayLaterUserRequest payLaterUserRequest =  (PayLaterUserRequest)payLaterRequest;
			boolean userExists = validationService.doesUserExist(payLaterUserRequest.getUserName());
			
			if(userExists) {
				cliResponse.setContents("Error.User already present");
				return cliResponse;
			}
			
			User user = userService.onBoard((PayLaterUserRequest)payLaterRequest);
			cliResponse.setContents(user.toString());
			return cliResponse;
			
		} else if (payLaterRequest instanceof PayLaterMerchantRequest) {
			
			PayLaterMerchantRequest simpleMerchantRequest = (PayLaterMerchantRequest)payLaterRequest;
			
			boolean merchantExists = validationService.doesMerchantExist(simpleMerchantRequest.getName());
			
			if(merchantExists && simpleMerchantRequest.getOpType().equals("NEW")) {
				cliResponse.setContents("Error.Merchant already present");
				return cliResponse;
			}
			
			if((!merchantExists) && simpleMerchantRequest.getOpType().equals("UPDATE")) {
				cliResponse.setContents("Error.Merchant NOT present");
				return cliResponse;
			}
			
			Merchant merchant = simpleMerchantRequest.getOpType().equals("NEW")
					? merchantService.onBoard(simpleMerchantRequest)
					: merchantService.updateDiscounts(simpleMerchantRequest);
			cliResponse.setContents(merchant.toString());
			
		}  else if (payLaterRequest instanceof PayLaterTxnRequest) {
			
			PayLaterTxnRequest simpleTxnRequest = (PayLaterTxnRequest)payLaterRequest;
			
			boolean userExists =  validationService.doesUserExist(simpleTxnRequest.getUserName());
			if(!userExists) {
				cliResponse.setContents("Error.User not present");
				return cliResponse;
			}
			
			boolean merchantExists =  validationService.doesMerchantExist(simpleTxnRequest.getMerchantName());
			if(!merchantExists) {
				cliResponse.setContents("Error.Merchant not present");
				return cliResponse;
			}
			
			boolean creditExists = validationService.doesUserHaveCredit(simpleTxnRequest.getUserName(), simpleTxnRequest.getAmount());
			if(!creditExists) {
				cliResponse.setContents("Error.Insufficient Credit");
				return cliResponse;
			}
			
			txnService.processTxn(simpleTxnRequest.getUserName(),
					simpleTxnRequest.getMerchantName(), simpleTxnRequest.getAmount());
			
			cliResponse.setContents("SUCCESS!");
			
		}  else if (payLaterRequest instanceof PayLaterPaybackRequest) {
			
			PayLaterPaybackRequest simplPaybackRequest = (PayLaterPaybackRequest)payLaterRequest;
			boolean userExists =  validationService.doesUserExist(simplPaybackRequest.getUserName());
			if(!userExists) {
				cliResponse.setContents("Error.User not present");
				return cliResponse;
			}
			
			User user = userService.payBack(simplPaybackRequest.getUserName(), simplPaybackRequest.getAmountDouble());
			cliResponse.setContents(user.toString());
			
		}
		else if (payLaterRequest instanceof PayLaterDiscountReportRequest) {
			PayLaterDiscountReportRequest simplDiscountReportRequest = (PayLaterDiscountReportRequest)payLaterRequest;
			Double discount = reportsService.processDiscountReports(simplDiscountReportRequest);
			cliResponse.setContents(Double.toString(discount));
			
		} else if (payLaterRequest instanceof PayLaterDuesReportRequest) {
			PayLaterDuesReportRequest simplDuesReportRequest = (PayLaterDuesReportRequest)payLaterRequest;
			Double dues = reportsService.processDuesReports(simplDuesReportRequest);
			cliResponse.setContents(Double.toString(dues));
			
		} else if (payLaterRequest instanceof PayLaterTotalDuesReportRequest) {
			PayLaterTotalDuesReportRequest simplTotalDuesReportRequest = (PayLaterTotalDuesReportRequest)payLaterRequest;
			List<User> userList = reportsService.processTotalDuesReport(simplTotalDuesReportRequest);
			
			String users = userList.stream()
				       .map(u-> u.getName()+":"+u.getDues())
				       .collect(Collectors.toList())
				       .stream()
				       .collect(Collectors.joining(","));
		
		    cliResponse.setContents(users);
		
			//cliResponse.setContents(Double.toString(dues));
		} else if (payLaterRequest instanceof PayLaterUsersCreditLimitReportRequest) {
			
			//SimplUsersCreditLimitReportRequest simplTotalDuesReportRequest = (SimplTotalDuesReportRequest)simplRequest;
			List<User> userList = reportsService.processUsersCreditLimitReport();
		
			String users = userList.stream()
					       .map(u-> u.getName())
					       .collect(Collectors.toList())
					       .stream()
					       .collect(Collectors.joining(","));
			
			cliResponse.setContents(users);
		}
		
		
		
		return cliResponse;
		
	}

}
