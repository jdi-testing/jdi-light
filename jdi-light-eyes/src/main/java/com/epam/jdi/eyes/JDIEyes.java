package com.epam.jdi.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.TestResults;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Configuration;
import com.applitools.eyes.selenium.Eyes;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.tools.Safe;
import com.epam.jdi.tools.func.JFunc;
import com.epam.jdi.tools.func.JFunc1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.applitools.eyes.TestResultsStatus.Passed;
import static com.epam.jdi.light.actions.ActionOverride.OverrideAction;
import static com.epam.jdi.light.elements.init.InitActions.JDI_ANNOTATIONS;
import static com.epam.jdi.light.elements.init.rules.AnnotationRule.aRule;
import static com.google.common.base.Strings.isNullOrEmpty;

public class JDIEyes extends Eyes {
    private static Safe<JEyes> eyes = new Safe<>(new JEyes());
    public static EyesConfig EYES_CONFIG = new EyesConfig();

    public static void initVisualTest() {
        OverrideAction("isDisplayed", e -> { e.get().isDisplayed(); visualCheckElement(e); });
        JDI_ANNOTATIONS.add("VisualCheck", aRule(VisualCheck.class, (e,a) -> e.params.add("visualCheck", "")));
    }
    public static void initVisualTest(EyesConfig config) {
        OverrideAction("isDisplayed", e -> { e.get().isDisplayed(); visualCheckElement(e); });
        JDI_ANNOTATIONS.add("VisualCheck", aRule(VisualCheck.class, (e,a) -> e.params.add("visualCheck", "")));
        EYES_CONFIG = config;
    }

    public static void startVisualTest(String testName) {
        eyes.get().setBatch(new BatchInfo(testName));
    }
    public static void endVisualTest() {
        try {
            eyes.get().close();
        } finally {
            eyes.get().abortIfNotClosed();
        }
    }
    public static boolean visualCheckPage(INamed page) {
        eyes.get().checkWindow(page.getName());
        return eyes.get().getResult();
    }
    public static boolean visualCheckElement(IBaseElement uiElement) {
        return visualCheckElement(uiElement.base().getWebElement(), uiElement.getName());
    }
    public static boolean visualCheckElement(WebElement webElement, String name) {
        eyes.get().checkElement(webElement, name);
        return eyes.get().getResult();
    }
}
