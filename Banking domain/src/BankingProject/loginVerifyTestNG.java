package BankingProject;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class loginVerifyTestNG {
	private WebDriver driver;
	private String baseUrl;
	String[][] data=null;

	@DataProvider
	public Object[][] getData() throws Exception 
	{
		System.out.println("In data provider function");
		return (Utility.readingFile(Utility.FILE_PATH));


	} 
	@DataProvider
	public Object[][] getArray()
	{
		//Rows - Number of times your test has to be repeated.
		//Columns - Number of parameters in test data.
		Object[][] data = new Object[3][2];

		// 1st row
		data[0][0] ="mngr88830";
		data[0][1] = "gazehYd";

		// 2nd row
		data[1][0] ="testuser2";
		data[1][1] = "zxcvb";

		// 3rd row
		data[2][0] ="guestuser3";
		data[2][1] = "pass123";

		return data;
	}




	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe");
		baseUrl= Utility.BASE_URL;
		System.out.println("In before method function");
		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

	}


	@Test(dataProvider ="getData")
	public void loginVerify(String username, String password) throws Exception {

		System.out.println("In main function");
		System.out.println("User name is " + username);
		System.out.println("Password is " + password);
		System.out.println("Inside the data provider");
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
		try
		{
			Alert alt =driver.switchTo().alert();
			String actualBoxtitle = alt.getText();
			alt.accept();
			if(actualBoxtitle.contains(Utility.EXPECT_ERROR))
			{
				System.out.println("User name and password is incorrect");

			}

			else
			{
				System.out.println("Test case failed");
			}
		}
		catch(NoAlertPresentException Ex)
		{
			String	actualTitle = driver.getTitle();
			if(actualTitle.contains(Utility.EXPECT_TITLE))
			{

				System.out.println("Test case passed. Login successfully");

			}
			else
			{
				System.out.println("test case is failed");
			}
		}
		driver.close();			

	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
