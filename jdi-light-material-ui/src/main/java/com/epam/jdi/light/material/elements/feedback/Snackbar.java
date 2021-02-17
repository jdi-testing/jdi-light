package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDISnackbar;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Snackbar extends UIBaseElement<SnackbarAssert> implements ISetup {

    String root;
    String message;
    String action;

    @JDIAction("Get message content of '{name}'")
    public String getMessageContent() {
        return core().find(message).getText();
    }

    @JDIAction("Click action element of '{name}'")
    public void clickAction() {
        core().find(action).click();
        core().waitFor(1).element().isNotVisible();
    }

    @JDIAction("Check if '{name}' is visible")
    public boolean isVisible() {
        return "visible".equalsIgnoreCase(core().find(root).getCssValue("visibility"));
    }

    @JDIAction("Check if '{name}' is exist")
    public boolean isExist() {
        return core().find(root).isExist();
    }

    @Override
    public SnackbarAssert is() {
        return new SnackbarAssert().set(this);
    }

    @Override
    public SnackbarAssert has() {
        return this.is();
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDISnackbar.class, Snackbar.class))
            return;
        JDISnackbar j = field.getAnnotation(JDISnackbar.class);
        root = j.root();
        message = j.message();
        action = j.action();
    }

}
