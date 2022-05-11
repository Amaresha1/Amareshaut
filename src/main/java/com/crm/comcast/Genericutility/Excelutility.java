package com.crm.comcast.Genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class Excelutility 
{
 public String getDatafromexcel(String sheet,int row,int cell) throws Throwable

     {
	 /**
		 *  its used read the data from excel base don below arguments 
		 * @param sheetName
		 * @param rowNum
		 * @param celNum
		 * @return Data
		 * @throws Throwable
		  */

	 FileInputStream fis=new FileInputStream(IConstants.EXCELPATH);
	 Workbook book = WorkbookFactory.create(fis);
	 Sheet sh = book.getSheet(sheet);
	 Row r = sh.getRow(row);
	 String data = r.getCell(cell).getStringCellValue();
	  book.close();
	 return data;
	 }
 
 /**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 
	 * @throws Throwable
	 */

    public void  setDataexcel(String sheet,int row,int cell,String data) throws Throwable
    {
    	FileInputStream fis=new FileInputStream("./data/campaign.xlsx");
    	Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet);
		Row r = sh.getRow(row);
		r.getCell(cell).setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./data/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	
    }
    
    
    /**
	 * used to get the last used row number on specified Sheet
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable
	{
		FileInputStream fis  = new FileInputStream("./data/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		wb.close();
		return sh.getLastRowNum();
	}
	/**
	 * This method is used to read data from excel &provide data to dataprovider
	 * @param sheet
	 * @return
	 * @throws Throwable
	 */
	public Object[][] getdatafordataprovider(String sheet) throws Throwable
	{
		FileInputStream fis=new FileInputStream(IConstants.EXCELPATH);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheet);
		int rowcount = sh.getLastRowNum();
		int cellcount = sh.getRow(0).getLastCellNum();
		Object[][] data=new Object[rowcount][cellcount];
		for(int i=0;i<rowcount;i++)
		{
			for(int j=0;j<cellcount;j++)
			{
				 
				data[i][j]= sh.getRow(i+1).getCell(j).getStringCellValue();
                			
			}
		}
		return data; 
	}
}
