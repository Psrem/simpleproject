package simpleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class dropDown {
	
	public static void main (String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");

		Select singleSel = new Select(driver.findElement(By.id("select-demo")));
		singleSel.selectByValue("Thursday");

		Select mulSel = new Select(driver.findElement(By.id("multi-select")));
		if(mulSel.isMultiple()) {
			mulSel.selectByIndex(0);
			mulSel.selectByValue("Ohio");
			mulSel.selectByVisibleText("Texas");
			mulSel.deselectByIndex(0);
		}
		
			
	}
	

	
}
