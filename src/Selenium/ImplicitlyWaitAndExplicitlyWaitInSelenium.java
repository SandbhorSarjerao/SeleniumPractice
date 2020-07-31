package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitlyWaitAndExplicitlyWaitInSelenium 
{
	public static WebDriver driver = null ;
	public static void main(String[] args) 
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.google.com/gmail/about/");
		driver.manage().window().maximize();
		
		
		WebElement SIGNIN = driver.findElement(By.xpath("//*[text()='Sign In']"));
		WebElement EmailID = driver.findElement(By.xpath("//input[@id='identifierId']"));
		WebElement NextButton = driver.findElement(By.xpath("//*[@id='identifierNext']"));
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement NextButton2 = driver.findElement(By.xpath("//*[@id='passwordNext']"));
		clickOn(driver,SIGNIN,5);
		sendKeys(driver,EmailID,10,"sandbhorsarjerao@gmail.com");
		clickOn(driver,NextButton,5);
		sendKeys(driver,password,10,"Rajguru@3");
		clickOn(driver,NextButton2,5);
	
	}
	
	public static void sendKeys(WebDriver driver , WebElement element, int timeout, String value)
	{
		new WebDriverWait(driver , timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	public static void clickOn(WebDriver driver , WebElement element, int timeout)
	{
		new WebDriverWait(driver , timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
	}
}
