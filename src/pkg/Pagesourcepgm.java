package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class Pagesourcepgm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String baseurl="https://www.google.com/";
		ChromeDriver driver=new ChromeDriver();
		driver.get(baseurl);
		String src=driver.getPageSource();
		if(src.contains("Gmail"))
		{
			System.out.println("Gmail is present");
		}
		else
		{
			System.out.println("Gmail not present");
		}
		driver.quit();

	}

}
