package com.shope.dev.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shope.dev.model.MasterLoginDetails;
import com.shope.dev.repository.LoginInfoRepository;

@Service
public class LoginInfoDao {
	@Autowired
	LoginInfoRepository loginInfoRepository;
	
	public MasterLoginDetails save(MasterLoginDetails masterLoginDetails) {
		return loginInfoRepository.save(masterLoginDetails);
	}
	
	public List<MasterLoginDetails> findAll(){
		return loginInfoRepository.findAll();
	}	
}
