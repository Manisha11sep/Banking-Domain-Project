import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test1 {
	@Test
	public void test1 () 
	{
		if (add(10,20)==30)
		System.out.println("test case is pass");
		else
			System.out.println("Failed");
	}

	@Before
	public void runBeforeSub()
	{
		System.out.println("runnin before subracting");
	}
	
@Test
	public void test2 ()
	{
		if(sub(30,20)==8)
			
			System.out.println("sub test case is pass");
		else
		{
			System.out.println("Failed");
		fail("this test is not showing correct subraction");
		}
	}
	
	
	
	
	
	
	
	public int add(int a, int b)
	{
		return a+b;
	}
	public int multiplication(int a, int b)
	{
		return a*b;
	}

	public int sub(int a, int b)
	{
		return a-b;
	}

}
