package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.MUIListItem;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class MUIListItemAssert extends UIAssert<MUIListItemAssert, MUIListItem> implements ITextAssert<MUIListItemAssert> {

    // Gets text using a regular primary text sub-element location or, failing that, text of list item element root.
    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public MUIListItemAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    // Gets text from the sub-element with '.MuiListItemText-primary' class
    @JDIAction("Assert that '{name}' has primary text '{0}'")
    public MUIListItemAssert primaryText(String text) {
        jdiAssert(element().getPrimaryText().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' has secondary text '{0}'")
    public MUIListItemAssert secondaryText(String text) {
        jdiAssert(element().getSecondaryText().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is selected")
    public MUIListItemAssert selected() {
        jdiAssert(element().isSelected() ? "is selected" : "is not selected", Matchers.is("is selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public MUIListItemAssert notSelected() {
        jdiAssert(!element().isSelected() ? "is not selected" : "is selected", Matchers.is("is not selected"));
        return this;
    }

    @JDIAction("Assert that '{name}' is checked")
    public MUIListItemAssert checked() {
        jdiAssert(element().checkbox().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    @JDIAction("Assert that '{name}' is unchecked")
    public MUIListItemAssert unchecked() {
        jdiAssert(!element().checkbox().isChecked() ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }
}
