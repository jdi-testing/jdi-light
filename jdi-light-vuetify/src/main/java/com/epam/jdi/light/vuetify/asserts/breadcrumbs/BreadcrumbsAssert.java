package com.epam.jdi.light.vuetify.asserts.breadcrumbs;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.breadcrumbs.Breadcrumbs;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BreadcrumbsAssert extends UIAssert<BreadcrumbsAssert, Breadcrumbs> implements
        ThemeAssert<BreadcrumbsAssert, Breadcrumbs> {
    @JDIAction(value = "Assert that '{0}' dividers satisfy a predicate '{1}'", isAssert = true)
    public BreadcrumbsAssert dividerType(String symbol) {
        element().dividers().forEach(e -> jdiAssert(e.text().equals(symbol), Matchers.is(true), String.format(
                "Actual divider type '%s' is not equal to expected '%s'", e.text(), symbol)));
        return this;
    }

    @JDIAction(value = "Assert that '{0}' dividers satisfy a predicate '{1}'", isAssert = true)
    public BreadcrumbsAssert iconDivider(String iconClass) {
        element().dividers().forEach(e -> jdiAssert(e.find("i").hasClass(iconClass), Matchers.is(true), String.format(
                "Actual divider type '%s' is not equal to expected '%s'", e.text(), iconClass)));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is large", isAssert = true)
    public BreadcrumbsAssert large() {
        jdiAssert(element().isLarge(), Matchers.is(true), "Breadcrumps is not large");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not large", isAssert = true)
    public BreadcrumbsAssert notLarge() {
        jdiAssert(element().isLarge(), Matchers.is(false), "Breadcrumps is large");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' size is {0}", isAssert = true)
    public BreadcrumbsAssert size(int size) {
        jdiAssert(element().list().size(), Matchers.is(size));
        return this;
    }
}
