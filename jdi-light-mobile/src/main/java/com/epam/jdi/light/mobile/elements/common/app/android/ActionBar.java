package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.mobile.asserts.ActionBarAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.elements.common.app.IActionBar;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

public class ActionBar extends MobileAppBaseElement<ActionBarAssert> implements IActionBar, HasTouchActions, IsButton {

    @JDIAction("Select {0} in '{name}'")
    public void select(String text) {
        List<WebElement> optionsList = getDriver().findElements(
                By.className("android.widget.TextView"));
        for (WebElement element : optionsList) {
            if (element.getAttribute("text").equals(text)) {
                element.click();
            }
        }
    }

    @Override
    public ActionBarAssert is() {
        return new ActionBarAssert().set(this);
    }
}
