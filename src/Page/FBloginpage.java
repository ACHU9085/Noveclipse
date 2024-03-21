package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FBloginpage {

	WebDriver driver;
	By fbemail= By.id("email");
	By fbpass=By.id("pass");
	By fblogin=By.name("login");
	By create=By.xpath("//*[@id=\"reg_pages_msg\"]/a");
	By sign=By.xpath("//*[@id=\"blueBarDOMInspector\"]/div/div[2]/div/div/span/a");
	
	public FBloginpage(WebDriver driver)
	{
	this.driver=driver;
	}
	
	
	public void setvalues(String username, String password)
	{
		driver.findElement(fbemail).sendKeys(username);
		driver.findElement(fbpass).sendKeys(password);
	}
	
	public void loginclick()
	{
		driver.findElement(fblogin).click();
	}
	
	public void createpage()
	{
		driver.findElement(create).click();
	}
	
	public void signup()
	{
		driver.findElement(sign).click();
	}
//	public void title(String exp)
//	{
//		String acttitle=driver.getTitle();
//		if(exp.equals(acttitle))
//		{
//			System.out.println("title is "+exp+"--pass");
//		}
//		else
//		{
//			System.out.println("title not as expected-- fail");
//		}
//	}
	public String title()
	{
		String act=driver.getTitle();
		return act;
	}
	public void closepage()
	{
		driver.quit();
	}
}
