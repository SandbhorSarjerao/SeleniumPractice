package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("file:///C:/Users/ssandbho/OneDrive%20-%20Capgemini/Desktop/ComedyShow.html");
		driver.findElement(By.id("Text24")).sendKeys("12345");
		driver.findElement(By.id("Button4")).click();
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		Thread.sleep(3000);
		driver.findElement(By.id("Text1")).sendKeys("123456789");
		driver.findElement(By.id("Button4")).click();
		Thread.sleep(3000);
		driver.quit();
	}

}
