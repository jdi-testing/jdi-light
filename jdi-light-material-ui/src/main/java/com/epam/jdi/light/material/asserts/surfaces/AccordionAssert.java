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
     * @return {@link AccordionAssert}
     */
    @JDIAction("Assert that '{name}' is expanded")
    public AccordionAssert expanded() {
        jdiAssert(element().isExpanded() ? "expanded" : "collapsed", Matchers.is("expanded"));
        return this;
    }

    /**
     * Checks that accordion is collapsed.
     *
     * @return {@link AccordionAssert}
     */
    @JDIAction("Assert that '{name}' is collapsed")
    public AccordionAssert collapsed() {
        jdiAssert(element().isCollapsed() ? "collapsed" : "expanded", Matchers.is("collapsed"));
        return this;
    }
}
