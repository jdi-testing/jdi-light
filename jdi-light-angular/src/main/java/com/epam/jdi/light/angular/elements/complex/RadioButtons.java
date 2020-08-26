package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.RadioButtonsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

public class RadioButtons extends UIBaseElement<RadioButtonsAssert> {

    @JDIAction("Click '{name}' button by tag value '{0}'")
    public void clickRadioButtonByValue(String value) {
        getRadioButtonByTagValue(value).click();
    }


    public UIElement getRadioButtonByTagValue(String value) {
        UIElement element = null;
        for (UIElement e : getRadioButtons()) {
            if (e.find("input").attr("value").equals(value)) {
                element = e;
            }
        }
        return element;
    }

    public WebList getRadioButtons() {
        return this.finds(".mat-radio-button");
    }

    @Override
    public RadioButtonsAssert is() {
        return new RadioButtonsAssert().set(this);
    }
}
