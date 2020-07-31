package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManager_LaunchBrowserWithoutExe 
{
	public WebDriver driver = null ;
	@BeforeMethod
	public void setup()
	{
		/*WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		*/
		
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		
		
		/*
		WebDriverManager.iedriver().setup();
		driver = new InternetExplorerDriver();
		*/
	}

	@Test
	public void test()
	{
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		System.out.println("Title => " + driver.getTitle());
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
