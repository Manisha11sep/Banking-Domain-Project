package BankingProject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility {

	public static final String Driver_path = "C:\\Users\\manisha\\selenium\\chromedriver_win32\\chromedriver.exe";

	public static final String BASE_URL = "http://www.demo.guru99.com/V4/";
	public static final int Wait_time = 30;
	public static final String user_name="mngr88830";
	public static final String password="gazehYd";
	public static final String FILE_PATH="C:\\Users\\manisha\\workspace\\BankingDomain\\testData.xlsx";
	public static final String SHEET_NAME = "Data";
	public static final String TABLE_NAME="testData";
	public static final String EXPECT_TITLE = "Guru99 Bank Manager HomePage";
	public static final String EXPECT_ERROR = "User or Password is not valid";



	public static  Object[][]  readingFile(String file_path) throws Exception
	{
		Object [][] data = new Object[10][10];


		//file_path= Utility.FILE_PATH;
		File src = new File(file_path);
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);

		int rowCount= sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		System.out.println("total number of rows are "+ rowCount);


		for(int i=1; i<sheet1.getLastRowNum(); i++)
		{

			XSSFRow row = sheet1.getRow(i);
			for(int j=0; j<row.getLastCellNum(); j++)
			{
				//HSSFCell cell= row.getCell(j, row.CREATE_NULL_AS_BLANK); 
				//String value = String.valueOf(cell);
				String value = row.getCell(j).getStringCellValue();
				data[i][j]=value;
				System.out.println("The user name is  " + data[i][j]);
			}

		}


		return data;


	}
}


