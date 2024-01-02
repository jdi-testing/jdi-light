package com.epam.jdi.light.vuetify.asserts.timelines;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.timelines.TimeLine;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TimeLineAssert extends UISelectAssert<TimeLineAssert, TimeLine>
    implements DenseAssert<TimeLineAssert, TimeLine> {

    @JDIAction(value = "Assert that '{name}' is align to top")
    public TimeLineAssert alignTop() {
        jdiAssert(element().isAlignTop() ? "align to top" : "not align to top", Matchers.is("align to top"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not align to top")
    public TimeLineAssert notAlignTop() {
        jdiAssert(element().isAlignTop() ? "align to top" : "not align to top", Matchers.is("not align to top"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is reversed")
    public TimeLineAssert reversed() {
        jdiAssert(element().isReversed() ? "reversed" : "not reversed", Matchers.is("reversed"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not reversed")
    public TimeLineAssert notReversed() {
        jdiAssert(element().isReversed() ? "reversed" : "not reversed", Matchers.is("not reversed"));
        return this;
    }
}
