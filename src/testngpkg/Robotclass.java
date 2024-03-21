package testngpkg;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Robotclass {
	
	ChromeDriver driver;
	String baseurl="https://www.ilovepdf.com/merge_pdf";
	
	@BeforeTest
	public void url()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}

	@Test
	public void upload() throws AWTException
	{
		driver.findElement(By.xpath("//*[@id=\"pickfiles\"]/span")).click();
		fileupload("C:\\Users\\aiswa\\OneDrive\\Desktop\\dummy");
	}
	
	public void fileupload(String p) throws AWTException
	{
		StringSelection strselectn=new StringSelection(p);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(strselectn, null);
		
		Robot robot=new Robot();
		
		robot.delay(2000);
		
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);		
		
		robot.delay(2000);
	}
	
	@AfterTest
	public void stop()
	{
		driver.quit();
	}

}
