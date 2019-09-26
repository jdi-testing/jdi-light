package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.Range;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getInt;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class RangeAssert extends UIAssert<RangeAssert, Range> {

    @JDIAction("Assert that '{name}' volume {0}")
    public RangeAssert volume(Matcher<Integer> volume) {
        jdiAssert(getInt("value", element.core()), volume);
        return this;
    }
    public RangeAssert volume(int volume) { return volume(is(volume)); }

    @JDIAction("Assert that '{name}' min volume {0}")
    public RangeAssert minVolume(Matcher<Integer> min) {
        jdiAssert(getInt("min", element.core()), min);
        return this;
    }
    public RangeAssert minVolume(int minVolume) { return minVolume(is(minVolume)); }
    @JDIAction("Assert that '{name}' max volume {0}")
    public RangeAssert maxVolume(Matcher<Integer> max) {
        jdiAssert(getInt("max", element.core()), max);
        return this;
    }
    public RangeAssert maxVolume(int maxVolume) { return maxVolume(is(maxVolume)); }

    @JDIAction("Assert that '{name}' step {0}")
    public RangeAssert step(Matcher<Integer> step) {
        jdiAssert(getInt("step", element.core()), step);
        return this;
    }
    public RangeAssert step(int step) { return step(is(step)); }
}