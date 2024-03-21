package testngpkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Automationexcersice 
{
	ChromeDriver driver;
	String baseurl="https://automationexercise.com/login";
	
	@BeforeTest
	public void urlload()
	{
		driver= new ChromeDriver();
		driver.get(baseurl);
	}
	
	@Test
	public void signup() throws InterruptedException
	{
		WebElement name=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
		name.sendKeys("Ravi");
		WebElement email=driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
		email.sendKeys("ravinc57@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
		
		driver.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("@Ravi1957");
		
		WebElement day=driver.findElement(By.xpath("//*[@id=\"days\"]"));
		Select daydetails=new Select(day);
		daydetails.selectByValue("2");
		
		WebElement month=driver.findElement(By.xpath("//*[@id=\"months\"]"));
		Select monthdetails=new Select(month);
		monthdetails.selectByValue("2");	
		
		WebElement year=driver.findElement(By.xpath("//*[@id=\"years\"]"));				
		Select yeardetails=new Select(year);
		yeardetails.selectByValue("1957");
		
		driver.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"optin\"]")).click();	
		
		driver.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys("FACT");
		
		driver.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys("Ravi");
		
		driver.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys("NC");
		
		driver.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys("CUSAT");
		driver.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("Kalamassery");
		
		WebElement country=driver.findElement(By.xpath("//*[@id=\"country\"]"));
		Select countrydetails=new Select(country);
		countrydetails.selectByValue("India");
		
		driver.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys("Kerala");
		
		driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Kochi");
		
		driver.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys("683502");
		
		driver.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys("9919097278");
		
		driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button")).click();
		
		Thread.sleep(2000);
	}


	@AfterTest
	public void setdown()
	{
		driver.quit();
	}
}
