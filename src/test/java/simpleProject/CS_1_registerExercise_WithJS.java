package simpleProject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.page.Page;

public class CS_1_registerExercise_WithJS {
	
	public static void main (String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();		
		driver.findElement(By.xpath("//a[text()='Register']")).click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("input-firstname")).sendKeys("Prem");
		driver.findElement(By.id("input-lastname")).sendKeys("Nath");	
		driver.findElement(By.id("input-email")).sendKeys("premnath@gmail.com");
		driver.findElement(By.id("input-password")).sendKeys("premnath@gmail.com");
		
        WebElement m = driver.findElement(By.xpath("//label[text()='Yes']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", m);
		
		WebElement d = driver.findElement(By.cssSelector("input[name='agree']"));
		js.executeScript("arguments[0].click();", d);
		
		WebElement e = driver.findElement(By.xpath("//button[@type='submit']"));
		js.executeScript("arguments[0].click();", e);
		
	}

}
