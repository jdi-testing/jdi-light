package com.epam.jdi.light.logger;

import io.qameta.allure.model.StepResult;

import java.io.*;

import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.elements.composite.WebPage.*;
import static com.epam.jdi.light.logger.AllureLogger.AttachmentStrategy.*;
import static com.epam.jdi.light.settings.WebSettings.*;
import static io.qameta.allure.Allure.*;
import static io.qameta.allure.aspects.StepsAspects.getLifecycle;
import static io.qameta.allure.model.Status.*;
import static java.nio.file.Files.*;
import static java.nio.file.Paths.*;
import static java.util.UUID.*;
import static org.apache.commons.lang3.StringUtils.*;

public class AllureLogger {
    public static AttachmentStrategy HTML_CODE_LOGGING = ON_FAIL;

    public static String startStep(String message) {
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
        if (!WRITE_TO_ALLURE || isBlank(uuid)) return;

        getLifecycle().updateStep(uuid, s -> s.withStatus(FAILED));
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
        if (isNotBlank(htmlSnapshot)) {
            attachText("HTTP Requests", "text/plain", requests);
        }

        getLifecycle().stopStep(uuid);
    }

    public static void passStep(String uuid) {
        if (!WRITE_TO_ALLURE || isBlank(uuid)) return;

        getLifecycle().updateStep(uuid, s -> s.withStatus(PASSED));
        getLifecycle().stopStep(uuid);
    }

    private static void attachText(String name, String type, String htmlSnapshot) {
        addAttachment(name, type, htmlSnapshot, "html");
    }

    private static void attachScreenshot(String screenName) throws IOException {
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
