package simpleProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class windowHandle {
	
	public static void main (String args[]) {
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://stqatools.com/demo/Windows.php");
		String parentWin = driver.getWindowHandle();
		System.out.println("Parent window" +parentWin);
		
		WebElement ont = driver.findElement(By.xpath("//button[text()=' Click to open new Tab ']"));
		ont.click();
		String childWin = driver.getWindowHandle();

		if(!parentWin.equals(childWin)) {
			driver.switchTo().window(childWin);
		}
		
		WebElement te = driver.findElement(By.xpath("//button[text()=' Click to open new Tab ']"));
		te.click();
		driver.switchTo().newWindow(WindowType.TAB);
		
		WebElement newin = driver.findElement(By.xpath("//button[text()=' Click to open new Window ']"));
		newin.click();
		driver.switchTo().newWindow(WindowType.WINDOW);
		
	}

}
