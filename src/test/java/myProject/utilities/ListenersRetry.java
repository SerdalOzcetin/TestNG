package myProject.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class ListenersRetry implements IRetryAnalyzer {

    private int retrycount = 0;
    private static final int maxRetryCount = 2;

    @Override
    public boolean retry(ITestResult iTestResult) {
        if (retrycount<maxRetryCount){
            retrycount++;
            return true;
        }
            return false;
    }
}
