package testNGPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class testNGClass_Three {
	
	@Test(groups = "featureOne")
	public void aucumSearchTest() {
        System.out.println("testNGClass_Three -> Sys.Out.Println 1");		
	}
	@Test
	public void bucumSearchTest() {
        System.out.println("testNGClass_Three -> Sys.Out.Println 2");		
	}
	@Test
	public void cucumSearchTest() {
        System.out.println("testNGClass_Three -> Sys.Out.Println 3");		
	}
	@Test
	public void ducumSearchTest() {
        System.out.println("testNGClass_Three -> Sys.Out.Println 4");		
	}

}
