package Selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Assignment_xPaths_Chrome 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		driver.get("file:///C:/SARJERAO/IMP%20Docs/Study/Selenium/drive-download-20180527T115250Z-001/xpath%20practice%20xml%20and%20exercise/xpath%20practice%20xml.xml");
		
		/*
		 1. select all the title nodes  
			=> .//title   OR  .//title[@lang='en']
		 */
		List<WebElement> allBooksTitles = driver.findElements(By.xpath("//title[@lang='en']"));
		for(int i=0; i<allBooksTitles.size(); i++)
		{
			System.out.println("The Title of " + i + " Book is => " + allBooksTitles.get(i).getText());
		}
	
		/*
			2. select the title of the first book node under the bookstore element:   
			   => .//title[contains(text(),'Everyday Italian')]
		*/
		WebElement FirstBookTitle = driver.findElement(By.xpath("//title[contains(text(),'Everyday Italian')]"));
		System.out.println();
		System.out.println("The Title of FirstBook is => " + FirstBookTitle.getText());
	
		/*
		 3. select the text from all the price nodes:	
			=> .//price[contains(text(),*)]
		 */
		List<WebElement> pricelist = driver.findElements(By.xpath("//price[contains(text(),*)]"));
		System.out.println();
		for(int i=0; i<pricelist.size(); i++)
		{
			System.out.println("The Title of " + i + " Book is => " + allBooksTitles.get(i).getText() + " and Its Price is => "+ pricelist.get(i).getText());
		}

		/*
		 4. select the price from all the price nodes whose price is > 35:	
			=> .//price[contains(text(),*)]
		 */
		List<WebElement> bookpricelist = driver.findElements(By.xpath("//price[contains(text(),*)]"));

		String[] BookPrice = new String[bookpricelist.size()] ;
		
		System.out.println();
		System.out.println("Below are the Book-Prices which are Greater Than 35: ");

		for(int i=0; i<bookpricelist.size(); i++)
		{
			  BookPrice[i] = bookpricelist.get(i).getText();

			  double price = Double.parseDouble(BookPrice[i]);

			  if(price > 35)
			  {
            	System.out.println(price);
			  }
		}


		/*
		 5. select the price from all the price nodes whose price is > 35 with Book Name:	
			=> .//price[contains(text(),*)]
		 */
		List<WebElement> pricelistbook = driver.findElements(By.xpath("//price[contains(text(),*)]"));

		String[] BookPrice1 = new String[pricelistbook.size()] ;

		List<WebElement> Books = driver.findElements(By.xpath("//title[@lang='en']"));

		String [] BooksList = new String[Books.size()];
		
		System.out.println();
		System.out.println("Below are the BookNames whose Prices are Greater Than 35: ");

		for(int i=0; i<pricelistbook.size(); i++)
		{
			BookPrice1[i] = pricelistbook.get(i).getText();

			BooksList[i] = Books.get(i).getText();


			double price = Double.parseDouble(BookPrice1[i]);

            if(price > 35)
            {
                 System.out.println(price + " => " + BooksList[i]);
            }
		}
	}
}
