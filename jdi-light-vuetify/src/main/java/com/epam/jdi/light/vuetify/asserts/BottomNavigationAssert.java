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
    @JDIAction(value = "Assert that '{name}' button color is '{0}'")
    public BottomNavigationAssert buttonColor(int index, String color) {
        String actualColor = element().buttonColor(index);
        jdiAssert(actualColor, Matchers.is(color), String.format("Element's actual button color '%s' is not equal " +
                "to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' button color is '{0}'")
    public BottomNavigationAssert buttonColor(String text, String color) {
        String actualColor = element().buttonColor(text);
        jdiAssert(actualColor, Matchers.is(color), String.format("Element's actual button color '%s' is not equal " +
                "to expected '%s'", actualColor, color));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is absolute")
    public BottomNavigationAssert absolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(true), "Element is not absolute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not absolute")
    public BottomNavigationAssert notAbsolute() {
        jdiAssert(element().isAbsolute(), Matchers.is(false), "Element is absolute");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is fixed")
    public BottomNavigationAssert fixed() {
        jdiAssert(element().isFixed(), Matchers.is(true), "Element is not fixed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not fixed")
    public BottomNavigationAssert notFixed() {
        jdiAssert(element().isFixed(), Matchers.is(false), "Element is fixed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is grow")
    public BottomNavigationAssert grow() {
        jdiAssert(element().isGrow(), Matchers.is(true), "Element is not grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not grow")
    public BottomNavigationAssert notGrow() {
        jdiAssert(element().isGrow(), Matchers.is(false), "Element is grow");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is horizontal")
    public BottomNavigationAssert horizontal() {
        jdiAssert(element().isHorizontal(), Matchers.is(true), "Element is not horizontal");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not horizontal")
    public BottomNavigationAssert notHorizontal() {
        jdiAssert(element().isHorizontal(), Matchers.is(false), "Element is horizontal");
        return this;
    }
}
