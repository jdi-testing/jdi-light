package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroup;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class ListItemGroupAssert extends ListItemAssert {

    @Override
    public ListItemGroup element() {
        return (ListItemGroup) super.element();
    }

    public ListItemGroupAssert set(ListItemGroup element) {
        super.set(element);
        return this;
    }

    public ListItemGroupAssert and() {
        super.and();
        return this;
    }


    @JDIAction(value = "Assert that '{name}' is active", isAssert = true)
    public ListItemGroupAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "ListItemGroup is not active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not active", isAssert = true)
    public ListItemGroupAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "ListItemGroup is active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has title", isAssert = true)
    public ListItemGroupAssert title() {
        jdiAssert(element().header().isExist(), Matchers.is(true), "ListItemGroup has no title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no title", isAssert = true)
    public ListItemGroupAssert noTitle() {
        jdiAssert(element().header().isExist(), Matchers.is(false), "ListItemGroup has title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' contains text '{0}'", isAssert = true)
    public ListItemGroupAssert containsText(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is a sub-group", isAssert = true)
    public ListItemGroupAssert subGroup() {
        jdiAssert(element().isSubgroup(), Matchers.is(true), "ListItemGroup is not a sub-group");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not a sub-group", isAssert = true)
    public ListItemGroupAssert notSubGroup() {
        jdiAssert(element().isSubgroup(), Matchers.is(false), "ListItemGroup is sub-group");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is no-action", isAssert = true)
    public ListItemGroupAssert noAction() {
        jdiAssert(element().isNoAction(), Matchers.is(true), "ListItemGroup is not no-action");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not no-action", isAssert = true)
    public ListItemGroupAssert notNoAction() {
        jdiAssert(element().isNoAction(), Matchers.is(false), "ListItemGroup is no-action");
        return this;
    }
}
