package exercise.selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Day1 {
	WebDriver driver;
	
	public void invokeBrowser()
	{
	try {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.findElement(By.name("firstname")).sendKeys("manisha");
		driver.findElement(By.name("lastname")).sendKeys("Laller");
		Select sel1= new Select(driver.findElement(By.name("birthday_month")));
		sel1.selectByValue("2");
		Select sel2 = new Select(driver.findElement(By.id("day")));
		sel2.selectByVisibleText("11");
		Select sel3=new Select(driver.findElement(By.id("year")));
		sel3.selectByValue("1988");
		
	driver.findElement(By.xpath(".//*[@id='u_0_i']")).click();
	
	driver.findElement(By.linkText("https://www.facebook.com/pages/create/?ref_type=registration_form")).click();
		
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
	
	
public static void main(String[] args)
{
	Day1 myObj = new Day1();
	myObj.invokeBrowser();
}

}