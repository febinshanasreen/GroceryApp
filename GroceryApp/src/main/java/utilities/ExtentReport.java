package utilities;

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
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport implements ITestListener {

	
	ExtentSparkReporter sparkReporter;
	ExtentReports reports;
	ExtentTest test;

	public void configureReport() {
	Date date = new Date();
	SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy_hhmmss");
	String strDate = formatter.format(date);

	File reportPath=new File(System.getProperty("user.dir")+"//ExtentReport");

	if(!reportPath.exists()) {
	reportPath.mkdir();
	}

	//create file
	sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"//ExtentReport//"+"ExtentReport_" + strDate + ".html");
	reports = new ExtentReports();
	reports.attachReporter(sparkReporter);

	//System details
	reports.setSystemInfo("PC Name", "Nazrin");
	reports.setSystemInfo("OS", "Windows 11");
	reports.setSystemInfo("Browser", "Chrome");
	sparkReporter.config().setDocumentTitle("Extent Report Sample");
	sparkReporter.config().setReportName("Report Summary");
	sparkReporter.config().setTheme(Theme.DARK);
	}
	
	
 
	public void onTestStart(ITestResult result) {

	}
 
	public void onTestSuccess(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.PASS,
	MarkupHelper.createLabel("Name of the Passed Test Case is : " + result.getName(), ExtentColor.GREEN));

	}

 
	public void onTestFailure(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.FAIL,
	MarkupHelper.createLabel("Name of the Failed Test Case is : " + result.getName(), ExtentColor.RED));

	}

 
	public void onTestSkipped(ITestResult result) {
	test = reports.createTest(result.getName());
	test.log(Status.SKIP,
	MarkupHelper.createLabel("Name of the skipped test case is : " + result.getName(), ExtentColor.YELLOW));

	}

	 
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	 
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	 
	public void onStart(ITestContext context) {
	configureReport();
	}

	 
	public void onFinish(ITestContext context) {
	reports.flush();
	}


}
