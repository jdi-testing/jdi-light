package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.ButtonToggleAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

public class ButtonToggle extends UIBaseElement<ButtonToggleAssert> {

    @JDIAction("Click '{name}' button by tag value '{0}'")
    public void clickButtonByValue(String value){
        getButtonByTagValue(value).click();
    }

    @JDIAction("Get '{name}' tabs")
    private WebList getButtonToggleGroups() {
        return this.finds(".mat-button-toggle");
    }

    private UIElement getButtonByTagValue(String value) {
        UIElement element = null;
        for (UIElement e : getButtonToggleGroups()) {
            if (e.attr("value").equals(value)) {
                element = e;
            }
        }
        return element;
    }
}
