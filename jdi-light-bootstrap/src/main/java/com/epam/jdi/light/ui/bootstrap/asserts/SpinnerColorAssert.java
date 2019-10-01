package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.ColorSpinner;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class SpinnerColorAssert extends UIAssert<SpinnerColorAssert, ColorSpinner> {
    @JDIAction("Assert that '{name}' color {0}")
    public SpinnerColorAssert color(Matcher<String> condition) {
        jdiAssert(element.getColor(), condition);
        return this;
    }
    public SpinnerColorAssert color(String color) {
        return color(is(color));
    }
}
