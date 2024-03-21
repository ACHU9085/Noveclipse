package testngpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datepick {
	WebDriver driver;
	String baseurl="https://www.goibibo.com/";		
	@BeforeTest	
	public void setup()
	{		
		driver=new ChromeDriver();
		}
	@BeforeMethod	
	public void urlopen()	
	{		
		driver.get(baseurl);		
		driver.manage().window().maximize();			
		}		
	@Test	
	public void test() throws InterruptedException	
	{		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));		
	    driver.navigate().refresh();				
	    driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div/p[2]")).click();
	    while(true)		
	    {		
	    	WebElement month=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div"));
	    	String monthtext=month.getText();
	    	System.out.println(monthtext);				
	    	if (monthtext.equals("August 2024"))		
	    	{			
	    		break;		
	    	}		
	    	else		
	    	{			
	    		driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();					
	    		
	    	}
	    	}			
	    List<WebElement> dates=driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/p"));		
	    	for( WebElement date:dates)		
	    	{		
	    		String dt=date.getText();		
	    		if(dt.equals("16"))		
	    		{			
	    			date.click();					
	    			}		
	    		}			
	    	driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();			
	    	}

}
