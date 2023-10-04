package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.RadioButtonsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

/**
 * To see an example of RadioButtons web element please visit https://material.angular.io/components/radio/overview.
 */

public class RadioButtons extends UIBaseElement<RadioButtonsAssert> {

    @JDIAction("Click '{name}' button by tag value '{0}'")
    public void click(String value) {
        getRadioButtonByTagValue(value).click();
    }

    @JDIAction("'name' has no ripple effect")
    public boolean hasNoRippleEffect(String value) {
        return getRadioButtonByTagValue(value).attr("disableripple").equalsIgnoreCase("true");
    }
    @JDIAction("'{name}' radio button  contain value '{0}'")
    public boolean isChecked(String value) {
        return getRadioButtonByTagValue(value).attr("class").contains("mat-mdc-radio-checked");
    }

    private UIElement getRadioButtonByTagValue(String value) {
        UIElement element = null;
        for (UIElement e : getRadioButtons()) {
            if (e.find("input").attr("value").equalsIgnoreCase(value)) {
                element = e;
            }
        }
        return element;
    }

    @JDIAction("'{name}'label is in before position")
    public boolean isBeforePosition() {
        return core().attr("labelposition").equalsIgnoreCase("before");
    }

    @JDIAction("'{name}'aria-label is '{0}'")
    public boolean isAriaLabel(String ariaLabel) {
        return core().attr("aria-label").equalsIgnoreCase(ariaLabel);
    }
    @JDIAction("'{name}'is disabled")
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @JDIAction("'{name}'is required")
    public boolean isRequired() {
        return core().hasAttribute("required");
    }

//    @JDIAction(value = "Get '{name}' color")
//    public AngularColors color() {
//        return AngularColors.fromColor(core().getAttribute("color"));
//        return AngularColors.fromColor((getRadioButtonByTagValue(value)).getAttribute("color"));
//    }

    @Override
    public RadioButtonsAssert is() {
        return new RadioButtonsAssert().set(this);
    }

    private WebList getRadioButtons() {
        return this.finds(".mat-mdc-radio-button");
    }
}

