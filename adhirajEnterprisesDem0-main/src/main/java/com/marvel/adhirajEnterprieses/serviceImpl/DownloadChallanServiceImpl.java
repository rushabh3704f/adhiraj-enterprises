package com.marvel.adhirajEnterprieses.serviceImpl;

import java.time.LocalDate;
import java.io.IOException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.marvel.adhirajEnterprieses.service.DownloadChallanService;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class DownloadChallanServiceImpl implements DownloadChallanService {

	public void downloadChallan(HttpServletResponse response, Model model) throws IOException {

		// Set response type to PDF
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=challan.pdf");

		// Create PDF
		PdfWriter writer = new PdfWriter(response.getOutputStream());
		PdfDocument pdfDoc = new PdfDocument(writer);
		Document document = new Document(pdfDoc);

		// Example content from uploaded PDF
		document.add(new Paragraph("Voucher No. AE/94 Date " + LocalDate.now()));
		document.add(new Paragraph("Chassis No. MC2P3LRT0TD563380"));
		document.add(new Paragraph("City: Jaipur, Rajasthan"));
		document.add(new Paragraph("Model: PRO 3010 L CWC AC BSVI"));
		document.add(new Paragraph("STN No. 1970076232"));
		document.add(new Paragraph("Driver Name: ARUN SIKARWAR"));
		document.add(new Paragraph("DL Number: UP8520220016326"));
		document.add(new Paragraph("Mobile: 9634568804"));
		document.add(new Paragraph("Total Advance: 307.6"));
		document.add(new Paragraph("--------------------------------"));
		document.add(new Paragraph("Adhiraj Enterprise, Pithumpur"));

		document.close();

		// Add success message in model (not visible immediately since file download
		// interrupts redirect)
		model.addAttribute("message", "PDF downloaded successfully!");
	}
}
