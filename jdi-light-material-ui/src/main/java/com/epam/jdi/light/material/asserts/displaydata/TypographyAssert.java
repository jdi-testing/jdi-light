package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TypographyAssert extends UIAssert<TypographyAssert, Typography> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TypographyAssert text(String text) {
        jdiAssert(element().getValue(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' style class")
    public TypographyAssert styleClass(String style) {
        jdiAssert(element().hasStyleClass(style), Matchers.is(true));
        return this;
    }
}
