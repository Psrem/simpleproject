package testNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class assertHard_Soft {
	
	@Test
	public void softAssertCucumberSearchTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		
		SoftAssert softAss = new SoftAssert();
		softAss.assertEquals(driver.getTitle(), "Java Tutorial - Google Page");
		
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		softAss.assertEquals(driver.getTitle(), "Java Tutorial - Google Search Page");
		softAss.assertAll(); // Need to use this to find all assert pass or fail
	}
	
	@Test
	public void hardAssertCucumberSearchTest() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Page");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search Page");
		
	}
	

}
