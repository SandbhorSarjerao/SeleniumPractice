package testNG;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class demo_guru99_com_v4_login {

	public WebDriver driver;
	public String baseURL = "https://demo.guru99.com/v4/";
	public String username = "mngr293179";
	public String password = "bEhysEh";

	@BeforeMethod
	public void setUpTest() 
	{
		// DesiredCapabilities cap = new DesiredCapabilities();
		ChromeOptions cap = new ChromeOptions();
	    cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(cap);

		driver.manage().window().fullscreen();
	}

	@Test(priority = 1, enabled = true)
	public void loginTest() throws InterruptedException 
	{
		driver.get(baseURL);
		Thread.sleep(3000);

		WebElement closeBtnIframe = driver.findElement(By.id("flow_close_btn_iframe"));
		WebElement closeBtn = driver.findElement(By.id("closeBtn"));

		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Total Frames ===>>" + size);

		final List<WebElement> iframes = driver.findElements(By.tagName("iframe"));
		for (WebElement iframe : iframes) {
			System.out.println("Frame name :- " + iframe.getAttribute("name"));
		}

		WebElement txtUserName = driver.findElement(By.name("uid"));
		txtUserName.sendKeys(username);

		WebElement txtPassword = driver.findElement(By.name("password"));
		txtPassword.sendKeys(password);

		WebElement btnLogin = driver.findElement(By.name("btnLogin"));
		btnLogin.click();
		// Use Config.properties for URL

		String pageTitle = driver.getTitle();
		Assert.assertEquals(pageTitle, "Guru99 Bank Manager HomePage");

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
