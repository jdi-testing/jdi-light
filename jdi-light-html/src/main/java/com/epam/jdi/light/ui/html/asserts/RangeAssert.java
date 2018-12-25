package com.epam.jdi.light.ui.html.asserts;

import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface RangeAssert {
    HtmlAssertion minVolume(int value);
    HtmlAssertion maxVolume(int value);
    HtmlAssertion step(int value);
    HtmlAssertion volume(Matcher<Integer> matcher);
}