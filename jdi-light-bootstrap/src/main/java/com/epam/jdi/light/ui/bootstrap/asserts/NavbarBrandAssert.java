package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Link;
import com.epam.jdi.light.ui.bootstrap.elements.common.NavbarBrand;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

public class NavbarBrandAssert extends UIAssert<NavbarBrandAssert, NavbarBrand>
    implements ITextAssert<NavbarBrandAssert> {

    @JDIAction("Assert that '{name}' text {0}")
    public NavbarBrandAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }
    public NavbarBrandAssert text(String text) {
         return text(is(text));
        }

    @JDIAction("Assert that '{name}' alt {0}")
    public NavbarBrandAssert alt(Matcher<String> condition) {
        jdiAssert(element.getAlt(), condition);
        return this;
    }
    public NavbarBrandAssert alt(String alt) { return alt(is(alt)); }

    @JDIAction("Assert that '{name}' ref {0}")
    public NavbarBrandAssert ref(Matcher<String> condition) {
        jdiAssert(element.getRef(), condition);
        return this;
    }
    public NavbarBrandAssert ref(String ref) { return ref(is(ref)); }
}
