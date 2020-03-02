package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Link;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class LinkAssert extends UIAssert<LinkAssert, Link>
        implements ITextAssert<LinkAssert> {
    
    @JDIAction("Assert that '{name}' text {0}")
    public LinkAssert text(Matcher<String> condition, String... messages) {
        jdiAssert(element.getText(), condition, messages);
        return this;
    }
    
    @JDIAction("Assert that '{name}' alt {0}")
    public LinkAssert alt(Matcher<String> condition, String... messages) {
        jdiAssert(element.alt(), condition, messages);
        return this;
    }
    
    public LinkAssert alt(String alt, String... messages) {
        return alt(Matchers.is(alt), messages);
    }
    
    @JDIAction("Assert that '{name}' ref {0}")
    public LinkAssert ref(Matcher<String> condition, String... messages) {
        jdiAssert(element.ref(), condition, messages);
        return this;
    }
    
    public LinkAssert ref(String ref, String... messages) {
        return ref(Matchers.is(ref), messages);
    }
}
