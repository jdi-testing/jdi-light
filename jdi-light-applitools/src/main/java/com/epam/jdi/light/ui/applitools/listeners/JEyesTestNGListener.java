package com.epam.jdi.light.ui.applitools.listeners;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.epam.jdi.light.ui.applitools.eyes.JEyes;
import com.epam.jdi.tools.Safe;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.jdi.light.settings.WebSettings.EYES_CHECK_AFTER_ASSERTION;
import static com.epam.jdi.light.settings.WebSettings.EYES_CHECK_ON_TEST_START;
import static com.epam.jdi.light.ui.applitools.eyes.JEyes.initEyesForBatch;
import static java.lang.System.currentTimeMillis;

public class JEyesTestNGListener implements ITestListener, IInvokedMethodListener {

    public static Safe<String> testNameForEyes = new Safe<>((String) null);

    @Override
    public void onTestStart(ITestResult testResult) {
        if (EYES_CHECK_ON_TEST_START || EYES_CHECK_AFTER_ASSERTION) {
            String testClass = testResult.getTestClass().getRealClass().getSimpleName();
            String methodName = testResult.getMethod().getMethodName();
            testNameForEyes.set(testClass + "." + methodName);
            if (EYES_CHECK_ON_TEST_START && testResult.getMethod().getConstructorOrMethod().getMethod().isAnnotationPresent(Test.class)) {
                JEyes.checkWindowBeforeTest(testNameForEyes.get());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod invokedMethod, ITestResult testResult) {
        Method method = invokedMethod.getTestMethod().getConstructorOrMethod().getMethod();
        if (invokedMethod.isTestMethod()) {
            if (EYES_CHECK_AFTER_ASSERTION && method.isAnnotationPresent(Test.class)) {
                JEyes.checkWindowAfterTest(testNameForEyes.get());
                JEyes.closeEyesAndLogMainInfo();
            }
        } else {
            if (EYES_CHECK_ON_TEST_START || EYES_CHECK_AFTER_ASSERTION) {
                if (method.isAnnotationPresent(BeforeSuite.class)) {
                    initEyesForBatch("Test run " + new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(new Date(currentTimeMillis())));
                }
                if (method.isAnnotationPresent(AfterSuite.class)) {
                    JEyes.closeEyesOrAbort();
                }
            }
        }
    }

}
