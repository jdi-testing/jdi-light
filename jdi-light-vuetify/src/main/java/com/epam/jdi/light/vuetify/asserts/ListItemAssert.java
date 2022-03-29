package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListItemAssert extends UIAssert<ListItemAssert, ListItem> {

    private static final String IS_ACTIVE = "is active";
    private static final String IS_NOT_ACTIVE = "is not active";
    private static final String IS_CLICKABLE = "is clickable";
    private static final String IS_NOT_CLICKABLE = "is not clickable";

    @Override
    @JDIAction("Assert that '{name}' is displayed")
    public ListItemAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
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

    @JDIAction("Assert that {name}'s title is '{0}'")
    public ListItemAssert title(String expectedTitle) {
        jdiAssert(element().title().getText(), Matchers.equalTo(expectedTitle));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public ListItemAssert expanded() {
        jdiAssert(element().isExpanded() ? "is expanded" : "is collapsed", Matchers.is("is expanded"));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public ListItemAssert collapsed() {
        jdiAssert(element().isExpanded() ? "is expanded" : "is collapsed", Matchers.is("is collapsed"));
        return this;
    }
}
