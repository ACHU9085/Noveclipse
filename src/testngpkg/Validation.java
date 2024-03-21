package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Validation {

	ChromeDriver driver;
	String baseurl="https://automationexercise.com/login";
	
	@BeforeTest
	public void urlloading()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void validation() throws InterruptedException
	{
		WebElement email=driver.findElement(By.name("email"));
		email.sendKeys("aiswaryaravi90@gmail.com");
		WebElement pswd=driver.findElement(By.name("password"));
		pswd.sendKeys("@Achu9085");
		WebElement login=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button"));
		login.click();
		
		String expurl="https://automationexercise.com/";
		String url=driver.getCurrentUrl();
		if(expurl.equals(url))
		{
			System.out.println("login validation success");
		}
		else
		{
			System.out.println("login validation fail");
		}
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void setdown()
	{
		driver.quit();
	}
}
