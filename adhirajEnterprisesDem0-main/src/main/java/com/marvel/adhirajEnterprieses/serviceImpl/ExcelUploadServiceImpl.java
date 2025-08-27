package com.marvel.adhirajEnterprieses.serviceImpl;

import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.marvel.adhirajEnterprieses.model.BookingEntry;
import com.marvel.adhirajEnterprieses.repository.BookingEntryRepository;
import com.marvel.adhirajEnterprieses.service.ExcelUploadService;

@Service
public class ExcelUploadServiceImpl implements ExcelUploadService {
	private static final Logger log = LoggerFactory.getLogger(ExcelUploadServiceImpl.class);

	@Autowired
	private BookingEntryRepository bookingEntryRepository;

	public void saveExcelData(MultipartFile file) {
		log.info("saveExcelData method start ::");
		try (InputStream is = file.getInputStream()) {
			Workbook workbook = WorkbookFactory.create(is);
			Sheet sheet = workbook.getSheetAt(0);

			for (int i = 1; i <= sheet.getLastRowNum(); i++) { // skip header row
				Row row = sheet.getRow(i);
				if (row == null)
					continue;

				/*
				 * BookingEntry entry = BookingEntry.builder().sNo(getCellValue(row,
				 * 0)).stockTrNum(getCellValue(row, 1)) .stockTrDate(getCellValue(row,
				 * 2)).deliveryNum(getCellValue(row, 3)) .vehicleChassisNumber(getCellValue(row,
				 * 4)).vehicleEngineNumber(getCellValue(row, 5)) .materialCode(getCellValue(row,
				 * 6)).materialDescription(getCellValue(row, 7)) .division(getCellValue(row,
				 * 8)).dealerCode(getCellValue(row, 9)).region(getCellValue(row, 10))
				 * .depoDealerRgpExport(getCellValue(row, 11)).depotToDesc(getCellValue(row,
				 * 12)) .transporter(getCellValue(row, 13)).stnValue(getCellValue(row,
				 * 14)).trcNo(getCellValue(row, 15)) .billToParty(getCellValue(row,
				 * 16)).shipToParty(getCellValue(row, 17)) .shipmentNo(getCellValue(row,
				 * 18)).plant(getCellValue(row, 19)).gw(getCellValue(row, 20))
				 * .invoiceNo(getCellValue(row, 21)).status(getCellValue(row, 22)).build();
				 */

				BookingEntry entry = new BookingEntry();
				entry.setsNo(getCellValue(row, 0));
				entry.setStockTrNum(getCellValue(row, 1));
				entry.setStockTrDate(getCellValue(row, 2));
				entry.setDeliveryNum(getCellValue(row, 3));
				entry.setVehicleChassisNumber(getCellValue(row, 4));
				entry.setVehicleEngineNumber(getCellValue(row, 5));
				entry.setMaterialCode(getCellValue(row, 6));
				entry.setMaterialDescription(getCellValue(row, 7));
				entry.setDivision(getCellValue(row, 8));
				entry.setDealerCode(getCellValue(row, 9));
				entry.setRegion(getCellValue(row, 10));
				entry.setDepoDealerRgpExport(getCellValue(row, 11));
				entry.setDepotToDesc(getCellValue(row, 12));
				entry.setTransporter(getCellValue(row, 13));
				entry.setStnValue(getCellValue(row, 14));
				entry.setTrcNo(getCellValue(row, 15));
				entry.setBillToParty(getCellValue(row, 16));
				entry.setShipToParty(getCellValue(row, 17));
				entry.setShipmentNo(getCellValue(row, 18));
				entry.setPlant(getCellValue(row, 19));
				entry.setGw(getCellValue(row, 20));
				entry.setInvoiceNo(getCellValue(row, 21));
				entry.setStatus(getCellValue(row, 22));

				bookingEntryRepository.save(entry);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to parse Excel file: " + e.getMessage());
		}
	}

	private String getCellValue(Row row, int cellNo) {
		Cell cell = row.getCell(cellNo);
		return (cell == null) ? "" : cell.toString();
	}
}
