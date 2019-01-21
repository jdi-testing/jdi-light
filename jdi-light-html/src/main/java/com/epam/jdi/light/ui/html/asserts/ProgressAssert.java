package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.CommonAssert;
import org.hamcrest.Matcher;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */

public interface ProgressAssert extends CommonAssert<HtmlAssertion> {
    HtmlAssertion maxVolume(Matcher<Integer> value);
    HtmlAssertion volume(Matcher<Integer> matcher);
}