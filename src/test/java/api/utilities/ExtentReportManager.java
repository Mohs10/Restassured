package api.utilities;

import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	String repName;
	
	public void onStart(ITestContext testContext)
	{
		//String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new Date()); //time stamp
		repName="Test-Report-.html";
		/*
		 * String timeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.SS").format(new
		 * Date()); repName= "Test-Report-"+timeStamp+".html";
		 */
		
	    sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName); //specify location of the report
	    
	    sparkReporter.config().setDocumentTitle("RestAssuredAutomationProject");  //title of report
	    sparkReporter.config().setReportName("pet store users API");  //name of the project
	    sparkReporter.config().setTheme(Theme.DARK);
	
	    extent=new ExtentReports();
	    extent.attachReporter(sparkReporter);
	    extent.setSystemInfo("Application","pet store users api");
	    extent.setSystemInfo("operating system", System.getProperty("os.name"));
	    extent.setSystemInfo("User Name", System.getProperty("user.name"));
	    extent.setSystemInfo("Environment", "QA");
	    extent.setSystemInfo("user", "karishma");
	
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, "Test Failed");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName());
		test.createNode(result.getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, "Test skipped");
		test.log(Status.SKIP, result.getThrowable().getMessage());
		
		
	}
	
	public void onFinish(ITestContext testcontext)
	{
		extent.flush();
	}
	

}
