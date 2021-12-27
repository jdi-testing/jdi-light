package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DrawerAssert extends UIAssert<DrawerAssert, Drawer> {

    @JDIAction("Assert that '{name}' is displayed")
    @Override
    public DrawerAssert displayed() {
        jdiAssert(element().core().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected position")
    public DrawerAssert position(String position) {
        jdiAssert(element().getPosition() , Matchers.is(position));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected width")
    public DrawerAssert width(int width) {
        jdiAssert(element().getWidth() , Matchers.is(String.format("%spx", width)));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of list items")
    public DrawerAssert numberOfListItems(int numberOfListItems) {
        jdiAssert(element().listItems().size(), Matchers.is(numberOfListItems));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is visible")
    public DrawerAssert visible() {
        jdiAssert(!element().isHidden() ? "is visible" : "is not visible", Matchers.is("is visible"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is not visible")
    public DrawerAssert notVisible() {
        jdiAssert(element().isHidden() ? "is not visible" : "is visible", Matchers.is("is not visible"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is hidden")
    public DrawerAssert hidden() {
        jdiAssert(element().isHidden() ? "is hidden" : "is visible", Matchers.is("is hidden"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not exist")
    public DrawerAssert notExist() {
        jdiAssert(element().core().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }
}
