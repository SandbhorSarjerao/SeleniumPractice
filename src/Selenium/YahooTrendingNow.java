package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class YahooTrendingNow 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://in.yahoo.com/?p=us");
		
		WebElement TrendingNowBox = driver.findElement(By.xpath("//li[@class='trending-list selected']"));
		List<WebElement> TrendingNow = TrendingNowBox.findElements(By.tagName("li"));
		System.out.println(TrendingNow.size());
		for(int i = 0 ; i<TrendingNow.size(); i++)
		{
			System.out.println(TrendingNow.get(i).getText());
		}
	}
}
