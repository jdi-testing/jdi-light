package com.epam.jdi.light.vuetify.asserts.breadcrumbs;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.breadcrumbs.Breadcrumb;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BreadcrumbAssert extends UIAssert<BreadcrumbAssert, Breadcrumb> implements ITextAssert<BreadcrumbAssert> {
    @Override
    @JDIAction(value = "Assert that '{name}' has text '{0}'", isAssert = true)
    public BreadcrumbAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
