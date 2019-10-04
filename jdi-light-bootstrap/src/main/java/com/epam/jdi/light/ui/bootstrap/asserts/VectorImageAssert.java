package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Image;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class VectorImageAssert extends UIAssert<VectorImageAssert, Image> {

    @JDIAction("Assert that '{name}' height {0}")
    public VectorImageAssert height(Matcher<Integer> condition) {
        jdiAssert(element.height(), condition);
        return this;
    }

    public VectorImageAssert height(int height) { return height(is(height)); }

    @JDIAction("Assert that '{name}' width {0}")
    public VectorImageAssert width(Matcher<Integer> condition) {
        jdiAssert(element.width(), condition);
        return this;
    }
    public VectorImageAssert width(int width) { return width(is(width)); }
}