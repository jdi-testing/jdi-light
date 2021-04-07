package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.annotations.JDICheckbox;
import com.epam.jdi.light.material.asserts.inputs.CheckboxAssert;
import org.openqa.selenium.By;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasClick, HasCheck,
    HasAssert<CheckboxAssert>{

    public UIElement getCheckBoxes() {
        return this.core();
    }

    @JDIAction("Is '{name}' checked")
    public boolean isChecked() {
        return getCheckBoxes().hasClass("Mui-checked");
    }

    @JDIAction("'{name}' has {className} class")
    public boolean hasClass(String className) {
        return this.getCheckBoxes().hasClass(className);
    }

    @JDIAction("Is '{name}' not selected")
    public boolean isNotChecked() {
        return !isChecked();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isNotChecked()) {
            getCheckBoxes().click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if(isChecked()) {
            getCheckBoxes().click();
        }
    }

    @JDIAction("Is '{name}' disabled")
    public boolean isDisabled() {
        return getCheckBoxes().hasClass("Mui-disabled");
    }

    @JDIAction("Is '{name}' enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
