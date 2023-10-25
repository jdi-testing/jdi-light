package com.epam.jdi.light.angular.elements.complex;

import com.epam.jdi.light.angular.asserts.RadioButtonsAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import org.openqa.selenium.By;

/**
 * To see an example of RadioButtons web element please visit https://material.angular.io/components/radio/overview.
 */

public class RadioGroup extends UIListBase<UISelectAssert<RadioButtonsAssert, RadioGroup>> {

    @JDIAction("Click '{name}' button with tag value '{0}'")
    public void click(String value) {
        getRadioButtonByTagValue(value).find(By.cssSelector(".mdc-form-field")).click();
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

    public AngularColors color(String value) {
        UIElement element = getRadioButtonByTagValue(value);
        if (element.hasClass("mat-primary")) {
            return AngularColors.PRIMARY;
        }
        if (element.hasClass("mat-warn")) {
            return AngularColors.WARN;
        } else
            return AngularColors.ACCENT;
    }

    @JDIAction("'{name}'label is in before position")
    public boolean isGroupBeforePosition() {
        return core().attr("labelposition").equalsIgnoreCase("before");
    }

    @JDIAction("'{name}' element label is in before position")
    public boolean isGroupElementBeforePosition(String value) {
        return getRadioButtonByTagValue(value).attr("labelposition").equalsIgnoreCase("before");
    }

    @JDIAction("'{name}'is disabled")
    public boolean isDisabled() {
        return core().hasAttribute("disabled");
    }

    @JDIAction("'{name}'is required")
    public boolean isRequired() {
        return core().hasAttribute("required");
    }

    @Override
    public RadioButtonsAssert is() {
        return new RadioButtonsAssert().set(this);
    }

    private WebList getRadioButtons() {
        return this.finds(".mat-mdc-radio-button");
    }
}

