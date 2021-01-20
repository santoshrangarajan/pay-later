package com.simpl;

import java.util.Scanner;

import com.simpl.controller.PayLaterController;
import com.simpl.controller.cli.CLIController;
import com.simpl.parser.Command;
import com.simpl.parser.CommandParser;
import com.simpl.parser.cli.CommandLineParser;
import com.simpl.paylater.repository.InMemoryRepositoryImpl;
import com.simpl.paylater.repository.PayLaterRepository;
import com.simpl.paylater.service.ValidatationService;
import com.simpl.paylater.service.ValidationServiceImpl;
import com.simpl.paylater.service.merchant.MerchantService;
import com.simpl.paylater.service.merchant.MerchantServiceImpl;
import com.simpl.paylater.service.reports.ReportsService;
import com.simpl.paylater.service.reports.ReportsServiceImpl;
import com.simpl.paylater.service.txn.TxnService;
import com.simpl.paylater.service.txn.TxnServiceImpl;
import com.simpl.paylater.service.user.UserService;
import com.simpl.paylater.service.user.UserServiceImpl;
import com.simpl.request.PayLaterRequest;
import com.simpl.request.cli.CLICommand;
import com.simpl.response.SimplResponse;

public class PayLaterCLIClient {

		PayLaterRepository inMemoryRepository;
	    MerchantService merchantService;
	    UserService userService;
	    TxnService txnService;
	    ReportsService reportsService;
	    ValidatationService validationService;
	    PayLaterController payLaterController;
	    CommandParser parser ;

	   public PayLaterCLIClient() {
		    
		    inMemoryRepository = new InMemoryRepositoryImpl();
			merchantService = new MerchantServiceImpl(inMemoryRepository);
			userService = new UserServiceImpl(inMemoryRepository);
			txnService = new TxnServiceImpl(inMemoryRepository);
			reportsService = new ReportsServiceImpl(inMemoryRepository);
			validationService = new ValidationServiceImpl(inMemoryRepository);
			payLaterController = new CLIController(merchantService, userService, txnService, validationService,reportsService);
			/////// in this case command Line parser. But it can be web,rpc ....
			parser = new CommandLineParser();
	   }
	
	   public void processCommands() {
		   try (Scanner input = new Scanner(System.in)) {
	            String line;
	            while (!(line = input.nextLine()).isEmpty()) {
	            	try {
	            		Command command = new CLICommand(line);
	            		PayLaterRequest simplRequest = parser.parseRequest(command);
						SimplResponse simplResponse = payLaterController.processRequest(simplRequest);
						System.out.println(simplResponse.getContents());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           
	            }
	        }
		   System.out.println("done");
		 
	   }
	
	
	public static void main(String[] args) {
		
		
		
		PayLaterCLIClient payLaterCLIClient = new PayLaterCLIClient();
		payLaterCLIClient.processCommands();
		

	}

}
