package com.epam.jdi.light.material.elements.feedback;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.material.annotations.JDISnackbar;
import com.epam.jdi.light.material.asserts.feedback.SnackbarAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class Snackbar extends UIBaseElement<SnackbarAssert> implements ISetup {

    String root;
    String message;
    String actions;

    @JDIAction("Get message content of '{name}'")
    public String getMessageContent() {
        return core().find(message).getText();
    }

    @JDIAction("Click action element of '{name}' by index '{0}'")
    public void clickActionByIndex(int index) {
        getActionByIndex(index).click();
        core().waitFor(1).element().isNotVisible();
    }

    @JDIAction("Get action element of '{name}'")
    public UIElement getActionByIndex(int index) {
        return getActions().get(index);
    }

    @JDIAction("Get action elements web list of '{name}'")
    public WebList getActions() {
        return core().finds(actions);
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
        actions = j.actions();
    }

}
