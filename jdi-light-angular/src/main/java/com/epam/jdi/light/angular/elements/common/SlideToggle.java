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

    private static final String BUTTON_LOCATOR = "button[role=switch]";

    public boolean isSelected() {
        return core().hasClass("mat-checked") || core().hasClass("mat-mdc-slide-toggle-checked");
    }

    @Override
    public boolean isEnabled() {
        return !isDisabled();
    }

    @Override
    public boolean isDisabled() {
        UIElement e = core().find("//button");
        return e.hasAttribute("disabled");
    }

    @JDIAction("Get if '{name}' element label is in before position")
    public boolean hasLabelBeforePosition() {
        return core().find(FORM_FIELD_LOCATOR).hasClass("mdc-form-field--align-end");
    }

    @JDIAction("Get label's text of slide toggle")
    public String getLabelsSlideToggleText() {
        return core().find(FORM_FIELD_LOCATOR).find("//label").getText();
    }

    public void check() {
        if (!isSelected()) {
            core().find(BUTTON_LOCATOR).click();
        }
    }

    public void uncheck() {
        if (isSelected()) {
            core().find(BUTTON_LOCATOR).click();
        }
    }

    @Override
    public SlideToggleAssert is() {
        return new SlideToggleAssert().set(this);
    }
}
