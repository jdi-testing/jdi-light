package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.ListItemGroups;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class ListItemGroupsAssert extends UIAssert<ListItemGroupsAssert, ListItemGroups> implements
        FlatAssert<ListItemGroupsAssert, ListItemGroups>, ColorAssert<ListItemGroupsAssert, ListItemGroups>,
        ThemeAssert<ListItemGroupsAssert, ListItemGroups> {

    @JDIAction(value = "Assert that '{name}' is active", isAssert = true)
    public ListItemGroupsAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Element is not active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not active", isAssert = true)
    public ListItemGroupsAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Element is active");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has title", isAssert = true)
    public ListItemGroupsAssert title() {
        jdiAssert(element().hasTitle(), Matchers.is(true), "Element has no title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no title", isAssert = true)
    public ListItemGroupsAssert noTitle() {
        jdiAssert(element().hasTitle(), Matchers.is(false), "Element has title");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has border", isAssert = true)
    public ListItemGroupsAssert border() {
        jdiAssert(element().hasBorder(), Matchers.is(true), "Element has no border");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has not border", isAssert = true)
    public ListItemGroupsAssert noBorder() {
        jdiAssert(element().hasBorder(), Matchers.is(false), "Element has border");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has icon", isAssert = true)
    public ListItemGroupsAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true), "Element has no icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has no icon", isAssert = true)
    public ListItemGroupsAssert noIcon() {
        jdiAssert(element().hasIcon(), Matchers.is(false), "Element has icon");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' contains text '{0}'", isAssert = true)
    public ListItemGroupsAssert containsText(String text) {
        String actualText = element().getText();
        jdiAssert(actualText, Matchers.containsString(text), String.format("Element's actual text '%s' doesn't " +
                "contain expected '%s'", actualText, text));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is a sub-group", isAssert = true)
    public ListItemGroupsAssert subGroup() {
        jdiAssert(element().isSubgroup(), Matchers.is(true), "Element is not a sub-group");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not a sub-group", isAssert = true)
    public ListItemGroupsAssert notSubGroup() {
        jdiAssert(element().isSubgroup(), Matchers.is(false), "Element is sub-group");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is no-action", isAssert = true)
    public ListItemGroupsAssert noAction() {
        jdiAssert(element().isNoAction(), Matchers.is(true), "Element is not no-action");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not no-action", isAssert = true)
    public ListItemGroupsAssert notNoAction() {
        jdiAssert(element().isNoAction(), Matchers.is(false), "Element is no-action");
        return this;
    }
}
