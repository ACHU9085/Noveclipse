package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Page.FBloginpage;


public class FBcreatepage {
	WebDriver driver;
	String url="https://www.facebook.com";
	
	
	
	@BeforeTest
	public void setup()
	{
	driver=new ChromeDriver();
	driver.get(url);
	}
	
	@Test
	public void test()
	{
		FBloginpage ob =new FBloginpage(driver);
		ob.createpage();
		//ob.title("Facebook");
		String actualtitle=ob.title();
		Assert.assertEquals(actualtitle, "Facebook");
		ob.signup();
		ob.closepage();
	}

}
