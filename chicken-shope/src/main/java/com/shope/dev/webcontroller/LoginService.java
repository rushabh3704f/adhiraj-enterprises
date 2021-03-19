package com.shope.dev.webcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shope.dev.model.UserData;
import com.shope.dev.repository.UserDataRepository;

@Service
public class LoginService {

	@Autowired
	UserDataRepository userDataRepository;

	public UserData isValidUser(Login login) {
		// TODO Auto-generated method stub
		UserData userData=userDataRepository.isValidUser(login.getUserName(), login.getPassword(),login.getUserType());
		return userData;
	}

}
