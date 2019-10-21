package com.epam.jdi.eyes;

/**
 * Created by Ekaterina Vasilkova on 25.09.2019
 * Email: katenka.vasilkova@gmail.com; Skype: live:katenka.vasilkova
 */

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.selenium.Eyes;
import com.epam.jdi.light.elements.interfaces.base.IBaseElement;
import com.epam.jdi.light.elements.interfaces.base.INamed;
import com.epam.jdi.tools.Safe;
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.actions.ActionOverride.OverrideAction;
import static com.epam.jdi.light.elements.init.InitActions.JDI_ANNOTATIONS;
import static com.epam.jdi.light.elements.init.rules.AnnotationRule.aRule;

public class JDIEyes {
    public static EyesConfig EYES_CONFIG = new EyesConfig();
    private static Safe<JEyes> eyes = new Safe<>(JEyes::new);

    public static void initVisualTest() {
        OverrideAction("isDisplayed", e -> {
            e.isDisplayed();
            visualCheckElement(e);
        });
        JDI_ANNOTATIONS.add("VisualCheck", aRule(VisualCheck.class, (e,a) -> e.params.add("visualCheck", "")));
    }
    public static void initVisualTest(EyesConfig config) {
        OverrideAction("isDisplayed", e -> {
            e.isDisplayed();
            visualCheckElement(e);
        });
        JDI_ANNOTATIONS.add("VisualCheck", aRule(VisualCheck.class, (e,a) -> e.params.add("visualCheck", "")));
        EYES_CONFIG = config;
    }

    public static void startVisualTest(String testName) {
        eyes.get().open(EYES_CONFIG.webDriver.execute(), EYES_CONFIG.appName, testName);
    }
    public static void endVisualTest() {
        try {
            eyes.get().close();
        } finally {
            if (eyes.get().getIsOpen())
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
