package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Range;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RangeAssert extends UIAssert<RangeAssert, Range> {
    
    @JDIAction("Assert that '{name}' value {0}")
    public RangeAssert value(Matcher<Integer> value, String... messages) {
        jdiAssert(getInt("value", element.core()), value, messages);
        return this;
    }
    
    public RangeAssert value(int value, String... messages) {
        return value(Matchers.is(value), messages);
    }
    
    @JDIAction("Assert that '{name}' min value {0}")
    public RangeAssert min(Matcher<Integer> min, String... messages) {
        jdiAssert(getInt("min", element.core()), min, messages);
        return this;
    }
    
    public RangeAssert min(int minVolume, String... messages) {
        return min(Matchers.is(minVolume), messages);
    }
    
    @JDIAction("Assert that '{name}' max value {0}")
    public RangeAssert max(Matcher<Integer> max, String ... messages) {
        jdiAssert(getInt("max", element.core()), max, messages);
        return this;
    }
    
    public RangeAssert max(int maxVolume, String ... messages) {
        return max(Matchers.is(maxVolume), messages);
    }
    
    @JDIAction("Assert that '{name}' step {0}")
    public RangeAssert step(Matcher<Integer> step, String ... messages) {
        jdiAssert(getInt("step", element.core()), step, messages);
        return this;
    }
    
    public RangeAssert step(int step, String ... messages) {
        return step(Matchers.is(step), messages);
    }
}