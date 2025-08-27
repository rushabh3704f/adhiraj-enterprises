package com.adhiraj.enterpries.webconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhiraj.enterpries.model.UserData;
import com.adhiraj.enterpries.repository.UserDataRepository;

@Service
public class LoginService {

	@Autowired
	UserDataRepository userDataRepository;

	public UserData isValidUser(Login login) {
		UserData userData = userDataRepository.isValidUser(login.getUserName(), login.getPassword(),login.getUserType());
		return userData;
	}

}
