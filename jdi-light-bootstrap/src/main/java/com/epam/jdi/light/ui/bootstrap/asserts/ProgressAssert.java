package com.epam.jdi.light.ui.bootstrap.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.bootstrap.elements.common.Progress;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static org.hamcrest.Matchers.is;

/**
 * Created by Aleksandr Khmelinin on 2.10.2019
 * Email: aleksandr_khmelinin@epam.com; Skype: live:bea50ebde18b7f9e
 */
public class ProgressAssert extends UIAssert<ProgressAssert, Progress> {
    @JDIAction("Assert that '{name}' value {0}")
    public ProgressAssert value(Matcher<String> condition) {
        jdiAssert(element.getValue(), condition);
        return this;
    }
    public ProgressAssert value(String value) {
        return value(is(value));
    }

    @JDIAction("Assert that '{name}' color {0}")
    public ProgressAssert color(Matcher<String> condition) {
        jdiAssert(element.getColor(), condition);
        return this;
    }
    public ProgressAssert color(String color) {
        return color(is(color));
    }

    @JDIAction(value = "Get '{name}' min value {0}")
    public ProgressAssert minValue(Matcher<String> condition) {
        jdiAssert(element.getMinValue(), condition);
        return this;
    }

    public ProgressAssert minValue(String minValue) {
        return minValue(is(minValue));
    }

    @JDIAction(value = "Get '{name}' max value {0}")
    public ProgressAssert maxValue(Matcher<String> condition) {
        jdiAssert(element.getMaxValue(), condition);
        return this;
    }

    public ProgressAssert maxValue(String maxValue) {
        return maxValue(is(maxValue));
    }

    @JDIAction(value = "Get '{name}' value {0}")
    public ProgressAssert style(Matcher<String> condition) {
        jdiAssert(element.getStyle(), condition);
        return this;
    }

    public ProgressAssert style(String style) {
        return style(is(style));
    }

    @JDIAction("Assert that '{name}' is animated")
    public ProgressAssert animated(Matcher<String> condition) {
        jdiAssert(element.css("animation-name"), is(condition));
        return this;
    }
    public ProgressAssert animated(String animation) {
        return animated(is(animation));
    }

    @JDIAction("Assert that '{name}' height is {0}")
    public ProgressAssert height(Matcher<Integer> height) {
        jdiAssert(element.core().getSize().getHeight(), height);
        return this;
    }
    public ProgressAssert height(Integer height) {
        return height(is(height));
    }
}
