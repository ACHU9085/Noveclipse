package testngpkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Amazon {
	
	ChromeDriver driver;
	String baseurl="https://www.amazon.in";
	
	@BeforeTest
	public void url()
	{
		driver=new ChromeDriver();
		
	}
	
	@Test
	public void addcart() throws InterruptedException
	{
		 
		driver.get(baseurl);
		driver.manage().window().maximize();
		
		String parentwindow=driver.getWindowHandle();
		WebElement search=driver.findElement(By.name("field-keywords"));
		search.sendKeys("mobilephones");
		search.submit();
		
		String exptitle="Amazon.in : mobilephones";
		String title=driver.getTitle();
		System.out.println("title is :"+title);
		if(title.equals(exptitle)) 
		{
			System.out.println("tile is correct--pass");
		}
		else
		{
			System.out.println("title incorrect--fail");
		}
		
		driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[4]/div/div/div/div/span/div/div/div/div[1]/div/div[2]/div/span/a/div/img")).click();
		Thread.sleep(2000);
		
		Set<String> handles=driver.getWindowHandles();
		for(String window:handles)
		{
			if(!window.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(window);
				System.out.println("2nd window title: "+driver.getTitle());
		
				driver.findElement(By.xpath("/html/body/div[2]/div/div[5]/div[3]/div[1]/div[3]/div/div[1]/div/div[1]/div/div/div[2]/div/div[2]/div/form/div/div/div[37]/div[1]/span/span/span/input")).click();
				Thread.sleep(2000);																		
			}
			
			
		}
		 
		
		
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}

}
