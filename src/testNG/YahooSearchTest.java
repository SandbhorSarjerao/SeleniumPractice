package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class YahooSearchTest 
{
	public WebDriver driver ;
	public WebElement SearchText;
	
	@BeforeTest
	public void launchBrowser()
	{
		driver = new FirefoxDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		SearchText = driver.findElement(By.xpath("//*[@name='q']"));
	}
	
	@Test
	public void verifyTitle() throws InterruptedException
	{
		System.out.println("Test For Verify Title ");
		Assert.assertTrue(driver.getTitle().contains("Google"));
		Thread.sleep(300);
	}
	
	@Test
	public void searchTest_howStuffWorks() throws InterruptedException
	{
		SearchText.click();
		System.out.println("Test For how stuff works ? ");
		SearchText.sendKeys("how stuff works ?");
		Thread.sleep(300);
	}
	
	@Test
	public void searchTest_whatToSearch() throws InterruptedException
	{
		SearchText.click();
		System.out.println("Test For how to control wife ? ");
		SearchText.sendKeys("how to control wife ?");
		Thread.sleep(300);
	}
	
	@AfterTest
	public void clearText_CloseBrowser() throws InterruptedException
	{
		SearchText.clear();
		SearchText.sendKeys("");
		Thread.sleep(300);
		
		driver.manage().deleteAllCookies();
		driver.quit();
	}
}
