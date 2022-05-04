package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.elements.utils.enums.TypographyStyle;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Typography}.
 */
public class TypographyAssert extends UIAssert<TypographyAssert, Typography>
        implements ITextAssert<TypographyAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public TypographyAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    /**
     * Checks that typography has given style
     *
     * @param style expected style
     * @return this {@link TypographyAssert} instance
     */
    @JDIAction("Assert that '{name}' has '{0}' style")
    public TypographyAssert style(TypographyStyle style) {
        jdiAssert(element().getStyle(), Matchers.is(style));
        return this;
    }
}
