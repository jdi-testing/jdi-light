package io.github.epam.testng;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

import com.epam.jdi.light.driver.ScreenshotMaker;
import com.epam.jdi.tools.Safe;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.epam.jdi.light.actions.ActionProcessor.provideExtraInfoOnFail;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static java.lang.String.format;
import static java.lang.System.currentTimeMillis;

public class TestNGListener implements IInvokedMethodListener {

    private Safe<Long> start = new Safe<>(0L);

    private Safe<WebDriver.Window> window = new Safe<>(getDriver().manage().window());

    private Safe<Integer> x = new Safe<>(window.get().getPosition().x);
    private Safe<Integer> y = new Safe<>(window.get().getPosition().y);
    private Safe<Integer> width = new Safe<>(window.get().getSize().width);
    private Safe<Integer> height = new Safe<>(window.get().getSize().height);

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult iTestResult) {
        if (method.isTestMethod()) {
            Method testMethod = method.getTestMethod().getConstructorOrMethod().getMethod();
            if (testMethod.isAnnotationPresent(Test.class)) {
                TEST_NAME.set(iTestResult.getTestClass().getRealClass().getSimpleName() + "." + testMethod.getName());
                start.set(currentTimeMillis());
                logger.step("== Test '%s' START ==", TEST_NAME.get());
            }
        }
    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult iTestResult) {
        if (method.isTestMethod()) {
            String result = getTestResult(iTestResult);
            logger.step("=== Test '%s' %s [%s] ===", TEST_NAME.get(), result,
                    new SimpleDateFormat("mm:ss.SS").format(new Date(currentTimeMillis() - start.get())));
            if (result.equals("FAILED")) {
                String methodName = method.getTestMethod().toString();
                String shortMethodName = methodName.substring(0, methodName.indexOf("("));

                try {
                    getDriver().switchTo().alert();
                    new ScreenshotMaker().takeScreenshotByRobot(
                            x.get(), y.get(), width.get(), height.get(),
                            format("Method_%s_failed_at_", shortMethodName + "(..)"), "dd-MM-yyyy_HH-mm-ss");
                    getDriver().wait(1000000000);
                } catch (NoAlertPresentException ex) {
                    provideExtraInfoOnFail(shortMethodName + "(..)");
                } catch (Exception ignore) {
                } finally {
                    logger.error("ERROR: " + iTestResult.getThrowable().getMessage());
                }
            }
        }
    }

    private String getTestResult(ITestResult iTestResult) {
        switch (iTestResult.getStatus()) {
            case ITestResult.SUCCESS:
                return "PASSED";
            case ITestResult.SKIP:
                return "SKIPPED";
            default:
                return "FAILED";
        }
    }

}
