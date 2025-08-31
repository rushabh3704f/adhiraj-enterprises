package com.adhiraj.enterpries.service;

import java.util.List;

import com.adhiraj.enterpries.model.MasterLoginDetails;

public interface LoginInfoService {

	public MasterLoginDetails save(MasterLoginDetails masterLoginDetails);

	public List<MasterLoginDetails> findAll();
}
