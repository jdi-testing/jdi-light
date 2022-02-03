package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.utils.enums.TypographyStyles;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TypographyAssert extends UIAssert<TypographyAssert, Typography>
        implements ITextAssert<TypographyAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public TypographyAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' style")
    public TypographyAssert style(TypographyStyles style) {
        jdiAssert(element().getStyle(), Matchers.is(style));
        return this;
    }
}