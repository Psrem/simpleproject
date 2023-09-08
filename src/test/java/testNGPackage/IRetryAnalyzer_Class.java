package testNGPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class IRetryAnalyzer_Class implements IRetryAnalyzer {

	private int retryCount = 0;
	private static final int maxRetryCount = 3;

	public boolean retry(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			if (retryCount < maxRetryCount) {
				retryCount++;
				return true;
			}
		}
		return false;
	}
}
