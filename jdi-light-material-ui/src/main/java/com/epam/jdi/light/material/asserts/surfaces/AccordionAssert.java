package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Accordion;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Accordion}
 */
public class AccordionAssert extends UIAssert<AccordionAssert, Accordion> {

    /**
     * Checks that accordion is expanded.
     *
     * @return this {@link AccordionAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public AccordionAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Accordion is not expanded");
        return this;
    }

    /**
     * Checks that accordion is collapsed.
     *
     * @return this {@link AccordionAssert} instance
     */
    @JDIAction(value = "Assert that '{name}' is collapsed", isAssert = true)
    public AccordionAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true), "Accordion is not collapsed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has first header", isAssert = true)
    public AccordionAssert hasFirstHeader() {
        jdiAssert(element().firstHeader.isExist(), Matchers.is(true), "Accordion has no first header");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has second header", isAssert = true)
    public AccordionAssert hasSecondHeader() {
        jdiAssert(element().secondHeader.isExist(), Matchers.is(true), "Accordion has no second header");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no first header", isAssert = true)
    public AccordionAssert hasNoFirstHeader() {
        jdiAssert(element().firstHeader.isNotExist(), Matchers.is(true), "Accordion has first header");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no second header", isAssert = true)
    public AccordionAssert hasNoSecondHeader() {
        jdiAssert(element().secondHeader.isNotExist(), Matchers.is(true), "Accordion has second header");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} in details", isAssert = true)
    public AccordionAssert details(String expText) {
        jdiAssert(element().details.getText(), Matchers.is(expText));
        return this;
    }


    @JDIAction(value = "Assert that '{name}' has {0} in details", isAssert = true)
    public AccordionAssert details(Matcher<String> expMatcher) {
        jdiAssert(element().details.getText(), expMatcher);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} in first Header", isAssert = true)
    public AccordionAssert firstHeader(String expText) {
        jdiAssert(element().firstHeader.getText(), Matchers.is(expText));
        return this;
    }


    @JDIAction(value = "Assert that '{name}' has {0} in first Header", isAssert = true)
    public AccordionAssert firstHeader(Matcher<String> expMatcher) {
        jdiAssert(element().firstHeader.getText(), expMatcher);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} in second Header", isAssert = true)
    public AccordionAssert secondHeader(String expText) {
        jdiAssert(element().secondHeader.getText(), Matchers.is(expText));
        return this;
    }


    @JDIAction(value = "Assert that '{name}' has {0} in second Header", isAssert = true)
    public AccordionAssert secondHeader(Matcher<String> expMatcher) {
        jdiAssert(element().secondHeader.getText(), expMatcher);
        return this;
    }
}
