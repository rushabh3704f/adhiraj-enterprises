package com.adhiraj.enterpries.service;

import org.springframework.web.multipart.MultipartFile;

public interface ExcelUploadService {

	public void saveExcelData(MultipartFile file);

}
