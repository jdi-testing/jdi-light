package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.BottomNavigation;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomNavigationAssert extends UISelectAssert<BottomNavigationAssert, BottomNavigation> implements
        ColorAssert<BottomNavigationAssert, BottomNavigation>, ThemeAssert<BottomNavigationAssert, BottomNavigation>,
        MeasurementAssert<BottomNavigationAssert, BottomNavigation> {
    @JDIAction(value = "Assert that '{name}' button color is '{0}'", isAssert = true)
    public BottomNavigationAssert buttonColor(int index, String color) {
        jdiAssert(element().buttonColor(index), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' button color is '{0}'", isAssert = true)
    public BottomNavigationAssert buttonColor(String text, String color) {
        jdiAssert(element().buttonColor(text), Matchers.is(color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has absolute position", isAssert = true)
    public BottomNavigationAssert absolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(true), "BottomNavigation is not absolute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' does not have absolute position", isAssert = true)
    public BottomNavigationAssert notAbsolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(false), "BottomNavigation is absolute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is fixed", isAssert = true)
    public BottomNavigationAssert fixed() {
        jdiAssert(element().isFixed(), Matchers.is(true), "BottomNavigation is not fixed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not fixed", isAssert = true)
    public BottomNavigationAssert notFixed() {
        jdiAssert(element().isFixed(), Matchers.is(false), "BottomNavigation is fixed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is grow", isAssert = true)
    public BottomNavigationAssert grow() {
        jdiAssert(element().isGrow(), Matchers.is(true), "BottomNavigation is not grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not grow", isAssert = true)
    public BottomNavigationAssert notGrow() {
        jdiAssert(element().isGrow(), Matchers.is(false), "BottomNavigation is grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is horizontal", isAssert = true)
    public BottomNavigationAssert horizontal() {
        jdiAssert(element().isHorizontal(), Matchers.is(true), "BottomNavigation is not horizontal");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not horizontal", isAssert = true)
    public BottomNavigationAssert notHorizontal() {
        jdiAssert(element().isHorizontal(), Matchers.is(false), "BottomNavigation is horizontal");
        return this;
    }
}
