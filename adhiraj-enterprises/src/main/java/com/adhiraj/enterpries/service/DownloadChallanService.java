package com.adhiraj.enterpries.service;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface DownloadChallanService {

	public void downloadChallan(HttpServletResponse response, Model model) throws IOException;
}
