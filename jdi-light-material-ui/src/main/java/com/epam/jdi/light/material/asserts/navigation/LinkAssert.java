package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.asserts.displaydata.TypographyAssert;
import com.epam.jdi.light.material.asserts.generic.IColorAssert;
import com.epam.jdi.light.material.elements.navigation.Link;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

/**
 * Assertions for {@link Link}
 */
public class LinkAssert extends TypographyAssert implements IColorAssert<LinkAssert> {

    private static final String IS_UNDERLINED = "is underlined";
    private static final String IS_NOT_UNDERLINED = "is not underlined";

    @Override
    public Link element() {
        return (Link) super.element();
    }

    /**
     * Checks that link is underlined.
     *
     * @return this {@link LinkAssert} instance
     */
    @JDIAction("Assert that '{name}' is underlined")
    public LinkAssert underlined() {
        jdiAssert(element().isUnderlined() ? IS_UNDERLINED : IS_NOT_UNDERLINED,
                Matchers.is(IS_UNDERLINED));
        return this;
    }

    /**
     * Checks that link is not underlined.
     *
     * @return this {@link LinkAssert} instance
     */
    @JDIAction("Assert that '{name}' is not underlined")
    public LinkAssert notUnderlined() {
        jdiAssert(element().isNotUnderlined() ? IS_NOT_UNDERLINED : IS_UNDERLINED,
                Matchers.is(IS_NOT_UNDERLINED));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' color {0}")
    public LinkAssert color(Matcher<String> condition) {
        jdiAssert(element().color(), condition);
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public LinkAssert text(Matcher<String> condition) {
        jdiAssert(element().text(), condition);
        return this;
    }

    @Override
    public LinkAssert and() {
        return this;
    }
}
