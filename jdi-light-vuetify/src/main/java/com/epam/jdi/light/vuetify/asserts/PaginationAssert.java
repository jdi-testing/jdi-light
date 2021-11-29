package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Pagination;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaginationAssert extends UISelectAssert<PaginationAssert, Pagination> {

    @JDIAction("Assert that '{name}' at the start")
    public PaginationAssert started() {
        jdiAssert(element().isStart() ? "start" : "end", Matchers.is("start"));
        return this;
    }

    @JDIAction("Assert that '{name}' at the end")
    public PaginationAssert ended() {
        jdiAssert(element().isStart() ? "start" : "end", Matchers.is("end"));
        return this;
    }
}
