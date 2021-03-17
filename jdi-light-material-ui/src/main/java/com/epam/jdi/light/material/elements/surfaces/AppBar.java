package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIAppBar;
import com.epam.jdi.light.material.asserts.surfaces.AppBarAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class AppBar extends UIBaseElement<AppBarAssert> implements ISetup {

    String buttons;
    String appTitle;

    private UIElement getButtonByIndex(int index) {
        return this.finds(buttons).get(index);
    }

    @JDIAction("Is '{name}' enabled by index")
    public boolean isButtonEnabled(int index) {
        return getButtonByIndex(index).isEnabled();
    }

    @JDIAction("Click on '{name}' by index")
    public void clickOnButtonByIndex(int index) {
        getButtonByIndex(index).click();
    }

    private String getTitle() {
        return this.find(appTitle).getText();
    }

    @JDIAction("Verify '{name}'")
    public boolean verifyTitle(String expectedTitle) {
        return getTitle().equals(expectedTitle);
    }

    @Override
    public AppBarAssert is() {
        return new AppBarAssert().set(this);
    }

    @Override
    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDIAppBar.class, AppBar.class))
            return;
        JDIAppBar j = field.getAnnotation(JDIAppBar.class);

        buttons = j.buttons();
        appTitle = j.appTitle();
    }
}
