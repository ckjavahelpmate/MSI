package genericlibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.LoginPage;
import utilities.DataUtility;

/**
 * BaseTest is a base class for all test classes that sets up and tears down the
 * WebDriver, initializes page objects, and handles login/logout.
 */
public class BaseTest {

	/** WebDriver instance shared across test classes. */
	public static WebDriver driver;

	/** Utility class for reading environment and test data. */
	private DataUtility dataUtility = new DataUtility();

	/** Page object for Login Page. */
	public LoginPage loginpage;

	/** Page object for Home Page. */
	public HomePage homePage;

	/**
	 * Initializes the page objects before each test method.
	 */
//	@BeforeMethod
//	public void setUp() {
//		loginpage = new LoginPage(driver);
//		homePage = new HomePage(driver);
//	}

	/**
	 * Logs out the user after each test method. If logout fails, the exception is
	 * caught silently.
	 */
//	@AfterMethod
//	public void logout() {
//		try {
//			homePage.logout();
//		} catch (Exception e) {
//			// Handle logout failure silently
//		}
//	}

	/**
	 * Launches the browser and navigates to the application under test.
	 *
	 * @param browser the browser to use, defaults to "edge" if none is provided.
	 */
	@Parameters("browser")
	@BeforeMethod
	public void launchBrowser(@Optional("edge") String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--no-sandbox");
			options.addArguments("--disable-dev-shm-usage");
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--headless=new"); // Comment this line if you want GUI

			driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver(); // Add EdgeOptions here if needed
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(dataUtility.getEnvironmentURL("TEST"));
		System.out.println();
	}

	/**
	 * Quits the browser and cleans up resources after all tests have run.
	 */
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	@BeforeSuite
	public void clearDir() {
		ScreenshotUtil.clearOldScreenshots();
	}
}
