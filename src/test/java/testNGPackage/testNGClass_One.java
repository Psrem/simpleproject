package testNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// TestNG xml hierarchical: Test Suite -> test -> classes -> TestMethod

public class testNGClass_One {
	
	WebDriver driver;
	
	@BeforeTest
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(retryAnalyzer = IRetryAnalyzer_Class.class)
	public void javaSearchTest() {
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search page");
		
	}
	
	@Test
	public void cypressSearchTest() {
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Cypress Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(), "Cypress Tutorial - Google Search");
	}
	
	@AfterTest
	public void quit() {
		driver.close();
	}
	

}
