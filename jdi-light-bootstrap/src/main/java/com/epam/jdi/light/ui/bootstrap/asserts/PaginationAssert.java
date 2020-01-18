package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.complex.Pagination;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Dmitrii Pavlov on 26.09.2019
 * Email: delnote@gmail.com; Skype: Dmitrii Pavlov
 */

public class PaginationAssert extends UISelectAssert<PaginationAssert, Pagination> {

    @JDIAction("Assert that '{name}' is enabled")
    public PaginationAssert enabled() {
        jdiAssert(element.isEnabled() ? "enabled" : "disabled", Matchers.is("enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' is enabled")
    public PaginationAssert disabled() {
        jdiAssert(element.isDisabled() ? "disabled" : "enabled", Matchers.is("enabled"));
        return this;
    }
}
