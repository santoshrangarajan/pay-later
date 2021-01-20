package com.simpl.paylater.service.txn;

import com.simpl.domain.Merchant;
import com.simpl.domain.PayLaterTxn;
import com.simpl.domain.User;
import com.simpl.paylater.repository.PayLaterRepository;
import  java.time.LocalDateTime;
import java.util.UUID;

public class TxnServiceImpl implements TxnService {

	
	private PayLaterRepository payLaterRepository;
	
	
	
	public TxnServiceImpl(PayLaterRepository payLaterRepository) {
		this.payLaterRepository = payLaterRepository;
	}


////TODO - VALIDATE
	@Override
	public void processTxn(String userName, String merchantName, Double amount) {
		// TODO Auto-generated method stubr
	
		User user = payLaterRepository.getUser(userName).get();
		Merchant merchant = payLaterRepository.getMerchant(merchantName).get();
		
		double discount = merchant.getDiscount();
		double absDiscount = (amount * merchant.getDiscount()/100);
		double payBack = amount - absDiscount;
		
		PayLaterTxn payLaterTxn = new PayLaterTxn(UUID.randomUUID().toString(),  
						user,  merchant,
						LocalDateTime.now().toString(),
						discount, 
						absDiscount,
						payBack
				);
		
		//Double newCreditLimit = user.getCreditLimit() - amount;
		//user.setCreditLimit(user.getCreditLimit());
		user.setDues(user.getDues()+amount);
		
		payLaterRepository.addUser(user);
		payLaterRepository.processTxn(payLaterTxn);
		
	}

}
