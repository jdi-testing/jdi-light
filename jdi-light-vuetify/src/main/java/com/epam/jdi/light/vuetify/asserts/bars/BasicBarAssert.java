package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.BasicBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BasicBarAssert<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIAssert<A, T> {

    @JDIAction("Assert that '{name}' is displayed")
    public A displayed() {
        Timer.waitCondition(element()::isDisplayed);
        element().show();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that '{name}' has expected text")
    public A text(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return (A)this;
    }

    @JDIAction("Assert that '{name}' has visible title")
    public A title() {
        jdiAssert(element().hasTitle() ? "title is displayed" : "title is not displayed",
                Matchers.is("title is displayed"));
        return (A)this;
    }

    @JDIAction("Assert that '{name}' has expected text in title")
    public A textInTitle(String text) {
        jdiAssert(element().titleText(), Matchers.is(text));
        return (A)this;
    }
}
