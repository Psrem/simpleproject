package simpleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class toottip {
	
	public static void main (String args[]) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		Actions actions = new Actions(driver);
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		actions.moveToElement(driver.findElement(By.id("age"))).perform();
				
		String getToolTipText = driver.findElement(By.xpath("//div[@role='tooltip']/div")).getText();
		System.out.println(getToolTipText);
		
	}

}
