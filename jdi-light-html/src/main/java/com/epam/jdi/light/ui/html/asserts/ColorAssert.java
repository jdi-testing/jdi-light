package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.ColorPicker;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public class ColorAssert extends UIAssert<ColorAssert, ColorPicker> {
    @JDIAction("Assert that '{name}' color is {0}")
    public ColorAssert color(String color) {
        jdiAssert(uiElement.color(), is(color));
        return this;
    }
}