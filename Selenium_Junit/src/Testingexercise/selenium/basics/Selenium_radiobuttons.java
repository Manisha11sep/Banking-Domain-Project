
package exercise.selenium.basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;




public class Selenium_radiobuttons {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		//driver.findElement(By.xpath(".//*[@id='post-body-4966932485064487229']/div[1]"));
	//Select sel1= new Select(driver.findElement(By.xpath("//input[@type='radio' and @name='lang']")));
	
		List<WebElement> list = driver.findElements(By.xpath("//input[@type='radio' and @name='lang']"));
		
				
	int size=list.size();
	
	System.out.println("Size of list is"+size);
	
for(int i=0; i<size;i++)
{
	WebElement radio = list.get(i);
	String value = radio.getAttribute("value");
System.out.println("vALUES ARE " + value);

if(value.equalsIgnoreCase("ruby"))
{
	radio.click();
	System.out.println("Ruby is selected");
}
}
screenshot_lib.screenshot(driver, "first");
	 
	}

}
