package com.epam.jdi.light.vuetify.asserts.timelines;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.timelines.TimeLineItem;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

public class TimeLineItemAssert extends UIAssert<TimeLineItemAssert, TimeLineItem> {

    @JDIAction("Assert that {name} is small")
    public TimeLineItemAssert small() {
        jdiAssert(element().isSmall() ? "small" : "large", Matchers.is("small"));
        return this;
    }

    @JDIAction("Assert that {name} is large")
    public TimeLineItemAssert large() {
        jdiAssert(element().isLarge() ? "large" : "small", Matchers.is("large"));
        return this;
    }

    @JDIAction("Assert that dot color of '{name}' is equal to '{0}'")
    public TimeLineItemAssert dotColor(String color) {
        jdiAssert(element().dotColor(), equalTo(color));
        return this;
    }

    @JDIAction("Assert that dot color of '{name}' is equal to '{0}'")
    public TimeLineItemAssert dotColor(Enum<?> color) {
        jdiAssert(element().dotColor(), equalTo(color.toString()));
        return this;
    }
}
