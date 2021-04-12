package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ButtonToggleAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.webList;
import org.openqa.selenium.By;

/**
 * To see an example of ButtonToggle web element please visit https://material.angular.io/components/button-toggle/overview.
 */

public class ButtonToggle extends UIBaseElement<ButtonToggleAssert> {

    @JDIAction("Click '{name}' button by tag value '{0}'")
    public void clickButtonToggleByValue(String value) {
        getButtonToggleByTagValue(value).click();
    }

    @JDIAction("Is '{name}' pressed '{0}'")
    public boolean isButtonToggleButtonPressed(String value) {
        return getButtonToggleByTagValue(value).find(By.cssSelector("button")).attr("aria-pressed").equals("true");
    }

    @JDIAction("'{name}' has text '{0}'")
    public boolean buttonToggleHasText(String value) {
        return getButtonToggleByTagValue(value).find(By.cssSelector("button")).getText().equalsIgnoreCase(value);
    }

    @JDIAction("Get '{name}' tabs")
    private webList getButtonToggleItems() {
        return this.finds(".mat-button-toggle");
    }

    @JDIAction("Is '{name}' selected '{0}'")
    public boolean isButtonToggleSelected(String value) {
        com.epam.jdi.light.elements.common.uiElement element = getButtonToggleByTagValue(value);
        if (isButtonToggleDisabled(value)) {
            throw new UnsupportedOperationException(String.format("button toggle is disabled %s", value));
        }
        return element.attr("class").contains("checked");
    }

    private boolean isButtonToggleDisabled(String value) {
        com.epam.jdi.light.elements.common.uiElement element = getButtonToggleByTagValue(value);
        return element.hasAttribute("disabled");
    }

    private com.epam.jdi.light.elements.common.uiElement getButtonToggleByTagValue(String value) {
        com.epam.jdi.light.elements.common.uiElement element = null;
        for (com.epam.jdi.light.elements.common.uiElement e : getButtonToggleItems()) {
            if (e.attr("value").equals(value)) {
                element = e;
            }
        }
        return element;
    }

    @Override
    public ButtonToggleAssert is() {
        return new ButtonToggleAssert().set(this);
    }
}
