package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Pagination;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class PaginationAssert extends UISelectAssert<PaginationAssert, Pagination> {

    @JDIAction("Assert that '{name}' is enabled")
    public PaginationAssert enabled() {
        jdiAssert(element.isEnabled() ? "enabled" : "disabled", is("enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public PaginationAssert disabled() {
        jdiAssert(element.isDisabled() ? "disabled" : "enabled", is("enabled"));
        return this;
    }


}
