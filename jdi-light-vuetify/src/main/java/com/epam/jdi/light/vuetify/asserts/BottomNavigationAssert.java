package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.BottomNavigation;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomNavigationAssert extends UISelectAssert<BottomNavigationAssert, BottomNavigation> {


    @JDIAction("Assert that '{name}' background color is '{0}'")
    public BottomNavigationAssert backgroundColor(String backgroundColor) {
        jdiAssert(element().backgroundColor(), Matchers.is(backgroundColor));
        return this;
    }


    @JDIAction("Assert that button color is '{0}'")
    public BottomNavigationAssert buttonColor(int index, String color) {
        jdiAssert(element().buttonColor(index), Matchers.is(color));
        return this;
    }
}