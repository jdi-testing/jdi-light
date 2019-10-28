package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.bootstrap.asserts.CheckboxAssert;
import org.openqa.selenium.By;

public class Checkbox extends UIBaseElement<CheckboxAssert>
    implements HasLabel, SetValue, HasClick, HasCheck {

    @UI("input")
    private UIElement input;

    // region Actions
    public void check(String value) {
        if ("true".equalsIgnoreCase(value) || ("1").equals(value)) {
            check();
        } else {
            uncheck();
        }
    }

    @JDIAction("Check '{name}'")
    public void check() {
        uiElement.check(); //only break when div is too long
        //uiElement.find(By.tagName("input")).check(); break for custom cannot access input field
        if(!isSelected()) {
            click();
        }
    }
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if(isSelected()) {
            click();
        }

    }

    @JDIAction("Click at '{name}'")
    public void click() {
        if (input.isDisplayed()) {
            input.click();
        } else {
            label().click();
            uiElement.click();//only break when div is too long
            //uiElement.find(By.tagName("input")).click(); //break for custom cannot access input field
        }
    }

    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
      return input.isSelected();
    }

    @Override
    public Label label() {
        return input.label();
    }

    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        check(value);
    }
    public String getValue() {
        return isSelected()+"";
    }
    // endregion

    // region Extend assertions
    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
    // endregion
}
