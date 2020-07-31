package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelPOI_With_xlsFormat 
{

	public static void main(String[] args) throws IOException 
	{
		//File src = new File("C:\\Users\\SARJERAO\\Desktop\\TestExcel.xls") ;
		File src = new File("C:\\Users\\SARJERAO\\eclipse-workspace\\SeleniumPractice\\tools\\TestExcel.xls");
		FileInputStream fis = new FileInputStream(src) ;
		HSSFWorkbook wb = new HSSFWorkbook(fis);
		HSSFSheet sh = wb.getSheet("Data") ;
		
		for(int i=0 ; i<sh.getPhysicalNumberOfRows()+1; i++)
		{
			for(int j=0 ; j<sh.getRow(0).getPhysicalNumberOfCells(); j++)
			{
				System.out.print(sh.getRow(i).getCell(j).getStringCellValue() + " | ");
			}
			System.out.println();
		}
	
	
		/*for(int i=0 ; i<sh.getPhysicalNumberOfRows()+1 ; i++)
		{
			for(int j=0 ; j<sh.getRow(0).getPhysicalNumberOfCells(); j++)
			{
				System.out.print(sh.getRow(i).getCell(j).getStringCellValue());
			}
			System.out.println();
		}*/
	}

}
