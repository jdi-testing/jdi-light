package com.jdi.testng;

/**
 * Created by Roman Iovlev on 10.11.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.tools.Safe;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.tools.LinqUtils.last;
import static java.lang.System.currentTimeMillis;

public class TestNGListener implements IInvokedMethodListener {
 
    private final Safe<Long> start = new Safe<>(0L);

    @Override
    public void beforeInvocation(IInvokedMethod m, ITestResult tr) {
        if (m.isTestMethod()) {
            ITestNGMethod testMethod = m.getTestMethod();
            if (testMethod.getConstructorOrMethod().getMethod().isAnnotationPresent(Test.class)) {
                TEST_NAME.set( last(testMethod.getTestClass().getName().split("\\.")) +
                        "." + testMethod.getMethodName());
                start.set(currentTimeMillis());
                logger.step("== Test '%s' START ==", TEST_NAME.get());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult tr) {
        if (method.isTestMethod()) {
            String result = getTestResult(tr);
            logger.step("=== Test '%s' %s [%s] ===", TEST_NAME.get(), result,
                    new SimpleDateFormat("mm:ss.SS")
                            .format(new Date(currentTimeMillis() - start.get())));
            if ("FAILED".equals(result)) {
                try {
                    takeScreen();
                } catch (RuntimeException ignored) { }
                logger.step("ERROR: " + tr.getThrowable().getMessage());
            }
            logger.step("");
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
