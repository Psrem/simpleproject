package simpleProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageTest {
	
	public static void main (String args[]) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Java tutorial");
	
		Thread.sleep(1000);
		List<WebElement> searchList = driver.findElements(By.cssSelector("ul.G43f7e div.wM6W7d span"));
		System.out.println("Search list" + searchList.size());
		
		for(int i=0; i<searchList.size(); i++) {
			System.out.println("Get text" + searchList.get(i).getText());
			if(searchList.get(i).getText().equals("java tutorial")) {
				searchList.get(i).click();
				break;
			}
			
		}
				
	}

}
