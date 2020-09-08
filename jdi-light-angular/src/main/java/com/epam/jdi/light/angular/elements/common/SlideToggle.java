package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.ui.html.elements.common.Checkbox;

/**
 * To see an example of SlideToggle web element please visit https://material.angular.io/components/slide-toggle/overview.
 */

public class SlideToggle extends Checkbox {

    @Override
    public boolean isSelected() {
        return super.isSelected() || hasClass("mat-checked");
    }

    @Override
    public boolean isEnabled() {
        if (hasClass("mat-disabled")) {
            return false;
        }
        return super.isEnabled();
    }

    @Override
    public boolean isDisabled() {
        return !isEnabled();
    }
}
