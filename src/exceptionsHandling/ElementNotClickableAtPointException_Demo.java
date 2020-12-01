package exceptionsHandling;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ElementNotClickableAtPointException_Demo {

	public static WebDriver driver;

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void elementNotClickableAtPointExceptionDemo() {
		
		driver.get("https://www.freecrm.com/index.html");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);

		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		
		// driver.findElement(By.name("email")).sendKeys("testing");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email"))).sendKeys("testing");
		driver.findElement(By.xpath("//*[contains(text(),'Login')]")).click();
		
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(3000);
		if (driver != null) {
			driver.quit();
		}
	}
}
