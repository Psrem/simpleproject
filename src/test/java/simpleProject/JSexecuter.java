package simpleProject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.EdgeDriverManager;

public class JSexecuter {

	public static void main(String args[]) throws InterruptedException {

		WebDriver driver;
		
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://plm-pf1.vnet.valeo.com:7001/enovia");

//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.google.com/");
//		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		String strTitle = (String)js.executeScript("return document.title"); // Method 1
//		System.out.println("Title:" + strTitle);
//		
//		js.executeScript("window.scrollBy(10, 500)"); // Method 2
//		js.executeScript("window.scrollBy(10, document.body.scrollHeight)"); // Method 3
//		
//		WebElement seabox = (WebElement)js.executeScript("return document.getElementsByName('search')[0]"); // Method 4
//		System.out.println("Search box:" + seabox);
//		
//		js.executeScript("history.go(-1)"); // Method 5 backward (-1, -2 ..)
//		js.executeScript("history.go(0)"); // Method 6 refresh page
//		js.executeScript("history.go(1)"); // Method 5 forward (1, 2 ..)

	}

}
