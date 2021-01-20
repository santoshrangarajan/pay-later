package com.simpl.paylater.service;

import java.util.Optional;

import com.simpl.domain.Merchant;
import com.simpl.domain.User;
import com.simpl.paylater.repository.PayLaterRepository;

public class ValidationServiceImpl implements ValidatationService {

	 PayLaterRepository payLaterRepository;
	 
	 public ValidationServiceImpl(PayLaterRepository payLaterRepository) {
		// TODO Auto-generated constructor stub
		 this.payLaterRepository=payLaterRepository;
	}
	
	
	@Override
	public void validateTxn(User user, Double amount) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void validateUserOnBoarding(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateMerchantOnBoarding(Merchant merchant) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validateRequest() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean doesUserExist(String userName) {
		// TODO Auto-generated method stub
		Optional<User> usrOpt =  payLaterRepository.getUser(userName);
	    return usrOpt.isPresent();
		
	}


	@Override
	public boolean doesMerchantExist(String merchantName) {
		// TODO Auto-generated method stub
		Optional<Merchant> merchantOpt = payLaterRepository.getMerchant(merchantName);
		 return merchantOpt.isPresent();
	}

	public boolean doesUserHaveCredit(String userName, Double amount) {
		Optional<User> userOptional = payLaterRepository.getUser(userName);
		
		if(userOptional.isEmpty()) {
			return false;
		}
		User user = userOptional.get();
		
		Double availableCreditLimit = user.getCreditLimit() - user.getDues();
		if(amount > availableCreditLimit) {
			return false;
		}
		
		return true;
	}

}
