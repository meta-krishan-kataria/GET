package com.service;

import com.model.UserDetailsVO;
import com.model.UserToken;

public interface UserService{

	boolean saveUser(UserToken tokenResponse);
	UserDetailsVO userSignInSignUp(UserToken tokenResponse);
	UserDetailsVO getUserById(String googleId);
	UserDetailsVO getUserById(int userId);
}
