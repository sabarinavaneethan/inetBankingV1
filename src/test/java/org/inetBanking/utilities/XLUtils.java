package org.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	
	public static FileInputStream fin;
	public static FileOutputStream fout;
	public static Workbook workbook;
	public static Sheet sheet;
	public static Row row;
	public static Cell cell;
	 
	
	public static int getRowCount(String xlfile,String xlSheet) throws IOException
	{
		fin = new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fin);
		sheet= workbook.getSheet(xlSheet);
		int rowCount = sheet.getPhysicalNumberOfRows();
		fin.close();
		return rowCount;

	}
	
	
	
	public static int getCellCount(String xlfile,String xlSheet,int rownum) throws IOException
	{
		fin = new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fin);
		sheet= workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		int cellCount = row.getPhysicalNumberOfCells();
		fin.close();
		return cellCount;

	}
	
	
	public static String getCellData(String xlfile,String xlSheet,int rownum,int cellnum) throws IOException 
	{
		fin = new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fin);
		sheet= workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell= row.getCell(cellnum);
		
		String data;
		try {
			
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;

		} 
		catch (Exception e)
		{
			data="";
		}
		
		fin.close();
		return data;
		
	}
	
	public static void setCellData(String xlfile,String xlSheet,int rownum,int colnum,String data) throws IOException
	{
		fin = new FileInputStream(xlfile);
		workbook= new XSSFWorkbook(fin);
		sheet = workbook.getSheet(xlSheet);
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fout = new FileOutputStream(xlfile);
		workbook.write(fout);
		fin.close();
		fout.close();

	}
	
	
	
	
	

}
