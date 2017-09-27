package exercise.selenium.basics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium_screenshot 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");

		 WebDriver driver = new ChromeDriver();
		driver.get("https://facebook.com");

		screenshot_lib.screenshot(driver, "second");
		
		
	}

	
}
