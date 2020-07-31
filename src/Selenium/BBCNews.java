package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BBCNews 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.bbc.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement LatestBusinessNewsBox = driver.findElement(By.xpath("//div[@class='most-popular']"));
		List<WebElement> LatestBusinessNews = LatestBusinessNewsBox.findElements(By.tagName("li"));
		System.out.println(LatestBusinessNews.size());
		
		for(int i=0 ; i<LatestBusinessNews.size() ; i++)
		{
			LatestBusinessNews.get(i).click();
			System.out.println(driver.getTitle());
			driver.navigate().back();
			
			/*
			 * WebElement LatestBusinessNewsBox = driver.findElement(By.xpath("//div[@class='most-popular']"));
			List<WebElement> LatestBusinessNews = LatestBusinessNewsBox.findElements(By.tagName("li"));
			*/
		}
	}
}
















