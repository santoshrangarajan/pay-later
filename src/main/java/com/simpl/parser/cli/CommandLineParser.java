package com.simpl.parser.cli;

import java.util.List;

import com.simpl.parser.Command;
import com.simpl.parser.CommandParser;
import com.simpl.request.PayLaterDiscountReportRequest;
import com.simpl.request.PayLaterDuesReportRequest;
import com.simpl.request.PayLaterMerchantRequest;
import com.simpl.request.PayLaterPaybackRequest;
import com.simpl.request.PayLaterRequest;
import com.simpl.request.PayLaterTotalDuesReportRequest;
import com.simpl.request.PayLaterTxnRequest;
import com.simpl.request.PayLaterUserRequest;
import com.simpl.request.PayLaterUsersCreditLimitReportRequest;

public class CommandLineParser implements CommandParser {

	

	/*@Override
	public PayLaterRequest parseRequest(Request request) throws Exception {
		// TODO Auto-generated method stub
		
		CLIRequest clRequest = (CLIRequest)request;
	    String contents = clRequest.getContents();
	 
	    if(contents.startsWith("new user")) {
	    	return processNewUserRequest(clRequest);
	    } else if (contents.startsWith("new merchant")) {
	    	return processNewMerchantRequest(clRequest);
	    } else if (contents.startsWith("new txn")) {
	    	return processNewTxnRequest(clRequest);
	    } else if (contents.startsWith("update merchant")) {
	    	return processUpdateMerchantRequest(clRequest);
	    } else if (contents.startsWith("payback")) {
	    	return processPayRequestRequest(clRequest);
	    } else if (contents.startsWith("report discount")) {
	    	return processDiscountReport(clRequest);
	    } else if (contents.startsWith("report dues")) {
	    	return processDuesReport(clRequest);
	    } else if (contents.startsWith("report total-dues")) {
	    	return processTotalDuesReport(clRequest);
	    } else if (contents.startsWith("report users-at-credit-limit"))  {
	       return 	processUsersCreditLimitReport(clRequest);
	    }
	    
	    
	
	   return null;
	};
	*/
	
	public PayLaterRequest processDiscountReport(Command command) throws Exception {
		List<String> tokensList = command.getTokensList();
		PayLaterDiscountReportRequest simplNewDiscountReportRequest = new PayLaterDiscountReportRequest();
		simplNewDiscountReportRequest.setMerchantName(tokensList.get(2));
		
		return simplNewDiscountReportRequest;
	}
	
	public PayLaterRequest processDuesReport(Command command) throws Exception {
		List<String> tokensList = command.getTokensList();
		PayLaterDuesReportRequest simplDuesReportRequest = new PayLaterDuesReportRequest();
		simplDuesReportRequest.setUserName(tokensList.get(2));;
		
		return simplDuesReportRequest;
	}
	
	public PayLaterRequest processTotalDuesReport(Command command) throws Exception {
		PayLaterTotalDuesReportRequest simplTotalDuesReportRequest = new PayLaterTotalDuesReportRequest();
		return simplTotalDuesReportRequest;
	}
	
	public PayLaterRequest processUsersCreditLimitReport(Command command) throws Exception {
		PayLaterUsersCreditLimitReportRequest simplUsersCreditLimitReportRequest = new PayLaterUsersCreditLimitReportRequest();
		return simplUsersCreditLimitReportRequest;
	}
	
	
	
	public PayLaterRequest processNewMerchantCommand(Command command) throws Exception {
		 List<String> tokensList = command.getTokensList();
		 
		 PayLaterMerchantRequest simplNewMerchantRequest = new PayLaterMerchantRequest();
		 simplNewMerchantRequest.setName(tokensList.get(2));
		 simplNewMerchantRequest.setDiscount(Double.valueOf(tokensList.get(4).replace("%", "")));
		 simplNewMerchantRequest.setOpType("NEW");
		 
		return simplNewMerchantRequest;	 
	}
	
	public PayLaterRequest processNewTxnCommand(Command command) throws Exception {
		 List<String> tokensList = command.getTokensList();
		 
		 PayLaterTxnRequest simplTxnRequest = new PayLaterTxnRequest();
		 simplTxnRequest.setUserName((tokensList.get(2)));
		 simplTxnRequest.setMerchantName((tokensList.get(3)));
		 simplTxnRequest.setAmount(Double.valueOf(tokensList.get(4)));
		
		 return simplTxnRequest;	 
	}
	
	
	public PayLaterRequest processUpdateMerchantCommand(Command command) throws Exception {
		    List<String> tokensList = command.getTokensList();
		 
		 	PayLaterMerchantRequest simplNewMerchantRequest = new PayLaterMerchantRequest();
		 	simplNewMerchantRequest.setName(tokensList.get(2));
		 	simplNewMerchantRequest.setDiscount(Double.valueOf(tokensList.get(2)));
		 	simplNewMerchantRequest.setOpType("UPDATE");
		 	
		  return simplNewMerchantRequest;	 
	   	}
	 
	public PayLaterRequest processNewUserCommand(Command command) throws Exception {
				
	     List<String> tokensList = command.getTokensList();
	     
	     PayLaterUserRequest simplNewUserRequest = new PayLaterUserRequest();
	     simplNewUserRequest.setUserName(tokensList.get(2));
	     simplNewUserRequest.setEmail((tokensList.get(3)));
	     simplNewUserRequest.setCreditLimit(Double.valueOf(tokensList.get(4)));
	     simplNewUserRequest.setOpType("NEW");
	     return simplNewUserRequest;     
	}
	
	public PayLaterRequest processPayRequestCommand(Command command) throws Exception {
		
	     List<String> tokensList = command.getTokensList();
	     
	     PayLaterPaybackRequest simplPaybackRequest = new PayLaterPaybackRequest();
	     simplPaybackRequest.setUserName(tokensList.get(1));
	     simplPaybackRequest.setAmountDouble(Double.valueOf(tokensList.get(2)));
	    
	     return simplPaybackRequest;     
	}
	
   
   
    
    

}
