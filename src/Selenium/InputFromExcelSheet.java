package Selenium;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputFromExcelSheet 
{

	public static void main(String[] args) throws Throwable 
	{
		File fle = new File("C:\\Users\\SARJERAO\\eclipse-workspace\\SeleniumPractice\\tools\\TestData.xlsx");
		FileInputStream fis = new FileInputStream(fle);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("Data");

	}

}
