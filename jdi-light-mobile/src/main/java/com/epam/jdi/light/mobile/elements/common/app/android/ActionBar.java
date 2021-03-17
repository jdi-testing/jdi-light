package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.mobile.asserts.ActionBarAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.IActionBar;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ActionBar extends MobileAppBaseElement<ActionBarAssert> implements IActionBar, HasTouchActions, IsButton {

    @JDIAction(value = "Set '{name}' expanded")
    @Override
    public void setExpanded() {
        if (core().isDisplayed())
            core().tap();
    }

    @JDIAction(value = "Check that '{name}' is expanded")
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
            core().get().findElements(By.className("android.widget.TextView"))
            .stream()
            .filter(webElement -> webElement.getAttribute("text").equalsIgnoreCase(text))
                    .forEach(WebElement::click);
    }

    @Override
    public ActionBarAssert is() {
        return new ActionBarAssert().set(this);
    }
}
