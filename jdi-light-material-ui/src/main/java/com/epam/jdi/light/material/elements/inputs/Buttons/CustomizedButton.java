package com.epam.jdi.light.material.elements.inputs.Buttons;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDICustomizedButtons;
import com.epam.jdi.light.material.asserts.inputs.Buttons.CustomizedButtonAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class CustomizedButton extends UIBaseElement<CustomizedButtonAssert> implements ISetup {
    CustomizedButton() {}

    String customCSSButton;
    String themeProviderButton;
    String bootstrapButton;



    @JDIAction("Get custom css button")
    public CustomizedButton getCustomCSSButton() {
        return new CustomizedButton(core().find(customCSSButton));
    }

    @JDIAction("Get theme provider icon")
    public CustomizedButton getThemeProviderButton() {
        return new CustomizedButton(core().find(themeProviderButton));
    }

    @JDIAction("Get bootstrap button")
    public CustomizedButton getBootstrapButton() {
        return new CustomizedButton(core().find(bootstrapButton));
    }

    public CustomizedButton(UIElement element) {
        core().setCore(element);
    }

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @Override
    public CustomizedButtonAssert is() {
        return new CustomizedButtonAssert().set(this);
    }

    @Override
    public CustomizedButtonAssert has() {
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
        if (!fieldHasAnnotation(field, JDICustomizedButtons.class, CustomizedButton.class))
            return;
        JDICustomizedButtons customizedButtons = field.getAnnotation(JDICustomizedButtons.class);
        customCSSButton = customizedButtons.customCSSButton();
        themeProviderButton = customizedButtons.themeProviderButton();
        bootstrapButton = customizedButtons.bootstrapButton();
    }
}
