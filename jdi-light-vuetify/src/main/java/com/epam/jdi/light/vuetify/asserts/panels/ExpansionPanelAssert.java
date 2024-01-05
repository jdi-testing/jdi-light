package com.epam.jdi.light.vuetify.asserts.panels;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.panels.ExpansionPanel;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ExpansionPanelAssert extends UIAssert<ExpansionPanelAssert, ExpansionPanel> implements
        ColorAssert<ExpansionPanelAssert, ExpansionPanel> {

    @JDIAction(value = "Assert that '{name}' is expanded", isAssert = true)
    public ExpansionPanelAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "ExpansionPanel is closed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is closed", isAssert = true)
    public ExpansionPanelAssert closed() {
        jdiAssert(element().isExpanded(), Matchers.is(false), "ExpansionPanel is expanded");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has content font color '{0}'", isAssert = true)
    public ExpansionPanelAssert contentColor(String color) {
        String actualContentColor = element().contentColor();
        jdiAssert(element().contentColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has content background color '{0}'", isAssert = true)
    public ExpansionPanelAssert contentBackgroundColor(String color) {
        String contentBackgroundColor = element().contentBackgroundColor();
        jdiAssert(element().contentBackgroundColor(), Matchers.equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon disable rotate", isAssert = true)
    public ExpansionPanelAssert iconDisableRotate() {
        jdiAssert(element().hasIconDisableRotate(), Matchers.is(true), "ExpansionPanel's icon rotation is not " +
                "disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' icon rotation is not disabled", isAssert = true)
    public ExpansionPanelAssert notIconDisableRotate() {
        jdiAssert(element().hasIconDisableRotate(), Matchers.is(false), "ExpansionPanel's icon rotation is " +
                "disabled");
        return this;
    }
}
