package Selenium;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_xPaths_Chrome2 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("file:///C:/SARJERAO/IMP%20Docs/Study/Selenium/drive-download-20180527T115250Z-001/xpath%20practice%20xml%20and%20exercise/xpath%20practice%20xml.xml");
		
		System.out.println("1. select all the title nodes ");
		/*
		 1. select all the title nodes  
			=> .//title   OR  .//title[@lang='en']
		 */
		List<WebElement> allBooksTitles = driver.findElements(By.xpath("//title[@lang='en']"));
		for(int i=0; i<allBooksTitles.size(); i++)
		{
			System.out.println("The Title of " + i + " Book is => " + allBooksTitles.get(i).getText());
		}
		System.out.println();
		
		/*
			2. select the title of the first book node under the bookstore element:   
			   => .//title[contains(text(),'Everyday Italian')]
		*/
		System.out.println("2. select the title of the first book node under the bookstore element:");
		WebElement FirstBookTitle = driver.findElement(By.xpath("//title[contains(text(),'Everyday Italian')]"));
		System.out.println("The Title of FirstBook is => " + FirstBookTitle.getText());
		System.out.println();
		
		/*
		 3. select the text from all the price nodes:	
			=> .//price[contains(text(),*)]
		 */
		System.out.println("3. select the text from all the price nodes:");
		List<WebElement> pricelist = driver.findElements(By.xpath("//price[contains(text(),*)]"));
		for(int i=0; i<pricelist.size(); i++)
		{
			System.out.println("The Title of " + i + " Book is => " + allBooksTitles.get(i).getText() + " and Its Price is => "+ pricelist.get(i).getText());
			
		}
		
		System.out.println();
		// 4. select all the price nodes with a price higher than 35:
		System.out.println("4. select all the price nodes with a price higher than 35:");
		List<WebElement> BookPriceSet = driver.findElements(By.xpath("//price[contains(text(),*)]"));
		//String BookPriceList[] = new String[BookPriceSet.size()];
		int BookPriceList[] = new int[BookPriceSet.size()];
		int BookPrice[] = new int[BookPriceList.length];
		//double BookPrice1[] = new double[BookPriceList.length];
		
		int MaxPrice = 35 ;
		for(int i=0; i<BookPriceSet.size(); i++)
		{
			//BookPriceList[i] = (Integer)(BookPriceSet.get(i));
					
			//BookPrice[i] = Integer.parseInt(BookPriceList[i]);
						
			System.out.println("The Title of " + i + " Book is => " + allBooksTitles.get(i).getText() + " and Its Price is => "+ BookPriceList[i]);
			
			if(MaxPrice < BookPriceList[i])
			{
				System.out.println(BookPriceList[i]);
			}
			else
			{
				break ;
			}
		}
		
	}
}
