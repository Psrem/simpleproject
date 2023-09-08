package parallelScripts;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class properties_LoginPageTest {
	
	WebDriver driver;
	Properties prop;
	
	@BeforeMethod
	public void setup() throws IOException {
		
		prop = new Properties();
		String path = System.getProperty("user.dir") + "//src//test//resources//configFiles//config.properties";
		FileInputStream fin = new FileInputStream(path);
		prop.load(fin);
		
		String strBrowser = prop.getProperty("browser");
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
		
		driver.get(prop.getProperty("url"));
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
