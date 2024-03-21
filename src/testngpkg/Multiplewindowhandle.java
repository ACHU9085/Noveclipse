package testngpkg;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Multiplewindowhandle {
	ChromeDriver driver;
	String base="https://demo.guru99.com/popup.php";
	
	@BeforeTest
	public void urlloading()
	{
		driver=new ChromeDriver();
		
	}
	
	@Test
	public void handling() throws InterruptedException
	{
		driver.get(base);
		
		String parentwindow=driver.getWindowHandle();
		
		WebElement clickhere=driver.findElement(By.xpath("/html/body/p/a"));
		clickhere.click();
		
		Set<String> handles=driver.getWindowHandles();
		
		for(String window:handles)
		{
			if(!window.equalsIgnoreCase(parentwindow))
			{
				driver.switchTo().window(window);
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[5]/td[2]/input")).sendKeys("abc.gmail.com");
				driver.findElement(By.xpath("/html/body/form/table/tbody/tr[6]/td[2]/input")).click();
				Thread.sleep(2000);
				driver.close();
			}
		}
		driver.switchTo().window(parentwindow);
		
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}

}
