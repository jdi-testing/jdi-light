package com.epam.jdi.light.vuetify.asserts.timelines;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.timelines.TimeLineItem;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.equalTo;

public class TimeLineItemAssert extends UIAssert<TimeLineItemAssert, TimeLineItem> {

    @JDIAction(value = "Assert that '{name}' is small", isAssert = true)
    public TimeLineItemAssert smallDot() {
        jdiAssert(element().isSmall(), Matchers.is(true), "TimeLineItem does not have small dot");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is large", isAssert = true)
    public TimeLineItemAssert largeDot() {
        jdiAssert(element().isLarge(), Matchers.is(true), "TimeLineItem does not have large dot");
        return this;
    }

    @JDIAction(value = "Assert that dot color of '{name}' is equal to '{0}'", isAssert = true)
    public TimeLineItemAssert dotColor(String color) {
        jdiAssert(element().dotColor(), equalTo(color));
        return this;
    }

    @JDIAction(value = "Assert that dot color of '{name}' is equal to '{0}'", isAssert = true)
    public TimeLineItemAssert dotColor(Enum<?> color) {
        jdiAssert(element().dotColor(), equalTo(color.toString()));
        return this;
    }
}
