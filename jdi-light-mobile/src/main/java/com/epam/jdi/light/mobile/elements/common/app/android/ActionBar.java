package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.logger.LogLevels;
import com.epam.jdi.light.mobile.asserts.ActionBarAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.IActionBar;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import io.appium.java_client.MobileBy;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class ActionBar extends MobileAppBaseElement<ActionBarAssert> implements IActionBar, HasTouchActions, IsButton {

    @JDIAction(value = "Check that '{name}' is iconified", level = LogLevels.DEBUG)
    @Override
    public boolean isIconified() {
        return core().isDisplayed();
    }

    @JDIAction(value = "Set '{name}' expanded", level = LogLevels.DEBUG)
    @Override
    public void setExpanded() {
        if (isIconified())
            core().tap();
    }

    @JDIAction(value = "Check that '{name}' is expanded", level = LogLevels.DEBUG)
    @Override
    public boolean isExpanded() {
        return core().attr("focused")
                .equalsIgnoreCase("true");
    }

    @Override
    public String getValue() {
        return text();
    }

    @Override
    public void input(String value) {
        core().input(value);
    }

    @JDIAction("Clear value from '{name}'")
    @Override
    public void clear() {
        if (!isEmpty()) {
            core().clear();
        }
    }

    @JDIAction("Select {0} in '{name}'")
    public void selectOption(String text) {
        List<WebElement> options = getDriver().findElements(
                new MobileBy.ByAndroidUIAutomator(
                        "new UiSelector().className(\"android.widget.TextView\")"));
        options.stream().filter(webElement -> webElement.getText().equalsIgnoreCase(text))
                .forEach(webElement -> webElement.click());
    }

    @Override
    public ActionBarAssert is() {
        return new ActionBarAssert().set(this);
    }
}
