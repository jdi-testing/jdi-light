package io.github.epam.testng;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import static com.epam.jdi.light.settings.WebSettings.logger;

public class RetryFailedTestCases implements IRetryAnalyzer {
    private int retryCnt = 0;
    final int maxRetryCnt = 2;

    //This method will be called everytime a test fails. It will return TRUE if a test fails and need to be retried, else it returns FALSE
    public boolean retry(ITestResult result) {
        //You could mentioned maxRetryCnt (Maximiun Retry Count) as per your requirement. Here I took 2, If any failed testcases then it runs two times
        if (retryCnt < maxRetryCnt) {
            logger.trace("Retrying " + result.getName() + " again and the count is " + (retryCnt+1));
            retryCnt++;
            return true;
        }
        return false;
    }

}

