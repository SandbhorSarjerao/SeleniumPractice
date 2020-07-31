package PasswordEncodeDecode;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCaseWithPasswordEncodeDecode {
	
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("http://demo.nopcommerce.com/login");
		
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("Shivajirao.Shivajirao@gmail.com");
		// driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Test123");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(decodePassword("VGVzdDEyMw=="));
		driver.findElement(By.xpath("//input[@class='button-1 login-button']")).click();
		
	}
	
	public static String encodePassword(String password) {
	        // Encode the Password
	        byte[] ecodedPassword = Base64.encodeBase64(password.getBytes());
	      //  System.out.println("encodePassword: " + new String(ecodedPassword));
	    	
	    	return new String(ecodedPassword);
	    }
	    
	public static String decodePassword(String password) {
	    	
	    	// Decode the Password
	        byte[] decodePassword = Base64.decodeBase64(password);
	      //  System.out.println("decodePassword: " + new String(decodePassword)); 
	    	
	    	return new String(decodePassword);
	    }
}
