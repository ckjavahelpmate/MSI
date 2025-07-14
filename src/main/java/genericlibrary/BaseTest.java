package genericlibrary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import pages.HomePage;
import pages.LoginPage;
import utilities.DataUtility;
public class BaseTest {

	public static WebDriver driver;
	private DataUtility dataUtility = new DataUtility();
	public LoginPage loginpage;
	public HomePage homePage;

	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	public void launchBrowser(@Optional("Chrome") String browser) {
		System.out.println("Launching Browser");
		if (browser.equalsIgnoreCase("Chrome")) {
			ChromeOptions options = new ChromeOptions();
		    options.addArguments("--headless=new"); // New headless mode
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-dev-shm-usage");
		    options.addArguments("--remote-allow-origins=*"); // Optional if needed
		    options.addArguments("--disable-gpu"); // Optional
		    options.addArguments("window-size=1920,1080");

		    driver = new ChromeDriver(options);

		} else if (browser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver(); // Add EdgeOptions here if needed
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(dataUtility.getEnvironmentURL("TEST"));
		System.out.println("Launching Browser");
	}

	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		loginpage = new LoginPage(driver);
		homePage = new HomePage(driver);
	}

	@AfterMethod(alwaysRun = true)
	public void logout() {
		try {
			homePage.logout();
		} catch (Exception e) {
			
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

	@BeforeSuite(alwaysRun = true)
	public void clearDir() {
		ScreenshotUtil.clearOldScreenshots();
	}
}
