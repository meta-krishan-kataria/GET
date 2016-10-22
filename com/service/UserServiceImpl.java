package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dao.UserDetailDAO;
import com.model.Department;
import com.model.UserDetails;
import com.model.UserDetailsVO;
import com.model.UserToken;
import com.util.ModelAdapter;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserDetails userDetails;

	@Autowired
	UserDetailDAO userDetailDAO;
	
	@Autowired
	ModelAdapter modelAdapter;

	public boolean saveUser(UserToken tokenResponse) {

		System.out.println(userDetails);
		return false;
	}

	@Override
	public UserDetailsVO userSignInSignUp(UserToken tokenResponse) {
		userDetails.setGoogleId(tokenResponse.getSub());
		userDetails.setEmailId(tokenResponse.getEmail());
		userDetails.setPictureURL(tokenResponse.getPicture());
		userDetails.setName(tokenResponse.getName());
		userDetails.setRole("general");
		userDetails.setDepartment(new Department(1));
		System.out.println("Service");
		return modelAdapter.convert(userDetailDAO.userSignInSignUp(userDetails));
	}

	@Override
	public UserDetailsVO getUserById(String googleId){
		System.out.println("getUserByID");
		return modelAdapter.convert(userDetailDAO.getUserById(googleId));
	}

	@Override
	public UserDetailsVO getUserById(int userId) {
		return modelAdapter.convert(userDetailDAO.getUserById(userId));
	}

}
