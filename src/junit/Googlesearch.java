package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Googlesearch {
	
	ChromeDriver driver;
	String baseurl="https://www.google.com";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void search()
	{
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("book",Keys.ENTER);
		//search.submit();
		
	}
	
	@After
	public void setdown() throws InterruptedException
	{
    	Thread.sleep(1000);
		driver.quit();
	}
	

}
