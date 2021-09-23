package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ExpansionPanel;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ExpansionPanelAssert extends UIAssert<ExpansionPanelAssert, ExpansionPanel> {

    @JDIAction("Assert that {name} is open")
    public ExpansionPanelAssert open() {
        jdiAssert(element().isOpen(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public ExpansionPanelAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    @Override
    @JDIAction("Assert that {name} is enabled")
    public ExpansionPanelAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @Override
    @JDIAction("Assert that {name} is disabled")
    public ExpansionPanelAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }
}
