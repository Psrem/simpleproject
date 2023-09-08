package testNGPackage;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v110.emulation.Emulation;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.devtools.*;

// CDP Test
public class chromeDevTools_CaseStudy {

	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		devTools = driver.getDevTools();
		devTools = driver.maybeGetDevTools().get();
		devTools.createSession();
	}

	@Test
	public void pixelsTest() {
		Map deviceMetrics = new HashMap() {{
			put("width", 500);
			put("height", 800);
			put("mobile", true);
			put("deviceScaleFactor", 50);
		}};
        driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        driver.get("https://www.selenium.dev/");		
	}
	
	@Test
	public void geoTest() {        
		devTools.send(Emulation.setGeolocationOverride(Optional.of(35.689487), Optional.of(139.691706), Optional.of(100)));
        driver.get("https://oldnavy.gap.com/stores");
	}
	
	
}
