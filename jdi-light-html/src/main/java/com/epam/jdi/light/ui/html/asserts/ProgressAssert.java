package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.ProgressBar;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ProgressAssert extends UIAssert<ProgressAssert, ProgressBar> {
    @JDIAction("Assert that '{name}' max value {0}")
    public ProgressAssert max(Matcher<Integer> max, String... messages) {
        jdiAssert(getInt("max", element.core()), max, messages);
        return this;
    }
    
    public ProgressAssert max(int maxVolume, String... messages) {
        return max(Matchers.is(maxVolume), messages);
    }
    
    @JDIAction("Assert that '{name}' value {0}")
    public ProgressAssert value(Matcher<Integer> value, String... messages) {
        jdiAssert(getInt("value", element.core()), value, messages);
        return this;
    }
    
    public ProgressAssert value(int value, String... messages) {
        return value(Matchers.is(value), messages);
    }
}