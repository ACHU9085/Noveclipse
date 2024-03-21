package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class Newsitepgm {

	public static void main(String[] args) {
		
		String baseurl="https://mail.yahoo.com/";
		ChromeDriver driver = new ChromeDriver();
		driver.get(baseurl);
		String expect="Yahoo Mail";
		String actual=driver.getTitle();
		if(actual.contentEquals(expect))
		{
			System.out.println("title is correct");
		}
		else
		{
			System.out.println("title is wrong");
		}
		String s="help";
		
		String src=driver.getPageSource();
		if(src.contains(s))
		{
			System.out.println("help is present");
		}
		else
		{
			System.out.println("help not present");
		}
		driver.quit();

	}

}
