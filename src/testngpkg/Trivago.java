package testngpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Trivago {
	ChromeDriver driver;
	String url="https://www.trivago.com/";
	
	@BeforeTest
	public void urlloading()
	{
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@Test
	public void datepic()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
		driver.navigate().refresh();
		driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section[1]/div[2]/div[4]/div/div/fieldset/button[1]/span/span[2]/span[1]")).click();
		
		while(true)
		{
			WebElement month=driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/h3"));
			
			String monthtext=month.getText();
			
			if(monthtext.equals("May 2024"))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/button[2]/span")).click();
				
			}
		}
		
		List<WebElement>dates=driver.findElements(By.xpath("//*[@id=\"__next\"]/div[1]/div[1]/section[1]/div[2]/div[4]/div/div[2]/div/div/div/div[2]/div/div[1]/div[2]/button/time"));
	  try
	  {
	  
		for(WebElement date:dates)
	    {
	    	String dt=date.getText();
	    	if(dt.equals("4"))
	    	{
	    		date.click();
	  	    }
	    	if(dt.equals("5"))
	    	{
	    		date.click();
	  	    }
	    	
	 	}
	  }
	  catch(Exception e)
      {
   	   System.out.println(e.getMessage());
      }
	   
	  	
	}
	
	 @AfterTest
	 public void close() throws InterruptedException
	 {
		 Thread.sleep(2000);
		 driver.quit();
	 }
	

}
