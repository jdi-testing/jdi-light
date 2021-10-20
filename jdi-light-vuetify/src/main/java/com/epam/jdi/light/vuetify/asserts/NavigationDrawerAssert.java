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
        element().scrollIntoView();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected number of options")
    public NavigationDrawerAssert numberOfOptions(int numberOfOptions) {
        jdiAssert(element().hasNumberOfOptions(), Matchers.is(numberOfOptions));
        return this;
    }

    @JDIAction("Assert that '{name}' option is clickable")
    public NavigationDrawerAssert optionClickable(int optionNumber) {
        jdiAssert(element().hasOptionClickable(optionNumber), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that all options of '{name}' are visible")
    public NavigationDrawerAssert allOptionsVisible() {
        jdiAssert(element().hasAllOptionsVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' option is selected")
    public NavigationDrawerAssert optionSelected(int optionNumber, Boolean optionStatus) {
        jdiAssert(element().hasOptionSelected(optionNumber-1, optionStatus), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is collapsed")
    public NavigationDrawerAssert collapsed() {
        Timer.waitCondition(element()::isCollapsed);
        jdiAssert(element().isCollapsed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public NavigationDrawerAssert expanded() {
        Timer.waitCondition(element()::isExpanded);
        jdiAssert(element().isExpanded(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is opened")
    public NavigationDrawerAssert opened() {
        Timer.waitCondition(element()::isOpened);
        jdiAssert(element().isOpened(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is closed")
    public NavigationDrawerAssert closed() {
        Timer.waitCondition(element()::isClosed);
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has background image")
    public NavigationDrawerAssert backgroundImage() {
        Timer.waitCondition(element()::hasBackgroundImage);
        jdiAssert(element().hasBackgroundImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' located in the expected part of the container")
    public NavigationDrawerAssert location(String position) {
        jdiAssert(element().hasLocation(), Matchers.containsString(position));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected background color")
    public NavigationDrawerAssert backgroundColor(String color) {
        jdiAssert(element().hasBackgroundColor(), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that '{name}' has button")
    public NavigationDrawerAssert button() {
        jdiAssert(element().hasButton(), Matchers.is(true));
        return this;
    }
}


