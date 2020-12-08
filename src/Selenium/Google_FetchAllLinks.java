package Selenium;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Google_FetchAllLinks {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		// DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);

		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		Thread.sleep(3000);
		String pageTitle = driver.getTitle();
		System.out.println("current url ==> " + driver.getCurrentUrl());
		System.out.println("Page Title ==> " + pageTitle);
		// System.out.println("Page source ==> "+ driver.getPageSource());

		List<WebElement> pageLinks = driver.findElements(By.tagName("a"));
		for (WebElement link : pageLinks) {
			System.out.println(link.getText());
		}

		Iterator<WebElement> listIterator = pageLinks.iterator();
		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}

		driver.quit();
	}

}
