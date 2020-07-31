package Selenium;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableMoneyRediff 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/index.html");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS) ;
		WebElement GainersLosers = driver.findElement(By.xpath("//*[@id='moremoney']"));
		GainersLosers.click(); 
		
		String TechM = "Tech Mahindra Ltd.";
		String HeroMotoCorp = "Hero MotoCorp" ;
		
		List<WebElement> Companies = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));
		List<WebElement> CurrentPrices = driver.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[4]"));
		
		System.out.println(" Company Name  -->  Current Price ");
		
		for(int i=0 ; i<Companies.size(); i++)
		{
			if(Companies.get(i).getText().equals(TechM)) 
			{
				System.out.println(Companies.get(i).getText() + " --> " + CurrentPrices.get(i).getText());
			}
			else if(Companies.get(i).getText().equals(HeroMotoCorp))
			{
				System.out.println(Companies.get(i).getText() + " --> " + CurrentPrices.get(i).getText());
				break ;
			}
		}
	}
}
