package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendedRepots {
	WebDriver driver;
	ExtentReports extent;
	ExtentTest test;

	@BeforeTest
	public void configuration() {
		// ExtendReports, ExtentSparkReporter
		String path = System.getProperty("D:\\selenium workspace\\Practise1") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "sruthi");
	}

	@Test
	public void logintoHomePage() {

		test =extent.createTest("Intial demo");

		System.setProperty("webdriver.chrome.driver", "D:\\selenium workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com");
		System.out.println(driver.getTitle());
		test.addScreenCaptureFromBase64String( "64");
		driver.close();
	
		//test.fail("Result do not match");
		extent.flush();
	}
}
