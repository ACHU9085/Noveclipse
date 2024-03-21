package junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Janasya {
	
	ChromeDriver driver;
	String baseurl="https://www.janasya.us/";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void linkcnt()throws InterruptedException
	{
		
		
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());
		
		String title="Janasya";
		String actual=driver.getTitle();
		if(actual.equals(title))
		{
			System.out.println("title is Janasya");
		}
		else
		{
			System.out.println("Title is not Janasya");
			System.out.println("title is "+actual);
		}
		
		driver.findElement(By.id("Search-In-Modal")).click();
		driver.findElement(By.xpath("//div[@id='HeaderNavigation']/nav/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id='halo-sidebar']/div[2]/div[1]/div[2]/div/ul/li[1]")).click();
		Thread.sleep(1000);
	}
	
	@After
	public void setdown() 
	{
   		driver.quit();
	}

}
