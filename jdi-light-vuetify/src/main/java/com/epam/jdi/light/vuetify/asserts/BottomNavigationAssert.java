package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.BottomNavigation;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomNavigationAssert extends UIAssert<BottomNavigationAssert, BottomNavigation> {

    @JDIAction("Assert that '{name}' is displayed")
    public BottomNavigationAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is notDisplayed")
    public BottomNavigationAssert notDisplayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that '{name}' is seen")
    public BottomNavigationAssert seen() {
        jdiAssert(element().getTransform(), Matchers.is("none"));
        return this;
    }

    @JDIAction("Assert that '{name}' is hidden")
    public BottomNavigationAssert hide() {
        jdiAssert(element().getTransform(), Matchers.not("none"));
        return this;
    }

    @JDIAction("Assert that '{name}' background color is '{0}'")
    public BottomNavigationAssert backgroundColor(String backgroundColor) {
        jdiAssert(element().getBackgroundColor(), Matchers.is(backgroundColor));
        return this;
    }

    @JDIAction("Assert that '{name}' background color attribute is '{0}'")
    public BottomNavigationAssert backgroundColorAttribute(String color) {
        jdiAssert(element().getClassAttribute(), Matchers.containsString(color));
        return this;
    }

    @JDIAction("Assert that button color is '{0}'")
    public BottomNavigationAssert buttonColor(int index, String color) {
        jdiAssert(element().getButtonColor(index), Matchers.is(color));
        return this;
    }

    @JDIAction("Assert that button wight is '{0}'")
    public BottomNavigationAssert buttonWight(int index, String wight) {
        jdiAssert(element().getButtonWight(index), Matchers.is(wight));
        return this;
    }

    @JDIAction("Assert that button direction is '{0}'")
    public BottomNavigationAssert buttonDirection(int index, String direction) {
        jdiAssert(element().getButtonDirection(index), Matchers.is(direction));
        return this;
    }

    @JDIAction("Assert that button text is '{0}' ")
    public BottomNavigationAssert buttonText(int index, String text) {
        jdiAssert(element().getButtonText(index), Matchers.is(text));
        return this;
    }

}