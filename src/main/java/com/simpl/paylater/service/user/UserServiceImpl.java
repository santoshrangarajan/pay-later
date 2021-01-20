package com.simpl.paylater.service.user;

import java.util.Optional;

import com.simpl.domain.User;
import com.simpl.paylater.repository.PayLaterRepository;
import com.simpl.request.PayLaterUserRequest;

public class UserServiceImpl implements UserService {

	private PayLaterRepository payLaterRepository;
	
	public UserServiceImpl(PayLaterRepository payLaterRepository) {
		this.payLaterRepository=payLaterRepository;
	}
	

	@Override
	public User onBoard(PayLaterUserRequest simpleNewUserRequest) {
		// TODO Auto-generated method stub
		User user = new User(simpleNewUserRequest);
		payLaterRepository.addUser(user);
		return user;
	}

	

	//// TODO CHECK DUES ARE NEGATIVE
	@Override
	public User payBack(String userName,Double amount) {
		// TODO Auto-generated method stub
		
		User user = payLaterRepository.getUser(userName).get();
	
		user.setDues(user.getDues()-amount);
		payLaterRepository.addUser(user);
		return user;
	}


	@Override
	public Optional<User> getUser(String userName) {
		// TODO Auto-generated method stub
		return payLaterRepository.getUser(userName);
	}

}
