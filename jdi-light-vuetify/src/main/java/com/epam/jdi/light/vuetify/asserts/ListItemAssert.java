package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ListItem;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ListItemAssert extends UIAssert<ListItemAssert, ListItem> {

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
        jdiAssert(element().isActive()  ? "is active" : "is not active", Matchers.is("is active"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not active")
    public ListItemAssert notActive() {
        jdiAssert(!element().isActive()  ? "is not active" : "is active",
                Matchers.is("is not active"));
        return this;
    }

    @JDIAction("Assert that '{name}' has border")
    public ListItemAssert border() {
        jdiAssert(element().hasBorder() ? "has border" : "does not have border",
                Matchers.is("has border"));
        return this;
    }

    @JDIAction("Assert that '{name}' is clickable")
    public ListItemAssert clickable() {
        jdiAssert(element().core().isClickable() ? "is clickable" : "is not clickable",
                Matchers.is("is clickable"));
        return this;
    }
}
