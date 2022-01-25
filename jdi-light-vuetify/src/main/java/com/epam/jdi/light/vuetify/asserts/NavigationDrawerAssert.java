package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class NavigationDrawerAssert extends UIAssert<NavigationDrawerAssert, NavigationDrawer> {

    @JDIAction("Assert that '{name}' is displayed")
    public NavigationDrawerAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        element().show();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of list items")
    public NavigationDrawerAssert numberOfListItems(int numberOfListItems) {
        jdiAssert(element().getNumberOfListItems(), Matchers.is(numberOfListItems));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public NavigationDrawerAssert collapsed() {
        Timer.waitCondition(element()::isCollapsed);
        jdiAssert(element().isCollapsed() ? "is collapsed" : "is expanded",
                Matchers.is("is collapsed"));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public NavigationDrawerAssert expanded() {
        Timer.waitCondition(element()::isExpanded);
        jdiAssert(element().isExpanded() ? "is expanded" : "is collapsed",
                Matchers.is("is expanded"));
        return this;
    }

    @JDIAction("Assert that '{name}' is opened")
    public NavigationDrawerAssert opened() {
        Timer.waitCondition(element()::isOpened);
        jdiAssert(element().isOpened() ? "is opened" : "is closed",
                Matchers.is("is opened"));
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public NavigationDrawerAssert closed() {
        Timer.waitCondition(element()::isClosed);
        jdiAssert(element().isClosed() ? "is closed" : "is opened",
                Matchers.is("is closed"));
        return this;
    }

    @JDIAction("Assert that '{name}' is located on the right side of the container")
    public NavigationDrawerAssert onTheRightSide() {
        jdiAssert(element().isOnTheRightSide() ? "is on the right side" : "is on the left side",
                Matchers.is("is on the right side"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected background color")
    public NavigationDrawerAssert backgroundColor(String color) {
        jdiAssert(element().getBackgroundColor(), Matchers.is(color));
        return this;
    }
}


