package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface NumberAssert {
    HtmlAssertion minValue(double value);
    HtmlAssertion maxValue(double value);
    HtmlAssertion stepValue(double value);
    HtmlAssertion placeholder(Matcher<String> value);
    HtmlAssertion number(Matcher<Double> matcher);
}