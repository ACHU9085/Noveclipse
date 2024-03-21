package pkg;

import org.openqa.selenium.chrome.ChromeDriver;

public class Firstscript {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver=new ChromeDriver(); //to launch browser
		driver.get("https://www.google.com"); //to get the application
		String expect="Google";
		String actual = driver.getTitle();
		if(actual.equals(expect)==true)
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		driver.quit();//close entire browser
		//driver.close(); one tab will be closed. 

	}

}
