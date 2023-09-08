package simpleProject;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class synchronization {
	
	// unconditional sync -> Thread.sleep -> without any condition we put wait (access third party system. It is helpful)
	// conditional sync -> implicit & explicit -> with condition we include
    // implicit wait -> Use Driver instance level. It is place to use 'Find Elements' or locate elements in page
	// explicit wait -> ele is visible, alert is visible, frame is displayed and multiple elements this case we use explicit wait
	// Fluent wait -> at the element level (we can give more control. polling every time)
	// Page load sync -> page loading we use this page load sync
	
	public static void main (String args[]) {
		
		// implicit wait
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java tutorial");
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait
		
		List<WebElement> searchList = driver.findElements(By.cssSelector("ul.G43f7e div.wM6W7d span"));
		System.out.println("Search list" + searchList.size());
		
		for(int i=0; i<searchList.size(); i++) {
			System.out.println("Get text" + searchList.get(i).getText());
			if(searchList.get(i).getText().equals("java tutorial")) {
				searchList.get(i).click();
				break;
			}
			
		}
		
		// explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement seaList = driver.findElement(By.cssSelector("ul.G43f7e div.wM6W7d span"));
		wait.until(ExpectedConditions.elementToBeClickable(seaList));
		
		// fluent wait
		Wait<WebDriver> fluWait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class);
		
		// page load sync
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		
	}
	
	
}
