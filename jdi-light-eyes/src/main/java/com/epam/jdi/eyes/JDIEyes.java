package com.epam.jdi.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.Eyes;
import com.epam.jdi.light.common.VisualCheckAction;
import com.epam.jdi.light.common.VisualCheckPage;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.tools.Safe;
import org.aspectj.lang.ProceedingJoinPoint;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static com.applitools.eyes.selenium.fluent.Target.region;
import static com.epam.jdi.light.actions.ActionHelper.getBeforeLogString;
import static com.epam.jdi.light.actions.ActionOverride.OverrideAction;
import static com.epam.jdi.light.common.VisualCheckAction.ON_VISUAL_ACTION;
import static com.epam.jdi.light.common.VisualCheckPage.CHECK_NEW_PAGE;
import static com.epam.jdi.light.settings.WebSettings.VISUAL_ACTION_STRATEGY;
import static com.epam.jdi.light.settings.WebSettings.VISUAL_PAGE_STRATEGY;
import static com.epam.jdi.tools.ReflectionUtils.isClass;
import static java.lang.String.format;

public class JDIEyes {
    public static EyesConfig EYES_CONFIG = new EyesConfig();
    private static Safe<Eyes> eyes = new Safe<>(JDIEyes::defaultEyes);

    private static Eyes defaultEyes() {
        Eyes eyes = new Eyes();
        eyes.setApiKey(EYES_CONFIG.apiKey);
        eyes.setAppName(EYES_CONFIG.appName);
        eyes.setBatch(new BatchInfo(EYES_CONFIG.batchName));
        return eyes;
    }

    static void visualTestInit(VisualCheckPage checkPageStrategy,
            VisualCheckAction checkActionStrategy) {
        VISUAL_PAGE_STRATEGY = checkPageStrategy;
        VISUAL_ACTION_STRATEGY = checkActionStrategy;
        OverrideAction("visualCheck", obj -> {
            ProceedingJoinPoint jp = (ProceedingJoinPoint)obj;
            if (!isClass(jp.getThis().getClass(), IBaseElement.class))
                return;
            IBaseElement ui = (IBaseElement) jp.getThis();
            String name = getBeforeLogString(jp);
            visualCheckElement(ui.base().getWebElement(), name);
        });
        OverrideAction("visualWindowCheck",
            jp -> visualCheckPage(WebPage.getCurrentPage()));
    }
    public static void visualTestInit() {
        visualTestInit(CHECK_NEW_PAGE, ON_VISUAL_ACTION);
    }
    public static void initVisualTest() {
        visualTestInit();
    }
    public static void initVisualTest(String apikey) {
        visualTestInit();
        EYES_CONFIG.apiKey = apikey;
    }
    static Safe<String> TEST_NAME = new Safe<>(() -> "Before tests");
    static Safe<Boolean> NEW_TEST = new Safe<>(() -> true);
    static List<Eyes> eyesList = new ArrayList<>();
    static void openEyes() {
        Eyes eye = eyes.get();
        if (!eyesList.contains(eye))
            eyesList.add(eye);
        if (NEW_TEST.get()) {
            if (eye.getIsOpen())
                closeEye(eye);
            eye.open(EYES_CONFIG.webDriver.execute(), EYES_CONFIG.appName, TEST_NAME.get());
            NEW_TEST.set(false);
        }
    }
    static void closeEye(Eyes eye) {
        try {
            if (eye.getIsOpen())
                eye.close();
        } finally {
            if (eye.getIsOpen())
                eye.abortIfNotClosed();
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
        openEyes();
        eyes.get().checkWindow(pageName);
    }
    public static void visualCheckPage(INamed page) {
        visualCheckPage(page.getName());
    }
    public static void visualCheckElement(WebElement webElement, String name) {
        openEyes();
        eyes.get().check(name, region(webElement));
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
