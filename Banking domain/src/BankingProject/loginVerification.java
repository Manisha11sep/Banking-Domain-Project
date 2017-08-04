package BankingProject;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hslf.util.SystemTimeUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BankingProject.Utility;

public class loginVerification {

	
	static WebDriver driver;
	 static String baseUrl;
	public static String file_path;
	String[][] data=null;
	
	public static void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");

		driver = new ChromeDriver();
		baseUrl= Utility.BASE_URL;
		driver.get("http://www.demo.guru99.com/V4/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}

	public static void loginVerify()
	{
		driver.get("http://www.demo.guru99.com/V4/");
		driver.findElement(By.name("uid")).sendKeys(Utility.user_name);
		driver.findElement(By.name("password")).sendKeys(Utility.password);

		driver.findElement(By.name("btnLogin")).click();
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
	
	
	
	public static void loginVerifyFromExcel() 
	{
			try {
				String[][] testData = Utility.readingFile(Utility.FILE_PATH);
						
				//driver.get(Utility.BASE_URL);
					String username, password;
					username = testData[1][0];
					String username1 = testData[1][1];
					

					for(int i=1; i<= testData.length; i++)
					{
						username = testData[i][0];
						password = testData[i][1];
						System.out.println("User name is " + username);
						System.out.println("Password is " + password);
						setup();
						
						driver.findElement(By.name("uid")).sendKeys(username);
						driver.findElement(By.name("password")).sendKeys(password);
						driver.findElement(By.name("btnLogin")).click();
						
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
						
						/*Alert alt =driver.switchTo().alert();
						String actualBoxtitle = alt.getText();
						alt.accept();
						if(actualBoxtitle.contains(Utility.EXPECT_ERROR))
						{
							System.out.println("Test case is Passed");
							
						}
						else
						{
							System.out.println("Test case is failed");
							
						}
						String actualTitle = driver.getTitle();
						if(actualTitle == Utility.EXPECT_TITLE)
						{
						
					System.out.println("Test case passed. Login successfully");
						
					}
					else
					{
						System.out.println("Test case failed");
					}
					}
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			 //driver.close();
	}
				*/
				
		
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args)  {
		// Code to test the login page//
		
		loginVerifyFromExcel();

}
}