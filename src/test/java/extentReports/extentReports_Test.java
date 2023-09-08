package extentReports;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import commonUtils.Utility;

public class extentReports_Test {

	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	WebDriver driver;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/SparkReport.html");
		extentReports.attachReporter(spark);
	}

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void javaSearchTest() {
		extentTest = extentReports.createTest("Java search test");
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
		
	}
	
	@Test
	public void cypressSearchTest() {
		extentTest = extentReports.createTest("Cypress search test");
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Cypress Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search Page");
	}
	
	@AfterMethod
	public void teardown(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			extentTest.fail(result.getThrowable().getMessage());
		    String path = Utility.getScreenshotPath(driver); 
			extentTest.addScreenCaptureFromPath(path);
			MediaEntityBuilder.createScreenCaptureFromPath(path);
		}	
		driver.close();
	}
	
	@AfterTest
	public void finishReport() {
		extentReports.flush();
	}

}
