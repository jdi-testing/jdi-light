package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDIAppBar;
import com.epam.jdi.light.material.asserts.surfaces.AppBarAssert;
import com.epam.jdi.light.material.elements.inputs.Button;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;

public class AppBar extends UIBaseElement<AppBarAssert> implements ISetup {

    String root;
    String buttons;
    String barTitle;

    @JDIAction("Get '{name}'")
    public String getButtonByIndexText(int index) {
        return this.finds(buttons).get(index).getText();
    }

    @JDIAction("Get '{name}'")
    public Button getButtonByIndex(int index) {
        return new Button(this.find(root).finds(buttons).get(index));
    }

    @JDIAction("Is '{name}' get text by index")
    public boolean verifyTitleButtonTextByIndex(int index, String expectedTitle) {
        return getButtonByIndexText(index).equals(expectedTitle);
    }

    @JDIAction("Is '{name}' enabled by index")
    public boolean isButtonEnabled(int index) {
        return getButtonByIndex(index).isEnabled();
    }

    @JDIAction("Click on '{name}' by index")
    public void clickOnButtonByIndex(int index) {
        getButtonByIndex(index).click();
    }

    @JDIAction("Get '{name}'")
    public String getTitle() {
        return this.find(barTitle).getText();
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

        root = j.root();
        buttons = j.buttons();
        barTitle = j.barTitle();
    }
}
