package com.simpl.parser;

import com.simpl.request.cli.CLICommand;
import com.simpl.request.PayLaterRequest;

public interface CommandParser {
	
	default public PayLaterRequest parseRequest(Command command) throws Exception{
		//CLICommand command = (CLICommand)command;
	    //String contents = command.getContents();
	 
	    if(command.getContents().startsWith("new user")) {
	    	return processNewUserCommand(command);
	    } else if (command.getContents().startsWith("new merchant")) {
	    	return processNewMerchantCommand(command);
	    } else if (command.getContents().startsWith("new txn")) {
	    	return processNewTxnCommand(command);
	    } else if (command.getContents().startsWith("update merchant")) {
	    	return processUpdateMerchantCommand(command);
	    } else if (command.getContents().startsWith("payback")) {
	    	return processPayRequestCommand(command);
	    } else if (command.getContents().startsWith("report discount")) {
	    	return processDiscountReport(command);
	    } else if (command.getContents().startsWith("report dues")) {
	    	return processDuesReport(command);
	    } else if (command.getContents().startsWith("report total-dues")) {
	    	return processTotalDuesReport(command);
	    } else if (command.getContents().startsWith("report users-at-credit-limit"))  {
	       return 	processUsersCreditLimitReport(command);
	    } else {
	    	throw new Exception("Unknow command");
	    }
	}
	
	public PayLaterRequest processDiscountReport(Command command) throws Exception;
	public PayLaterRequest processDuesReport(Command command) throws Exception;
	public PayLaterRequest processTotalDuesReport(Command command) throws Exception;
	public PayLaterRequest processUsersCreditLimitReport(Command command) throws Exception;
	public PayLaterRequest processNewMerchantCommand(Command command) throws Exception;
	public PayLaterRequest processNewTxnCommand(Command command) throws Exception;
	public PayLaterRequest processUpdateMerchantCommand(Command command) throws Exception;
	public PayLaterRequest processNewUserCommand(Command command) throws Exception;
	public PayLaterRequest processPayRequestCommand(Command command) throws Exception;

}
