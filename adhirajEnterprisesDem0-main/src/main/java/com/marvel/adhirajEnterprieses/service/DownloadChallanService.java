package com.marvel.adhirajEnterprieses.service;

import java.io.IOException;

import org.springframework.ui.Model;

import jakarta.servlet.http.HttpServletResponse;

public interface DownloadChallanService {

	public void downloadChallan(HttpServletResponse response, Model model) throws IOException;
}
