package com.epam.jdi.light.angular.elements.complex.radiobuttons;

import com.epam.jdi.light.angular.asserts.radiobuttons.RadioButtonAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public class RadioButton extends UIBaseElement<RadioButtonAssert> implements HasLabel {
    private static final String INPUT_SELECTION_CONTROL = ".//input[@type='radio']";
    private static final String LABEL_LOCATOR = "//label";
    private static final String FORM_FIELD_LOCATOR = ".mdc-form-field";
    private static final String DISPLAYED_POINT_LOCATOR = ".mdc-radio__outer-circle";



    @Override
    public RadioButtonAssert is() {
        return new RadioButtonAssert().set(this);
    }

    @Override
    public RadioButtonAssert has() {
        return is();
    }

    @Override
    @JDIAction("Get if '{name}' is disabled")
    public boolean isDisabled() {
        return core().find(INPUT_SELECTION_CONTROL).hasAttribute("disabled");
    }

    @Override
    @JDIAction("Get if '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Get '{name}' input control color")
    public String color() {
        return core().find(DISPLAYED_POINT_LOCATOR).getCssValue("border-bottom-color");
    }

    @JDIAction("Get radio-button {name} value")
    public String value() {
        return core().find("input").attr("value");
    }

    @JDIAction("'{name}' element label is in before position")
    public boolean hasLabelBeforePosition() {
        return core().find(FORM_FIELD_LOCATOR).hasClass("mdc-form-field--align-end");
    }

    @JDIAction("Click '{name}' radio button")
    public void click() {
        core().find(FORM_FIELD_LOCATOR).click();
    }

    @Override
    public Label label() {
        return new Label().setCore(Label.class, core().find(LABEL_LOCATOR));
    }

    @JDIAction("'{name}' is checked")
    public boolean isChecked() {
        return core().attr("class").contains("mat-mdc-radio-checked");
    }
}
