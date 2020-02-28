package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.DateTimeSelector;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getFloat;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DateTimeAssert extends UIAssert<DateTimeAssert, DateTimeSelector>
        implements ITextAssert<DateTimeAssert> {
    
    @JDIAction("Assert that '{name}' text {0}")
    public DateTimeAssert text(Matcher<String> condition, String... messages) {
        jdiAssert(element.value(), condition, messages);
        return this;
    }
    
    @JDIAction("Assert that '{name}' date {0}")
    public DateTimeAssert date(Matcher<String> date, String... messages) {
        jdiAssert(element.value(), date, messages);
        return this;
    }
    
    public DateTimeAssert date(String date, String... messages) {
        return date(Matchers.is(date), messages);
    }
    
    @JDIAction("Assert that '{name}' month {0}")
    public DateTimeAssert month(Matcher<String> month, String... messages) {
        jdiAssert(element.value(), month, messages);
        return this;
    }
    
    public DateTimeAssert month(String month, String... messages) {
        return month(Matchers.is(month), messages);
    }
    
    @JDIAction("Assert that '{name}' week {0}")
    public DateTimeAssert week(Matcher<String> week, String... messages) {
        jdiAssert(element.value(), week, messages);
        return this;
    }
    
    public DateTimeAssert week(String week, String... messages) {
        return week(Matchers.is(week), messages);
    }
    
    @JDIAction("Assert that '{name}' time {0}")
    public DateTimeAssert time(Matcher<String> time, String... messages) {
        jdiAssert(element.value(), time, messages);
        return this;
    }
    
    public DateTimeAssert time(String time, String... messages) {
        return time(Matchers.is(time), messages);
    }
    
    @JDIAction("Assert that '{name}' min {0}")
    public DateTimeAssert min(Matcher<Float> min, String... messages) {
        jdiAssert(getFloat("min", element.core()), min, messages);
        return this;
    }
    
    public DateTimeAssert min(float min,String... messages) {
        return min(Matchers.is(min), messages);
    }
    
    @JDIAction("Assert that '{name}' max {0}")
    public DateTimeAssert max(Matcher<Float> max, String... messages) {
        jdiAssert(getFloat("max", element.core()), max, messages);
        return this;
    }
    
    public DateTimeAssert max(float max, String... messages) {
        return max(Matchers.is(max), messages);
    }
}