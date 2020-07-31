package PasswordEncodeDecode;

import PasswordEncodeDecode.EncodingDecodingPassword;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCaseWithPasswordEncodeDecode2 {
	
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("http://demo.nopcommerce.com/login");
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Shivajirao.Shivajirao@gmail.com");
		// driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test123");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(EncodingDecodingPassword.decodePassword("VGVzdDEyMw=="));
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
	}	
}
