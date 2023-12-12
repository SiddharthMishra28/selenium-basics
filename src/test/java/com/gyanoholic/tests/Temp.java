package com.gyanoholic.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Temp {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/studentdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis); //xlsx HSSFWorkbook
		XSSFSheet sheet = wb.getSheet("credentials");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] testData = new Object[rowCount+1][colCount];
		for(int i=1; i<=rowCount; i++) {			
			for(int j=0; j<colCount; j++) {
				testData[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(testData[i][j]);
			}
		}
	}
}
