package GetMega.MegaAppium;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AppiumExtentReports {

	ExtentReports extent; 
	
	
	public ExtentReports setUp() { 

		ExtentSparkReporter htmlReporter = new ExtentSparkReporter("DCR.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		return extent;
	}

	
	public void tearDown() {
		extent.flush();
	}

}
