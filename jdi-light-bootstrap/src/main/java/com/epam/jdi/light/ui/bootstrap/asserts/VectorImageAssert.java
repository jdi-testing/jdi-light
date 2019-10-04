package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.VectorImage;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class VectorImageAssert extends BaseImageAssert<VectorImage> {

    @JDIAction("Assert that '{name}' width {0}")
    public VectorImageAssert width(Matcher<String> condition) {
        jdiAssert(element.width(), condition);
        return this;
    }

}