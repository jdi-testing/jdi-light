package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListItemAssert extends UIAssert<ListItemAssert, ListItem> {

    private static final String IS_DISPLAYED = "is displayed";
    private static final String IS_HIDDEN = "is not hidden";
    private static final String IS_ACTIVE = "is active";
    private static final String IS_NOT_ACTIVE = "is not active";
    private static final String IS_CLICKABLE = "is clickable";
    private static final String IS_NOT_CLICKABLE = "is not clickable";
    private static final String IS_EXPANDED = "is expanded";
    private static final String IS_COLLAPSED = "is collapsed";

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public ListItemAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed() ? IS_DISPLAYED : IS_HIDDEN, Matchers.is(IS_DISPLAYED));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public ListItemAssert hidden() {
        Timer.waitCondition(element()::isHidden);
        jdiAssert(element().isHidden() ? IS_HIDDEN : IS_DISPLAYED, Matchers.is(IS_HIDDEN));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public ListItemAssert text(String text) {
        jdiAssert(element().text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' is active")
    public ListItemAssert active() {
        jdiAssert(element().isActive() ? IS_ACTIVE : IS_NOT_ACTIVE, Matchers.is(IS_ACTIVE));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public ListItemAssert notActive() {
        jdiAssert(!element().isActive() ? IS_NOT_ACTIVE : IS_ACTIVE, Matchers.is(IS_NOT_ACTIVE));
        return this;
    }

    @JDIAction("Assert that '{name}' is clickable")
    public ListItemAssert clickable() {
        jdiAssert(element().core().isClickable() ? IS_CLICKABLE : IS_NOT_CLICKABLE,
            Matchers.is(IS_CLICKABLE));
        return this;
    }

    @JDIAction("Assert that '{name}' is clickable")
    public ListItemAssert notClickable() {
        jdiAssert(element().core().isClickable() ? IS_CLICKABLE : IS_NOT_CLICKABLE,
            Matchers.is(IS_NOT_CLICKABLE));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public ListItemAssert expanded() {
        jdiAssert(element().isExpanded() ? IS_EXPANDED : IS_COLLAPSED, Matchers.is(IS_EXPANDED));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public ListItemAssert collapsed() {
        jdiAssert(element().isExpanded() ? IS_EXPANDED : IS_COLLAPSED, Matchers.is(IS_COLLAPSED));
        return this;
    }
}
