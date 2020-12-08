package Selenium;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class OpenNewTab {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		// DesiredCapabilities cap = DesiredCapabilities.chrome();
		options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		WebDriver driver = new ChromeDriver(options);

		driver.manage().window().maximize();

		driver.get("https://www.myntra.com/");
		// driver.findElement(By.xpath("//a[contains(text(),'Men')]")).click();
		String parentWindowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[contains(text(),'Men')]")).sendKeys(Keys.chord(Keys.CONTROL, Keys.RETURN));
		Thread.sleep(3000);

		ArrayList<String> windowList = new ArrayList<String>(driver.getWindowHandles());
		// windowList = (ArrayList<String>) driver.getWindowHandles();
		driver.switchTo().window(windowList.get(1));
		// String lastWindowHandle = windowList.get(index); 
		
		/*
		 * Set<String> winHandles = driver.getWindowHandles(); String lastWindowHandle =
		 * ""; for (String handle : winHandles) {
		 * System.out.println("Switching to window - > " + handle);
		 * driver.switchTo().window(handle); Thread.sleep(3000); lastWindowHandle =
		 * handle; driver.switchTo().window(lastWindowHandle); Thread.sleep(3000); }
		 */
		Thread.sleep(3000);
		// driver.switchTo().defaultContent();
		driver.switchTo().window(parentWindowHandle);
		Thread.sleep(3000);
		// driver.switchTo().window(lastWindowHandle);
		// Thread.sleep(3000);
		driver.close();
		Thread.sleep(3000);
		driver.quit();
	}

}
