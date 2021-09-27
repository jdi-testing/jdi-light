package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Pagination;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class PaginationAssert extends UISelectAssert<PaginationAssert, Pagination> {

    @JDIAction("Assert that '{name}' is disabled")
    public PaginationAssert started() {
        jdiAssert(element().isStart() && element().isEnabled(), Matchers.is(true), "Selected page in list is not first");
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public PaginationAssert ended() {
        jdiAssert(element().isEnd() && element().isEnabled(), Matchers.is(true), "Selected page in list is not last");
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public PaginationAssert hiddenButtons() {
        jdiAssert(element().hasHiddenButtons(), Matchers.is(true), "There are no hidden button on pagination element");
        return this;
    }

}
