package com.mmb.qa.util;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.mmb.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT;
	public static long IMPLICIT_WAIT;
	
	public static String TESTDATA_SHEET_PATH = "C:\\Users\\ashok.kushwah\\workspace-Lockdown\\MagicbricksTest\\src\\main\\java\\com\\mmb\\qa\\testdata\\magicbricksTestdata.xlsx";
	
	static Workbook book;
	static Sheet sheet;
	
	
	public void switchToFrame() {
		driver.switchTo().frame("id");
		
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file=null;
		try {
		file = new FileInputStream(TESTDATA_SHEET_PATH);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		}catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object [][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++) {
			for(int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
	}


}
