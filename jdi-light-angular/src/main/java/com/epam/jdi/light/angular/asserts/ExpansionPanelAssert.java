package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.ExpansionPanel;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ExpansionPanelAssert extends UIAssert<ExpansionPanelAssert, ExpansionPanel> {
    @JDIAction(value = "Assert that '{name}' expanded", isAssert = true)
    public ExpansionPanelAssert expanded(final int indexNumber) {
        jdiAssert(element().isExpanded(indexNumber), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' collapsed", isAssert = true)
    public ExpansionPanelAssert collapsed(final int indexNumber) {
        jdiAssert(element().isCollapsed(indexNumber), Matchers.is(true), "ERROR MESSAGE IS REQUIRED");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has field '{0}' with value '{1}'", isAssert = true)
    public ExpansionPanelAssert value(final Matcher<String> value, final String field) {
        jdiAssert(element().value(field), value);
        return this;
    }

    public ExpansionPanelAssert value(final String value, final String field) {
        return value(Matchers.is(field), value);
    }

    @JDIAction(value = "Assert that '{name}' has title '{0}' with value '{1}'", isAssert = true)
    public ExpansionPanelAssert title(final Matcher<String> title, final int titleNumber) {
        jdiAssert(element().title(titleNumber), title);
        return this;
    }

    public ExpansionPanelAssert title(final String title, final int titleNumber) {
        return title(Matchers.is(title), titleNumber);
    }

    @JDIAction(value = "Assert that '{name}' has description '{0}' with value '{1}'", isAssert = true)
    public ExpansionPanelAssert description(final Matcher<String> description, final int titleNumber) {
        jdiAssert(element().description(titleNumber), description);
        return this;
    }

    public ExpansionPanelAssert description(final String description, final int titleNumber) {
        return description(Matchers.is(description), titleNumber);
    }

    @JDIAction(value = "Assert that '{name}' has content '{0}' with value '{1}'", isAssert = true)
    public ExpansionPanelAssert content(final Matcher<String> content, final int titleNumber) {
        jdiAssert(element().content(titleNumber), content);
        return this;
    }

    public ExpansionPanelAssert content(final String content, final int titleNumber) {
        return content(Matchers.is(content), titleNumber);
    }
}
