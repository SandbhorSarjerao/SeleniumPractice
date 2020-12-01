package exceptionsHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class NoSuchElementException_Demo {
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void noSuchElementExceptionDemo() {
		
		// Get NoSuchElementException due to below 3 reasons
		// a. Timing Issue
		// b. incorrect locator or type of locator
		// c. Element is in Frame
		
		// 1. Using implicityWait
		// driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://learn.letskodeit.com/");	
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		// Click on Login 
		// driver.findElement(By.xpath("//a[@href='/sign_in']")).click();
		
		// 2. Using Explicit Wait
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/sign_in']"))).click();
		
		// Send userId in userid input field
		// driver.findElement(By.id("user_email")).sendKeys("testing");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user_email"))).sendKeys("testing");
		
		// c. Element is in Frame
		driver.get("https://letskodeit.teachable.com/p/practice");
		driver.switchTo().frame("courses-iframe");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search-courses"))).sendKeys("testing");
		driver.switchTo().defaultContent();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		if(driver != null) {
			driver.quit();
		}
	}

}
