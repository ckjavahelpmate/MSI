package tests;

import org.testng.annotations.Test;

import genericlibrary.BaseTest;

public class FirstTest extends BaseTest {
	
	@Test
	public void testCase1() 
	{
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Test1 - Testcase1");
	}
	
	@Test
	public void testCase2() 
	{
//		WebDriver driver = new ChromeDriver();
//		driver.get("https:/www.google.com");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		driver.quit() ;
		System.out.println("Test1 - Testcase2");
	}

}
