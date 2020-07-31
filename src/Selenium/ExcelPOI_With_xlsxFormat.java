package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelPOI_With_xlsxFormat 
{
	public static void main(String[] args) throws IOException 
	{
		//File fle = new File("C:\\Users\\SARJERAO\\Desktop\\TestExcel.xlsx");
		File fle = new File("C:\\Users\\SARJERAO\\eclipse-workspace\\SeleniumPractice\\tools\\TestExcel.xlsx");
		FileInputStream fis = new FileInputStream(fle);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Data");
		
		for(int i=0 ;  i<sh.getPhysicalNumberOfRows()+1 ; i++)
		{
			for(int j=0 ; j<sh.getRow(0).getPhysicalNumberOfCells() ; j++)
			{
				System.out.print(" | "+ sh.getRow(i).getCell(j).getStringCellValue() +" | ");
			}
			System.out.println();
		}
				
	}
}
