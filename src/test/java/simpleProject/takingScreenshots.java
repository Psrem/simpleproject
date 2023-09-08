package simpleProject;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class takingScreenshots {
	
	// complete web page screenshot
	// error screenshot
	
	public static void main (String args[]) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/tooltip/");
		Actions actions = new Actions(driver);
		
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\pmanokar\\Documents\\seleniumTraining\\workspace\\simpleProject\\screenshots\\fullscreen.png"));
 				
		
		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
		actions.moveToElement(driver.findElement(By.id("age"))).perform();
		
		WebElement age = driver.findElement(By.id("age"));
		File srcSc = age.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcSc, new File("C:\\Users\\pmanokar\\Documents\\seleniumTraining\\workspace\\simpleProject\\screenshots\\elescreen.png"));
				
		String getToolTipText = driver.findElement(By.xpath("//div[@role='tooltip']/div")).getText();
		System.out.println(getToolTipText);
		
	}

}
