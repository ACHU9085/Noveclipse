package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webpagealert {
	
	ChromeDriver driver;
	String baseurl="file:///C:/Users/aiswa/OneDrive/Desktop/webpage.html";
	
	@Before
	public void setup()
	{
		driver =new ChromeDriver();
		driver.get(baseurl);
		
	}
	
	@Test
	public void alert()
	{
		driver.findElement(By.xpath("/html/body/input[1]")).click();
		
	    Alert a=driver.switchTo().alert();
	    String alertext=a.getText();
	    System.out.println("alerttext = "+alertext);
	    a.accept();
	    
		
		driver.findElement(By.xpath("/html/body/input[2]")).sendKeys("abc");
				
		driver.findElement(By.xpath("/html/body/input[3]")).sendKeys("hhtt");
				
		driver.findElement(By.xpath("/html/body/input[4]")).click();
				
	}
	
	@After
	public void setdown() throws InterruptedException
	{
    	Thread.sleep(5000);
		driver.quit();
	}
	

}
