package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Rediff
{
	ChromeDriver driver;
	String baseurl="https://register.rediff.com/register/register.php?FormName=user_details";
	
	@BeforeTest(alwaysRun=true)
	public void setup()
	{
		driver=new ChromeDriver();
	}
		
	@BeforeMethod(alwaysRun=true)
	public void urlloading()
	{
		driver.get(baseurl);
	}
	
	@Test(groups= {"smoke"})
	public void titleverification()
	{
	 String exp="Rediffmail";
	 String title=driver.getTitle();
	 if(exp.equals(title))
	 {
		 System.out.println("title is correct--pass");
	 }
	 else
	 {
		 System.out.println("title is wrong--fail");
	 }
	}
	 @Test(groups= {"smoke","sanity"})
	 public void logodisplay()
	 {
		 WebElement logo=driver.findElement(By.xpath("//*[@id='wrapper']/table[1]/tbody/tr[1]/td[1]/img"));
			if (logo.isDisplayed())
			{
				System.out.println("logo present--pass");
			}
			else
			{
				System.out.println("logo not present--fail");
			}
	 }
	 
	 @Test(priority=3)
	 public void buttonenable()
	 {
		 WebElement ele=driver.findElement(By.id("Register"));
		 if(ele.isEnabled())
		 {
			 System.out.println("Create Account button is enabled--pass");
		 }
		 else
		 {
			 System.out.println("Create Account button is disabled--fail");
		 }
		 
	 }
	
	 @Test(priority=2)
	 public void textverification()
	 {
		 WebElement ele1=driver.findElement(By.xpath("//table[@id='tblcrtac']/tbody/tr/td[1]"));
		 String exp="Create a Rediffmail account";
		 String text1= ele1.getText();
		 if(text1.equals(exp))
		 {
			 System.out.println("Create a Rediffmail account is displayed--pass");
		 }
		 else
		 {
			 System.out.println("Create a Rediffmail account not displayed--fail");
		 }
	 }
	 
	 @Test
	 public void buttontext()
	 {
		 String textexp="Check availability";
		WebElement ele2=driver.findElement(By.xpath("//*[@id=\"tblcrtac\"]/tbody/tr[7]/td[3]/input[2]")); 
		String text=ele2.getAttribute("value");
		if(text.equals(textexp))
		{
			System.out.println("button text is correct--pass");
		}
		else
		{
			System.out.println("button text is not correct--fail");
		}
	 }
	 
	 @AfterTest
	 public void close()
	 {
		 driver.quit();
	 }
	  
}
