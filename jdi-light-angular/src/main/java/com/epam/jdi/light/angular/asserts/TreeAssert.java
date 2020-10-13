package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.MaterialTree;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TreeAssert extends UIAssert<TreeAssert, MaterialTree> {
    @JDIAction("Assert that '{name}' expanded")
    public TreeAssert expanded(final String nodeName) {
        jdiAssert(element().isExpanded(nodeName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' collapsed")
    public TreeAssert collapsed(final String nodeName) {
        jdiAssert(element().isCollapsed(nodeName), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has field '{0}' with value '{1}'")
    public TreeAssert value(final Matcher<String> value, final String field) {
        jdiAssert(element().value(field), value);
        return this;
    }

    public TreeAssert value(final String value, final String field) {
        return value(Matchers.is(field), value);
    }
}
