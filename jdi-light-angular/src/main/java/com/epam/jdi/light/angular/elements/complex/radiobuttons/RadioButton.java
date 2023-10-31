package com.epam.jdi.light.angular.elements.complex.radiobuttons;

import com.epam.jdi.light.angular.asserts.radiobuttons.RadioButtonAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import org.openqa.selenium.By;

public class RadioButton extends UIBaseElement<RadioButtonAssert> implements HasLabel {
    private static final String INPUT_SELECTION_CONTROL = "//input[@type='radio']";

    @Override
    public RadioButtonAssert is() {
        return new RadioButtonAssert().set(this);
    }

    @Override
    public RadioButtonAssert has() { return is(); }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return find(INPUT_SELECTION_CONTROL).hasAttribute("disabled");
    }

    @JDIAction("Get '{name}' input control color")
    public AngularColors color() {
        if (hasClass("mat-primary")) {
            return AngularColors.PRIMARY;
        }
        if (hasClass("mat-warn")) {
            return AngularColors.WARN;
        } else
            return AngularColors.ACCENT;
    }

    @JDIAction("'{name}' element label is in before position")
    public boolean isRadioButtonBeforePosition() {
        return attr("labelposition").equalsIgnoreCase("before");
    }

    @JDIAction("Click '{name}' radio button")
    public void click() {
        find(By.cssSelector(".mdc-form-field")).click();
    }
}
