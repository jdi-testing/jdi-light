package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.NumberSelector;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class NumberAssert extends UIAssert<NumberAssert, NumberSelector>
    implements ITextAssert<NumberAssert> {

    @JDIAction("Assert that '{name}' text {0}")
    public NumberAssert text(Matcher<String> condition) {
        jdiAssert(element.attr("value"), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' minValue {0}")
    public NumberAssert min(Matcher<Double> min) {
        jdiAssert(getDouble("min", element.core()), min);
        return this;
    }
    public NumberAssert min(double min) { return min(is(min)); }

    @JDIAction("Assert that '{name}' maxValue {0}")
    public NumberAssert max(Matcher<Double> max) {
        jdiAssert(getDouble("max", element.core()), max);
        return this;
    }
    public NumberAssert max(double max) { return max(is(max)); }

    @JDIAction("Assert that '{name}' step {0}")
    public NumberAssert step(Matcher<Double> step) {
        jdiAssert(getDouble("step", element.core()), step);
        return this;
    }
    public NumberAssert step(double step) { return step(is(step)); }

    @JDIAction("Assert that '{name}' placeholder {0}")
    public NumberAssert placeholder(Matcher<String> placeholder) {
        jdiAssert(element.placeholder(), placeholder);
        return this;
    }
    public NumberAssert placeholder(String placeholder) { return placeholder(is(placeholder)); }

    @JDIAction("Assert that '{name}' number {0}")
    public NumberAssert number(Matcher<Double> number) {
        jdiAssert(getDouble("value", element.core()), number);
        return this;
    }
    public NumberAssert number(double number) { return number(is(number)); }
}