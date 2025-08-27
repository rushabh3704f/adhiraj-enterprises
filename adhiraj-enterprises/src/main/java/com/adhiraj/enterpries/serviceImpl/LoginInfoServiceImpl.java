package com.adhiraj.enterpries.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adhiraj.enterpries.model.MasterLoginDetails;
import com.adhiraj.enterpries.repository.LoginInfoRepository;
import com.adhiraj.enterpries.service.LoginInfoService;

@Service
public class LoginInfoServiceImpl implements LoginInfoService {

	@Autowired
	LoginInfoRepository loginInfoRepository;

	public MasterLoginDetails save(MasterLoginDetails masterLoginDetails) {
		return loginInfoRepository.save(masterLoginDetails);
	}

	public List<MasterLoginDetails> findAll() {
		return loginInfoRepository.findAll();
	}
}
