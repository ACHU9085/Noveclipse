package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fileuploadsendkeys {
	
	ChromeDriver driver;
	String baseurl="https://demo.guru99.com/test/upload";
	
	@BeforeTest
	public void url()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}

	@Test
	public void fileupload() throws InterruptedException
	{
		driver.findElement(By.xpath("//*[@id=\"uploadfile_0\"]")).sendKeys("C:/Users/aiswa/OneDrive/Desktop");
		
		WebElement check=driver.findElement(By.xpath("//*[@id=\"terms\"]"));
		if(check.isSelected()==false)
		{
			check.click();
		}
		
		WebElement sub=driver.findElement(By.xpath("//*[@id=\"submitbutton\"]"));
		String text =sub.getText();
		if(text.equals("Submit File"))
		{
			System.out.println("button text is "+text+"--pass ");
		}
		else
		{
			System.out.println("button text not as expected--fail");
		}
		sub.click();
						
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void stop()
	{
		driver.quit();
	}
}
