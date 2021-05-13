package com.epam.jdi.light.logger;

import com.epam.jdi.light.actions.ActionObject;
import com.epam.jdi.light.elements.common.Alerts;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.tools.Timer;
import com.epam.jdi.tools.func.JFunc1;
import io.qameta.allure.model.StepResult;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeRobotScreenshot;
import static com.epam.jdi.light.driver.ScreenshotMaker.takeScreen;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;
import static com.epam.jdi.light.elements.init.UIFactory.$;
import static com.epam.jdi.light.logger.AttachmentStrategy.OFF;
import static com.epam.jdi.light.logger.AttachmentStrategy.ON_FAIL;
import static com.epam.jdi.light.settings.JDISettings.*;
import static com.epam.jdi.tools.JsonUtils.beautifyJson;
import static com.epam.jdi.tools.LinqUtils.filter;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static com.epam.jdi.tools.ReflectionUtils.isInterface;
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

    public static void screenshotStep(String screenName) {
        String detailsUUID = startStep(screenName);
        createScreenAttachment(screenName);
        getLifecycle().stopStep(detailsUUID);
    }
    public static void infoStep() {
        infoStep("Step info");
    }
    public static void infoStep(String stepName) {
        infoStep(stepName, true, false, true, false);
    }
    public static void infoStep(String stepName, boolean screenshot, boolean pageSource, boolean htmlErrors, boolean video) {
        String detailsUUID = startStep(stepName);
        try {
            if (screenshot) {
                attachScreenshot();
            }
            if (pageSource) {
                attachPageSource();
            }
            if (htmlErrors) {
                attachHttpErrors();
            }
            if (video) {
                attachVideo(DRIVER.videoUrl);
            }
        } catch (Exception ex) {
            throw exception(ex, "Failed to add attachments to Allure step");
        }
        getLifecycle().stopStep(detailsUUID);
    }

    public static void attachScreenshotStep(ICoreElement element) {
        attachScreenshotStep(element.getName(), element.core());
    }
    public static void attachScreenshotStep(String stepName, WebElement element) {
        String detailsUUID = startStep(stepName);
        try {
            UIElement uiElement = isInterface(element.getClass(), ICoreElement.class)
                    ? ((ICoreElement)element).core()
                    : $(element);
            File elementScreen = uiElement.makePhoto();
            attachScreenshot("Screenshot", elementScreen.getAbsolutePath());
        } catch (Exception ex) {
            attachText("Screenshot failed", "text/plain", ex.getMessage());
        }
        getLifecycle().stopStep(detailsUUID);
    }
    public static void attachScreenshotStep(String stepName) {
        String detailsUUID = startStep(stepName);
        String screenPath;
        try {
            screenPath = makeScreenshot("After test");
            attachScreenshot("Screenshot", screenPath);
        } catch (Exception ex) {
            attachText("Screenshot failed", "text/plain", ex.getMessage());
        }
        getLifecycle().stopStep(detailsUUID);
    }
    private static void attachScreenshot() {
        String screenPath;
        try {
            screenPath = makeScreenshot("After test");
            attachScreenshot("Screenshot", screenPath);
        } catch (Exception ex) {
            attachText("Screenshot failed", "text/plain", ex.getMessage());
        }
    }

    public static void attachPageSourceStep(String stepName) {
        String detailsUUID = startStep(stepName);
        attachPageSource();
        getLifecycle().stopStep(detailsUUID);
    }
    private static void attachPageSource() {
        String htmlCode;
        try {
            htmlCode = getDriver().getPageSource();
            attachText("HTML Code", "text/html", htmlCode);
        } catch (Exception ex) {
            attachText("HTML Code failed", "text/plain", ex.getMessage());
        }
    }
    public static void attachElementHtmlStep(ICoreElement element) {
        attachElementHtmlStep(element.getName(), element.core());
    }
    public static void attachElementHtmlStep(String stepName, WebElement element) {
        String detailsUUID = startStep(stepName);
        try {
            UIElement uiElement = isInterface(element.getClass(), ICoreElement.class)
                    ? ((ICoreElement)element).core()
                    : $(element);
            String html = uiElement.printHtml();
            attachText("HTML Code", "text/html", html);
        } catch (Exception ex) {
            attachText("Screenshot failed", "text/plain", ex.getMessage());
        }
        getLifecycle().stopStep(detailsUUID);
    }

    public static void attachHttpErrorsStep(String stepName) {
        String detailsUUID = startStep(stepName);
        attachHttpErrors();
        getLifecycle().stopStep(detailsUUID);
    }
    private static void attachHttpErrors() {
        String httpErrors;
        try {
            httpErrors = getHtmlErrors();
            attachText("HTTP Errors", "text/plain", httpErrors);
        } catch (Exception ex) {
            attachText("HTTP Errors failed", "text/plain", ex.getMessage());
        }
    }

    public static void attachVideoStep(String stepName) {
        attachVideoStep(stepName, DRIVER.videoUrl);
    }
    public static void attachVideoStep(String stepName, String videoUrl) {
        String detailsUUID = startStep(stepName);
        attachVideo(videoUrl);
        getLifecycle().stopStep(detailsUUID);
    }
    private static void attachVideo(String videoUrl) {
        addAttachment("Video", "text/html", htmlVideo(videoUrl), ".html");
    }

    private static String htmlVideo(String url) {
        return "<html><body><video width='100%' height='100%' controls autoplay><source src='"+url+"' type='video/mp4'></video></body></html>";
    }
    public static void createScreenAttachment(String screenName) {
        String screenPath = makeScreenshot(screenName);
        if (isNotBlank(screenPath)) {
            try {
                attachScreenshot("Page screenshot", screenPath);
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

    public static AllureLogData logDataToAllure(Strategy expectedStrategy, String screenName, boolean isAssert) {
        String screenPath = "";
        String htmlSnapshot = "";
        String errors = "";
        if (LOGS.screenStrategy.contains(expectedStrategy)) {
            screenPath = makeScreenshot(screenName, isAssert);
        }
        if (LOGS.htmlCodeStrategy.contains(expectedStrategy)) {
            htmlSnapshot = getHtmlCode();
        }
        if (LOGS.requestsStrategy.contains(expectedStrategy)) {
            errors = getHtmlErrors();
        }
        return new AllureLogData(screenPath, htmlSnapshot, errors);
    }

    public static void attachDataToStep(String screenPath, String htmlSnapshot, String requests) {
        attachDataToStep(new AllureLogData(screenPath, htmlSnapshot, requests));
    }
    public static void attachDataStep(String stepName, String screenPath, String htmlSnapshot, String requests) {
        attachDataStep(stepName, new AllureLogData(screenPath, htmlSnapshot, requests));
    }
    public static void attachDataStep(String stepName, AllureLogData ld) {
        String detailsUUID = startStep(stepName);
        attachDataToStep(ld);
        getLifecycle().stopStep(detailsUUID);
    }
    public static void attachDataToStep(AllureLogData ld) {
        try {
            if (isNotBlank(ld.screenPath)) {
                attachScreenshot("Screenshot", ld.screenPath);
            }
            if (isNotBlank(ld.htmlSnapshot)) {
                attachText("HTML Code Snapshot", "text/html", ld.htmlSnapshot);
            }
            if (isNotBlank(ld.requests)) {
                attachText("HTTP Requests", "text/plain", ld.requests);
            }
        } catch (Exception ex) {
            throw exception(ex, "Failed to add attachments to Allure step");
        }
    }
    public static void failStep(String uuid, AllureLogData ld) {
        if (!LOGS.writeToAllure || isBlank(uuid)) return;

        if (isNotBlank(ld.screenPath) || isNotBlank(ld.htmlSnapshot) || isNotBlank(ld.requests)) {
            String detailsUUID = startStep("Failure details");
            try {
                attachDataToStep(ld);
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

    public static void attachScreenshot(String attachName, String screenName) throws IOException {
        addAttachment(attachName, new ByteArrayInputStream(readAllBytes(get(screenName))));
    }

    public static String getHtmlCode() {
        if (HTML_CODE_LOGGING == OFF)
            return null;
        return getDriver().getPageSource();
    }

    public static String makeScreenshot(String screenName) {
        return makeScreenshot(screenName, false);
    }
    public static String makeScreenshot(String screenName, ActionObject jInfo) {
        return makeScreenshot(screenName, isClass(jInfo.jpClass(), Alerts.class));
    }
    public static String makeScreenshot(String screenName, boolean isAssert) {
        try {
            Timer.sleep(200);
            return SCREEN.tool.equalsIgnoreCase("robot") || isAssert
                    ? takeRobotScreenshot(screenName)
                    : takeScreen(screenName);
        } catch (Exception ignore) { return ""; }
    }
    public static String getHtmlErrors() {
        return getHtmlErrors(LOGS.filterHttpRequests);
    }
    public static String getHtmlErrors(JFunc1<LogEntry, Boolean> filterHttpRequests) {
        List<LogEntry> requests = getDriver().manage().logs().get("performance").getAll();
        List<String> errorEntries = map(filter(requests, filterHttpRequests),
                logEntry -> beautifyJson(logEntry.getMessage()));
        return print(errorEntries);
    }

}
