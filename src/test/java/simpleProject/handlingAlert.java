package simpleProject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class handlingAlert {
	
	public static void main (String args[]) throws InterruptedException {
		
		// simple, confirmation and prompt
		// Default method getText(), sendKeys(), accept(), dismiss()
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://stqatools.com/demo/Alerts.php");
		
	    Thread.sleep(1000);
	    WebElement baAl = driver.findElement(By.cssSelector("button#jbalert"));
	    baAl.click();
		Alert basicAlert = driver.switchTo().alert();
		basicAlert.getText();
		basicAlert.accept();

	    WebElement cmAl = driver.findElement(By.cssSelector("button#jcalert"));
	    cmAl.click();
		Alert confirmAlert = driver.switchTo().alert();
		confirmAlert.getText();
		confirmAlert.accept();
		
	    cmAl.click();
		confirmAlert.getText();
		confirmAlert.dismiss();
		
	    WebElement pmAl = driver.findElement(By.cssSelector("button#jpalert"));
	    pmAl.click();
		Alert promptAlert = driver.switchTo().alert();
		promptAlert.sendKeys("Testing Prompt");
		
	}

}
 