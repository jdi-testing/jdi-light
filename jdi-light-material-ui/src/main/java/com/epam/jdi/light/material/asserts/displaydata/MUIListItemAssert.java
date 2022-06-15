package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.MUIListItem;
import com.epam.jdi.light.material.elements.inputs.Checkbox;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * @deprecated
 *
 * Assertion for {@link MUIListItem}.
 */
public class MUIListItemAssert extends UIAssert<MUIListItemAssert, MUIListItem> implements ITextAssert<MUIListItemAssert> {

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public MUIListItemAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }

    /**
     * Checks that list item has given primary text.
     *
     * @param text expected primary text
     * @return this {@link MUIListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' has primary text '{0}'")
    public MUIListItemAssert primaryText(String text) {
        jdiAssert(element().getPrimaryText().text(), Matchers.is(text));
        return this;
    }

    /**
     * Checks that list item has given secondary text.
     *
     * @param text expected secondary text
     * @return this {@link MUIListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' has secondary text '{0}'")
    public MUIListItemAssert secondaryText(String text) {
        jdiAssert(element().getSecondaryText().text(), Matchers.is(text));
        return this;
    }

    /**
     * Checks that list item is selected.
     *
     * @return this {@link MUIListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is selected")
    public MUIListItemAssert selected() {
        jdiAssert(element().isSelected() ? "is selected" : "is not selected", Matchers.is("is selected"));
        return this;
    }

    /**
     * Checks that list item is not selected.
     *
     * @return this {@link MUIListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is not selected")
    public MUIListItemAssert notSelected() {
        jdiAssert(!element().isSelected() ? "is not selected" : "is selected", Matchers.is("is not selected"));
        return this;
    }

    /**
     * Checks that list item is checked. Relevant only for list items with {@link Checkbox}.
     *
     * @return this {@link MUIListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is checked")
    public MUIListItemAssert checked() {
        jdiAssert(element().checkbox().isChecked() ? "is checked" : "is unchecked", Matchers.is("is checked"));
        return this;
    }

    /**
     * Checks that list item is unchecked. Relevant only for list items with {@link Checkbox}.
     *
     * @return this {@link MUIListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is unchecked")
    public MUIListItemAssert unchecked() {
        jdiAssert(!element().checkbox().isChecked() ? "is unchecked" : "is checked", Matchers.is("is unchecked"));
        return this;
    }
}
