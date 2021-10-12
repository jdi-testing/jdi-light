package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TreeView;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class TreeViewAssert extends UISelectAssert<TreeViewAssert, TreeView> {

    @JDIAction("Assert that '{name}' is a pseudo core node")
    public TreeViewAssert pseudo() {
        jdiAssert(element().isPseudoCore(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is a leaf")
    public TreeViewAssert leaf() {
        jdiAssert(element().isLeaf(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public TreeViewAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public TreeViewAssert closed() {
        jdiAssert(element().isExpanded(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is active is '{0}'")
    public TreeViewAssert active(boolean status) {
        jdiAssert(element().isActive(), Matchers.is(status));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected is '{0}'")
    public TreeViewAssert selected(boolean status) {
        jdiAssert(element().isSelected(), Matchers.is(status));
        return this;
    }

    @JDIAction("Assert that '{name}' has checkbox is '{0}'")
    public TreeViewAssert checkbox(boolean status) {
        jdiAssert(element().checkbox().isExist(), Matchers.is(status));
        return this;
    }

    @JDIAction("Assert that {0} values checked in '{name}'")
    public TreeViewAssert checked(Matcher<? super List<String>> values) {
        jdiAssert(element().checked(), values);
        return this;
    }
    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewAssert checked(String... values) {
        return checked(containsInAnyOrder(values));
    }

    @JDIAction("Assert that '{0}' values checked in '{name}'")
    public TreeViewAssert checked(List<String> values) {
        return checked(containsInAnyOrder(values.toArray()));
    }
}
