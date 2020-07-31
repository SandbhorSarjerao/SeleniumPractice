package Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GmailLogin 
{
	public static WebDriver driver = null ;
	public static void main(String[] args) throws InterruptedException 
	{
		BrowserSetup browser = new BrowserSetup("ie");
		GmailLogin.driver = browser.getDriver();
		// WebDriver driver = new FirefoxDriver();
		driver.get("https://www.google.com/gmail/about/");
		driver.manage().window().maximize();
		WebElement SIGNIN = driver.findElement(By.xpath("//*[text()='Sign In']"));
		SIGNIN.click();
		
		WebElement EmailID = driver.findElement(By.xpath("//input[@id='identifierId']"));
		EmailID.sendKeys("********@****.com");
		
		WebElement NextButton = driver.findElement(By.xpath("//*[@id='identifierNext']"));
		NextButton.click();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("********");
		
		WebElement NextButton2 = driver.findElement(By.xpath("//*[@id='passwordNext']"));
		NextButton2.click();	
		
		Thread.sleep(21000);
		
		/*
		//WebElement ComposeMail = driver.findElement(By.xpath("//a[@text()='Compose Mail']"));
		WebElement ComposeMail = driver.findElement(By.xpath("html/body/table[2]/tbody/tr/td[1]/table[1]/tbody/tr[1]/td/b/a"));
		ComposeMail.click();
		
		WebElement toEmailID = driver.findElement(By.xpath("//*[@id='to'][@name='to']"));
		toEmailID.click();
		toEmailID.sendKeys("SeleniumForSure@gmail.com");
		toEmailID.sendKeys(";");
		
		WebElement subject = driver.findElement(By.xpath("//input[@name='subject']"));
		subject.sendKeys("Gmail-Send Email Assignment");
		
		WebElement emailBody = driver.findElement(By.xpath("//textarea[@name='body']"));
		emailBody.clear();
		emailBody.sendKeys("Gmail-Send Email Assignment Practice, Please ignore!");
		
		WebElement sendButton = driver.findElement(By.xpath("//input[@name='nvp_bu_send']"));
		sendButton.click();
		
		WebElement SignOut = driver.findElement(By.xpath("//*[@id='gb_71']"));
		SignOut.click();
		driver.manage().deleteAllCookies();
		driver.quit();
		 */	
	}
}
