package com.dhfl.OnlinePaymentGatewayDataDump.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static void main(String[] args) throws Exception{
		ReadExcel.readExcel();
	}
	public static void readExcel() throws IOException {
		// obtaining input bytes from a file
		FileInputStream fis = new FileInputStream(
				new File("F:\\Freelance\\DHFL\\docs\\Click_To_Pay_Fields_15_06_2020.xlsx"));
		// creating workbook instance that refers to .xls file
		// HSSFWorkbook wb = new HSSFWorkbook(fis);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// creating a Sheet object to retrieve the object
		// HSSFSheet sheet = wb.getSheetAt(0);
		XSSFSheet sheet = wb.getSheetAt(0);
		// evaluating cell type
		FormulaEvaluator formulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();
		int counter = 0;
		for (Row row : sheet) // iteration over row using for each loop
		{
			if(counter==0) {
				for(Cell header : row) {
					System.out.println("Header---"+header.getStringCellValue());
				}
			}if(counter>=2) {
				for (Cell cell : row) // iteration over cell using for each loop
				{
					String cellValue = "";
					switch (formulaEvaluator.evaluateInCell(cell).getCellType()) {
					case Cell.CELL_TYPE_NUMERIC: // field that represents numeric cell type
						// getting the value of the cell as a number
						cellValue = String.valueOf(cell.getNumericCellValue());
						//System.out.print("Value--" + cell.getNumericCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_STRING: // field that represents string cell type
						// getting the value of the cell as a string
						cellValue = String.valueOf(cell.getStringCellValue());
						//System.out.print("Value2-" + cell.getStringCellValue() + "\t\t");
						break;
					case Cell.CELL_TYPE_BLANK:
						cellValue = String.valueOf(cell.getStringCellValue());
						break;
					}
					System.out.println("Value---"+cellValue);
				}
			}
			counter++;
			System.out.println();
		}
	}
}
