package com.dao;

import com.model.UserDetails;

public interface UserDetailDAO {
	UserDetails userSignInSignUp(UserDetails userDetails);

	UserDetails getUserById(String googleId);

	UserDetails getUserById(int userId);

	void saveUser(UserDetails userDetails);
}
