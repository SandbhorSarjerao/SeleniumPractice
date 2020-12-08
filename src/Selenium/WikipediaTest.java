package Selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WikipediaTest {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		Thread.sleep(3000);
		String pageTitle = driver.getTitle();
		System.out.println("current url ==> "+ driver.getCurrentUrl());
		System.out.println("Page Title ==> "+ pageTitle);
		System.out.println("Page source  ==> "+ driver.getPageSource());
		Thread.sleep(3000);
		driver.quit();
	}

}
