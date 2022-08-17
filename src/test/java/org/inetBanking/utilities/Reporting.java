package org.inetBanking.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting implements ITestListener {

	ExtentHtmlReporter htmlReporter;

	ExtentReports extent;

	ExtentTest test;

	public void onStart(ITestContext context) {

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

		String repName = "Test-Report-" + timeStamp + " .html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + repName);

		htmlReporter.config().setDocumentTitle("InetBanking Test Project");

		htmlReporter.config().setReportName("Functional Test Report");

		htmlReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Host Name", "Local Host");
		extent.setSystemInfo("UserName", "Sabari N");
		extent.setSystemInfo("OS", "Windows 11");
		extent.setSystemInfo("Java version", "1.8.0");

	}

	public void onTestStart(ITestResult result) {

		

	}

	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());

		test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

	}

	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		
		test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
		
		String screenShotPath = System.getProperty("user.dir")+"\\Screenshot\\"+result.getName()+".png";
		
		
		File desc =new File(screenShotPath);
		
		if (desc.exists()) 
		{
			try {
				test.fail("Screenshot is below: "+test.addScreenCaptureFromPath(screenShotPath));
				
			} catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
		
		
		
	}

	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		
		test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(),ExtentColor.ORANGE));

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		extent.flush(); 

	}

}
