package com.epam.jdi.light.angular.elements.common;

import static com.epam.jdi.light.driver.get.DriverData.getOs;

import com.epam.jdi.light.angular.asserts.InputAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.driver.get.OsTypes;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import org.openqa.selenium.Keys;

public class Input extends UIBaseElement<InputAssert> {

    @JDIAction("Type text to '{name}' input field")
    public Input typeText(String text) {
        core().sendKeys(text);
        return this;
    }

    @JDIAction("Type text to '{name}' input field")
    public Input typeText(Keys key) {
        core().sendKeys(key);
        return this;
    }

    @JDIAction("Clear '{name}' input field")
    public Input clear() {
        if (getOs().equals(OsTypes.MAC)) {
            core().sendKeys(Keys.chord(Keys.COMMAND, Keys.ARROW_RIGHT));
            core().sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME));
        } else {
            core().sendKeys(Keys.chord(Keys.CONTROL, Keys.END));
            core().sendKeys(Keys.chord(Keys.CONTROL, Keys.SHIFT, Keys.HOME));
        }
        core().sendKeys(Keys.DELETE);
        return this;
    }

    @JDIAction("Clear '{name}' text field and type text to it")
    public Input clearAndTypeText(String text) {
        this.clear();
        this.typeText(text);
        return this;
    }

    @JDIAction("Get {name}' typed text")
    public String getTypedText() {
        return core().getText();
    }

    @Override
    public InputAssert is() {
        return new InputAssert().set(this);
    }
}
