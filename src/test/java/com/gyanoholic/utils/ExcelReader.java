package com.gyanoholic.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./testdata/studentdata.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis); //xlsx HSSFWorkbook
		XSSFSheet sheet = wb.getSheet("credentials");
		int rowCount = sheet.getLastRowNum();
		for(int i=0; i<=rowCount; i++) {
			int colCount = sheet.getRow(i).getLastCellNum();
			for(int j=0; j<colCount; j++) {
				String data = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.println(data);
			}
		}
	}
}
