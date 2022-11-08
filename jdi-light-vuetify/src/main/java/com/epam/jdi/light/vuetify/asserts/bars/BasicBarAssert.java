package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.BasicBar;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BasicBarAssert<A extends BasicBarAssert<?, ?>, T extends BasicBar<?, ?>> extends UIAssert<A, T> {

    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        Timer.waitCondition(element()::isDisplayed);
        element().show();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' has expected text")
    public A text(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return (A) this;
    }


    @JDIAction("Assert that '{name}' is collapsed")
    public A collapsed() {
        jdiAssert(element().isCollapsed() ? "is collapsed" : "is expanded",
                Matchers.is("is collapsed"));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is expanded")
    public A expanded() {
        jdiAssert(element().isExpanded() ? "is expanded" : "is collapsed",
                Matchers.is("is expanded"));
        return (A) this;
    }

    public A color(String expectedColor) {
        jdiAssert(element().css("background-color"), Matchers.is(expectedColor));
        return (A) this;
    }
}
