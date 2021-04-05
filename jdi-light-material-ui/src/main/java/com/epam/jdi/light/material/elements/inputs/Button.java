package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIButtons;
import com.epam.jdi.light.material.asserts.inputs.ButtonAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Button extends UIBaseElement<ButtonAssert> implements ISetup {
    String containedButton;
    String textButton;
    String iconLabelButton;
    String iconLabelIcon;
    String iconLabelSpanIcon;
    String iconButton;
    String customizedButton;
    String complexButton;

    Button() {}

    @JDIAction("Get contained button by index")
    public Button getContainedButtonByIndex(int index) {
        return new Button(core().finds(containedButton).get(index));
    }

    @JDIAction("Get text button by index")
    public Button getTextButtonByIndex(int index) {
        return new Button(core().finds(textButton).get(index));
    }

    @JDIAction("Get icon label button by index")
    public Button getIconLabelButtonByIndex(int index) {
        return new Button(core().finds(iconLabelButton).get(index));
    }

    @JDIAction("Get icon label icon by index")
    public Button getIconLabelIconByIndex(int index) {
        return new Button(core().finds(iconLabelIcon).get(index));
    }

    @JDIAction("Get icon label span icon")
    public Button getIconLabelSpanIcon() {
        return new Button(core().find(iconLabelSpanIcon));
    }

    @JDIAction("Get icon button by index")
    public Button getIconButtonByIndex(int index) {
        return new Button(core().finds(iconButton).get(index));
    }

    @JDIAction("Get customized button by index")
    public Button getCustomizedButtonByIndex(int index) {
        return new Button(core().finds(customizedButton).get(index));
    }

    @JDIAction("Get complex button by index")
    public Button getComplexButtonByIndex(int index) {
        return new Button(core().finds(complexButton).get(index));
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
        if (!fieldHasAnnotation(field, JDIButtons.class, Button.class))
            return;
        JDIButtons buttons = field.getAnnotation(JDIButtons.class);
        containedButton = buttons.containedButton();
        textButton = buttons.textButton();
        iconLabelButton = buttons.iconLabelButton();
        iconLabelIcon = buttons.iconLabelIcon();
        iconLabelSpanIcon = buttons.iconLabelSpanIcon();
        iconButton = buttons.iconButton();
        customizedButton = buttons.customizedButton();
        complexButton = buttons.complexButton();
    }
}
