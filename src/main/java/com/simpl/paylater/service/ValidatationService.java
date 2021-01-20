package com.simpl.paylater.service;

import com.simpl.domain.Merchant;
import com.simpl.domain.User;

public interface ValidatationService {

	public void validateTxn(User user, Double amount);
	public void validateUserOnBoarding(User user);
	public void validateMerchantOnBoarding(Merchant merchant);
	public void validateRequest();
	public boolean doesUserExist(String userName);
	public boolean doesMerchantExist(String merchantName);
	public boolean doesUserHaveCredit(String userName, Double amount);
}
