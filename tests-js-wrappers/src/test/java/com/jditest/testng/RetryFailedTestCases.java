package com.jditest.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryFailedTestCases implements IRetryAnalyzer {
    private int retryCnt = 0;
    private int retryLimit = 2;

    public boolean retry(ITestResult result) {
        if (retryCnt < retryLimit) {
            System.out.println("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt ++;
            return true;
        }
        return false;
    }

}

