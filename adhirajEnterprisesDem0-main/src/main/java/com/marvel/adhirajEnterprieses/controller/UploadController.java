package com.marvel.adhirajEnterprieses.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.marvel.adhirajEnterprieses.service.ExcelUploadService;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UploadController {

	private static final Logger log = LoggerFactory.getLogger(UploadController.class);
	@Autowired
	private ExcelUploadService excelUploadService;

	@PostMapping("/uploadExcel")
	public String uploadExcel(@RequestParam("file") MultipartFile file, Model model) {
		log.info("uploadExcel method start :: file :: " + file.toString());
		try {
			excelUploadService.saveExcelData(file);
			model.addAttribute("message", "File uploaded & data saved successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Error: " + e.getMessage());
		}
		log.info("uploadExcel method end ");
		return "home"; // reload home.html
	}

}
