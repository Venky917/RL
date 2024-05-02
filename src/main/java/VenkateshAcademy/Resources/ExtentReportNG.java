package VenkateshAcademy.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

public static ExtentReports getReportObject() {
		
		ExtentReports extent;
		ExtentSparkReporter reporter;
		ExtentTest Test ;
			
		    String path = System.getProperty("user.dir")+"\\reports\\index.html";
			reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation Results");
			reporter.config().setDocumentTitle("Test Results");
			reporter.config().getStore();
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Venkatesh K");
			return extent;
		
		}

	
}
