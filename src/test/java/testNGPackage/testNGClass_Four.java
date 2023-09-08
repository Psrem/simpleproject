package testNGPackage;

import org.testng.annotations.Test;

public class testNGClass_Four {
	
	@Test
	public void aucumSearchTest() {
        System.out.println("testNGClass_Four -> Sys.Out.Println 5");		
	}
	@Test(groups = "featureOne")
	public void bucumSearchTest() {
        System.out.println("testNGClass_Four -> Sys.Out.Println 6");		
	}
	@Test
	public void cucumSearchTest() {
        System.out.println("testNGClass_Four -> Sys.Out.Println 7");		
	}
	@Test
	public void ducumSearchTest() {
        System.out.println("testNGClass_Four -> Sys.Out.Println 8");		
	}

}
