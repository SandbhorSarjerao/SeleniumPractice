package exceptionsHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StaleElementException_Demo {

	WebDriver driver;
	String baseUrl;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled = false)
	public void staleElementExceptionDemo() {
		baseUrl = "https://letskodeit.teachable.com/p/practice";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(baseUrl);

		WebElement bmwCheck = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("bmwcheck")));
		driver.get(driver.getCurrentUrl());
		// driver.navigate().refresh();
		bmwCheck.click();
	}

	@Test(priority = 2, enabled = false)
	public void staleElementReferenceExceptionDemo() throws InterruptedException {
		// Exception ==> org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
		baseUrl = "http://www.pavantestingtools.com/";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(baseUrl);

		WebElement trainingLnk = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Training')]")));
		trainingLnk.click();
		WebElement onlineLink = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Online')]")));
		onlineLink.click();
		Thread.sleep(3000);
		driver.navigate().back();
		Thread.sleep(3000);
		try {
			trainingLnk.click();
		} catch (StaleElementReferenceException e) {
			trainingLnk = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Training')]")));
			trainingLnk.click();
		}

		onlineLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Online')]")));
		onlineLink.click();

	}

	@Test(priority = 3, enabled = true)
	public void staleElementReferenceExceptionDemoFreeCRM() throws InterruptedException {
		// Exception ==> org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document
		baseUrl = "https://ui.freecrm.com/";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get(baseUrl);

		WebElement userName = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
		userName.sendKeys("test123");
		WebElement password = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		password.sendKeys("test123");
		Thread.sleep(3000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		
		try {
		userName.sendKeys("test123");}
		catch(StaleElementReferenceException e) {
			userName = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
			userName.sendKeys("test123");
		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("test123");
	}
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}
}
