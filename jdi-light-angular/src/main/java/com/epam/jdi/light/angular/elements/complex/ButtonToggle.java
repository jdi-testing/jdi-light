package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.TabsAssert;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

public class ButtonToggle extends UIBaseElement<TabsAssert> {

    public void clickButtonByValue(String value){
        getButtonByTagValue(value).click();
    }

    public WebList getButtonToggleGroups() {
        return this.finds(".mat-button-toggle");
    }

    public UIElement getButtonByTagValue(String value) {
        UIElement element = null;
        for (UIElement e : getButtonToggleGroups()) {
            if (e.attr("value").equals(value)) {
                element = e;
            }
        }
        return element;
    }

}
