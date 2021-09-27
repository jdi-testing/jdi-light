package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.BasicBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BasicBarAssert<T extends BasicBar<?,?>, A extends BasicBarAssert<?,?>> extends UIAssert<A, T> {

    @JDIAction("Assert that {name} is displayed")
    public A displayed() {
        new Timer(base().getTimeout() * 2000L)
            .wait(() -> element().isDisplayed());
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public A menuButton() {
        jdiAssert(element().hasMenuButton(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public A properTitleText(String text) {
        jdiAssert(element().getTitle().getText(), Matchers.is(text));
        return (A)this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public A searchButton() {
        jdiAssert(element().hasSearchButton(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public A heartButton() {
        jdiAssert(element().hasHeartButton(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that banner has 'checker' element")
    public A verticalDotsButton() {
        new Timer(base().getTimeout() * 2000L)
                .wait(() -> element().getVerticalDotsButton().isDisplayed());
        jdiAssert(element().hasVerticalDotsButton(), Matchers.is(true));
        return (A)this;
    }
}
