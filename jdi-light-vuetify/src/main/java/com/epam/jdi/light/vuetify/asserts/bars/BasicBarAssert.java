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
        Timer.waitCondition(element()::isDisplayed);
        element().scrollIntoView();
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that {name} has proper text")
    public A text(String text) {
        jdiAssert(element().getText(), Matchers.containsString(text));
        return (A)this;
    }

    @JDIAction("Assert that {name} has 'menu' button")
    public A menuButton() {
        jdiAssert(element().hasMenuButton(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that {name} has title")
    public A title() {
        jdiAssert(element().hasTitle(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that {name} has proper text in title")
    public A properTitleText(String text) {
        jdiAssert(element().titleText(), Matchers.is(text));
        return (A)this;
    }

    @JDIAction("Assert that {name} has 'search' button")
    public A searchButton() {
        jdiAssert(element().hasSearchButton(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that {name} has 'heart' button")
    public A heartButton() {
        jdiAssert(element().hasHeartButton(), Matchers.is(true));
        return (A)this;
    }

    @JDIAction("Assert that {name} has 'vertical dots' button")
    public A verticalDotsButton() {
        jdiAssert(element().hasVerticalDotsButton(), Matchers.is(true));
        return (A)this;
    }
}
