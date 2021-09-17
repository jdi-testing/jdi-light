package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.BottomNavigationButton;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomNavigationAssert extends UIAssert<BottomNavigationAssert, BottomNavigationButton> {

    public BottomNavigationAssert() {
    }

    @JDIAction("Assert that '{name}' is displayed")
    public BottomNavigationAssert displayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' is not displayed")
    public BottomNavigationAssert notDisplayed() {
        jdiAssert(element().isDisplayed(), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} has icon")
    public BottomNavigationAssert icon() {
        jdiAssert(element().hasIcon(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} text is '{0}'")
    public BottomNavigationAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name} weight is '{0}'")
    public BottomNavigationAssert weight(String weight) {
        jdiAssert(element().getWidth(), Matchers.is(weight));
        return this;
    }

    @JDIAction("Assert that {name} direction is '{0}'")
    public BottomNavigationAssert direction(String direction) {
        jdiAssert(element().getText(), Matchers.is(direction));
        return this;
    }

    @JDIAction("Assert that {name} color is '{0}'")
    public BottomNavigationAssert color(String text) {
        jdiAssert(element().getColor(), Matchers.is(text));
        return this;
    }
}
