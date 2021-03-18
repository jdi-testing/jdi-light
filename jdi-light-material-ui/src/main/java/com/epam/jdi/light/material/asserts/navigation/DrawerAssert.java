package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import org.hamcrest.Matchers;

public class DrawerAssert extends UIAssert<DrawerAssert, Drawer> {

    @JDIAction("Assert that drawer is displayed")
    public DrawerAssert drawerDisplayed() {
        jdiAssert(element().isDrawerDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that left list is displayed")
    public DrawerAssert leftListDisplayed() {
        jdiAssert(element().isLeftListItemsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that right list is displayed")
    public DrawerAssert rightListDisplayed() {
        jdiAssert(element().isRightListItemsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that top list is displayed")
    public DrawerAssert topListDisplayed() {
        jdiAssert(element().isTopListItemsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that bottom list is displayed")
    public DrawerAssert bottomListDisplayed() {
        jdiAssert(element().isBottomListItemsDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that base button is displayed")
    public DrawerAssert baseButtonDisplayed() {
        jdiAssert(element().isBaseButtonDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that left docked list is displayed")
    public DrawerAssert leftDockedDisplayed() {
        jdiAssert(element().isLeftDockedListItemsDisplayed(), Matchers.is(true));
        return this;
    }
}
