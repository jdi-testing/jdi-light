package com.epam.jdi.light.logger;

import com.epam.jdi.tools.Timer;
import io.qameta.allure.model.StepResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeRobotScreenshot;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.elements.composite.WebPage.getHtml;
import static com.epam.jdi.light.logger.AllureLogger.AttachmentStrategy.OFF;
import static com.epam.jdi.light.logger.AllureLogger.AttachmentStrategy.ON_FAIL;
import static com.epam.jdi.light.settings.JDISettings.LOGS;
import static com.epam.jdi.light.settings.JDISettings.SCREEN;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static io.qameta.allure.model.Status.PASSED;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class AllureLogger {
    public static AttachmentStrategy HTML_CODE_LOGGING = ON_FAIL;

    public static void screenshotStep(String screenName, boolean isNativeAlert) {
        String detailsUUID = AllureLogger.startStep(screenName);
        createAttachment(screenName, isNativeAlert);
        getLifecycle().stopStep(detailsUUID);
    }
    public static void createAttachment(String screenName, boolean isNativeAlert) {
        String screenPath;
        if (SCREEN.allowRobot || isNativeAlert) {
            Timer.sleep(200);
            screenPath = takeRobotScreenshot(screenName);
        } else {
            screenPath = takeScreen(screenName);
        }
        if (isNotBlank(screenPath)) {
            try {
                attachScreenshot(screenPath);
            } catch (IOException ex) {
                throw exception(ex, "");
            }
        }
    }
    public static String startStep(String message) {
        if (!LOGS.writeToAllure) return "";

        try {
            StepResult step = new StepResult().setName(message);
            if (getLifecycle().getCurrentTestCase().isPresent()) {
                String uuid = randomUUID().toString();
                getLifecycle().startStep(uuid, step);
                return uuid;
            }
        } catch (Exception ignore) { }
        return "";
    }

    public static void failStep(String uuid, String screenPath, String htmlSnapshot, String requests) {
        if (!LOGS.writeToAllure || isBlank(uuid)) return;

        if (isNotBlank(screenPath) || isNotBlank(htmlSnapshot) || isNotBlank(requests)) {
            String detailsUUID = AllureLogger.startStep("Failure details");
            try {
                if (isNotBlank(screenPath)) {
                    attachScreenshot(screenPath);
                }
                if (isNotBlank(htmlSnapshot)) {
                    attachText("HTML Code Snapshot", "text/html", htmlSnapshot);
                }
                if (isNotBlank(requests)) {
                    attachText("HTTP Requests", "text/plain", requests);
                }
            } catch (Exception ex) {
                throw exception(ex, "Failed to add attachments to Allure step");
            } finally {
                getLifecycle().stopStep(detailsUUID);
            }
        }
    }

    public static void passStep(String uuid) {
        if (!LOGS.writeToAllure || isBlank(uuid)) return;

        getLifecycle().updateStep(uuid, s -> s.setStatus(PASSED));
        getLifecycle().stopStep(uuid);
    }

    public static void attachText(String name, String type, String htmlSnapshot) {
        addAttachment(name, type, htmlSnapshot, "html");
    }

    public static void attachScreenshot(String screenName) throws IOException {
        addAttachment("Page screenshot", new ByteArrayInputStream(readAllBytes(get(screenName))));
    }

    public static String takeHtmlCodeOnFailure() {
        if (HTML_CODE_LOGGING == OFF)
            return null;
        return getHtml();
    }

    public enum AttachmentStrategy {
        ON_FAIL, OFF
    }

}
