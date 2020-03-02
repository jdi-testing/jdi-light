package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.NumberSelector;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getDouble;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class NumberAssert extends UIAssert<NumberAssert, NumberSelector>
        implements ITextAssert<NumberAssert> {
    
    @JDIAction("Assert that '{name}' text {0}")
    public NumberAssert text(Matcher<String> condition, String... messages) {
        jdiAssert(element.attr("value"), condition, messages);
        return this;
    }
    
    @JDIAction("Assert that '{name}' minValue {0}")
    public NumberAssert min(Matcher<Double> min, String... messages) {
        jdiAssert(getDouble("min", element.core()), min, messages);
        return this;
    }
    
    public NumberAssert min(double min, String... messages) {
        return min(Matchers.is(min), messages);
    }
    
    @JDIAction("Assert that '{name}' maxValue {0}")
    public NumberAssert max(Matcher<Double> max, String... messages) {
        jdiAssert(getDouble("max", element.core()), max, messages);
        return this;
    }
    
    public NumberAssert max(double max, String... messages) {
        return max(Matchers.is(max), messages);
    }
    
    @JDIAction("Assert that '{name}' step {0}")
    public NumberAssert step(Matcher<Double> step, String... messages) {
        jdiAssert(getDouble("step", element.core()), step, messages);
        return this;
    }
    
    public NumberAssert step(double step, String... messages) {
        return step(Matchers.is(step), messages);
    }
    
    @JDIAction("Assert that '{name}' placeholder {0}")
    public NumberAssert placeholder(Matcher<String> placeholder, String... messages) {
        jdiAssert(element.placeholder(), placeholder, messages);
        return this;
    }
    
    public NumberAssert placeholder(String placeholder, String... messages) {
        return placeholder(Matchers.is(placeholder), messages);
    }
    
    @JDIAction("Assert that '{name}' number {0}")
    public NumberAssert number(Matcher<Double> number, String... messages) {
        jdiAssert(getDouble("value", element.core()), number, messages);
        return this;
    }
    
    public NumberAssert number(double number, String... messages) {
        return number(Matchers.is(number), messages);
    }
}