package com.adhiraj.enterpries;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class AdhirajEnterprisesApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AdhirajEnterprisesApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AdhirajEnterprisesApplication.class);
	}

}
