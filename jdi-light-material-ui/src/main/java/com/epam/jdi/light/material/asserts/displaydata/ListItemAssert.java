package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.list.ListItem;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 *   Represent asserts for Material UI ListItem
 *
 * Assertion for {@link ListItem}.
 */
public class ListItemAssert extends UIAssert<ListItemAssert, ListItem> implements ITextAssert<ListItemAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public ListItemAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    /**
     * Checks that list item has given primary text.
     *
     * @param text expected primary text
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' has primary text '{0}'")
    public ListItemAssert primaryText(String text) {
        jdiAssert(element().getPrimaryText().text(), Matchers.is(text));
        return this;
    }

    /**
     * Checks that list item has given secondary text.
     *
     * @param text expected secondary text
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' has secondary text '{0}'")
    public ListItemAssert secondaryText(String text) {
        jdiAssert(element().getSecondaryText().text(), Matchers.is(text));
        return this;
    }

    /**
     * Checks that list item is selected.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is selected")
    public ListItemAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true), "Item is not selected");
        return this;
    }

    /**
     * Checks that list item is not selected.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is not selected")
    public ListItemAssert notSelected() {
        jdiAssert(!element().isSelected(), Matchers.is(false), "Item is selected");
        return this;
    }

    /**
     * Checks that list item is checked. Relevant only for list items with {@link Checkbox}.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is checked")
    public ListItemAssert checked() {
        jdiAssert(element().checkbox().isChecked(), Matchers.is(true), "Item is not checked");
        return this;
    }

    /**
     * Checks that list item is unchecked. Relevant only for list items with {@link Checkbox}.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is unchecked")
    public ListItemAssert unchecked() {
        jdiAssert(!element().checkbox().isChecked(), Matchers.is(false), "Item is unchecked");
        return this;
    }
}
