package exercise.selenium.basics;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class Selenium_Dropdown {
	WebDriver driver;
	public void DropDownValues()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("https://facebook.com");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		Select sel1= new Select(driver.findElement(By.name("birthday_month")));
		//List<WebElement>month_list=sel1.getOptions();
		sel1.selectByValue("2");
		List<WebElement>dropdown_list = sel1.getOptions();
		System.out.println("Number of list iteams are" + dropdown_list.size() );
		int ListSize = dropdown_list.size();

		
		
		System.out.println("List of iteams are" + ListSize);
		for(int i=0;i<ListSize;i++){
			String month_name = dropdown_list.get(i).getText();
			if(month_name.contentEquals("Sep"))
			{
				System.out.println("ITs your birthday month");
				break;
			}
			System.out.println(month_name);
		}
		

		}
		



	public static void main(String[] args)
	{
		Selenium_Dropdown myObj = new Selenium_Dropdown();
		myObj.DropDownValues();
	}

	}
	

