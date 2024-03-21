package junit;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Linktext {
	ChromeDriver driver;
	String baseurl="https://www.facebook.com";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void linkcnt()
	{
		List<WebElement> linklist=driver.findElements(By.tagName("a"));
		System.out.println(linklist.size());
		
		/*for(int i = 0; i < linklist.size(); i++)
		{
			System.out.println(linklist.get(i).getText());
		}*/
		for(WebElement ele:linklist)
		{
			String link=ele.getAttribute("href");
			String linktext=ele.getText();
			System.out.println(link+"......."+linktext);
		}
	}
	
	@After
	public void setdown()
		{
	    	
			driver.quit();
		}

}
