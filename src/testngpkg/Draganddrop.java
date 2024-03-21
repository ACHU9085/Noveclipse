package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Draganddrop {
	
	ChromeDriver driver;
	String baseurl="https://demo.guru99.com/test/drag_drop.html";
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void draganddrop() throws InterruptedException
	{
		WebElement bank=driver.findElement(By.xpath("//*[@id=\"credit2\"]/a"));
		WebElement account=driver.findElement(By.xpath("//*[@id=\"bank\"]/li"));
		WebElement fivethsnd=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement amount=driver.findElement(By.xpath("//*[@id=\"amt7\"]/li"));
		WebElement sales=driver.findElement(By.xpath("//*[@id=\"credit1\"]/a"));
		WebElement caccount=driver.findElement(By.xpath("//*[@id=\"loan\"]/li"));
		WebElement fivethsnd1=driver.findElement(By.xpath("//*[@id=\"fourth\"]/a"));
		WebElement camount=driver.findElement(By.xpath("//*[@id=\"amt8\"]/li"));
		
		Actions act=new Actions(driver);
		act.dragAndDrop(bank, account).perform();
		act.dragAndDrop(fivethsnd, amount).perform();
		act.dragAndDrop(sales, caccount).perform();
		act.dragAndDrop(fivethsnd1, camount).perform();
		
		WebElement perfect=driver.findElement(By.xpath("//*[@id=\"equal\"]"));
		if(perfect.isDisplayed())
		{
			System.out.println("perfect button is displayed");
		}
		else
		{
			System.out.println("not displayed");
		}
		
		Thread.sleep(2000);
		
	}
	
	@AfterTest
	public void setdown()
	{
		driver.quit();
	}

}
