package simpleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class shadowDOM {
	
	public static void main (String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://watir.com/examples/shadow_dom.html");
		WebElement shH = driver.findElement(By.cssSelector("div#shadow_host"));
		SearchContext context = shH.getShadowRoot();
		WebElement shC = context.findElement(By.cssSelector("span#shadow_content"));

				
	}

}
