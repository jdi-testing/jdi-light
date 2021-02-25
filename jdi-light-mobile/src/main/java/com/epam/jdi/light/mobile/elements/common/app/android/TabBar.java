package com.epam.jdi.light.mobile.elements.common.app.android;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsButton;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.mobile.asserts.TabBarAssert;
import com.epam.jdi.light.mobile.elements.base.MobileAppBaseElement;
import com.epam.jdi.light.mobile.interfaces.HasTouchActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Optional;

import static com.epam.jdi.light.common.Exceptions.exception;

public class TabBar extends MobileAppBaseElement<TabBarAssert> implements HasTouchActions, IsButton, IsText {

    @Override
    public TabBarAssert is() {
        return new TabBarAssert().set(this);
    }

    @JDIAction(value = "Get selected value from '{name}'")
    public String isSelected() {
        return getFirstElementByAttributeValue("selected", "true")
                .getAttribute("text");
    }

    @JDIAction(value = "Select {0} on '{name}'")
    public void selectByText(String tabName) {
        getFirstElementByAttributeValue("text", tabName).click();
    }

    @JDIAction(value = "Select tab {0} on '{name}'")
    public void selectByNumber(int tabNumber) {
        core().get().findElements(By.className("android.widget.LinearLayout")).get(tabNumber-1).click();
    }

    private WebElement getFirstElementByAttributeValue(String attributeName, String attributeValue) {
        Optional<WebElement> first = core().get().findElements(By.id("android:id/title"))
                .stream()
                .filter(element -> element.getAttribute(attributeName).equals(attributeValue))
                .findFirst();
        if (!first.isPresent()) {
            throw exception("Tab with %s=%s was not found", attributeName, attributeValue);
        }
        return first.get();
    }
}
