package io.github.epam.testng;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.jdiai.tools.Safe;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.jdi.light.logger.AllureLogger.screenshotStep;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.jdiai.tools.LinqUtils.last;
import static java.lang.System.currentTimeMillis;

public class TestNGListener implements IInvokedMethodListener {
    private Safe<Long> start = new Safe<>(0L);

    @Override
    public void beforeInvocation(IInvokedMethod m, ITestResult tr) {
        if (m.isTestMethod()) {
            ITestNGMethod testMethod = m.getTestMethod();
            if (testMethod.getConstructorOrMethod().getMethod().isAnnotationPresent(Test.class)) {
                String testName = last(testMethod.getTestClass().getName().split("\\.")) +
                        "." + testMethod.getMethodName();
                TEST_NAME.set(testName);
                start.set(currentTimeMillis());
                logger.step("== Test '%s' START ==", testName);
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
                    screenshotStep("On Fail Screenshot");
                } catch (RuntimeException ignored) { }
                if (tr.getThrowable() != null) {
                    logger.step("ERROR: " + tr.getThrowable().getMessage());
                } else {
                    logger.step("UNKNOWN ERROR");
                }
            }
        }
    }

    private String getTestResult(ITestResult result) {
        switch (result.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASSED";
            case ITestResult.SKIP:
                return "SKIPPED";
            case ITestResult.FAILURE:
            case ITestResult.SUCCESS_PERCENTAGE_FAILURE:
                return "FAILED";
            case ITestResult.STARTED:
                return "STARTED";
            case ITestResult.CREATED:
                return "CREATED";
            default: break;
        }
        return "FAILED";
    }
}