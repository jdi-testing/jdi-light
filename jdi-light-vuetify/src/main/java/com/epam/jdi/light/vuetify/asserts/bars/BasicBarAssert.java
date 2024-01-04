package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.BasicBar;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.FlatAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.OutlinedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.RoundedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ShapedAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BasicBarAssert<A extends BasicBarAssert<?, ?>, T extends BasicBar<?, ?>> extends UIAssert<A, T>
        implements ColorAssert<A, T>, FlatAssert<A, T>, DenseAssert<A, T>, ShapedAssert<A, T>, OutlinedAssert<A, T>,
        ElevationAssert<A, T>, ThemeAssert<A, T>, RoundedAssert<A, T> {

    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        Timer.waitCondition(element()::isDisplayed);
        element().show();
        jdiAssert(element().isDisplayed(), Matchers.is(true), "Bar is not displayed");
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

    @JDIAction("Assert that '{name}' is extended")
    public A extended() {
        jdiAssert(element().isExtended(), Matchers.is(true), "Toolbar is not extended");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not extended")
    public A notExtended() {
        jdiAssert(element().isExtended(), Matchers.is(false), "Toolbar is extended");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is floating")
    public A floating() {
        jdiAssert(element().isFloating(), Matchers.is(true), "Toolbar is not floating");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not floating")
    public A notFloating() {
        jdiAssert(element().isFloating(), Matchers.is(false), "Toolbar is floating");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is prominent")
    public A prominent() {
        jdiAssert(element().isProminent(), Matchers.is(true), "Toolbar is not prominent");
        return (A) this;
    }

    @JDIAction("Assert that '{name}' is not prominent")
    public A notProminent() {
        jdiAssert(element().isProminent(), Matchers.is(false), "Toolbar is prominent");
        return (A) this;
    }
}
