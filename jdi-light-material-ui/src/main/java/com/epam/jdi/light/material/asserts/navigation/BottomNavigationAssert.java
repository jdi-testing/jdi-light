package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.BottomNavigation;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomNavigationAssert extends UISelectAssert<BottomNavigationAssert, BottomNavigation> {

    @JDIAction("Assert that '{name}' is selected")
    public BottomNavigationAssert selected() {
        jdiAssert(element().isSelected(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not selected")
    public BottomNavigationAssert notSelected() {
        jdiAssert(element().isNotSelected(), Matchers.is(true));
        return this;
    }
}
