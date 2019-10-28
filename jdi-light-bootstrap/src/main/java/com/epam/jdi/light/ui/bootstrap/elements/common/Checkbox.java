package com.epam.jdi.light.ui.bootstrap.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.ui.bootstrap.asserts.CheckboxAssert;
import org.openqa.selenium.By;

public class Checkbox extends UIBaseElement<CheckboxAssert>
    implements HasLabel, SetValue, HasClick, HasCheck {
    // region Actions
    public void check(String value) {
        if ("true".equalsIgnoreCase(value) || ("1").equals(value))
            check();
        else uncheck();
    }


    //private  UIElement inputField=uiElement.find(By.tagName("input"));

    @JDIAction("Check '{name}'")
    public void check() {
        uiElement.check(); //only break when div is too long
        //uiElement.find(By.tagName("input")).check(); break for custom cannot access input field
    }
    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if(isSelected()) {
            uiElement.click();//only break when div is too long
            //uiElement.find(By.tagName("input")).click(); //break for custom cannot access input field
        }
    }

    @JDIAction("Check that '{name}' is selected")
    public boolean isSelected() {
      return uiElement.find(By.tagName("input")).isSelected();
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
