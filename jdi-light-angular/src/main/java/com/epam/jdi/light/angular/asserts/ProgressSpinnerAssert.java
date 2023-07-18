package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.common.ProgressSpinner;
import com.epam.jdi.light.angular.elements.enums.ProgressSpinnerModes;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressSpinnerAssert extends UIAssert<ProgressSpinnerAssert, ProgressSpinner> {

    @JDIAction("Assert that '{name}' has color '{0}'")
    public ProgressSpinnerAssert color(String color) {
        String actualColor = element().color();
        jdiAssert(actualColor, Matchers.equalTo(color), actualColor + " is not equal to " + color);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has mode value '{0}'")
    public ProgressSpinnerAssert mode(ProgressSpinnerModes mode) {
        String actualMode = element().mode();
        jdiAssert(actualMode, Matchers.equalTo(mode.getMode()), actualMode + " is not equal to " + mode.getMode());
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has diameter '{0}'")
    public ProgressSpinnerAssert diameter(String diameter) {
        String height = element().height();
        String width = element().width();
        jdiAssert(height, Matchers.equalTo(diameter), height + " height is not equal to " + diameter);
        jdiAssert(width, Matchers.equalTo(diameter), width + " width is not equal to " + diameter);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has stroke width '{0}'")
    public ProgressSpinnerAssert strokeWidth(String strokeWidth) {
        String actualStrokeWidth = element().strokeWidth();
        jdiAssert(actualStrokeWidth, Matchers.equalTo(strokeWidth), actualStrokeWidth + " is not equal to " + actualStrokeWidth);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has value '{0}'")
    public ProgressSpinnerAssert value(int value) {
        int actualValue = element().value();
        jdiAssert(actualValue, Matchers.equalTo(value), actualValue + " is not equal to " + value);
        return this;
    }
}
