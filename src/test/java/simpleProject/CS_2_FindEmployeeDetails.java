package simpleProject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CS_2_FindEmployeeDetails {
	
	public static void main (String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.seleniumeasy.com/");
		
		driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//li/a[contains(text(),'Table')])[1]")).click();		
		driver.findElement(By.xpath("(//ul[@class='nav navbar-nav']//li/a[contains(text(),'Table Sort & Search')])")).click();
		
		driver.findElement(By.xpath("(//td[text()='B. Wagner']//following::td)[5]")).getText();
	    System.out.println("B. Wagner" + driver.findElement(By.xpath("(//td[text()='B. Wagner']//following::td)[5]")).getText());
	    

	    List<WebElement> getEmp = driver.findElements(By.xpath("//td[text()='San Francisco']"));
	    System.out.println("Get size of the san" + getEmp.size());
	    for(int i=1; i<=getEmp.size(); i++) {
	    	
	    	System.out.println("Employee name of San Francisco" + driver.findElement(By.xpath("(//td[text()='San Francisco'])/../td["+i+"]")).getText());
	    	
	    }
	}

}
