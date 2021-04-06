package com.epam.jdi.light.material.asserts.utils;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.utils.TextAreaAutoSize;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TextAreaAutoSizeAssert extends UIAssert<TextAreaAutoSizeAssert, TextAreaAutoSize> {
    @JDIAction("Assert that '{name}' has  height: {0}")
    public TextAreaAutoSizeAssert height(Matcher<Integer> condition) {
        jdiAssert(element().getSize().height, condition);
        return this;
    }
}
