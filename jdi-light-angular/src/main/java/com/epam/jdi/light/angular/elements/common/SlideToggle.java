package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.SlideToggleAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

/**
 * To see an example of SlideToggle web element please visit https://material.angular
 * .io/components/slide-toggle/overview.
 */

public class SlideToggle extends UIBaseElement<SlideToggleAssert> {

    private static final String FORM_FIELD_LOCATOR = ".mdc-form-field";

    public boolean isSelected() {
        return hasClass("mat-checked") || hasClass("mat-mdc-slide-toggle-checked");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public boolean isDisabled() {
        UIElement e = find("//button");
        return e.hasAttribute("disabled");
    }

    @JDIAction("'{name}' element label is in before position")
    public boolean hasLabelBeforePosition() {
        return core().find(FORM_FIELD_LOCATOR).hasClass("mdc-form-field--align-end");
    }

    public void check() {
        if (!isSelected()) {
            core().find(FORM_FIELD_LOCATOR).click();
        }
    }

    public void uncheck() {
        if (isSelected()) {
            core().find(FORM_FIELD_LOCATOR).click();
        }
    }

    @Override
    public SlideToggleAssert is() {
        return new SlideToggleAssert().set(this);
    }
}
