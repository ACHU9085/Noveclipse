package pkg;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
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

public class Reportgeneration2 {
	ChromeDriver driver;
	String url="https://www.facebook.com";
	
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	
	@BeforeTest
    public void beftest()
    {
    reporter = new ExtentHtmlReporter("./Reports/myreport2.html");
    reporter.config().setDocumentTitle("Automationreport");
    reporter.config().setReportName("Functional test");
    reporter.config().setTheme(Theme.DARK);
    extent=new ExtentReports();
    extent.attachReporter(reporter);
    extent.setSystemInfo("hostname", "localhost");
    extent.setSystemInfo("os", "window10");
    extent.setSystemInfo("testername", "chrome");
    extent.setSystemInfo("Browser  Name", "chrome");
    driver=new ChromeDriver();
}


@BeforeMethod
public void setUp()
{
	driver.get(url);

    }
@Test
public void fbtitleverification()
{
	test=extent.createTest("Fbtitleverification");
	String Exp="facebook";
	String actual=driver.getTitle();
	Assert.assertEquals(Exp, actual);
}
@Test
public void buttonverification()
{
	
}

@AfterTest
public void teardown()
{
	extent.flush();
}
@AfterMethod
public void browserclose(ITestResult result) throws IOException
{
	if(result.getStatus()==ITestResult.FAILURE)
	{
		test.log(Status.FAIL, "test case failed is"+result.getName());
		test.log(Status.FAIL, "test case failed is"+result.getThrowable());
    //String screenshotpath=screenshotMethod(driver,result.getName());
		//test.addScreenCaptureFromPath(screenshotpath);
	}
	else if(result.getStatus()==ITestResult.SUCCESS)
	{
		test.log(Status.PASS, "test case passed is"+result.getName());

	}
	else if(result.getStatus()==ITestResult.SKIP)
	{
		
		test.log(Status.SKIP, "test case skipped is"+result.getName());

	}
}
//	public static String screenshotMethod(WebDriver driver, String screenshotname) throws IOException
//	{
//		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//		String destination="./Screenshot/"+screenshotname +".jpeg";
//		//File finaldestination=new File(destination);
//		//FileHandler.copy(src, finaldestination);
//		FileHandler.copy(src,  new File(destination));
//   return destination;
//	}
}

