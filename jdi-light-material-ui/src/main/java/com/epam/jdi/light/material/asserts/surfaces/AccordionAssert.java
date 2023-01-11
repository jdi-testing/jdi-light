package com.epam.jdi.light.material.asserts.surfaces;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Accordion;
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
    @JDIAction("Assert that '{name}' is expanded")
    public AccordionAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Accordion is not expanded");
        return this;
    }

    /**
     * Checks that accordion is collapsed.
     *
     * @return this {@link AccordionAssert} instance
     */
    @JDIAction("Assert that '{name}' is collapsed")
    public AccordionAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true), "Accordion is not collapsed");
        return this;
    }
}
