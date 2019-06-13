package com.epam.jdi.light.ui.html.aserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Link;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class LinkAssert extends UIAssert<LinkAssert, Link> {
    @JDIAction("Assert that '{name}' text {0}")
    public LinkAssert text(Matcher<String> condition) {
        jdiAssert(uiElement.getText(), condition);
        return this;
    }
    public LinkAssert text(String text) { return text(is(text)); }

    @JDIAction("Assert that '{name}' alt {0}")
    public LinkAssert alt(Matcher<String> condition) {
        jdiAssert(uiElement.alt(), condition);
        return this;
    }
    public LinkAssert alt(String alt) { return alt(is(alt)); }

    @JDIAction("Assert that '{name}' ref {0}")
    public LinkAssert ref(Matcher<String> condition) {
        jdiAssert(uiElement.ref(), condition);
        return this;
    }
    public LinkAssert ref(String ref) { return ref(is(ref)); }
}
