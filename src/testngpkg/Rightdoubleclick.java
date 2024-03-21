package testngpkg;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rightdoubleclick {
	
	ChromeDriver driver;
	String baseurl="https://demo.guru99.com/test/simple_context_menu.html";
	
	@BeforeTest
	public void url()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void test() throws InterruptedException
	{
	WebElement right=driver.findElement(By.xpath("//*[@id=\"authentication\"]/span"));
	Actions act=new Actions(driver);
	act.contextClick(right);
	act.perform();
	
	WebElement edit=driver.findElement(By.xpath("//*[@id=\"authentication\"]/ul/li[1]"));
	act.click(edit);
	act.perform();
	
	Alert a=driver.switchTo().alert();
    a.accept();
    
    Thread.sleep(2000);
    
    WebElement dclick=driver.findElement(By.xpath("//*[@id=\"authentication\"]/button"));
    act.doubleClick(dclick);
    act.perform();
    Alert b=driver.switchTo().alert();
    String alertext=b.getText();
    System.out.println("alerttext = "+alertext);
    b.accept();
    
    Thread.sleep(3000);
		
	}
	
	@AfterTest
	public void stop()
	{
		driver.quit();
	}
	

}
