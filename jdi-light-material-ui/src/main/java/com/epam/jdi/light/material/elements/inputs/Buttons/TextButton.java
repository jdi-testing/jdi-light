package com.epam.jdi.light.material.elements.inputs.Buttons;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDITextButtons;
import com.epam.jdi.light.material.asserts.inputs.Buttons.TextButtonAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class TextButton extends UIBaseElement<TextButtonAssert> implements ISetup {
    TextButton() {}

    String defaultTextButton;
    String primaryTextButton;
    String secondaryTextButton;
    String disabledTextButton;
    String linkTextButton;


    @JDIAction("Get default button")
    public TextButton getDefaultTextButton() {
        return new TextButton(core().find(defaultTextButton));
    }

    @JDIAction("Get primary button")
    public TextButton getPrimaryTextButton() {
        return new TextButton(core().find(primaryTextButton));
    }

    @JDIAction("Get secondary button")
    public TextButton getSecondaryTextButton() {
        return new TextButton(core().find(secondaryTextButton));
    }

    @JDIAction("Get disabled button")
    public TextButton getDisabledTextButton() {
        return new TextButton(core().find(disabledTextButton));
    }

    @JDIAction("Get link button")
    public TextButton getLinkTextButton() {
        return new TextButton(core().find(linkTextButton));
    }

    public TextButton(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public TextButtonAssert is() {
        return new TextButtonAssert().set(this);
    }

    @Override
    public TextButtonAssert has() {
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
        if (!fieldHasAnnotation(field, JDITextButtons.class, TextButton.class))
            return;
        JDITextButtons textButtons = field.getAnnotation(JDITextButtons.class);
        defaultTextButton = textButtons.defaultButton();
        primaryTextButton = textButtons.primaryButton();
        secondaryTextButton = textButtons.secondaryButton();
        disabledTextButton = textButtons.disabledButton();
        linkTextButton = textButtons.linkButton();
    }
}
