package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Card;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertion for {@link Card}
 */
public class CardAssert extends UIAssert<CardAssert, Card> {

    /**
     * Checks that {@link Card} has title text meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link CardAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' title text {0}", isAssert = true)
    public CardAssert title(Matcher<String> condition) {
        jdiAssert(element().title().getText(), condition);
        return this;
    }

    /**
     * Checks that {@link Card} has sub header text meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link CardAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' sub header text {0}", isAssert = true)
    public CardAssert subHeader(Matcher<String> condition) {
        jdiAssert(element().subHeader().getText(), condition);
        return this;
    }
}
