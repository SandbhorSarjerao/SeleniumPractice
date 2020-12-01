package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleHiddenElements {

	// Exception ==> org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element 
	//               org.openqa.selenium.ElementNotInteractableException: element not intractable
	
	WebDriver driver;
	String baseUrl;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test(priority = 1, enabled=true)
	public void handleHiddenElementsDemo() throws InterruptedException {
		
		driver.get("https://letskodeit.teachable.com/p/practice");
		
		// <input id="displayed-text" name="show-hide" class="inputs displayed-class" placeholder="Hide/Show Example" type="text" style="display: block;">
		
		WebElement showHideTxt = driver.findElement(By.name("show-hide"));
		System.out.println("Element showHideTxt is Displayed ? " + showHideTxt.isDisplayed());
		Thread.sleep(3000);
		
		WebElement hideBtn = driver.findElement(By.xpath("//input[@id='hide-textbox']"));
		System.out.println("Clicked on Hide Button...");
		hideBtn.click();
		
		// org.openqa.selenium.ElementNotInteractableException: element not intractable
		
		Thread.sleep(3000);
		showHideTxt = driver.findElement(By.name("show-hide"));
		System.out.println("Element showHideTxt is Displayed ? " + showHideTxt.isDisplayed());
		// showHideTxt.clear();
		// showHideTxt.click();
		// showHideTxt.sendKeys("testing");

		WebElement showBtn = driver.findElement(By.xpath("//input[@id='show-textbox']"));
		System.out.println("Clicked on Show Button...");
		showBtn.click();
		
		Thread.sleep(3000);
		showHideTxt = driver.findElement(By.name("show-hide"));
		System.out.println("Element showHideTxt is Displayed ? " + showHideTxt.isDisplayed());
	}
	
	@Test(priority = 2)
	public void expediaHiddenElentTest() {
		
		// Exception ==> org.openqa.selenium.NoSuchElementException: no such element: Unable to locate element
		
		driver.get("https://www.expedia.co.in/");
		WebElement chldDropDown = driver.findElement(By.id("package-1-age-select-1"));
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}
}
