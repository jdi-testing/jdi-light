package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class NavigationDrawerAssert extends UIAssert<NavigationDrawerAssert, NavigationDrawer>
        implements ThemeAssert<NavigationDrawerAssert, NavigationDrawer> {

    @JDIAction("Assert that '{name}' has expected number of items")
    public NavigationDrawerAssert itemSize(int value) {
        jdiAssert(element().size(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public NavigationDrawerAssert collapsed() {
        Timer.waitCondition(element()::isCollapsed);
        jdiAssert(element().isCollapsed(),
                Matchers.is(true), "NavigationDrawer is not collapsed");
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public NavigationDrawerAssert expanded() {
        Timer.waitCondition(element()::isExpanded);
        jdiAssert(element().isExpanded(),
                Matchers.is(true), "NavigationDrawer is not expanded");
        return this;
    }

    @JDIAction("Assert that '{name}' is opened")
    public NavigationDrawerAssert opened() {
        Timer.waitCondition(element()::isOpened);
        jdiAssert(element().isOpened(),
                Matchers.is(true), "NavigationDrawer is not opened");
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public NavigationDrawerAssert closed() {
        Timer.waitCondition(element()::isClosed);
        jdiAssert(element().isClosed(),
                Matchers.is(true), "NavigationDrawer is not closed");
        return this;
    }

    @JDIAction("Assert that '{name}' is located on the right side")
    public NavigationDrawerAssert right() {
        jdiAssert(element().isRight(),
                Matchers.is(true), "NavigationDrawer is not on right side");
        return this;
    }

    @JDIAction("Assert that '{name}' has expected background color")
    public NavigationDrawerAssert backgroundColor(String color) {
        jdiAssert(element().backgroundColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Check '{name}' text of items")
    public NavigationDrawerAssert text(List<String> values) {
        text(Matchers.is(values));
        text(Matchers.hasSize(values.size()));
        return this;
    }

    @JDIAction("Check '{name}' text of items using specific condition")
    public NavigationDrawerAssert text(Matcher<? super List<String>> condition) {
        jdiAssert(element().itemsText(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' is absolute")
    public NavigationDrawerAssert absolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(true), "NavigationDrawer is not absolute");
        return this;
    }

    @JDIAction("Assert that '{name}' is bottom")
    public NavigationDrawerAssert bottom() {
        jdiAssert(element().isBottom(), Matchers.is(true), "NavigationDrawer is not in bottom");
        return this;
    }

    @JDIAction("Assert that '{name}' is clipped")
    public NavigationDrawerAssert clipped() {
        jdiAssert(element().isClipped(), Matchers.is(true), "NavigationDrawer is not clipped");
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is floating")
    public NavigationDrawerAssert floating() {
        jdiAssert(element().isFloating(),
                Matchers.is(true), "NavigationDrawer is not floating");
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
        jdiAssert(element().isTemporary(), Matchers.is(true), "NavigationDrawer is not temporary");
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is permanent")
    public NavigationDrawerAssert permanent() {
        jdiAssert(element().isTemporary(), Matchers.is(false), "NavigationDrawer is temporary");
        return this;
    }

    @JDIAction("Assert that theme of '{name}' is mini-variant")
    public NavigationDrawerAssert miniVariant() {
        jdiAssert(element().isMiniVariant(),
                Matchers.is(true), "NavigationDrawer is not mini-variant");
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
        jdiAssert(element().isExpandedOnHover(),
                Matchers.is(true), "NavigationDrawer is not expanded on hover");
        return this;
    }

}


