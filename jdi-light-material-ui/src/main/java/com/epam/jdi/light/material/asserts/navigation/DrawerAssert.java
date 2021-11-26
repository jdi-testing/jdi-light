package com.epam.jdi.light.material.asserts.navigation;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Drawer;
import com.jdiai.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class DrawerAssert extends UIAssert<DrawerAssert, Drawer> {

    @JDIAction("Assert that {name} is displayed")
    @Override
    public DrawerAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name}'s element has icon")
    public DrawerAssert elementHasIcon(int elNum) {
        jdiAssert(element().elementHasIcon(elNum) ? "element has icon" : "element hasn't icon",
                Matchers.is("element has icon"));
        return this;
    }

    @JDIAction("Assert that {name}'s element has text")
    public DrawerAssert elementHasText(int elNum, String text) {
        jdiAssert(element().elementText(elNum),
                Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name}'s container has title")
    public DrawerAssert containerHasTitle(String text) {
        jdiAssert(element().containerTitle(),
                Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that {name}'s container has paragraph")
    public DrawerAssert paragraphHasText(int paragraphNum, Matcher<String> matcher) {
        jdiAssert(element().containerText().get(paragraphNum - 1),
                Matchers.is(matcher));
        return this;
    }

    @JDIAction("Assert that {name} has position")
    public DrawerAssert position(String position) {
        String expected = "element has " + position + " position";
        String unexpected = "element hasn't " + position + " position";
        jdiAssert(element().hasPosition(position) ? expected : unexpected, Matchers.is(expected));
        return this;
    }
}
