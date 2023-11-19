package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.CheckboxAssert;
import com.epam.jdi.light.angular.elements.enums.AngularColors;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.CanBeSelected;
import com.epam.jdi.light.elements.interfaces.base.HasCheck;
import com.epam.jdi.light.elements.interfaces.base.HasClick;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import org.openqa.selenium.By;

import static com.epam.jdi.light.common.Exceptions.runtimeException;

/**
 * To see an example of Checkbox web element please visit https://material.angular.io/components/checkbox/overview.
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasLabel, HasClick, HasCheck, CanBeSelected {
    public static final String ARIA_CHECKED = "aria-checked";
    public static final String COLOR_LOCATOR = ".mdc-checkbox__background";

    @JDIAction("Check '{name}'")
    @Override
    public void check() {
        if (!isSelected()) {
            click();
        }
    }

    @JDIAction("Uncheck '{name}'")
    @Override
    public void uncheck() {
        if (isSelected()) {
            click();
        }
    }

    @JDIAction("Get if '{name}' is selected")
    @Override
    public boolean isSelected() {
        boolean attribute = hasAttribute(ARIA_CHECKED) && attr(ARIA_CHECKED).equals("true");
        return hasClass("mat-mdc-checkbox-checked") || attribute || core().isSelected();
    }

    @JDIAction("Get if '{name}' is enabled")
    @Override
    public boolean isEnabled() {
        if (hasClass("mdc-checkbox--disabled")) {
            return false;
        } else {
            return super.isEnabled();
        }
    }
    @JDIAction("Get if '{name}' is disabled'")
    @Override
    public boolean isDisabled() {
        return !isEnabled();
    }

    @JDIAction("Get if '{name}' is text aligned in before position")
    public boolean isAlignedBefore() {
        UIElement element = core().find(By.cssSelector(".mdc-form-field"));
        if (element != null) {
            return element.hasClass("mdc-form-field--align-end");
        } else {
            return false;
        }

    }

    @JDIAction("Get '{name}'s label")
    @Override
    public Label label() {
        UIElement input = core().find("input[type=checkbox]");
        if (input.label().isDisplayed()) {
            return input.label();
        }
        throw runtimeException("Can't find label for element %s", this);
    }

    @JDIAction("Get if '{name}' is indeterminate")
    public boolean isIndeterminate() {
        return  core().find(By.cssSelector(".mdc-checkbox__native-control:indeterminate~.mdc-checkbox__background"))
                      .isExist();
    }

    @JDIAction("Get if '{name}' is required")
    public boolean isRequired() {
        return attrs().has("required");
    }

    /**
     * Get element color.
     * If there is an attribute "color" - get by attribute,
     * if there is no attribute "color" - get by class.
     * @return Angular color
     */
    @JDIAction("Get '{name}'s color")
    public String color() {
        return core().find(COLOR_LOCATOR).getCssValue("border-bottom-color");
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
