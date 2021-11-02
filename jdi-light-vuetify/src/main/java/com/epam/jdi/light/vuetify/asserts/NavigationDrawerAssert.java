package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.NavigationDrawer;
import com.epam.jdi.tools.Timer;
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

    @JDIAction("Assert that '{name}' has expected number of options")
    public NavigationDrawerAssert numberOfOptions(int numberOfOptions) {
        jdiAssert(element().hasNumberOfOptions(), Matchers.is(numberOfOptions));
        return this;
    }

    @JDIAction("Assert that '{name}' option is clickable")
    public NavigationDrawerAssert optionClickable(int index) {
        jdiAssert(element().hasOptionClickable(index) ? "option is clickable" : "option is not clickable",
                Matchers.is("option is clickable"));
        return this;
    }

    @JDIAction("Assert that all '{name}'s options are visible")
    public NavigationDrawerAssert allOptionsVisible() {
        jdiAssert(element().hasAllOptionsVisible() ? "all options are visible" : "one or more options are hidden",
                Matchers.is("all options are visible"));
        return this;
    }

    @JDIAction("Assert that '{name}'s option on index {0} is selected")
    public NavigationDrawerAssert optionSelected(int index) {
        jdiAssert(element().optionIsSelected(index) ? "option is selected" : "option is not selected",
                Matchers.is("option is selected"));
        return this;
    }

    @JDIAction("Assert that '{name}'s option on index {0} is not selected")
    public NavigationDrawerAssert optionNotSelected(int index) {
        jdiAssert(element().optionIsSelected(index) ? "option is not selected" : "option is selected",
                Matchers.is("option is not selected"));
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

    @JDIAction("Assert that '{name}' has background image")
    public NavigationDrawerAssert backgroundImage() {
        Timer.waitCondition(element()::hasBackgroundImage);
        jdiAssert(element().hasBackgroundImage() ? "has background image" : "does not have background image",
                Matchers.is("has background image"));
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
        jdiAssert(element().hasBackgroundColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has button")
    public NavigationDrawerAssert button() {
        jdiAssert(element().hasButton() ? "has button" : "does not have has button",
                Matchers.is("has button"));
        return this;
    }
}


