package testngpkg;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Browserpopup {

	ChromeDriver driver;
	String baseurl="https://webcamtests.com/check";
	@Test
	public void popup()
	{
		ChromeOptions options =new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver=new ChromeDriver();
		driver.get(baseurl);
		
		
	}
}
