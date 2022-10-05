package com.epam.jdi.light.vuetify.elements.common;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.vuetify.asserts.CheckboxAssert;

import static com.epam.jdi.light.elements.init.UIFactory.$;

/**
 * To see an example of Checkbox web element please visit https://vuetifyjs.com/en/components/checkboxes/
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasLabel {

    public String input = "div input";
    public UIElement input() {
        return $(input, this);
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }

    @JDIAction("Check that '{name}' is checked")
    public boolean isChecked() {
        return input().attr("aria-checked").equalsIgnoreCase("true");
    }

    @JDIAction("Check that '{name}' is not selected")
    public boolean isNotChecked() {
        return !isChecked();
    }

    @JDIAction("Check '{name}'")
    public void check() {
        if (isNotChecked()) {
            this.core().click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    public void uncheck() {
        if(isChecked()) {
            this.core().click();
        }
    }

    @JDIAction("Check that '{name}' is disabled")
    @Override
    public boolean isDisabled() {
        return core().getAttribute("class").contains("disabled");
    }

    @JDIAction("Check that '{name}' is enabled")
    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public Label label() {
      return core().find("input[type=checkbox]").label();
    }

    @JDIAction("'{name}' has '{className}' class")
    public String labelText() {
        return label().getText();
    }

    @JDIAction("Check that '{name}' is indeterminate")
    public boolean isIndeterminate() {
        return this.core().hasClass("v-input--indeterminate");
    }

    @JDIAction("Check that '{name}' has '{className}' class")
    @Override
    public boolean hasClass(String className) {
        return this.core().hasClass(className);
    }

    @JDIAction("Get {name}'s {0} color")
    public String hasColor() {
        return css("color");
    }

    @JDIAction("Get {name}'s background color")
    public String hasBackgroundColor() {
        return css("background-color");
    }

    @JDIAction("Check that {name} is {0} theme")
    public boolean hasTheme(String theme){
        return this.core().attr("class").contains(theme);
    }
}
