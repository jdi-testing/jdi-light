package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.CommonAssert;
import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface NumberAssert extends CommonAssert<HtmlAssertion> {
    HtmlAssertion minValue(Matcher<Double> value);
    HtmlAssertion maxValue(Matcher<Double> value);
    HtmlAssertion stepValue(Matcher<Double> value);
    HtmlAssertion placeholder(Matcher<String> value);
    HtmlAssertion number(Matcher<Double> matcher);
}