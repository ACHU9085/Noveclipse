package junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linkcount {
	
	ChromeDriver driver;
	String baseurl="https://www.facebook.com";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void linkcnt()
	{
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());
	}
	
	@After
	public void setdown()throws InterruptedException
		{
	    	Thread.sleep(5000);
			driver.quit();
		}
		
	}
	


