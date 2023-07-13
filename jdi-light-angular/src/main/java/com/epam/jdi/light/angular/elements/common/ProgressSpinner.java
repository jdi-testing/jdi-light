package com.epam.jdi.light.angular.elements.common;

import com.epam.jdi.light.angular.asserts.ProgressSpinnerAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;

import static com.epam.jdi.light.angular.elements.enums.ProgressSpinnerModes.DETERMINATE;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

/**
 * To see an example of ProgressSpinner web element please visit https://material.angular.io/components/progress-spinner/overview.
 */

public class ProgressSpinner extends UIBaseElement<ProgressSpinnerAssert> {

    @JDIAction("Get '{name}' circle")
    public UIElement circle() {
        return this.find("circle");
    }

    @JDIAction("Get '{name}' color")
    public String color() {
        return circle().css("stroke");
    }

    @JDIAction(value = "Get '{name}' mode value")
    public String mode() {
        return core().attr("mode");
    }

    @JDIAction(value = "Get '{name}' width")
    public String width() {
        return css("width");
    }

    @JDIAction(value = "Get '{name}' height")
    public String height() {
        return css("height");
    }

    @JDIAction(value = "Get '{name}' stroke width")
    public String strokeWidth() {
        return circle().css("stroke-width");
    }

    @JDIAction("Get '{name}' progress value")
    public int value() {
        if (mode().equals(DETERMINATE.getMode())) {
            return getInt(core().attr("aria-valuenow"));
        }
        throw new IllegalArgumentException("There is no 'value' attribute in this mode");
    }

    @Override
    public ProgressSpinnerAssert is() {
        return new ProgressSpinnerAssert().set(this);
    }
}
