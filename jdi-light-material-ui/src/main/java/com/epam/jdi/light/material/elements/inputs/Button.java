package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIContainedButtons;
import com.epam.jdi.light.material.asserts.inputs.ButtonAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Button extends UIBaseElement<ButtonAssert> implements ISetup {
    Button() {}

    String defaultContainedButton;
    String primaryContainedButton;
    String secondaryContainedButton;
    String disabledContainedButton;
    String linkContainedButton;


    @JDIAction("Get default button")
    public Button getDefaultContainedButton() {
        return new Button(core().find(defaultContainedButton));
    }

    @JDIAction("Get primary button")
    public Button getPrimaryContainedButton() {
        return new Button(core().find(primaryContainedButton));
    }

    @JDIAction("Get secondary button")
    public Button getSecondaryContainedButton() {
        return new Button(core().find(secondaryContainedButton));
    }

    @JDIAction("Get disabled button")
    public Button getDisabledContainedButton() {
        return new Button(core().find(disabledContainedButton));
    }

    @JDIAction("Get link button")
    public Button getLinkContainedButton() {
        return new Button(core().find(linkContainedButton));
    }

    public Button(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public ButtonAssert is() {
        return new ButtonAssert().set(this);
    }

    @Override
    public ButtonAssert has() {
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
        if (!fieldHasAnnotation(field, JDIContainedButtons.class, Button.class))
            return;
        JDIContainedButtons containedButtons = field.getAnnotation(JDIContainedButtons.class);
        defaultContainedButton = containedButtons.defaultButton();
        primaryContainedButton = containedButtons.primaryButton();
        secondaryContainedButton = containedButtons.secondaryButton();
        disabledContainedButton = containedButtons.disabledButton();
        linkContainedButton = containedButtons.linkButton();
    }
}
