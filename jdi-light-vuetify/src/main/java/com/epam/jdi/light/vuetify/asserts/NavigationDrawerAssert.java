package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class NavigationDrawerAssert extends UIAssert<NavigationDrawerAssert, NavigationDrawer>
        implements ThemeAssert<NavigationDrawerAssert, NavigationDrawer> {

    @JDIAction("Assert that '{name}' is displayed")
    public NavigationDrawerAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of items")
    public NavigationDrawerAssert itemSize(int value) {
        jdiAssert(element().size(), Matchers.is(value));
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

    @JDIAction("Assert that '{name}' is located on the right side")
    public NavigationDrawerAssert right() {
        jdiAssert(element().isRight() ? "is on the right side" : "is on the left side",
                Matchers.is("is on the right side"));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected background color")
    public NavigationDrawerAssert backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Check '{name}' text of items")
    public NavigationDrawerAssert text(List<String> values) {
        jdiAssert(element().itemsText().equals(values), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is absolute")
    public NavigationDrawerAssert absolute() {
        jdiAssert(element().isAbsolute() ? "is absolute" : "is not absolute", Matchers.is("is absolute"));
        return this;
    }

    @JDIAction("Assert that '{name}' is bottom")
    public NavigationDrawerAssert bottom() {
        jdiAssert(element().isBottom() ? "is bottom" : "is not bottom", Matchers.is("is bottom"));
        return this;
    }

    @JDIAction("Assert that '{name}' is clipped")
    public NavigationDrawerAssert clipped() {
        jdiAssert(element().isClipped() ? "is clipped" : "is not clipped", Matchers.is("is clipped"));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is floating")
    public NavigationDrawerAssert floating() {
        jdiAssert(element().isFloating() ? "is floating" : "is not floating",
                Matchers.is("is floating"));
        return this;
    }

    @JDIAction("Assert that '{name}' height is '{0}'")
    public NavigationDrawerAssert height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return this;
    }

    @JDIAction("Assert that '{name}' width is '{0}'")
    public NavigationDrawerAssert width(int width) {
        jdiAssert(element().width(), Matchers.is(width));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is temporary")
    public NavigationDrawerAssert temporary() {
        jdiAssert(element().isTemporary() ? "is temporary" : "permanent", Matchers.is("is temporary"));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is permanent")
    public NavigationDrawerAssert permanent() {
        jdiAssert(element().isTemporary() ? "is temporary" : "permanent", Matchers.is("permanent"));
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is mini-variant")
    public NavigationDrawerAssert miniVariant() {
        jdiAssert(element().isMiniVariant() ? "is mini-variant" : "is not mini-variant",
                Matchers.is("is mini-variant"));
        return this;
    }

    @JDIAction("Assert that '{name}' has overlay")
    public NavigationDrawerAssert overlay() {
        jdiAssert(element().overlay().isExist(), Matchers.is(true),
                "Navigation drawer has no overlay");
        return this;
    }

    @JDIAction("Assert that '{name}' has no overlay")
    public NavigationDrawerAssert noOverlay() {
        jdiAssert(element().overlay().isExist(), Matchers.is(false),
                "Navigation drawer has overlay");
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is expanded on hover")
    public NavigationDrawerAssert expandedOnHover() {
        jdiAssert(element().isExpandedOnHover() ? "is expanded on hover" : "is not expanded on hover",
                Matchers.is("is expanded on hover"));
        return this;
    }

}


