package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Link;
import com.epam.jdi.light.material.elements.utils.enums.TypographyComponentStyle;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Link}
 */
public class LinkAssert extends UIAssert<LinkAssert, Link> implements ITextAssert<LinkAssert> {
    /**
     * Checks that link is underlined.
     *
     * @return this {@link LinkAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is underlined", isAssert = true)
    public LinkAssert underlined() {
        jdiAssert(element().isUnderlined(), Matchers.is(true), "Link is not underlined");
        return this;
    }

    /**
     * Checks that link is not underlined.
     *
     * @return this {@link LinkAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is not underlined", isAssert = true)
    public LinkAssert notUnderlined() {
        jdiAssert(element().isNotUnderlined(), Matchers.is(true), "Link is underlined");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    public LinkAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    /**
     * Checks that link has given style
     *
     * @param style given style
     * @return this {@link LinkAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' has '{0}' style", isAssert = true)
    public LinkAssert style(TypographyComponentStyle style) {
        jdiAssert(element().getStyle(), Matchers.is(style));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public LinkAssert hasIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Link has no Icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no icon", isAssert = true)
    public LinkAssert hasNoIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "Link has Icon");
        return this;
    }
}
