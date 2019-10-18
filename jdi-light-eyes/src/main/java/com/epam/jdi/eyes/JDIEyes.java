package com.epam.jdi.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class JDIEyes extends Eyes {
    private static Safe<JDIEyes> eyes = new Safe<>(new JDIEyes());

    public static String APPLICATION_NAME = "JDI Application";
    public static JFunc1<Configuration, Configuration> EYES_CONFIG = c -> { c.setHideScrollbars(false); return c; };
    public static JFunc<WebDriver> EYES_DRIVER = ChromeDriver::new;

    public static void startTest(String testName) {
        eyes.get().setBatch(new BatchInfo(testName));
    }
    public static void endTest() {
        try {
            eyes.get().close();
        } finally {
            eyes.get().abortIfNotClosed();
        }
    }
    public static void eyesCheckWindow(String tag) {
        eyes.get().checkWindow(tag);
        eyes.get().logResult();
    }
    public static void eyesCheckElement(IBaseElement uiElement) {
        eyes.get().checkElement(uiElement.base().getWebElement(), uiElement.getName());
        eyes.get().logResult();
    }
    public static void eyesCheckElement(WebElement webElement) {
        eyes.get().checkElement(webElement);
        eyes.get().logResult();
    }

    JDIEyes() {
        super(new ClassicRunner());
        if (isNullOrEmpty(System.getenv("APPLITOOLS_API_KEY"))) {
            throw new RuntimeException("No API Key found; Please set environment variable 'APPLITOOLS_API_KEY'. More info how to obtain API_KEY https://applitools.com/docs/topics/overview/obtain-api-key.html");
        }
        setApiKey(System.getenv("APPLITOOLS_API_KEY"));
        setAppName(APPLICATION_NAME);
        setConfiguration(EYES_CONFIG.execute(new Configuration()));
        open(EYES_DRIVER.execute());
    }
    void open(String batchName) {
        setBatch(new BatchInfo(batchName));
    }

    void logResult() {
        try {
            TestResults testResults = close(false);
            String fullTestResult = testResults.toString();
            String testResult = fullTestResult.substring(fullTestResult.indexOf("test name"), fullTestResult.indexOf(']'));
            String status = testResults.getStatus().toString().toUpperCase();
            logger.info(format("Applitools eyes check result: %s: %s (full info in your Applitools account).", status, testResult));
        } catch (Exception ignore) {
        } finally {
            abortIfNotClosed();
        }
    }

}
