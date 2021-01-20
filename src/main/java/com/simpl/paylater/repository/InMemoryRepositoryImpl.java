package com.simpl.paylater.repository;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.simpl.domain.Merchant;
import com.simpl.domain.PayLaterTxn;
import com.simpl.domain.User;

public class InMemoryRepositoryImpl implements PayLaterRepository {

	Map<String,User> userMap= Collections.synchronizedMap(new HashMap<String,User>());
	Map<String,Merchant> merchantMap= Collections.synchronizedMap(new HashMap<String,Merchant>());
	Map<String,PayLaterTxn> txnMap= Collections.synchronizedMap(new HashMap<String,PayLaterTxn>());
	
	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userMap.put(user.getName(), user);
		
	}

	@Override
	public void addMerchant(Merchant merchant) {
		// TODO Auto-generated method stub
		merchantMap.put(merchant.getName(), merchant);	
	}

	//TODO - CHECK IF KEY IS VALID
	public void updateMerchantDiscount(Merchant merchant) {
		merchantMap.put(merchant.getName(), merchant);
	}

	///https://www.baeldung.com/java-optional-return
	@Override
	public Optional<User> getUser(String userName) {
		// TODO Auto-generated method stub
		
		User user = userMap.get(userName);
		
		Optional<User> opt = Optional.ofNullable(user);
	    return opt;
		//return userMap.getOrDefault(userName, null);
	}

	@Override
	public Optional<Merchant> getMerchant(String merchantName) {
		// TODO Auto-generated method stub
		Merchant merchant= merchantMap.getOrDefault(merchantName,null);
		Optional<Merchant> optMerchant = Optional.ofNullable(merchant);
		
		 return optMerchant;
	}

	@Override
	public void processTxn(PayLaterTxn payLaterTxn) {
		// TODO Auto-generated method stub
		txnMap.put(payLaterTxn.getReferenceNo(), payLaterTxn);
	}

	@Override
	public Collection<PayLaterTxn> getAllTxns() {
		// TODO Auto-generated method stub
		return txnMap.values();
	}

	@Override
	public Collection<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userMap.values();
	}
}
