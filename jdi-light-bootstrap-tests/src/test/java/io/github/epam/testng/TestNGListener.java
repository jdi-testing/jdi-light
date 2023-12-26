package io.github.epam.testng;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.System.currentTimeMillis;

public class TestNGListener implements IInvokedMethodListener {
    private Long start = currentTimeMillis();
    @Override
    public void beforeInvocation(IInvokedMethod m, ITestResult tr) {
        if (m.isTestMethod()) {
            Method testMethod = m.getTestMethod().getConstructorOrMethod().getMethod();
            if (testMethod.isAnnotationPresent(Test.class)) {
                TEST_NAME.set(tr.getTestClass().getRealClass().getSimpleName()+"."+testMethod.getName());
                start = currentTimeMillis();
                logger.step("== Test '%s' START ==", TEST_NAME.get());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult r) {
        if (method.isTestMethod()) {
            String result = getTestResult(r);
            logger.step("=== Test '%s' %s [%s] ===", TEST_NAME.get(), result,
                        new SimpleDateFormat("mm:ss.SS").format(new Date(currentTimeMillis() - start)));
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