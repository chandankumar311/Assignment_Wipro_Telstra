
package com.Utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

/**
 * @author CHANDAN KUMAR
 * This class will get the data from excel sheet.
 */

@Test
public class ExcelDataConfig {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelDataConfig(String filePath) {
        try {
			File src = new File(filePath);
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		}
        catch (Exception e) {
        	System.out.println("Found Exception is: " + e.getMessage());
		}
	}
	
	public String getData(int sheetNumber, int rowNo, int columnNo) {
		sheet = wb.getSheetAt(sheetNumber);
		String data = sheet.getRow(rowNo).getCell(columnNo).getStringCellValue();
		return data;
	}
	
	public int getRowCount(int sheetIndex) {
		int row = wb.getSheetAt(sheetIndex).getLastRowNum();
		row = row + 1;
		return row;
	}
	
}
