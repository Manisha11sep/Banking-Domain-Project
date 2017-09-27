package exercise.selenium.basics;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;





public class selenium_Assert {
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");

		 WebDriver driver = new ChromeDriver();
		 driver.get("http://learn-automation.com");
		 String actual_title=driver.getTitle();
		String expected_title="Selenium WebDriver tutorial - Selenium WebDriver tutorial Step by Step";
		Assert.assertEquals(expected_title, actual_title);
		 System.out.println("Resuts are"+ actual_title);
		// Assert.assertTrue(actual_title.contains("Selenium WebDriver tutorial"));
		 		System.out.println("Pass");
		 
		

}


@Test
public void testadd()
{
	var a=10;
	var b=32;
	Assert.assertEquals(a,b);
	}

}
