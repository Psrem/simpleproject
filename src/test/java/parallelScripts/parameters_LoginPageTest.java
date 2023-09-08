package parallelScripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class parameters_LoginPageTest {

	WebDriver driver;
	
	@Parameters("browser")
	@BeforeMethod
	public void setup(String strBrowser) {
		if(strBrowser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();			
		} else if(strBrowser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();			
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@Test
	public void validLogin() {
		
		driver.get("http://the-internet.herokuapp.com/login");
		driver.findElement(By.cssSelector("input#username")).sendKeys("tomsmith");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("SuperSecretPassword!");	
		driver.findElement(By.cssSelector("button.radius")).click();
		boolean isDisp = driver.findElement(By.cssSelector("div.flash.success")).isDisplayed();
		Assert.assertTrue(isDisp);		
	}
	
	@AfterMethod
	public void close() {		
		driver.close();
	}
	
}
