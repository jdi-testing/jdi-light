package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.BottomNavigation;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomNavigationAssert extends UIAssert<BottomNavigationAssert, BottomNavigation> {
    @JDIAction("Assert that '{name}' is enabled")
    @Override
    public BottomNavigationAssert enabled() {
        jdiAssert(element().isEnabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    @Override
    public BottomNavigationAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public BottomNavigationAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }
}
