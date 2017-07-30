package com.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWriter {

	private static ExcelWriter instance = new ExcelWriter();

	private ExcelWriter() {

	}

	public static ExcelWriter getInstance() {
		return instance;
	}
	
	/* 07- Version (.xlsx) */
	public void xlsxWriter(User user) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet();
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell;

		/* create value name */
		cell = row.createCell(0);
		cell.setCellValue("이름");

		cell = row.createCell(1);
		cell.setCellValue("나이");

		cell = row.createCell(2);
		cell.setCellValue("학년");

		cell = row.createCell(3);
		cell.setCellValue("전화번호");

		row = sheet.createRow(1);

		cell = row.createCell(0);
		cell.setCellValue(user.getName());

		cell = row.createCell(1);
		cell.setCellValue(user.getAge());

		cell = row.createCell(2);
		cell.setCellValue(user.getYear());

		cell = row.createCell(3);
		cell.setCellValue(user.getPhone());

		File file = new File("/Users/cykim/Desktop/testWrite.xlsx");
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream(file);
			workbook.write(fos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (workbook != null)
					workbook.close();
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int studentWriter() throws EncryptedDocumentException, InvalidFormatException, IOException {
		InputStream inp = new FileInputStream("/Users/cykim/Desktop/testWrite.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook(inp);
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row = sheet.getRow(1);
		XSSFCell cell;
		cell = row.getCell(3);
		
		if (cell == null)
	        cell = row.createCell(3);
	    cell.setCellType(CellType.STRING);
	    cell.setCellValue("a test");

	    // Write the output to a file
	    FileOutputStream fileOut = new FileOutputStream("/Users/cykim/Desktop/testWrite1.xlsx");
	    wb.write(fileOut);
		fileOut.close();
	    
		return 1;
	}
}