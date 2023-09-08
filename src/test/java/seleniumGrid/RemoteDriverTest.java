package seleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//java -jar selenium-server-4.9.0.jar standalone (this cmd used for run the hub)
//
//hub & node
//java -jar selenium-server-4.9.0.jar hub
//java -jar selenium-server-4.9.0.jar node (same system syntax)
//java -jar selenium-server-4.9.0.jar node --hub ipaddress (different system syntax)

public class RemoteDriverTest {

	WebDriver driver;

	@Test
	public void test() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		String strHub = "http://10.176.12.128:4444";
		driver = new RemoteWebDriver(new URL(strHub), options);		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.navigate().to("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.tagName("textarea"));
		// (check exception) WebElement searchBox = driver.findElement(By.tagName("q"));
		searchBox.sendKeys("Java Tutorial");
		searchBox.submit();
		System.out.println("page title is...." + driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	}

}
