package utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import genericlibrary.ScreenshotUtil;

public class ExtentTestNGListener implements ITestListener {

	@Override
	public void onStart(ITestContext context) {
//		Create webPage, create report dashBoard , attach report dashBoard to webPage
		ExtentManager.getExtentReports(); 
	}

	@Override
	public void onTestStart(ITestResult result) {
//		Create Test report, add test report to report dashBoard
		ExtentTest test = ExtentManager.getExtentReports().createTest(result.getMethod().getMethodName());
		ExtentManager.setTest(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
//		Log info to test report
		ExtentManager.getTest().log(Status.PASS, result.getMethod().getMethodName()+" Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		Log info to test report
		ScreenshotUtil.takeScreenshot(result.getMethod().getMethodName()) ;
		ExtentManager.getTest().log(Status.FAIL, " Failed: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
//		Log info to test report
		ExtentManager.getTest().log(Status.SKIP, " Skipped: " + result.getThrowable());
	}

	@Override
	public void onFinish(ITestContext context) {
//		publish report dashBoard on webPage
		ExtentManager.flushReports();
	}
}
