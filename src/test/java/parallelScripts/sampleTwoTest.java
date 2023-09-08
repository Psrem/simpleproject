package parallelScripts;

import org.testng.annotations.Test;

public class sampleTwoTest {
	
	@Test
	public void sampleTestFive() {
		long sTO_thread_id_Five = Thread.currentThread().getId();
        System.out.println("Sample two test thread id five" + sTO_thread_id_Five);		
	}
	@Test
	public void sampleTestSix() {
		long sTO_thread_id_Six = Thread.currentThread().getId();
        System.out.println("Sample two test thread id six" + sTO_thread_id_Six);		
	}
	@Test
	public void sampleTestSeven() {
		long sTO_thread_id_Seven = Thread.currentThread().getId();
        System.out.println("Sample two test thread id seven" + sTO_thread_id_Seven);		
	}
	@Test
	public void sampleTestEight() {
		long sTO_thread_id_Eight = Thread.currentThread().getId();
        System.out.println("Sample two test thread id eight" + sTO_thread_id_Eight);		
	}

}
