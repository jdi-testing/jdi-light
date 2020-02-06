package com.epam.jdi.mobile.ui.html.asserts;

import com.epam.jdi.mobile.asserts.generic.ITextAssert;
import com.epam.jdi.mobile.asserts.generic.UIAssert;
import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.ui.html.elements.common.Link;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.mobile.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class LinkAssert extends UIAssert<LinkAssert, Link>
    implements ITextAssert<LinkAssert> {

    @JDIAction("Assert that '{name}' text {0}")
    public LinkAssert text(Matcher<String> condition) {
        jdiAssert(element.getText(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' alt {0}")
    public LinkAssert alt(Matcher<String> condition) {
        jdiAssert(element.alt(), condition);
        return this;
    }
    public LinkAssert alt(String alt) { return alt(Matchers.is(alt)); }

    @JDIAction("Assert that '{name}' ref {0}")
    public LinkAssert ref(Matcher<String> condition) {
        jdiAssert(element.ref(), condition);
        return this;
    }
    public LinkAssert ref(String ref) { return ref(Matchers.is(ref)); }
}
