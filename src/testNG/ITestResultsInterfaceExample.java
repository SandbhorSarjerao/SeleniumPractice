package testNG;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class ITestResultsInterfaceExample 
{
	@Test
	public void testCaseFail()
	{
		fail("Fail");
	}
	
	@Test
	public void testCasePass()
	{
		assertTrue(true);
	}
	
	@AfterMethod
	public void getStatus(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			System.out.println("Success Result Status : " + result.getStatus() + " : Method Name : " + result.getMethod().getMethodName());
		}
		else if(result.getStatus()==ITestResult.FAILURE)
		{
			System.out.println("Failure Result Status : " + result.getStatus() + " : Method Name : " + result.getMethod().getMethodName());
		}
	}
		
}
