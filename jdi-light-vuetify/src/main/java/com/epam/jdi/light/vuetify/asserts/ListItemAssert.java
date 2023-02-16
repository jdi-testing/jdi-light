package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link ListItem}
 */
public class ListItemAssert extends UIAssert<ListItemAssert, ListItem> implements ITextAssert<ListItemAssert> {

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public ListItemAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Element is not displayed");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public ListItemAssert hidden() {
        jdiAssert(element().isHidden(), Matchers.is(true), "Element is not hidden");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' text {0}")
    public ListItemAssert text(Matcher<String> condition) {
        String actualText = element().text();
        jdiAssert(actualText, condition, String.format("Element's actual text '%s' is not equal to expected '%s'",
                actualText, condition));
        return this;
    }

    /**
     * Checks that the list item is active.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is active")
    public ListItemAssert active() {
        jdiAssert(element().isActive(), Matchers.is(true), "Element is not active");
        return this;
    }

    /**
     * Checks that the list item is not active.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is not active")
    public ListItemAssert notActive() {
        jdiAssert(element().isActive(), Matchers.is(false), "Element is active");
        return this;
    }

    /**
     * Checks that the list item is clickable.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is clickable")
    public ListItemAssert clickable() {
        jdiAssert(element().core().isClickable(), Matchers.is(true), "Element is not clickable");
        return this;
    }

    /**
     * Checks that the list item is not clickable.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is clickable")
    public ListItemAssert notClickable() {
        jdiAssert(element().core().isClickable(), Matchers.is(false), "Element is clickable");
        return this;
    }

    /**
     * Checks that the list item is expanded.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is expanded")
    public ListItemAssert expanded() {
        jdiAssert(element().isExpanded(), Matchers.is(true), "Element is collapsed");
        return this;
    }

    /**
     * Checks that the list item is collapsed.
     *
     * @return this {@link ListItemAssert} instance
     */
    @JDIAction("Assert that '{name}' is collapsed")
    public ListItemAssert collapsed() {
        jdiAssert(element().isExpanded(), Matchers.is(false), "Element is expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' title is {0}")
    public ListItemAssert title(String expTitle) {
        jdiAssert(element().title().text(), Matchers.is(expTitle));
        return this;
    }
    @JDIAction("Assert that '{name}' title matches {0}")
    public ListItemAssert title(Matcher<String> condition) {
        jdiAssert(element().title().text(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' subtitle matches {0}")
    public ListItemAssert subtitle(Matcher<String> condition) {
        jdiAssert(element().subtitle().text(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' subtitle is {0}")
    public ListItemAssert subtitle(String expSubtitle) {
        jdiAssert(element().subtitle().text(), Matchers.is(expSubtitle));
        return this;
    }
}
