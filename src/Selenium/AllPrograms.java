package Selenium;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AllPrograms 
{
	public static WebDriver driver = null ;

	public static void main(String[] args) throws Throwable 
	{
		// Code For Complete String Reverse and Word Reverse

		String s = "Life is beautiful enjoy it";
		String parts[] = s.split(" ");
		for(int i=s.length()-1; i>=0; i--)
			System.out.print(s.charAt(i)); // ti yojne lufituaeb si efiL
		System.out.println();
		for(int i=parts.length-1; i>=0; i--)
			System.out.print(parts[i]+" ");	//it enjoy beautiful is Life

// Code For Complete String Reverse and Word Reverse

	int prev,next,sum;
	prev=next=1;
	System.out.print(prev+" ");
	for	(int i=0;i<10;i++)
	{
		sum= prev+next;
		System.out.print(sum+" ");
		prev=next;
		next=sum;
	}

// Code For Factorial Number

		int fact=1;
		int n=4;
		for(int i=1;i<=n;i++)
		fact=fact*i;
		System.out.println(fact);

 // Swipe Two Numbers without Using Third Variable

		 int a = 50;
		 int b = 40;
		 a=a+b;
		 b=a-b;
		 a=a-b;
		 System.out.println("A = "+a+" B = "+b);

// Find Greater Number From Array

		int[] a2={1,5,2,3,40};
		int gt=0;
		for(int i=0;i<a2.length;i++)
			if(a2[i]>gt) gt=a2[i];
		System.out.println("Greater No. in Array : "+gt);

// Find Second Greater Number From Array

		int[] a1={1,5,70,30,10};
		int gt1=0, gt2=0;
		for(int i=0;i<a1.length;i++)
		{
			for(int j=0;j<a1.length;j++)
			{
				if(a1[i]>a1[j])
				{
					a1[i]=a1[i]+a1[j];
					a1[j]=a1[i]-a1[j];
					a1[i]=a1[i]-a1[j];
				}
			}
		}
		for(int i=0;i<a1.length;i++)
		System.out.print(a1[i]+" ");
		System.out.print("Second Greater Number : "+a1[1]);

 // Convert First Character of String to Upper Case

		String s1 = "hello how are you";
		String parts1[] = s1.split(" ");
		for(int j=0;j<parts1.length;j++)
		{
			char[] ca = parts1[j].toCharArray();
			for(int i=0;i<ca.length;i++)
			{
				ca[0] = Character.toUpperCase(ca[0]);
				System.out.print(ca[i]);
				if(i==(ca.length-1)) System.out.print(" ");
			}
		}

// String to Char Array to String

// String to Char Array Conversion
		String s2 = "Welcome to Java";
		char a4[] = s2.toCharArray();
//Char Array to String conversion
		char b1[] = {'a','b','c','d'};
		String s11 = new String(b1);



 // To check Palindrome String

		String ss1 = "madam";
		StringBuilder s12 = new StringBuilder(ss1);
		StringBuilder s21 = s12.reverse();
		String ss2=s2.toString();
		System.out.println("Actual  String : "+ss1);
		System.out.println("Reverse String : "+ss2);
		if(ss1.equals(ss2)) System.out.println("String is Palindrome");
		else System.out.println("NOT Palindrome");




// Open a Link in a new Tab

		WebElement link = driver.findElement(By.xpath("//*[@id='mw-content-text']/p[1]/strong[2]/a"));
		Actions act = new Actions(driver);
		act.contextClick(link).perform();
		Thread.sleep(5000);
		act.sendKeys("k");




// Use of Random Function

		List<String> abc = new ArrayList<String>();
		abc.add(0, "New Delhi");
		abc.add(1, "Kochhi");
		abc.add(2, "Mumbai");
		abc.add(3, "Banglore");
		Random r = new Random();
		String random = abc.get(r.nextInt(abc.size()));
		System.out.println(random);




// Capturing Screenshot
			String screenshotName = "" ;
			TakesScreenshot ts=(TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
			System.out.println("Screenshot taken");

	}

}
