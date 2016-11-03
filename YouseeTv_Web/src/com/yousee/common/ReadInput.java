package com.yousee.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadInput {
	
	public static String readExcel(int row, int column) throws IOException{
		
		String fileName="YouseeInput.xlsx";
		String filePath = System.getProperty("user.dir");
		String sheetName="input";
		File file = new File("F:\\Automation\\Nishant\\YouseeReport\\"+fileName);
		FileInputStream inputStream = new FileInputStream(file);
		Workbook guru99Workbook = null;
		//Find the file extension by spliting file name in substring and getting only extension name
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		//Check condition if the file is xlsx file
		if(fileExtensionName.equals(".xlsx")){
	
			guru99Workbook = new XSSFWorkbook(inputStream);
	
	}
	
		else if(fileExtensionName.equals(".xls")){

		guru99Workbook = new HSSFWorkbook(inputStream);

		}

	
		org.apache.poi.ss.usermodel.Sheet guru99Sheet = guru99Workbook.getSheet(sheetName);
		
	/*int rowCount = guru99Sheet.getLastRowNum()-guru99Sheet.getFirstRowNum();

	
	for (int i = 0; i < rowCount+1; i++) {

	Row row = guru99Sheet.getRow(i);
	
	
	for (int j = 0; j < row.getLastCellNum(); j++) {

	System.out.print(row.getCell(j).getStringCellValue()+"|| ");

	
	}

}*/
		
	System.out.println(guru99Sheet.getRow(row).getCell(column).getStringCellValue());
	String value = guru99Sheet.getRow(row).getCell(column).getStringCellValue();
	return value;
	}
}
