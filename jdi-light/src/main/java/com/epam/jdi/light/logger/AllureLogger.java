package com.epam.jdi.light.logger;

import io.qameta.allure.model.StepResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.composite.WebPage.getHtml;
import static com.epam.jdi.light.logger.AllureLogger.AttachmentStrategy.OFF;
import static com.epam.jdi.light.logger.AllureLogger.AttachmentStrategy.ON_FAIL;
import static com.epam.jdi.light.settings.JDISettings.LOGS;
import static io.qameta.allure.Allure.addAttachment;
import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static io.qameta.allure.model.Status.FAILED;
import static io.qameta.allure.model.Status.PASSED;
import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;
import static java.util.UUID.randomUUID;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class AllureLogger {
    public static AttachmentStrategy HTML_CODE_LOGGING = ON_FAIL;

    public static String startStep(String message) {
        if (!LOGS.writeToAllure) return "";

        try {
            StepResult step = new StepResult().withName(message);
            if (getLifecycle().getCurrentTestCase().isPresent()) {
                String uuid = randomUUID().toString();
                getLifecycle().startStep(uuid, step);
                return uuid;
            }
        } catch (Exception ignore) { }
        return "";
    }

    public static void failStep(String uuid, String screenName, String htmlSnapshot, String requests) {
        if (!LOGS.writeToAllure || isBlank(uuid)) return;

        getLifecycle().updateStep(uuid, s -> s.setStatus(FAILED));
        getLifecycle().stopStep(uuid);

        if (isNotBlank(screenName) || isNotBlank(htmlSnapshot) || isNotBlank(requests)) {
            String detailsUUID = AllureLogger.startStep("Failure details");
            if (isNotBlank(screenName)) {
                try {
                    attachScreenshot(screenName);
                } catch (IOException ex) {
                    throw exception(ex, "");
                }
            }
            if (isNotBlank(htmlSnapshot)) {
                attachText("HTML Code Snapshot", "text/html", htmlSnapshot);
            }
            if (isNotBlank(requests)) {
                attachText("HTTP Requests", "text/plain", requests);
            }
            getLifecycle().stopStep(detailsUUID);
        }
    }

    public static void passStep(String uuid) {
        if (!LOGS.writeToAllure || isBlank(uuid)) return;

        getLifecycle().updateStep(uuid, s -> s.setStatus(PASSED));
        getLifecycle().stopStep(uuid);
    }

    private static void attachText(String name, String type, String htmlSnapshot) {
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
