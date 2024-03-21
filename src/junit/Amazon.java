package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {
	
	ChromeDriver driver;
	String baseurl="https://www.amazon.in";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();    //maximize window
	}
	
	@Test
	public void search()
	{
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("mobiles");
		search.submit();
		
		driver.findElement(By.xpath("//div[@id='nav-xshop']/a[4]")).click();
		
		driver.findElement(By.xpath("//div[@id='nav-tools']/a[2]")).click();
		
		driver.navigate().back();   //goes back
						
		driver.findElement(By.xpath("//span[@id='nav-cart-count']")).click();
		driver.navigate().back();
		
		driver.findElement(By.xpath("//div[@id='nav-main']/div/a")).click();
						
	}
	
	
	
	@After
	public void setdown() throws InterruptedException
	{
    	Thread.sleep(5000);
		driver.quit();
	}

}
