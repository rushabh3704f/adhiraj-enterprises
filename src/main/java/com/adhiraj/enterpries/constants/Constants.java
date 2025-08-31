package com.adhiraj.enterpries.constants;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Constants {

	// @Value("${BASE.URL}:${server.port}")
	@Value("${BASE.URL}")
	private String baseURL;

	@PostConstruct
	public void init() {
		BASE_URL = baseURL;
	}

	public static String BASE_URL;

}
