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

    @JDIAction("Assert that {name} is indeterminate")
    public ProgressBarAssert indeterminate() {
        jdiAssert(element().isIndeterminate(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has expected background color")
    public ProgressBarAssert color(String backgroundColor) {
        jdiAssert(element().hasColor(), Matchers.is(backgroundColor));
        return this;
    }

    @JDIAction("Assert that {name} has expected bar color")
    public ProgressBarAssert barColor(String barColor) {
        jdiAssert(element().hasBarColor(), Matchers.is(barColor));
        return this;
    }


}
