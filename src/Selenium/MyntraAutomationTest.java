package Selenium;

import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyntraAutomationTest {

	static WebDriver driver;
	static Actions action;
	static WebElement mensSection;

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Drivers//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		// options.addArguments("--disable-notifications");

		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("profile.default_content_setting_values.notifications", 2);
		options.setExperimentalOption("prefs", prefs);

		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		driver = new ChromeDriver(options);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		action = new Actions(driver);
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();

		mensSection = driver.findElement(By.xpath("//a[contains(text(),'Men')]"));
		action.moveToElement(mensSection).perform();

		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Bags & Backpacks')]")))
				.click();

		Thread.sleep(5000);
		// driver.switchTo().alert().accept();

		
		List<WebElement> Category = driver.findElements(By.xpath("//ul[@class='categories-list']//child::li"));
		 for(int i=0;i<Category.size();i++) {
		 	if(Category.get(i).getText().contains("Backpacks")) {
		 	Category.get(i).click(); 
		 	}
		 }
		
		/*
		List<WebElement> t = driver.findElements(By.xpath("//ul[@class='categories-list']//child::li"));
		// identify child nodes with ./child::* expression in xpath
		System.out.println(t.size());
		for (WebElement e : t) {
			System.out.println(e.getText());
			if (e.getText().contains("Backpacks")) {
				action.moveToElement(e.findElement(By.tagName("input"))).click().perform();
			}
		}
		 */
		Thread.sleep(5000);
		 Assert.assertEquals(driver.getTitle().contains("Bags & Backpacks"),true);

		/*
		 if (driver.getTitle().contains("Bags & Backpacks")) {
			System.out.println("Correct Page!!");
		} else {
			System.out.println("Wrong Page!!");
		}
		 */
		driver.quit();
	}
}
