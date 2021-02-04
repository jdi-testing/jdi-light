package com.epam.jdi.light.material.asserts.inputs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.surfaces.Accordion;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class AccordionAssert extends UIAssert<AccordionAssert, Accordion> {

    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public AccordionAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public AccordionAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public AccordionAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public AccordionAssert collapsed() {
        jdiAssert(element().isCollapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is content visible")
    public AccordionAssert contentVisible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().content().isDisplayed());
        jdiAssert(isVisible, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is content invisible")
    public AccordionAssert contentInvisible() {
        boolean isVisible = new Timer(base().getTimeout() * 1000L)
                .wait(() -> !element().content().isDisplayed());
        jdiAssert(isVisible, Matchers.is(true));
        return this;
    }
}
