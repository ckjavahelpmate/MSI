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

	@Test(dataProvider = "testData", dataProviderClass = DataUtility.class)
	public void validUserTest(JsonNode data) throws InterruptedException {
		loginpage.singIn(TestCredentials.uwUsername(), TestCredentials.uwPassword());
		Assert.assertEquals(homePage.getSelectSearchCriteriaTest().getText(), UILabels.SEARCH_PAGE);
	}

	@Test
	public void inValidUserTest() throws InterruptedException {
		loginpage.singIn(TestCredentials.uwPassword(), TestCredentials.uwUsername());
		Assert.assertEquals(loginpage.getSignIntoVIPText().getText(), UILabels.LOGIN_PAGE );
		
		
	}

}
