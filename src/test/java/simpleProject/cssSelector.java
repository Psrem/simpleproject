package simpleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class cssSelector {
	
	public static void main (String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://stqatools.com/demo/Alerts.php");
		
		driver.findElement(By.cssSelector("button#jbalert")); // Get id name
		driver.findElement(By.cssSelector("div.col-md-12")); // Get class name
		
		// We can't able to get the direct text cssSelector path (https://www.w3schools.com/cssref/css_selectors.php)
		
	}

}
