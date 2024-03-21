package testngpkg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Scrolldown {
	ChromeDriver driver;
	String baseurl="https://www.amazon.in";
	
	@BeforeTest
	public void url()
	{
		driver=new ChromeDriver();
		
	}
	
	@Test
	public void scroll() throws InterruptedException
	{
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(baseurl);
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		WebElement Element = driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]/ul/li[1]/a"));
//		js.executeScript("arguments[0].scrollIntoView();", Element);
//		Element.click();
	
		
//	    JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
//		
//		driver.findElement(By.xpath("//*[@id=\"navFooter\"]/div[4]/ul/li[1]/a")).click();
		
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void close()
	{
		driver.quit();
	}
		

}
