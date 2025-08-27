package com.marvel.adhirajEnterprieses;

import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.properties.TextAlignment;

import java.io.File;

public class VoucherPdfGenerator {

    public static void main(String[] args) {
        try {
            String dest = "D:\\Rushabh\\Backup\\voucher.pdf"; // output file
            File file = new File(dest);
            file.getParentFile().mkdirs();

            PdfWriter writer = new PdfWriter(dest);
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // ---- Header ----
            document.add(new Paragraph("Voucher No. AE/94   Date 05/29/2025").setBold());
            document.add(new Paragraph("Chassis No. MC2P3LRT0TD563380    KM 8"));
            document.add(new Paragraph("City JAIPUR, RAJASHTAN    Total Diesel 1"));
            document.add(new Paragraph("Model PRO 3010 L CWC AC BSVI"));
            document.add(new Paragraph("RAS#"));
            document.add(new Paragraph("Pump Filling 1"));
            document.add(new Paragraph("STN No. 1970076232"));
            document.add(new Paragraph("TC/ TRC No. "));
            document.add(new Paragraph("Hand Diesel 0"));
            document.add(new Paragraph("Hand Diesel Amt./CNG Amt. 0"));
            document.add(new Paragraph("Driver Payment 17.6"));
            document.add(new Paragraph("Return Fare 50    Toll Tax 50"));
            document.add(new Paragraph("Incentive/DD 100"));
            document.add(new Paragraph("Incharge Name Test    Grand Total- 310.6"));
            document.add(new Paragraph("Driver Name ARUN SIKARWAR    Gate Pass(-)- 10"));
            document.add(new Paragraph("DL Number UP8520220016326 / 29.08.20229    Adj(-)- 7"));
            document.add(new Paragraph("Mobile No. 9634568804    Total Advance- 307.6"));

            // ---- Footer ----
            document.add(new Paragraph("\nCONTACT NO.: 8085061043, 9109961043, 9926561043\n" +
                    "Toll free number - 18001023531")
                    .setTextAlignment(TextAlignment.CENTER));

            document.add(new Paragraph("ADHIRAJ ENTERPRISE\n" +
                    "ADDRESS: Akoliya Mhow Neemuch Road Pithumpur DIST-DHAR")
                    .setTextAlignment(TextAlignment.CENTER).setBold());

            document.close();

            System.out.println("✅ PDF generated successfully at: " + file.getAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
