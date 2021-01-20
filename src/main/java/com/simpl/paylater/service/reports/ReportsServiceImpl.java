package com.simpl.paylater.service.reports;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.simpl.domain.PayLaterTxn;
import com.simpl.domain.User;
import com.simpl.paylater.repository.PayLaterRepository;
import com.simpl.request.PayLaterDiscountReportRequest;
import com.simpl.request.PayLaterDuesReportRequest;
import com.simpl.request.PayLaterTotalDuesReportRequest;
import com.simpl.request.PayLaterUsersCreditLimitReportRequest;

public class ReportsServiceImpl implements ReportsService {

	private PayLaterRepository payLaterRepository;
	
	
	
	public ReportsServiceImpl(PayLaterRepository payLaterRepository) {
		this.payLaterRepository = payLaterRepository;
	}

	@Override
	public Double processDiscountReports(PayLaterDiscountReportRequest simplDiscountReportRequest) {
		// TODO Auto-generated method stub
		
		String merchantName = simplDiscountReportRequest.getMerchantName();
		Collection<PayLaterTxn> txns = payLaterRepository.getAllTxns();
		
		Double totalDiscountDouble = txns.stream()
									.filter(t -> t.getMerchant().getName().equals(merchantName))
									.mapToDouble(t -> t.getAbsDiscount() ).sum();
		
		
		return totalDiscountDouble;
	}

	///// TODO - HANDLE CONDITION IF USER DOESNT EXIST
	@Override
	public Double processDuesReports(PayLaterDuesReportRequest simplDuesReportRequest) {
		// TODO Auto-generated method stub
		
		String userName = simplDuesReportRequest.getUserName();
		Collection<User> users = payLaterRepository.getAllUsers();
		
		
		User user = users.stream()
						 .filter(u -> u.getName().equals(userName))
						 .findFirst().get();
							 
		
		
        return user.getDues();
		
	}

	@Override
	public List<User> processUsersCreditLimitReport() {
		// TODO Auto-generated method stub
		
		//String userName = simplDuesReportRequest.getUserName();
		Collection<User> users = payLaterRepository.getAllUsers();
		List<User> usersList = users.stream()
									.filter(u -> u.getDues()>=u.getCreditLimit())
									.collect(Collectors.toList());
	
		return usersList;
		
	}

	@Override
	public List<User> processTotalDuesReport(PayLaterTotalDuesReportRequest simplDuesReportRequest) {
		// TODO Auto-generated method stub
		Collection<User> users = payLaterRepository.getAllUsers();
		List<User> usersList = users.stream()
							  .filter(u-> (u.getDues() > 0))
							  .collect(Collectors.toList());
							  //.mapToDouble(u -> u.getDues()).sum();
		
		return usersList;
	}

}
