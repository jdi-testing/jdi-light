package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.common.ProgressBar;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ProgressBarAssert extends UIAssert<ProgressBarAssert, ProgressBar> {

    @JDIAction("Assert that {name} is displayed")
    public ProgressBarAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has expected color")
    public ProgressBarAssert color(String color) {
        jdiAssert(element().hasColor(color), Matchers.is(true));
        return this;
    }


}
