package headlessbrowser;

import java.util.Collections;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class headlessbrowserslir {
		
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	WebDriver driver;
	
	@BeforeTest
	public void setupExtent() {
		extentReports = new ExtentReports();
		spark = new ExtentSparkReporter("test-output/slirhomepagecheck.html");
		extentReports.attachReporter(spark);
	}
	
	@BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

	public void getScreenshot() {
	       //Take the screenshot
     File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
     try {
		FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "/screenshot/homePageScreenshot.png"));
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	@Test
	public void verifyTitle() {
        
        //Copy the file to a location and use try catch block to handle exception
        	extentTest = extentReports.createTest("browserstack search test");
        	ChromeOptions options=new ChromeOptions();
        	options.addArguments("headless");
        	driver=new ChromeDriver(options);
        	driver.get("https://cp0512-acp3.apps-test.valeo.com/slir/");
        	getScreenshot();
        	System.out.println("Title is: " +driver.getTitle());
//        	Assert.assertEquals(driver.getTitle(), "Most Reliable App & Cross Browser Testing Platform | BrowserStack");
	driver.quit();
	}

	
}
