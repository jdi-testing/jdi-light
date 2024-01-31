package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.SideNav;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static java.lang.String.format;

public class SideNaveAssert extends UIAssert<SideNaveAssert, SideNav> implements ITextAssert<SideNaveAssert> {
    private static final String MAT_DRAWER_TEMPLATE = "mat-drawer-%s";

    @JDIAction(value = "Assert that '{name}' text {0}", isAssert = true)
    @Override
    public SideNaveAssert text(Matcher<String> condition) {
        jdiAssert(element().getSideNaveText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' text is '{0}'", isAssert = true)
    @Override
    public SideNaveAssert text(String text) {
        return text(Matchers.is(text));
    }

    @JDIAction(value = "Assert that '{name}' has class '{0}'", isAssert = true)
    public void configurableMode(String mode) {
        this.cssClass(format(MAT_DRAWER_TEMPLATE, mode.toLowerCase()));
    }
}
