package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
	
public class Xpathscript {

		ChromeDriver driver;
		String baseurl="https://www.facebook.com";
		
		@Before
		public void setup()
		{
			driver=new ChromeDriver();
			driver.get(baseurl);
		}
		
		@Test
		public void login() 
		{
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("abc@gmail.com");
			driver.findElement(By.xpath("//input[@type='password']")).sendKeys("fsdddk");
			driver.findElement(By.xpath("//button[@value='1']")).click();
			
		}
		
		
	    @After
	   	public void setdown()throws InterruptedException
		{
	    	Thread.sleep(5000);
			driver.quit();
		}
		

	}



