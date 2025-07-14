package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import genericlibrary.BaseTest;

public class Test3  extends BaseTest{
	
	@Test
	public void testCase1() 
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
		System.out.println("Test3 - Testcase1");
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
		System.out.println("Test3 - Testcase2");
	}

}
