package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface TextAssert  {
    HtmlAssertion text(Matcher<String> condition);

    HtmlAssertion attr(String attrName, Matcher<String> condition);
    HtmlAssertion css(String css, Matcher<String> condition);
    HtmlAssertion tag(Matcher<String> condition);
    HtmlAssertion cssClass(Matcher<String> condition);
    HtmlAssertion displayed();
    HtmlAssertion disappear();
    HtmlAssertion selected();
    HtmlAssertion deselected();
    HtmlAssertion enabled();
    HtmlAssertion disabled();
}