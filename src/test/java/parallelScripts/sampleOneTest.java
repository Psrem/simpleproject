package parallelScripts;

import org.testng.annotations.Test;

public class sampleOneTest {

	@Test
	public void sampleTestOne() {
		long sTO_thread_id_One = Thread.currentThread().getId();
        System.out.println("Sample one test thread id one" + sTO_thread_id_One);		
	}
	@Test
	public void sampleTestTwo() {
		long sTO_thread_id_Two = Thread.currentThread().getId();
        System.out.println("Sample one test thread id two" + sTO_thread_id_Two);		
	}
	@Test
	public void sampleTestThree() {
		long sTO_thread_id_Three = Thread.currentThread().getId();
        System.out.println("Sample one test thread id three" + sTO_thread_id_Three);		
	}
	@Test
	public void sampleTestFour() {
		long sTO_thread_id_Four = Thread.currentThread().getId();
        System.out.println("Sample one test thread id four" + sTO_thread_id_Four);		
	}
	
	// In project = Instead of 'invocationCount' need to 'Data Provider'
	// timeout is optional
	// threadPoolSize is 3 thread will create for this method
	// We can't able to configure this method in 'TestNG xml'
	@Test (invocationCount = 6, threadPoolSize = 3, timeOut = 2000)
	public void sampleTestFive() {
		long sTO_thread_id_Five = Thread.currentThread().getId();
        System.out.println("Sample one test thread id four" + sTO_thread_id_Five);		
	}
	
}
