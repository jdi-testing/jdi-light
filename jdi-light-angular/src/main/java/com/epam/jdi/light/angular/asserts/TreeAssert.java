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

//    @JDIAction("Assert that '{name}' has title '{0}' with value '{1}'")
//    public TreeAssert attribute(final Matcher<String> attrib, final String value) {
//        jdiAssert(element().attribute(attrib,value), attrib);
//        return this;
//    }

//    @JDIAction("Assert that '{name}' has title '{0}' with value '{1}'")
//    public TreeAssert title(final Matcher<String> title, final int titleNumber) {
//        jdiAssert(element().title(titleNumber), title);
//        return this;
//    }
//
//    public TreeAssert title(final String title, final int titleNumber) {
//        return title(Matchers.is(title), titleNumber);
//    }
//
//    @JDIAction("Assert that '{name}' has description '{0}' with value '{1}'")
//    public TreeAssert description(final Matcher<String> description, final int titleNumber) {
//        jdiAssert(element().description(titleNumber), description);
//        return this;
//    }
//
//    public TreeAssert description(final String description, final int titleNumber) {
//        return description(Matchers.is(description), titleNumber);
//    }
//
//    @JDIAction("Assert that '{name}' has content '{0}' with value '{1}'")
//    public TreeAssert content(final Matcher<String> content, final int titleNumber) {
//        jdiAssert(element().content(titleNumber), content);
//        return this;
//    }
//
//    public TreeAssert content(final String content, final int titleNumber) {
//        return content(Matchers.is(content), titleNumber);
//    }
}
