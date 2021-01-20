package com.simpl.paylater.service.user;

import java.util.Optional;

import com.simpl.domain.User;
import com.simpl.request.PayLaterUserRequest;

public interface UserService {

	public User onBoard(PayLaterUserRequest simpleNewUserRequest);
	public User payBack(String userName,Double amount);
	public Optional<User> getUser(String userName);
}
