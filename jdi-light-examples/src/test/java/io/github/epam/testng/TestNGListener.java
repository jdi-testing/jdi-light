package io.github.epam.testng;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.logger.AllureLoggerHelper;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class TestNGListener implements IInvokedMethodListener {
    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            Method testMethod = iInvokedMethod.getTestMethod().getConstructorOrMethod().getMethod();
            if (testMethod.isAnnotationPresent(Test.class)) {
                TEST_NAME.set(iTestResult.getInstanceName()+"."+testMethod.getName());
                logger.step("== Test '%s' START ==", TEST_NAME.get());
                AllureLoggerHelper.startStep(Integer.toString(iInvokedMethod.hashCode()), testMethod.getName());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        if (iInvokedMethod.isTestMethod()) {
            String result = getTestResult(iTestResult);
            logger.step("=== Test '%s' %s ===", TEST_NAME.get(), result);
            if (iTestResult.isSuccess()) {
                AllureLoggerHelper.passStep(Integer.toString(iInvokedMethod.hashCode()));
            }
            else {
                String screenName = takeScreen();
                AllureLoggerHelper.failStep(Integer.toString(iInvokedMethod.hashCode()), screenName);
            }
        }
    }

    private String getTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASSED";
            case ITestResult.SKIP:
                return "SKIPPED";
            default:
                return "FAILED";
        }
    }


}