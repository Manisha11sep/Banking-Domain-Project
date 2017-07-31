package BankingDomain;



import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class VerifyLogin {
	
	static WebDriver driver;
	private static String baseUrl;
	
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		baseUrl= Utility.BASE_URL;
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}

	
	public static void main(String[] args) {
		// Code to test the login page//

	setup();

		
		try {
			
			driver.get("http://www.demo.guru99.com/V4/");
		
			driver.findElement(By.name("uid")).sendKeys(Utility.user_name);
			driver.findElement(By.name("password")).sendKeys(Utility.password);
	
			driver.findElement(By.name("btnLogin")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Code to verify the successful login and Title of homepage//
		
	String expected_title=driver.getTitle();
	Assert.assertEquals(expected_title,"Guru99 Bank Manager HomePage" );
	System.out.println("Title of home page is matched");
	
	String Welcome = driver.findElement(By.xpath("//marquee")).getText();
if(Welcome.contains("Welcome"))
		{
	System.out.println("Test case passed. Login successfully");
	
}
else
{
	System.out.println("Test case failed");
}
	
		

	}

}
