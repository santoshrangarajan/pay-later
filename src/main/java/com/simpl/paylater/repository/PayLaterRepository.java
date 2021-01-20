package com.simpl.paylater.repository;

import java.util.Collection;
import java.util.Optional;

import com.simpl.domain.Merchant;
import com.simpl.domain.PayLaterTxn;
import com.simpl.domain.User;

public interface PayLaterRepository {

	public void addUser(User user);
	public void addMerchant (Merchant merchant);
	public void updateMerchantDiscount(Merchant merchant);
	public Optional<User> getUser(String userName);
	public Optional<Merchant> getMerchant(String merchantName);
	
	public void processTxn(PayLaterTxn payLaterTxn);
	
	public Collection<PayLaterTxn> getAllTxns();
	
	public Collection<User> getAllUsers();
	
	
}
