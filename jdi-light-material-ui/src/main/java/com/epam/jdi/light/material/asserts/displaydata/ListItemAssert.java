package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListItemAssert extends UIAssert<ListItemAssert, ListItem> {

    // Gets text using a regular primary text sub-element location or, failing that, text of list item element root.
    @JDIAction("Assert that '{name}' has text '{0}'")
    public ListItemAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    // Gets text from the sub-element with '.MuiListItemText-primary' class
    @JDIAction("Assert that '{name}' has primary text '{0}'")
    public ListItemAssert primaryText(String text) {
        jdiAssert(element().getPrimaryText().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary text '{0}'")
    public ListItemAssert secondaryText(String text) {
        jdiAssert(element().getSecondaryText().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public ListItemAssert selected() {
        jdiAssert(element().isSelected() ? "is selected" : "is not selected", Matchers.is("is selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public ListItemAssert notSelected() {
        jdiAssert(!element().isSelected() ? "is not selected" : "is selected", Matchers.is("is not selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public ListItemAssert checked() {
        jdiAssert(element().checkbox().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public ListItemAssert unchecked() {
        jdiAssert(!element().checkbox().isChecked() ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }
}
