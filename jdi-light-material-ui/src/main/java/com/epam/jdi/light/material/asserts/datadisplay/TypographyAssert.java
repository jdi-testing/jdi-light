package com.epam.jdi.light.material.asserts.datadisplay;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.datadisplay.Typography;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TypographyAssert extends UIAssert<TypographyAssert, Typography> {

    @JDIAction("Assert that '{name}' text is '{0}'")
    public TypographyAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' style class")
    public TypographyAssert styleClass(String style) {
        jdiAssert(element().hasStyleClass(style), Matchers.is(true));
        return this;
    }
}
