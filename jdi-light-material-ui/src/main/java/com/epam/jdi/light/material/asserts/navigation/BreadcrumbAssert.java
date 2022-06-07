package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UISelectAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Breadcrumbs;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Assertions for {@link Breadcrumbs}.
 */
public class BreadcrumbAssert extends UISelectAssert<BreadcrumbAssert, Breadcrumbs> {

    /**
     * Checks that {@link Breadcrumbs} has current url meets the given condition.
     *
     * @param condition expected condition
     * @return this {@link BreadcrumbAssert} instance
     */
    @JDIAction("Assert that '{name}' current url {0}")
    public BreadcrumbAssert currentUrl(Matcher<String> condition) {
        jdiAssert(element().currentUrl(), condition);
        return this;
    }
}
