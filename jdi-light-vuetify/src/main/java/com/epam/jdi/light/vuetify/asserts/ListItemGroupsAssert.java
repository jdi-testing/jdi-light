package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroups;
import org.hamcrest.Matchers;


public class ListItemGroupsAssert extends UIAssert<ListItemGroupsAssert, ListItemGroups> {

    @JDIAction("Assert that '{name}' is active")
    public ListItemGroupsAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public ListItemGroupsAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' has title")
    public ListItemGroupsAssert title() {
        jdiAssert(element().hasTitle(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has border")
    public ListItemGroupsAssert border() {
        jdiAssert(element().hasBorder(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has not icon")
    public ListItemGroupsAssert notBorder() {
        jdiAssert(element().hasBorder(), Matchers.is(false));
        return this;
    }


    @JDIAction("Assert that '{name}' has icon")
    public ListItemGroupsAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}'s label contains '{0}'")
    public ListItemGroupsAssert containsText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }
}
