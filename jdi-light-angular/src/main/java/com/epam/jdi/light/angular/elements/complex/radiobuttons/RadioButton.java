package com.epam.jdi.light.angular.elements.complex.radiobuttons;

import com.epam.jdi.light.angular.asserts.radiobuttons.RadioButtonAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;

public class RadioButton extends UIBaseElement<RadioButtonAssert> implements HasLabel {
    private static final String INPUT_SELECTION_CONTROL = ".//input[@type='radio']";
    private static final String LABEL_LOCATOR = "//label";
    private static final String FORM_FIELD_LOCATOR = ".mdc-form-field";

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
        if (isChecked()) {
            if (hasClass("mat-primary")) {
                return AngularColors.PRIMARY;
            }
            if (hasClass("mat-warn")) {
                return AngularColors.WARN;
            } else
                return AngularColors.ACCENT;
        }
        return AngularColors.UNDEFINED;
    }

    @JDIAction("'{name}' element label is in before position")
    public boolean hasBeforePosition() {
        return core().find(FORM_FIELD_LOCATOR).hasClass("mdc-form-field--align-end");
    }

    @JDIAction("Click '{name}' radio button")
    public void click() {
        find(FORM_FIELD_LOCATOR).click();
    }

    @Override
    public Label label() {
        return new Label().setCore(Label.class, find(LABEL_LOCATOR));
    }

    @JDIAction("'{name}' is checked")
    public boolean isChecked() {
        return attr("class").contains("mat-mdc-radio-checked");
    }
}
