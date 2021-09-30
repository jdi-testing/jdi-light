package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ExpansionPanelAssert extends UIAssert<ExpansionPanelAssert, ExpansionPanel> {

    @JDIAction("Assert that {name} is expanded")
    public ExpansionPanelAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is closed")
    public ExpansionPanelAssert closed() {
        jdiAssert(element().isExpanded(), Matchers.is(false));
        return this;
    }
}
