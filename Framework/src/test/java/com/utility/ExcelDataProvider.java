package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook xb;
	HSSFWorkbook hb;

	public ExcelDataProvider() {

		File file = new File("./TestData/Data.xls");

		try {
			FileInputStream fis = new FileInputStream(file);
		//	xb = new XSSFWorkbook(fis);
			hb = new HSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to access excel data file: " + e.getMessage());
		}
	}

	public String getStringData(String sheetName, int rowNum, int colNum) {

		return hb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getStringCellValue();
	}

	public double getNumericDAta(String sheetName, int rowNum, int colNum) {

		return xb.getSheet(sheetName).getRow(rowNum).getCell(colNum).getNumericCellValue();
	}

	public String getStringData(int sheetIndex, int rowNum, int colNum) {

		return xb.getSheetAt(sheetIndex).getRow(rowNum).getCell(colNum).getStringCellValue();
	}
}
