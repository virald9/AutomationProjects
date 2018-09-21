package utilibillautomationpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {

	static String dataTable[][];
	
	public static String[][] get(String filename) throws IOException{

		File file = new File(filename);
		FileInputStream fs = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		
		//Returns index value
		int rownumber = sheet.getLastRowNum()+1;
		//Returns number
		int colnumber = sheet.getRow(0).getLastCellNum();
		
		dataTable = new String[rownumber][colnumber];
		
		System.out.println(rownumber);
		System.out.println(colnumber);
		
		
		for(int i =0;i<rownumber;i++) {
			
			XSSFRow row = sheet.getRow(i);
			for(int j=0;j<colnumber;j++) {
				XSSFCell cell = row.getCell(j);
				dataTable[i][j] = cell.toString();
	
			}
		}
		return dataTable;
	
				
				
			}
}
