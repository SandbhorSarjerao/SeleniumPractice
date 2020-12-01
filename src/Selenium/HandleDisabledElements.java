package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleDisabledElements {

	// Exception => org.openqa.selenium.InvalidElementStateException: invalid element state
	
	WebDriver driver;
	String baseUrl;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
	}

	@Test
	public void handleDisabledElementsDemo() {
		// <input value="AINFCbYAAAAAX6qPN3RJ6qgYoOQMAnJbFvDJ5aUjSdMs" disabled="true" name="iflsig" type="hidden">
		WebElement iflsig = driver.findElement(By.name("iflsig"));
		System.out.println("Element iflsig is Enabled ? " + iflsig.isEnabled());
		// iflsig.clear();
		// iflsig.click();
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}

}
