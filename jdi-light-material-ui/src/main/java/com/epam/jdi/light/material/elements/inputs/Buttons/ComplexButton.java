package com.epam.jdi.light.material.elements.inputs.Buttons;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIComplexButtons;
import com.epam.jdi.light.material.asserts.inputs.Buttons.ComplexButtonAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class ComplexButton extends UIBaseElement<ComplexButtonAssert> implements ISetup {
    ComplexButton() {}

    String breakfastButton;
    String burgersButton;
    String cameraButton;



    @JDIAction("Get breakfast button")
    public ComplexButton getBreakfastButton() {
        return new ComplexButton(core().find(breakfastButton));
    }

    @JDIAction("Get burgers icon")
    public ComplexButton getBurgersButton() {
        return new ComplexButton(core().find(burgersButton));
    }

    @JDIAction("Get camera button")
    public ComplexButton getCameraButton() {
        return new ComplexButton(core().find(cameraButton));
    }

    public ComplexButton(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public ComplexButtonAssert is() {
        return new ComplexButtonAssert().set(this);
    }

    @Override
    public ComplexButtonAssert has() {
        return this.is();
    }

    @JDIAction("Check if '{name}' is enabled")
    public boolean isEnabled() {
        return !isDisabled();
    }

    @JDIAction("Check if '{name}' is disabled")
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }


    @JDIAction("Check text in '{name}'")
    public String getText() {
        return core().getText();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIComplexButtons.class, ComplexButton.class))
            return;
        JDIComplexButtons complexButtons = field.getAnnotation(JDIComplexButtons.class);
        breakfastButton = complexButtons.breakfastButton();
        burgersButton = complexButtons.burgersButton();
        cameraButton = complexButtons.cameraButton();
    }
}
