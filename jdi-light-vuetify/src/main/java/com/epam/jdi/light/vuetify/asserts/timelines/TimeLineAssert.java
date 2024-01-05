package com.epam.jdi.light.vuetify.asserts.timelines;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.timelines.TimeLine;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TimeLineAssert extends UISelectAssert<TimeLineAssert, TimeLine>
    implements DenseAssert<TimeLineAssert, TimeLine> {

    @JDIAction(value = "Assert that '{name}' is align to top", isAssert = true)
    public TimeLineAssert alignTop() {
        jdiAssert(element().isAlignTop(), Matchers.is(true), "Timeline is not align to top");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not align to top", isAssert = true)
    public TimeLineAssert notAlignTop() {
        jdiAssert(element().isAlignTop(), Matchers.is(false), "Timeline is align to top");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is reversed", isAssert = true)
    public TimeLineAssert reversed() {
        jdiAssert(element().isReversed(), Matchers.is(true), "Timeline is not reversed");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not reversed", isAssert = true)
    public TimeLineAssert notReversed() {
        jdiAssert(element().isReversed(), Matchers.is(false),  "Timeline is reversed");
        return this;
    }
}
