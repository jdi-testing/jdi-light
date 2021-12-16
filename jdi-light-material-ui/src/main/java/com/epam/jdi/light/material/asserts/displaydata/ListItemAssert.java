package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.ListItem;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListItemAssert extends UIAssert<ListItemAssert, ListItem> {

    @JDIAction("Assert that '{name}' has expected text")
    public ListItemAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected primary text")
    public ListItemAssert primaryText(String text) {
        jdiAssert(element().getPrimaryText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected secondary text")
    public ListItemAssert secondaryText(String text) {
        jdiAssert(element().getSecondaryText().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public ListItemAssert selected() {
        jdiAssert(element().isSelected()? "is selected" : "is not selected", Matchers.is("is selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' has is selected")
    public ListItemAssert notSelected() {
        jdiAssert(!element().isSelected()? "is not selected" : "is selected", Matchers.is("is not selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public ListItemAssert checked() {
        jdiAssert(element().checkbox().isChecked()? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public ListItemAssert unchecked() {
        jdiAssert(!element().checkbox().isChecked()? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }


}
