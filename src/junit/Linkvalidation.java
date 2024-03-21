package junit;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;

public class Linkvalidation {
	
	String link="https://www.google.com";
	
	@Test
	public void test()
	{
		try {
			URL u=new URL(link);
			HttpURLConnection con=(HttpURLConnection)u.openConnection();//type casting
			int code=con.getResponseCode();
			
			if(code==200)
			{
				System.out.println("response code is 200---successfull");
			}
			else
			{
				System.out.println("not expected");
			}
			
			
		} catch (Exception e) 
		{
			System.out.println(e.getMessage());
		}
	}
	

}
