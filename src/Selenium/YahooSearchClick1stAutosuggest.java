package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooSearchClick1stAutosuggest 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.yahoo.com/?p=us");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement YahooSearch = driver.findElement(By.xpath("//*[@id='uh-search-box']"));
		YahooSearch.click();
		YahooSearch.sendKeys("How stuff works");
		
		WebElement FirstAutoSuggest = driver.findElement(By.xpath("//span[@id='uh-assist-link-1']"));
		FirstAutoSuggest.click();
	}
}
