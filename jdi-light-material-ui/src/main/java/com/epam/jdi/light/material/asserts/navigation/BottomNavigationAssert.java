package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.BottomNavigation;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomNavigationAssert extends UIAssert<BottomNavigationAssert, BottomNavigation> {

    @JDIAction("Assert that '{name}' is disabled")
    public BottomNavigationAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true));
        return this;
    }
}
