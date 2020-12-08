package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class CloseQuitDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.get("http://www.popuptest.com/popuptest2.html");
		Thread.sleep(3000);
		driver.close();
		
		driver.get("http://www.popuptest.com/popuptest2.html");
		Thread.sleep(3000);
		driver.quit();
		
		
		
	}

}
