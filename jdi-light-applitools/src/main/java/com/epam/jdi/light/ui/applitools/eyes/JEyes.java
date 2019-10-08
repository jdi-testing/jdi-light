package com.epam.jdi.light.ui.applitools.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.tools.Safe;
import org.openqa.selenium.WebDriver;

import static com.epam.jdi.light.settings.WebSettings.*;
import static com.epam.jdi.light.ui.applitools.actions.JEyesActions.integrateEyesInJDI;
import static com.epam.jdi.light.ui.applitools.actions.JEyesActions.uiElementLastProcessed;
import static com.epam.jdi.light.ui.applitools.listeners.JEyesTestNGListener.testNameForEyes;
import static com.google.common.base.Strings.isNullOrEmpty;
import static java.lang.String.format;

public class JEyes extends Eyes {

    private static Safe<JEyes> jEyes = new Safe<>(new JEyes());

    private static boolean eyesAreAlreadyIntegratedInJDI = false;

    private static void setApiKey() {
        if (isNullOrEmpty(System.getenv("APPLITOOLS_API_KEY"))) {
            throw new RuntimeException("No API Key found; Please set environment variable 'APPLITOOLS_API_KEY'.");
        }
        jEyes.get().setApiKey(System.getenv("APPLITOOLS_API_KEY"));
    }

    public static void initEyesForBatch(String batchName) {
        if (EYES_ENABLED) {
            if (!eyesAreAlreadyIntegratedInJDI) {
                integrateEyesInJDI();
                eyesAreAlreadyIntegratedInJDI = true;
            }
            if (jEyes.get().getBatch().getName() == null) {
                initEyesSettingsForBatch(batchName);
            }
        }
    }

    private static void initEyesSettingsForBatch(String batchName) {
        setApiKey();
        jEyes.get().setAppName(APPLICATION_NAME);
        jEyes.get().setBatch(new BatchInfo(batchName));
        jEyes.get().setHideScrollbars(false);
    }

    public static void openEyesCheckWindowAndClose(String tag) {
        if (EYES_ENABLED) {
            initEyesForBatch(tag);
            if (jEyes.get().getIsOpen() && !testNameForEyes.get().equals(tag)) {
                closeEyesOrAbort();
            }
            checkWindowByOpenedEyes(tag, tag);
            closeEyesAndLogMainInfo();
        }
    }

    public static void openEyesCheckElementAndClose(UIElement uiElement, String tag) {
        if (EYES_ENABLED) {
            initEyesForBatch(tag);
            if (jEyes.get().getIsOpen() && !testNameForEyes.get().equals(tag)) {
                closeEyesOrAbort();
            }
            checkElementByOpenedEyes(uiElement, tag);
            closeEyesAndLogMainInfo();
        }
    }

    private static WebDriver openEyesForTest(String testName) {
        if (EYES_ENABLED) {
            return jEyes.get().open(WebDriverFactory.getDriver(), jEyes.get().getAppName(), testName);
        }
        return null;
    }

    public static void checkWindowByOpenedEyes(String testName, String tag) {
        if (EYES_ENABLED) {
            if (jEyes.get().getIsOpen()) {
                jEyes.get().checkWindow(tag);
                if (EYES_CHECK_WITH_PROCESSED_ELEMENT && uiElementLastProcessed.get() != null) {
                    UIElement uiElement = uiElementLastProcessed.get();
                    try {
                        jEyes.get().checkElement(uiElement.getWebElement(), uiElement.name);
                    } catch (Exception e) {
                        logger.step(failToCheckElementByEyesMessage(uiElement.name, e.getMessage()));
                    }
                }
            } else {
                openEyesForTest(testName);
                checkWindowByOpenedEyes(testName, tag);
            }
        }
    }

    public static void checkElementByOpenedEyes(UIElement uiElement, String testName) {
        if (EYES_ENABLED) {
            if (jEyes.get().getIsOpen()) {
                try {
                    jEyes.get().checkElement(uiElement.getWebElement(), uiElement.name);
                } catch (Exception e) {
                    logger.error(failToCheckElementByEyesMessage(uiElement.name, e.getMessage()));
                }
            } else {
                openEyesForTest(testName);
                checkElementByOpenedEyes(uiElement, testName);
            }
        }
    }

    public static void checkWindowBeforeTest(String testName) {
        if (EYES_CHECK_ON_TEST_START) {
            checkWindowByOpenedEyes(getTestNameOrUse(testName), "Before the test started");
        }
    }

    public static void checkWindowAfterTest(String testName) {
        if (EYES_CHECK_AFTER_ASSERTION) {
            checkWindowByOpenedEyes(getTestNameOrUse(testName), "After the test finished");
        }
    }

    private static String getTestNameOrUse(String testName) {
        return testNameForEyes.get() != null ? testNameForEyes.get() : testName;
    }

    public static void closeEyesOrAbort() {
        if (EYES_ENABLED && jEyes.get().getIsOpen()) {
            try {
                jEyes.get().close(false);
            } catch (Exception ignore) {
            } finally {
                jEyes.get().abortIfNotClosed();
            }
        }
    }

    public static void closeEyesAndLogMainInfo() {
        if (EYES_ENABLED && jEyes.get().getIsOpen()) {
            try {
                TestResults testResults = jEyes.get().close(false);
                String fullTestResult = testResults.toString();
                String testResult = fullTestResult.substring(fullTestResult.indexOf("test name"), fullTestResult.indexOf(']'));
                String status = testResults.getStatus().toString().toUpperCase();
                logger.step(format("Applitools eyes check result: %s: %s (full info in your Applitools account).", status, testResult));
            } catch (Exception ignore) {
            } finally {
                jEyes.get().abortIfNotClosed();
            }
        }
    }

    public static void closeEyesAndLogFullInfo() {
        if (EYES_ENABLED && jEyes.get().getIsOpen()) {
            try {
                TestResults testResults = jEyes.get().close(false);
                logger.step(format("Applitools eyes check result: %s (full info in your Applitools account).", testResults.toString()));
            } catch (Exception ignore) {
            } finally {
                jEyes.get().abortIfNotClosed();
            }
        }
    }

    private static String failToCheckElementByEyesMessage(String elementName, String exceptionMessage) {
        return format("Fail to check the element %s by eyes. Cause: %s", elementName, exceptionMessage);
    }

}
