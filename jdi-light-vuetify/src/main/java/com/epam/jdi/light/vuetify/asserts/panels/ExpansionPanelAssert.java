package com.epam.jdi.light.vuetify.asserts.panels;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ExpansionPanelAssert extends UIAssert<ExpansionPanelAssert, ExpansionPanel> implements
        ColorAssert<ExpansionPanelAssert, ExpansionPanel> {

    @JDIAction("Assert that '{name}' is expanded")
    public ExpansionPanelAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Element is closed");
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public ExpansionPanelAssert closed() {
        jdiAssert(element().isExpanded(), Matchers.is(false), "Element is expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' has content font color '{0}'")
    public ExpansionPanelAssert contentColor(String color) {
        String actualContentColor = element().contentColor();
        jdiAssert(actualContentColor, Matchers.equalTo(color), String.format("Actual element's content font color " +
                "'%s' is not equal to expected '%s'", actualContentColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' has content background color '{0}'")
    public ExpansionPanelAssert contentBackgroundColor(String color) {
        String contentBackgroundColor = element().contentBackgroundColor();
        jdiAssert(contentBackgroundColor, Matchers.equalTo(color), String.format("Actual element's content " +
                "background color '%s' is not equal to expected '%s'", contentBackgroundColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' has icon disable rotate")
    public ExpansionPanelAssert iconDisableRotate() {
        jdiAssert(element().hasIconDisableRotate(), Matchers.is(true), "Element's icon rotation is not " +
                "disabled");
        return this;
    }

    @JDIAction("Assert that '{name}' icon rotation is not disabled")
    public ExpansionPanelAssert notIconDisableRotate() {
        jdiAssert(element().hasIconDisableRotate(), Matchers.is(false), "Element's icon rotation is " +
                "disabled");
        return this;
    }
}
