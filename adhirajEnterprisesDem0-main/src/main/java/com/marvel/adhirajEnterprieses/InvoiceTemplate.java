package com.marvel.adhirajEnterprieses;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;

public class InvoiceTemplate {
	public static void main(String[] args) throws Exception {
		String dest = "D:\\Rushabh\\Backup\\Generated_Invoice.pdf";

		PdfWriter writer = new PdfWriter(dest);
		PdfDocument pdf = new PdfDocument(writer);
		Document document = new Document(pdf);

		PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
		PdfFont normal = PdfFontFactory.createFont(StandardFonts.HELVETICA);
		Color headerColor = new DeviceRgb(230, 230, 250); // light lavender background

		// Title
		Paragraph title = new Paragraph("Invoice").setFont(bold).setFontSize(22).setTextAlignment(TextAlignment.CENTER);
		document.add(title);

		// BILL FROM Section
		document.add(new Paragraph("\nBILL FROM").setFont(bold).setFontSize(12));

		document.add(new Paragraph("Redcliffe Lifetech Private Limited\n" + "CIN Number:- U85100UP2021PTC140992\n"
				+ "Redcliffe Lifetech Pvt Ltd, Unit 1 (Chandralok Colony), Ground Floor,\n"
				+ "Santoshi Heights, Indore, Madhya Pradesh 452001").setFont(normal).setFontSize(10));

		// Customer Details
		document.add(new Paragraph("\nCUSTOMER DETAILS").setFont(bold).setFontSize(12));

		Table customer = new Table(new float[] { 2, 4 });

		customer.setWidth(UnitValue.createPercentValue(100));
		customer.addCell(new Cell().add(new Paragraph("Name").setFont(bold)));
		customer.addCell(new Cell().add(new Paragraph("Anjali Lokhande").setFont(normal)));
		customer.addCell(new Cell().add(new Paragraph("Address").setFont(bold)));
		customer.addCell(
				new Cell().add(new Paragraph("Ae 534 housing board colony, Pithampur, Dhar, MP").setFont(normal)));
		customer.addCell(new Cell().add(new Paragraph("Invoice Date").setFont(bold)));
		customer.addCell(new Cell().add(new Paragraph("Nov 28, 2024").setFont(normal)));

		document.add(customer);

		// Services Table (Test Description + Amount)
		document.add(new Paragraph("\nTEST DESCRIPTION").setFont(bold).setFontSize(12));

		Table serviceTable = new Table(new float[] { 4, 2 });
		serviceTable.setWidth(UnitValue.createPercentValue(100));

		serviceTable.addHeaderCell(
				new Cell().add(new Paragraph("Description").setFont(bold)).setBackgroundColor(headerColor));
		serviceTable.addHeaderCell(new Cell().add(new Paragraph("Amount").setFont(bold)).setBackgroundColor(headerColor)
				.setTextAlignment(TextAlignment.RIGHT));

		serviceTable.addCell(new Cell().add(new Paragraph("CRED Wellness Comprehensive").setFont(normal)));
		serviceTable
				.addCell(new Cell().add(new Paragraph("₹6998").setFont(normal)).setTextAlignment(TextAlignment.RIGHT));

		serviceTable.addCell(new Cell().add(new Paragraph("VIP Membership Discount (Diagnostic)").setFont(normal)));
		serviceTable
				.addCell(new Cell().add(new Paragraph("₹699").setFont(normal)).setTextAlignment(TextAlignment.RIGHT));

		document.add(serviceTable);

		// Totals Table
		Table totals = new Table(new float[] { 4, 2 });
		totals.setWidth(UnitValue.createPercentValue(100));

		totals.addCell(new Cell().add(new Paragraph("Grand Total").setFont(bold)).setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT));
		totals.addCell(new Cell().add(new Paragraph("₹6998").setFont(normal)).setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT));

		totals.addCell(new Cell().add(new Paragraph("Paid Amount").setFont(bold)).setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT));
		totals.addCell(new Cell().add(new Paragraph("₹6299").setFont(normal)).setBorder(Border.NO_BORDER)
				.setTextAlignment(TextAlignment.RIGHT));

		totals.addCell(new Cell().add(new Paragraph("Amount Chargable (in words)").setFont(bold))
				.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));
		totals.addCell(new Cell().add(new Paragraph("Rupees four thousand, five hundred Only").setFont(normal))
				.setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT));

		document.add(totals);
		// Notes
		document.add(new Paragraph("\nImportant Notes:").setFont(bold).setFontSize(12));

		document.add(new Paragraph(
				"This invoice can be used for tax exemption under section 80-D (Preventive Health Checkup)\n"
						+ "Reports sent on registered mail ID according to the respective TAT and can also be downloaded through Redcliffe Labs Application\n"
						+ "All dispute/claims concerning to reports are subject to the courts of Delhi only\n"
						+ "Redcliffe Labs assumes no liability towards any delays beyond its control\n"
						+ "It is recommended that you consult your treating Doctor/Physician before choosing any treatment based on your report\n"
						+ "Maximum liability of the Company shall not exceed the amount charged by the Company for the services availed\n"
						+ "This is a computer generated invoice and does not require signature/stamp")
				.setFont(normal).setFontSize(9));

		// Footer
		document.add(new Paragraph("\n898-898-0606   |   care@redcliffelabs.com   |   www.redcliffelabs.com")
				.setFont(normal).setFontSize(10).setTextAlignment(TextAlignment.CENTER));

		document.close();
		System.out.println("✅ Invoice PDF generated successfully: " + dest);
	}
}
