package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Facebooklogin {
	
	ChromeDriver driver;
	String baseurl="https://www.facebook.com";
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
		
	@BeforeMethod
	public void urlloading()
	{
		driver.get(baseurl);
	}
	@Parameters({"userid","pswd"})
	@Test
	public void login(String userid,String pswd) throws InterruptedException
	{
		driver.findElement(By.id("email")).sendKeys(userid);
		driver.findElement(By.name("pass")).sendKeys(pswd);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void setdown()
	{
		driver.quit();
	}
	 

}
