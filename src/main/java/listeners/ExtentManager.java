package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import helper.Utility;

public class ExtentManager {
	
	public static ExtentReports extent;
	
	public static ExtentReports getInstance()
	{
		//If there 100 test cases by calling create instance everytime it will create 100 reports
		//but we need all test cases in single report so we need to write logic if instance is created
		//just return the extent else create the extent and then return the extent
		if(extent == null)
		{
			createInstance();
			return extent;
		}
		else
		{
			return extent;
		}
		
	}
	
	
	public static ExtentReports createInstance()
	{
		ExtentSparkReporter sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/Automation_"+Utility.getCurrentTime()+".html");
		sparkreporter.config().setTheme(Theme.DARK);
		sparkreporter.config().setDocumentTitle("Sprint 1 report");
		sparkreporter.config().setReportName("Automation report");
		
		extent  = new ExtentReports();
		extent.attachReporter(sparkreporter);
		
		return extent;
	}

}
