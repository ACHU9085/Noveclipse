package junit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Redifflogo {
	
	ChromeDriver driver;
	String baseurl="https://register.rediff.com/register/register.php?FormName=user_details";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void logoverification()
	{
		WebElement logo=driver.findElement(By.xpath("//*[@id='wrapper']/table[1]/tbody/tr[1]/td[1]/img"));
		if (logo.isDisplayed())
		{
			System.out.println("logo present");
		}
		else
		{
			System.out.println("logo not present");
		}
		
		WebElement radio1=driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[24]/td[3]/input[1]"));
		WebElement radio2=driver.findElement(By.xpath("//*[@id='tblcrtac']/tbody/tr[24]/td[3]/input[2]"));
		
		
		if(radio1.isSelected()||radio2.isSelected())
		{
			System.out.println("radio button is selected");
		}
		else
		{
			System.out.println("not selected");
		}
	}
	
	@After
	public void setdown()
	{
		driver.quit();
	}

}
