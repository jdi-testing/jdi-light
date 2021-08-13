package com.epam.jdi.light.material.asserts.navigation;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.navigation.Breadcrumb;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BreadcrumbAssert extends UIAssert<BreadcrumbAssert, Breadcrumb> {

    @JDIAction("Assert that {name} is displayed")
    @Override
    public BreadcrumbAssert displayed() {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' text is '{0}'")
    public BreadcrumbAssert text(String text) {
        jdiAssert(element().getText(), Matchers.is(text));
        return this;
    }
}
