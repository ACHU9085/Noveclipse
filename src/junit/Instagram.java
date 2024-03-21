package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Instagram {
	ChromeDriver driver;
	String baseurl="https://www.instagram.com";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void login() 
	{
		driver.findElement(By.xpath("//form[@id='loginForm']/div/div[1]/div/label/input")).sendKeys("abc@gmail.com");
		WebElement log=driver.findElement(By.xpath("//form[@id='loginForm']/div/div[2]/div/label/input"));
		//log.sendKeys("fsdk");
		log.sendKeys("fsdddk",Keys.ENTER);
		//log.submit();
		
		
		//driver.findElement(By.xpath("//form[@id='loginForm']/div/div[3]/button")).click();
		
	}
	
	
    @After
   	public void setdown()throws InterruptedException
	{
    	Thread.sleep(5000);
		driver.quit();
	}

}
