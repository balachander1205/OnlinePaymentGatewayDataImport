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
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.dhfl.OnlinePaymentGatewayDataDump.entity.DHFLCustomersEntity;

public class ReadExcelFile {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "BrLoan Code", "Appl No", "Customer Name", "Overdue EMI","Total Overdue EMI",
								"Minimum Overdue Amount","Overdue Blank Field","Charges","Total Charges Amount",
								"Minimum Charge Amount", "Charge Blank Field" };
	static String SHEET = "Tutorials";
	
	public static void main(String[] args) throws Exception{
		FileInputStream fis = new FileInputStream(
				new File("F:\\Freelance\\DHFL\\docs\\Click_To_Pay_Fields_15_06_2020-edited.xlsx"));
		// creating workbook instance that refers to .xls file
		List<DHFLCustomersEntity> customers = ReadExcelFile.excelToTutorials(fis);
		for(DHFLCustomersEntity customer : customers) {
			System.out.println("Name="+customer.getCustomername()+" LoanCode="+customer.getBrloancode()+
								" AppNo="+customer.getApplno()+" Total OverDue="+customer.getTotalOverdueEMI()+
								" MinOverDue="+customer.getMinimumOverdueAmount()+
								" TotalCharges="+customer.getTotalChargesAmount()+" MinCharges="+customer.getMinimumChargeAmount()+
								" Mobile Number="+customer.getMobileno());
		}
	}
	public static boolean hasExcelFormat(MultipartFile file) {
		if (!TYPE.equals(file.getContentType())) {
			return false;
		}
		return true;
	}
	public static List<DHFLCustomersEntity> excelToTutorials(InputStream is) {
		try {
			// creating workbook instance that refers to .xls file
			XSSFWorkbook workbook = new XSSFWorkbook(is);			
			XSSFSheet sheet = workbook.getSheetAt(0);
			List<DHFLCustomersEntity> customers = new ArrayList<DHFLCustomersEntity>();
			int rowNumber = 0;
			System.out.println("Last Row Number "+sheet.getLastRowNum());
			for(Row row : sheet) {
				Row currentRow = row;
				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}
				if(!isRowEmpty(row)) {
					Iterator<Cell> cellsInRow = currentRow.iterator();
					DHFLCustomersEntity tutorial = new DHFLCustomersEntity();
					int cellIdx = 0;
					while (cellsInRow.hasNext()) {
						Cell currentCell = cellsInRow.next();					
						switch (cellIdx) {
						case 0:
							//tutorial.setId((long) currentCell.getNumericCellValue());
							Double bd = new Double(getCellValueByType(currentCell));
							//tutorial.setBrloancode(String.valueOf(bd.longValue()));
							String loanCode = "";
							if(getCellValueByType(currentCell).contains("E")) {
								bd = new Double(getCellValueByType(currentCell));
								loanCode = String.valueOf(bd.longValue());										
							}else {
								loanCode = getCellValueByType(currentCell);
							}
							tutorial.setBrloancode(loanCode);
							break;
						case 1:
							//tutorial.setBrloancode(currentCell.getStringCellValue());
							tutorial.setApplno(getCellValueByType(currentCell));
							break;
						case 2:
							//tutorial.setApplno(currentCell.getStringCellValue());
							tutorial.setCustomername(getCellValueByType(currentCell));
							break;
						case 3:
							//tutorial.setCustomername(currentCell.getStringCellValue());
							Double mobileNo = new Double(getCellValueByType(currentCell));
							tutorial.setMobileno(String.valueOf(mobileNo.longValue()));
							break;
						case 4:
							//tutorial.setOverdueBlankField(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setTotalOverdueEMI((long)Double.parseDouble(getCellValueByType(currentCell)));
							break;
						case 5:
							//tutorial.setTotalOverdueEMI(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setMinimumOverdueAmount((long)Double.parseDouble(getCellValueByType(currentCell)));
							break;
						case 6:
							//tutorial.setMinimumOverdueAmount(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setTotalChargesAmount((long)Double.parseDouble(getCellValueByType(currentCell)));
							break;
						case 7:
							//tutorial.setOverdueBlankField(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setMinimumChargeAmount((long)Double.parseDouble(getCellValueByType(currentCell)));
							break;
						case 8:
							//tutorial.setChargeBlankField(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setChargeBlankField(Long.valueOf("0"));
							break;
						case 9:
							//tutorial.setTotalChargesAmount(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setTotalChargesAmount((long)Double.parseDouble(getCellValueByType(currentCell)));
							break;
						case 10:
							//tutorial.setMinimumChargeAmount(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setMinimumChargeAmount((long)Double.parseDouble(getCellValueByType(currentCell)));
							break;
						case 11:
							//tutorial.setChargeBlankField(Long.parseLong(currentCell.getStringCellValue()));
							tutorial.setChargeBlankField(Long.valueOf("0"));
							break;
						default:
							break;
						}
						cellIdx++;
					}
					System.out.println("-------------------------");
					customers.add(tutorial);
				}
			}
			//workbook.close();
			return customers;
		} catch (IOException e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public static String getCellValueByType(Cell cell) {
		String value = "0";
		if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC) {
			value = String.valueOf(cell.getNumericCellValue()) != null
					|| String.valueOf(cell.getNumericCellValue()) != "" ? String.valueOf(cell.getNumericCellValue())
							: "0";
		}
		if(cell.getCellType()==Cell.CELL_TYPE_STRING) {
			value = String.valueOf(cell.getStringCellValue()) != null || String.valueOf(cell.getStringCellValue()) != ""
					? String.valueOf(cell.getStringCellValue())
					: "0";
		}
		System.out.println("Value----->>>"+value);
		return value;
	}
	
	public static boolean isRowEmpty(Row row) {
		if (row == null) {
			return true;
		}
		if (row.getLastCellNum() <= 0) {
			return true;
		}
		for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
			Cell cell = row.getCell(c);
			if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK)
				return false;
		}
		return true;
	}
}
