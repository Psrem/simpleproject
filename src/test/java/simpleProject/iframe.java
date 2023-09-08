package simpleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class iframe {
	
	public static void main (String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		
		String strlbl = driver.findElement(By.cssSelector("label > span")).getText();
		System.out.println("Lbl message" +strlbl);
				
		driver.switchTo().frame("frame1");
		driver.findElement(By.tagName("input")).sendKeys("Testing Frame");
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		
		driver.switchTo().parentFrame();
		driver.findElement(By.tagName("input")).clear();
		driver.findElement(By.tagName("input")).sendKeys("Welcome Prem");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame2");
		driver.findElement(By.xpath("//select[@id='animals']")).click();		
		driver.findElement(By.xpath("//select/option[text()='Big Baby Cat']")).click();
		
		driver.switchTo().frame(1);
		driver.findElement(By.id("animals")).click();		
		driver.findElement(By.xpath("//select/option[text()='Cat']")).click();
		
	}

}
