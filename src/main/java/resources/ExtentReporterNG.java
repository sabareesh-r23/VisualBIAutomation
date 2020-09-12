package resources;

import org.testng.ITestNGListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG extends Base implements ITestNGListener{
	static ExtentReports extent;
	
	public static ExtentReports getReportObject()
	{
		
		String path =currentDirectory+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		
		extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Sabareesh");
		return extent;
		
	}
}
