package com.dhfl.OnlinePaymentGatewayDataDump.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "BrLoan Code", "Appl No", "Customer Name", "Overdue EMI","Total Overdue EMI",
								"Minimum Overdue Amount","Overdue Blank Field","Charges","Total Charges Amount",
								"Minimum Charge Amount", "Charge Blank Field" };
	static String SHEET = "Tutorials";

	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}
	public static List<DHFLCustomersEntity> excelToTutorials(InputStream is) {
		try {
			//Workbook workbook = new XSSFWorkbook(is);
			FileInputStream fis = new FileInputStream(
					new File("F:\\Freelance\\DHFL\\docs\\Click_To_Pay_Fields_15_06_2020.xlsx"));
			// creating workbook instance that refers to .xls file
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			
			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();
			List<DHFLCustomersEntity> customers = new ArrayList<DHFLCustomersEntity>();
			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cellsInRow = currentRow.iterator();
				DHFLCustomersEntity tutorial = new DHFLCustomersEntity();
				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();
					switch (cellIdx) {
					case 0:
						tutorial.setId((long) currentCell.getNumericCellValue());
						break;
					case 1:
						tutorial.setBrloancode(currentCell.getStringCellValue());
						break;
					case 2:
						tutorial.setApplno(currentCell.getStringCellValue());
						break;
					case 3:
						tutorial.setCustomername(currentCell.getStringCellValue());
						break;
					case 4:
						tutorial.setOverdueBlankField(Long.parseLong(currentCell.getStringCellValue()));
						break;
					case 5:
						tutorial.setTotalOverdueEMI(Long.parseLong(currentCell.getStringCellValue()));
						break;
					case 6:
						tutorial.setMinimumOverdueAmount(Long.parseLong(currentCell.getStringCellValue()));
						break;
					case 7:
						tutorial.setOverdueBlankField(Long.parseLong(currentCell.getStringCellValue()));
						break;
					case 8:
						tutorial.setChargeBlankField(Long.parseLong(currentCell.getStringCellValue()));
						break;
					case 9:
						tutorial.setTotalChargesAmount(Long.parseLong(currentCell.getStringCellValue()));
						break;
					case 10:
						tutorial.setMinimumChargeAmount(Long.parseLong(currentCell.getStringCellValue()));
						break;
					case 11:
						tutorial.setChargeBlankField(Long.parseLong(currentCell.getStringCellValue()));
						break;
					default:
						break;
					}
					cellIdx++;
				}
				customers.add(tutorial);
			}
			//workbook.close();
			return customers;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
