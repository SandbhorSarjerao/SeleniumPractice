package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class NavigationDemo {

	static WebDriver driver;

	/*
	 * public NavigationDemo() { System.setProperty("webdriver.chrome.driver",
	 * "Drivers\\chromedriver.exe");
	 * 
	 * ChromeOptions options = new ChromeOptions(); // DesiredCapabilities cap =
	 * DesiredCapabilities.chrome();
	 * options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	 * options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
	 * 
	 * driver = new ChromeDriver(options); }
	 */

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		// DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.navigate().to("https://www.google.com/");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		WebElement searchTxt = driver.findElement(By.name("q"));
		searchTxt.sendKeys("Capgemini Inida");
		searchTxt.submit();
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		driver.navigate().forward();
		Thread.sleep(3000);
		
		driver.quit();
	}

}
