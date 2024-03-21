package junit;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alllinkvalidation {
	
	ChromeDriver driver;
	String baseurl="https://www.facebook.com";
	
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.get(baseurl);
	}
	
	
	@Test
	public void link()
	{
		List<WebElement> li=driver.findElements(By.tagName("a"));
	    System.out.println("link count: "+li.size());
	    for(WebElement ele:li)
	    {
	    	String link=ele.getAttribute("href");
	    	verify(link);
	    }
	}


	private void verify(String link)
	{
		try {
			URL u=new URL(link);
			HttpURLConnection con=(HttpURLConnection)u.openConnection();
			if(con.getResponseCode()==200)
			{
				System.out.println("response code=200--successfull");
			}
			else if(con.getResponseCode()==404)
			{
				System.out.println("broken link");
			}
			else
			{
				System.out.println("not expected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	@After
	public void setdown()
	{
		driver.quit();
	}
	
}
		
	


