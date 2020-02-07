package com.epam.jdi.mobile.logger;

import io.qameta.allure.Allure;
import io.qameta.allure.model.StepResult;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.epam.jdi.mobile.common.Exceptions.exception;
import static com.epam.jdi.mobile.elements.composite.WebPage.getHtml;
import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static io.qameta.allure.model.Status.FAILED;
import static io.qameta.allure.model.Status.PASSED;

public class AllureLoggerHelper {
    public static boolean writeToAllure = true;
    public static AttachmentStrategy HTML_CODE_LOGGING = AttachmentStrategy.ON_FAIL;

    public static void startStep(String uuid, String message) {
        if (!writeToAllure) return;

        StepResult step = new StepResult().withName(message).withStatus(PASSED);
        getLifecycle().startStep(uuid, step);
    }

    public static void failStep(String uuid, String screenName, String htmlSnapshot) {
        if (!writeToAllure) return;

        getLifecycle().updateStep(uuid, s -> s.withStatus(FAILED));
        if (screenName != null) {
            try {
                attachScreenshot(screenName);
            } catch (IOException ex) {
                throw exception(ex, ex.getMessage());
            }
        }
        if (htmlSnapshot != null) {
            attachHtmlSnapshot(htmlSnapshot);
        }

        getLifecycle().stopStep(uuid);
    }

    public static void passStep(String uuid) {
        if (!writeToAllure) return;

        getLifecycle().updateStep(uuid, s -> s.withStatus(PASSED));
        getLifecycle().stopStep(uuid);
    }

    private static void attachHtmlSnapshot(String htmlSnapshot) {
        if (!writeToAllure) return;
        Allure.addAttachment("HTML Code Snapshot", "text/html", htmlSnapshot, "html");
    }

    private static void attachScreenshot(String screenName) throws IOException {
        if (!writeToAllure) return;
        Allure.addAttachment("Page screenshot", new ByteArrayInputStream(Files.readAllBytes(Paths.get(screenName))));
    }

    public static String takeHtmlCodeOnFailure() {
        if (HTML_CODE_LOGGING == AttachmentStrategy.ON_FAIL) {
            return getHtml();
        }
        return null;
    }

    public enum AttachmentStrategy {
        ON_FAIL, OFF
    }

}
