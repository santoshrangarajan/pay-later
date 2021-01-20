package com.simpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.simpl.controller.PayLaterController;
import com.simpl.controller.cli.CLIController;
import com.simpl.parser.RequestParser;
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
import com.simpl.request.Request;
import com.simpl.request.PayLaterRequest;
import com.simpl.request.cli.CLIRequest;
import com.simpl.response.SimplResponse;

public class PayLaterCLIClient {

	
	
	/*
	 * Request
	 * Response
	 * 
	 * SimplRequest
	 * SimplResponse
	 */
	public static void main(String[] args) {
		// TODO MOVe all to constructor
		
		PayLaterRepository inMemoryRepository = new InMemoryRepositoryImpl();
		
		MerchantService merchantService = new MerchantServiceImpl(inMemoryRepository);
		UserService userService = new UserServiceImpl(inMemoryRepository);
		TxnService txnService = new TxnServiceImpl(inMemoryRepository);
		
		ReportsService reportsService = new ReportsServiceImpl(inMemoryRepository);
		
		ValidatationService validationService = new ValidationServiceImpl(inMemoryRepository);
		PayLaterController payLaterService = new CLIController(merchantService, userService, txnService, validationService,reportsService);

		/////// in this case command Line parser. But it can be web,rpc ....
		RequestParser parser = new CommandLineParser();
		 
		 try (Scanner input = new Scanner(System.in)) {
	            String line;
	            while (!(line = input.nextLine()).isEmpty()) {
	 
	            	try {
	            		Request request = new CLIRequest(line);
	            		PayLaterRequest simplRequest = parser.parseRequest(request);
						SimplResponse simplResponse = payLaterService.processRequest(simplRequest);
						System.out.println(simplResponse.getContents());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	           
	            }
	        }
		 
		 System.out.println("done");
		

	}

}
