package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.CommonAssert;
import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface DateTimeAssert  extends CommonAssert<HtmlAssertion> {
    HtmlAssertion min(Matcher<Float> value);
    HtmlAssertion max(Matcher<Float> value);

    HtmlAssertion date(Matcher<String> date);
    HtmlAssertion month(Matcher<String> month);
    HtmlAssertion week(Matcher<String> week);
    HtmlAssertion time(Matcher<String> time);
}