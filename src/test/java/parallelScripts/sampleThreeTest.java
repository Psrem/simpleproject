package parallelScripts;

import org.testng.annotations.Test;

public class sampleThreeTest {
	
	@Test
	public void sampleTestNine() {
		long sTO_thread_id_Nine = Thread.currentThread().getId();
        System.out.println("Sample three test thread id Nine" + sTO_thread_id_Nine);		
	}
	@Test
	public void sampleTestTen() {
		long sTO_thread_id_Ten = Thread.currentThread().getId();
        System.out.println("Sample three test thread id Ten" + sTO_thread_id_Ten);		
	}
	@Test
	public void sampleTestThree() {
		long sTO_thread_id_Eleven = Thread.currentThread().getId();
        System.out.println("Sample three test thread id three" + sTO_thread_id_Eleven);		
	}
	@Test
	public void sampleTestFour() {
		long sTO_thread_id_Twelve = Thread.currentThread().getId();
        System.out.println("Sample three test thread id four" + sTO_thread_id_Twelve);		
	}

}
