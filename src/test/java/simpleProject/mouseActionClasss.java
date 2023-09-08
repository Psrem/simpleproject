package simpleProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class mouseActionClasss {
	
	public static void main (String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.opencart.com/");

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		Actions actions = new Actions(driver);
		driver.findElement(By.name("search")).sendKeys("Phone");
		
		WebElement mouseM = driver.findElement(By.xpath("//a[text()='Components']"));
		
		WebElement mouseDDC = driver.findElement(By.xpath("//a[text()='Scanners (0)']"));
		
		actions.moveToElement(mouseM).click(mouseDDC).build().perform();
		actions.moveToElement(mouseM).contextClick(mouseDDC).build().perform();
		actions.moveToElement(mouseM).doubleClick(mouseDDC).build().perform();
				
	}

}
