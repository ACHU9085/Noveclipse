package testngpkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reportgeneration 
{
	WebDriver driver;
	String url="https://www.facebook.com";
	
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
	public void beftest()
	{
		reporter=new ExtentHtmlReporter("./Reports/myreport.html");
		reporter.config().setDocumentTitle("AutomationReport");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester Name", "Aiswarya");
		extent.setSystemInfo("Browser Name", "Chrome");
				
	}
	
	@BeforeMethod
	public void urlloading()
	{
		driver=new ChromeDriver();
		driver.get(url);
	}
	
	@Test
	public void fbtitleverification()
	{
		test=extent.createTest("FB Title Verification");
		String exp="facebook";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
	}
	
	@AfterMethod
	public void report(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"Failed Test case is"+result.getName());
			test.log(Status.PASS,"Failed Test case is"+result.getThrowable());
			String screenshotpath=screenshotMethod(driver,result.getName());
			test.addScreenCaptureFromPath(screenshotpath);
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"Passed Test case is"+result.getName());
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,"Skippes Test case is"+result.getName());
		}
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush();
	}
	public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException
    {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destination="./ScreenShot/"+screenshotname +".png";
		FileHandler.copy(src,  new File(destination));
        return destination;
	}
}
