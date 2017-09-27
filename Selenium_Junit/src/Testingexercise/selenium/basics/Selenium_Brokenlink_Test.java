package exercise.selenium.basics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_Brokenlink_Test {

	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");


		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.google.com");
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println("Number of links are " +list.size());
		
		for (int i=0; i<list.size();i++)
		{
			WebElement ele = list.get(i);
			String url =ele.getAttribute("href");
			verifyActiveLink(url);
		}
		
	}
	public static void verifyActiveLink(String linkUrl)
	{
		
			try {
				URL url= new URL(linkUrl);
				HttpURLConnection connect = (HttpURLConnection)url.openConnection();
				connect.setConnectTimeout(3000);
connect.connect();
				if(connect.getResponseCode()==200)
				{
					System.out.println(linkUrl +"-" + connect.getResponseMessage());
					
				}
				if(connect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND);
				{
					System.out.println(linkUrl +"-"+ connect.getResponseMessage());
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 
		
	
}




