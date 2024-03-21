package testngpkg;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Datadriven 
{
	ChromeDriver driver;
	String baseurl="https://www.facebook.com";
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
	}
	
	@Test
	public void datadriven() throws IOException, InterruptedException
	{
		driver.get(baseurl);
		
		FileInputStream fi=new FileInputStream("C:\\Users\\aiswa\\OneDrive\\Desktop\\book.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet sh=wb.getSheet("Sheet1");
		int rowcount=sh.getLastRowNum();
		System.out.println("rowcount ="+rowcount);
		
		for(int i=1;i<=rowcount;i++)
		{
			String username=sh.getRow(i).getCell(0).getStringCellValue();
			System.out.println("username ="+username);
			String paswd=sh.getRow(i).getCell(1).getStringCellValue();
			System.out.println("password ="+paswd);
			
			driver.findElement(By.id("email")).clear();
			driver.findElement(By.id("email")).sendKeys(username);
			driver.findElement(By.name("pass")).sendKeys(paswd);
			driver.findElement(By.name("login")).click();
			Thread.sleep(3000);
			
		}
		
		
	}
	
	@AfterTest
	public void setdown()
	{
		driver.quit();
	}
	 

	


}
