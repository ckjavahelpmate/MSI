package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	public static ExtentReports getExtentReports() {
//		Create WebPage
		if (extent == null) {
			ExtentSparkReporter webpage = new ExtentSparkReporter("test-output/ExtentReport.html");
			webpage.config().setReportName("Automation Test Dashboard");
			webpage.config().setDocumentTitle("UI Test Execution Report");
			webpage.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.STANDARD); // DARK/LIGHT

//			Create report Dashboard
			extent = new ExtentReports();
			extent.setSystemInfo("Environment", "TEST");
			extent.setSystemInfo("Tester", "QA");
			
//			Attach report dashboard to webpage
			extent.attachReporter(webpage);
			
		}
		return extent;
	}

	public static ExtentTest getTest() {
		return test.get();
	}

	public static void setTest(ExtentTest extentTest) {
		test.set(extentTest);
	}

	public static void flushReports() {
		if (extent != null) {
			extent.flush();
		}
	}
}
