package Utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{
	int retryCount =0;
	int maxRetryCount =2;
	@Override
	public boolean retry(ITestResult result) {
		
		while(retryCount<maxRetryCount) {
			retryCount++;
			return true;
		}
		return false;
	}

}
