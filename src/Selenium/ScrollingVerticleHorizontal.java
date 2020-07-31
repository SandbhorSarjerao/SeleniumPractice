package Selenium;

import org.openqa.selenium.WebDriver;

public class ScrollingVerticleHorizontal 
{
	public static WebDriver driver ;
	public static void main(String[] args) 
	{
		driver.manage().window().maximize() ;
		
		int ht = driver.manage().window().getSize().getHeight() ;
		int wd = driver.manage().window().getSize().getWidth() ;


	}

}
