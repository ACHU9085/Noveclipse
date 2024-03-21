package testngpkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datepicker {

 ChromeDriver driver;
 String url="https://www.goibibo.com/";
 
 @BeforeTest
 public void urlload()
 {
	 driver = new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
 }
 
 @Test
 public void datepick()
 {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30)); 
	driver.navigate().refresh();
	WebElement datepkr=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div"));
	datepkr.click();
			 
	 while(true)
	 {
		WebElement month=driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[1]/div"));
		String monthtext=month.getText();
		 
		if(monthtext.equals("May 2024"))
		{
			break;
		}
		else
		{
			driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[1]/span[2]")).click();
		}
	 }
		List<WebElement> dates=driver.findElements(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[2]/div/div/div[2]/div[1]/div[3]/div/div/p"));
		
		for(WebElement date:dates)
		{
			String dt=date.getText();
			if(dt.equals("6"))
			{
				date.click();
			}
		}
	 	 
	 driver.findElement(By.xpath("//*[@id=\"root\"]/div[4]/div/div/div[1]/div[3]/div[2]/div[3]/span[2]")).click();	 
 }
 
 @AfterTest
 public void close()
 {
	 driver.quit();
 }
}
