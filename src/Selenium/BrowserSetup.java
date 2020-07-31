package Selenium;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserSetup 
{
	WebDriver driver = null ;
	DesiredCapabilities capabilities = null ;
	
	private static String path = "C:\\Users\\SARJERAO\\eclipse-workspace\\SeleniumPractice\\tools\\";
	private static final String FIREFOX = "firefox" ;
	private static final String CHROME = "chrome" ;
	private static final String INTERNET_EXP = "ie" ;
	
	public BrowserSetup(final String browser)
	{
		try
		{
			this.setupDriver(browser) ;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void setupDriver(final String browser) throws MalformedURLException, IOException
	{
		switch (browser.toLowerCase())
		{
			case BrowserSetup.FIREFOX:
				
				this.capabilities = DesiredCapabilities.firefox() ;
				this.capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				final String firebug = BrowserSetup.path + "firebug-2.0.19.xpi" ;
				final String firepath = BrowserSetup.path + "firepath-0.9.7.1-fx.xpi" ;
				FirefoxProfile profile = new FirefoxProfile();
				try
				{
					profile.addExtension(new File(firebug));
					profile.addExtension(new File(firepath));
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				profile.setPreference("extensions.firebug.allPagesActivation", "on");
				this.capabilities.setCapability(FirefoxDriver.PROFILE, profile);
				this.driver = new FirefoxDriver(this.capabilities);
				
				break ;
				
			case BrowserSetup.CHROME:
				System.setProperty("webdriver.chrome.driver", BrowserSetup.path + "chromedriver.exe");
				this.capabilities = DesiredCapabilities.chrome();
				this.capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				this.driver = new ChromeDriver(this.capabilities);
				
				break ;
				
			case BrowserSetup.INTERNET_EXP:
				System.setProperty("webdriver.ie.driver", BrowserSetup.path + "IEDriverServer.exe");
				this.capabilities = DesiredCapabilities.internetExplorer();
				this.capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
				this.driver = new InternetExplorerDriver(this.capabilities);
				
				break ;
				
			default:
				System.out.println("Incorrect Browser Name, Please provide correct Browser name...");
				break ;
		}
		
		this.browserMaximize();
		this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void browserMaximize()
	{
		this.driver.manage().window().maximize();
	}
	
	public void browserMinimize()
	{
		this.driver.manage().window().maximize();
	}
	
	public void closeAllBrowsers()
	{
		this.driver.quit();
	}
	
	public WebDriver getDriver()
	{
		return this.driver;
	}
	
	
}
