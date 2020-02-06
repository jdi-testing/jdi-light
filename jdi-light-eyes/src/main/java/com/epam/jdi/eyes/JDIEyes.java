package com.epam.jdi.eyes;

/**
 * Created by Roman Iovlev on 11.04.2019
 * Email: roman.iovlev.jdi@gmail.com;
 * Skype: roman.iovlev
 */

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.tools.Safe;
import org.aspectj.lang.ProceedingJoinPoint;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.applitools.eyes.selenium.fluent.Target.region;
import static com.epam.jdi.light.actions.ActionHelper.getBeforeLogString;
import static com.epam.jdi.light.actions.ActionOverride.overrideAction;
import static com.epam.jdi.light.common.VisualCheckAction.IS_DISPLAYED;
import static com.epam.jdi.light.common.VisualCheckAction.ON_VISUAL_ACTION;
import static com.epam.jdi.light.common.VisualCheckPage.CHECK_NEW_PAGE;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static java.lang.String.format;

public class JDIEyes {
    public static EyesConfig EYES_CONFIG = new EyesConfig();
    public static Safe<Eyes> eyes = new Safe<>(JDIEyes::defaultEyes);

    private static Eyes defaultEyes() {
        Eyes eyes = new Eyes();
        eyes.setApiKey(EYES_CONFIG.apiKey);
        eyes.setAppName(EYES_CONFIG.appName);
        eyes.setBatch(new BatchInfo(EYES_CONFIG.batchName));
        eyes.setForceFullPageScreenshot(true);
        return eyes;
    }
    static void visualTestInit() {
        overrideAction("visualCheck", obj -> {
            try {
                ProceedingJoinPoint jp = (ProceedingJoinPoint) obj;
                if (!isClass(jp.getThis().getClass(), IBaseElement.class))
                    return;
                IBaseElement ui = (IBaseElement) jp.getThis();
                String name = getBeforeLogString(jp);
                show(ui.base().getWebElement());
                visualCheckElement(ui.base().getWebElement(), name);
            } catch (Exception ex) {
                visualCheckPage(WebPage.getCurrentPage());
            }
        });
        overrideAction("visualWindowCheck",
            jp -> visualCheckPage(WebPage.getCurrentPage()));
    }
    public static EyesConfig visualTestInit(Class<?> cl) {
        initSite(cl);
        return visualTestInitJdi();
    }
    public static EyesConfig visualTestInitJdi() {
        visualTestInit();
        return EYES_CONFIG.pageStrategy(CHECK_NEW_PAGE).actionStrategy(ON_VISUAL_ACTION);
    }
    public static EyesConfig visualTestInitSelenium() {
        visualTestInit();
        return EYES_CONFIG.pageStrategy(CHECK_NEW_PAGE).actionStrategy(IS_DISPLAYED);
    }
    static Safe<String> TEST_NAME = new Safe<>(() -> "Before tests");
    static Safe<Boolean> NEW_TEST = new Safe<>(() -> true);
    static List<Eyes> eyesList = new ArrayList<>();
    public static void openEyes() {
        Eyes eyes = JDIEyes.eyes.get();
        if (!eyesList.contains(eyes))
            eyesList.add(eyes);
        if (NEW_TEST.get()) {
            closeEye(eyes);
            eyes.open(EYES_CONFIG.webDriver.execute(), EYES_CONFIG.appName, TEST_NAME.get());
            NEW_TEST.set(false);
        }
    }
    static void closeEye(Eyes eyes) {
        try {
            if (eyes.getIsOpen())
                eyes.close(false);
        } finally {
            if (eyes.getIsOpen())
                eyes.abortIfNotClosed();
        }
    }

    public static void closeAllEyes() {
        try {
            for (Eyes eye : eyesList)
                closeEye(eye);
        } finally {
            if (eyes.get().getIsOpen())
                eyes.get().abortIfNotClosed();
        }
    }
    public static void newVisualTest(String testName) {
        TEST_NAME.set(testName);
        NEW_TEST.set(true);
    }
    public static void newVisualTest(Method method) {
        newVisualTest(format("%s.%s", method.getDeclaringClass().getSimpleName(), method.getName()));
    }
    public static void visualCheckPage(String pageName) {
        try {
            openEyes();
            eyes.get().checkWindow(pageName);
        } catch (Exception ignore) { }
    }
    public static void visualCheckPage(INamed page) {
        visualCheckPage(page.getName());
    }
    public static void visualCheckElement(WebElement webElement, String name) {
        openEyes();
        eyes.get().check(name, region(webElement));
    }
    static void show(WebElement element) {
        ((JavascriptExecutor)EYES_CONFIG.webDriver.execute()).executeScript(
        "return arguments[0].scrollIntoView({behavior:'auto',block:'center',inline:'center'});", element
        );
    }
    static TestResults getResult(Eyes eyes) {
        try {
            return eyes.close(false);
            //return testResults.getStatus() != Failed;
        } catch (Exception ex){
            eyes.abortIfNotClosed();
        }
        return null;
    }
}
