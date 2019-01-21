package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.CommonAssert;
import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface RangeAssert extends CommonAssert<HtmlAssertion> {
    HtmlAssertion minVolume(Matcher<Integer> value);
    HtmlAssertion maxVolume(Matcher<Integer> value);
    HtmlAssertion step(Matcher<Integer> value);
    HtmlAssertion volume(Matcher<Integer> matcher);
}