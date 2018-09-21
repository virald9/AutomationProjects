package oops;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	

	public class ExcelReader {
		
	

		
	public static void main(String args[]) throws IOException{
		
	
		File file = new File("C:\\Users\\vdesai\\Desktop\\Excel_Poi.xlsx");
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		//getLastRowNum will give you the last row number having data and numbering starts from 0
		int numberofrows = sheet.getLastRowNum();
		//getLastCellNum gived you last cell number having data col. wise  and numbering starts from 1
		int numberofcolcell = sheet.getRow(0).getLastCellNum()-1;
		//System.out.println(numberofrows);
		//System.out.println(numberofcolcell);
		
		//dataTable = new String[numberofrows][numberofcolcell];
		
		for(int i =0;i<=numberofrows;i++) {
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<=numberofcolcell;j++) {
				XSSFCell cell = row.getCell(j);
				System.out.println(cell);
				
				
				
			}
		}
		
	
				
				
			}
		}
	
	


