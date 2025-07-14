package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;

import genericlibrary.BaseTest;
import utilities.DataUtility;
import utilities.ExtentTestNGListener;
import utilities.TestCredentials;
import utilities.UILabels;

@Listeners(ExtentTestNGListener.class)
public class LoginTest extends BaseTest {

	@Test(dataProvider = "testData", dataProviderClass = DataUtility.class, groups = {"smoke"})
	public void validUserTest(JsonNode data) throws InterruptedException {
		System.out.println("Login method started");
		loginpage.singIn(TestCredentials.uwUsername(), TestCredentials.uwPassword());
		Assert.assertEquals(homePage.getSelectSearchCriteriaTest().getText(), UILabels.SEARCH_PAGE);
	}

	@Test( groups = {"smoke"})
	public void inValidUserTest() throws InterruptedException {
		System.out.println("HIIIIIIIIIIIIIIIIIIIII");
		loginpage.singIn(TestCredentials.uwPassword(), TestCredentials.uwUsername());
		
		
		
	}

}
