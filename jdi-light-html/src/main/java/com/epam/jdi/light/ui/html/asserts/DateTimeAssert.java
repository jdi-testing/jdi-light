package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.elements.common.DateTimeSelector;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.ui.html.HtmlUtils.getFloat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DateTimeAssert extends UIAssert<DateTimeAssert, DateTimeSelector>
    implements ITextAssert<DateTimeAssert> {

    @JDIAction("Assert that '{name}' text {0}")
    public DateTimeAssert text(Matcher<String> condition) {
        jdiAssert(element.value(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' date {0}")
    public DateTimeAssert date(Matcher<String> date) {
        jdiAssert(element.value(), date);
        return this;
    }
    public DateTimeAssert date(String date) {
        return date(Matchers.is(date));
    }

    @JDIAction("Assert that '{name}' month {0}")
    public DateTimeAssert month(Matcher<String> month) {
        jdiAssert(element.value(), month);
        return this;
    }
    public DateTimeAssert month(String month) {
        return month(Matchers.is(month));
    }

    @JDIAction("Assert that '{name}' week {0}")
    public DateTimeAssert week(Matcher<String> week) {
        jdiAssert(element.value(), week);
        return this;
    }
    public DateTimeAssert week(String week) {
        return week(Matchers.is(week));
    }

    @JDIAction("Assert that '{name}' time {0}")
    public DateTimeAssert time(Matcher<String> time) {
        jdiAssert(element.value(), time);
        return this;
    }
    public DateTimeAssert time(String time) { return time(Matchers.is(time)); }

    @JDIAction("Assert that '{name}' min {0}")
    public DateTimeAssert min(Matcher<Float> min) {
        jdiAssert(getFloat("min", element.core()), min);
        return this;
    }
    public DateTimeAssert min(float min) {
        return min(Matchers.is(min));
    }

    @JDIAction("Assert that '{name}' max {0}")
    public DateTimeAssert max(Matcher<Float> max) {
        jdiAssert(getFloat("max", element.core()), max);
        return this;
    }
    public DateTimeAssert max(float max) {
        return max(Matchers.is(max));
    }
}