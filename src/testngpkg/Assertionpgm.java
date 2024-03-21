package testngpkg;


import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Assertionpgm {
	ChromeDriver driver;
	String baseurl="https://www.facebook.com";
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void verifytitle()
	{
		String exp="facebook";
		String act=driver.getTitle();
		Assert.assertEquals(act, exp);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
