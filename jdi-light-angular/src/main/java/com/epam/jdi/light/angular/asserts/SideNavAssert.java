package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.SideNav;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SideNavAssert extends UIAssert<SideNavAssert, SideNav> {

    @JDIAction("'{name}' side nav is visible")
    public SideNavAssert navVisible() {
        jdiAssert(element.navIsVisible(), Matchers.is(true));
        return this;
    }

    @JDIAction("'{name}' side nav has '{0}' text")
    public SideNavAssert navText(String text) {
        jdiAssert(element.navHasText(text), Matchers.is(true));
        return this;
    }

    @JDIAction("'{name}' content has '{0}' text ")
    public SideNavAssert contentText(String text) {
        jdiAssert(element.contentHasText(text), Matchers.is(true));
        return this;
    }

}
