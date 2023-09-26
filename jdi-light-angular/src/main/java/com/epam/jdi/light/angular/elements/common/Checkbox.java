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
import org.openqa.selenium.WebElement;

import static com.epam.jdi.light.common.Exceptions.runtimeException;
import static com.epam.jdi.light.driver.WebDriverFactory.getDriver;

/**
 * To see an example of Checkbox web element please visit https://material.angular.io/components/checkbox/overview.
 */

public class Checkbox extends UIBaseElement<CheckboxAssert> implements HasLabel, HasClick, HasCheck, CanBeSelected {
    public static final String ARIA_CHECKED = "aria-checked";

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

    @JDIAction("Is '{name}' selected")
    @Override
    public boolean isSelected() {
        boolean attribute = hasAttribute(ARIA_CHECKED) && attr(ARIA_CHECKED).equals("true");
        return hasClass("mat-mdc-checkbox-checked") || attribute || core().isSelected();
    }

    @JDIAction("Is '{name}' enabled")
    @Override
    public boolean isEnabled() {
        if (hasClass("mdc-checkbox--disabled")) {
            return false;
        } else {
            return super.isEnabled();
        }
    }
    @JDIAction("Is '{name} disabled'")
    @Override
    public boolean isDisabled() {
        return core().hasClass("mdc-checkbox--disabled");
    }

    @JDIAction("Is '{name}' aligned in before position")
    public boolean isAlignedBefore() {
        return core().find(By.cssSelector("#result-checkbox .mdc-form-field")).hasClass("mdc-form-field--align-end");
    }

    @JDIAction("Get '{name}' label")
    @Override
    public Label label() {
        if (core().label().isDisplayed()) {
            return core().label();
        }
        UIElement input = core().find("input[type=checkbox]");
        if (input.label().isDisplayed()) {
            return input.label();
        }
        throw runtimeException("Can't find label for element %s", this);
    }

    @JDIAction("Click on '{name}'")
    @Override
    public void click() {
        if (label().isDisplayed()) {
            label().click();
        } else {
            core().click();
        }
    }

    @JDIAction("Is '{name}' indeterminate")
    public boolean isIndeterminate() {
        return  core().find(By.cssSelector(".mdc-checkbox__native-control:indeterminate~.mdc-checkbox__background"))
                      .isExist();
    }

    @JDIAction("'{name}' has no ripple effect")
    public boolean isNoRippleEffect() {
        return !core().find(By.cssSelector(".mat-ripple-element")).isExist();
    }

    @JDIAction("'{name}' has aria-label '{0}'")
    public boolean hasAriaLabel(String ariaLabel) {
        return input().getAttribute("aria-label").equalsIgnoreCase(ariaLabel);
    }

    private UIElement input() {
        WebElement element = null;
        element = getDriver().findElement(By.xpath("//*[@id='checkbox-aria-label']//input"));
        return new UIElement(element);
    }
    private UIElement required() {
        WebElement element = null;
        element = getDriver().findElement(By.cssSelector("#checkbox-required-option"));
        return new UIElement(element);
    }
    @JDIAction("'{name}' is required")
    public boolean isRequired() {
        return required().attrs().has("required");
    }

    @JDIAction(value = "Get '{name}' color")
    public AngularColors color() {
        return AngularColors.fromColor(core().getAttribute("color"));
    }

    @Override
    public CheckboxAssert is() {
        return new CheckboxAssert().set(this);
    }
}
