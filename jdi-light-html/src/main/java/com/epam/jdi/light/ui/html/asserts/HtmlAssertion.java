package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.ui.html.utils.HtmlUtils.getDouble;
import static com.epam.jdi.light.ui.html.utils.HtmlUtils.getInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HtmlAssertion extends IsAssert<HtmlAssertion> implements ImageAssert, TextAssert,
        LinkAssert, TextAreaAssert, ColorAssert, CheckboxAssert, DateTimeAssert,
        RangeAssert, NumberAssert, ProgressAssert, ComboboxAssert {

    HtmlElement html;
    public HtmlAssertion(HtmlElement html) { super(html); this.html = html; }

    /**
     * Custom match src attribute and passed condition
     * @param condition
     */
    public HtmlAssertion src(Matcher<String> condition) {
        assertThat(html.src(), condition);
        return this;
    }

    /**
     * Custom match alt attribute and passed condition
     * @param condition
     */
    public HtmlAssertion alt(Matcher<String> condition) {
        assertThat(html.alt(), condition);
        return this;
    }

    /**
     * Custom match href attribute and passed condition
     * @param condition
     */
    public HtmlAssertion ref(Matcher<String> condition) {
        assertThat(html.ref(), condition);
        return this;
    }

    /**
     * Match passed value with html element height
     * @param value to compare
     */
    public HtmlAssertion height(int value) {
        assertThat(getInt("height", html), is(value));
        return this;
    }

    /**
     * Match passed value with html element width
     * @param value to compare
     */
    public HtmlAssertion width(int value) {
        assertThat(getInt("width", html), is(value));
        return this;
    }

    public HtmlAssertion rows(Matcher<Integer> condition) {
        assertThat(html.rows(), condition);
        return this;
    }
    public HtmlAssertion cols(Matcher<Integer> condition) {
        assertThat(html.cols(), condition);
        return this;
    }
    public HtmlAssertion minlength(Matcher<Integer> condition) {
        assertThat(html.minlength(), condition);
        return this;
    }
    public HtmlAssertion maxlength(Matcher<Integer> condition) {
        assertThat(html.maxlength(), condition);
        return this;
    }

    public HtmlAssertion color(String color) {
        assertThat(html.color(), is(color));
        return this;
    }
    public HtmlAssertion selected(Boolean value) {
        assertThat(html.isSelected(), is(value));
        return this;
    }
    public HtmlAssertion minValue(double min) {
        assertThat(getDouble("min", html), is(min));
        return this;
    }
    public HtmlAssertion maxValue(double max) {
        assertThat(getDouble("max", html), is(max));
        return this;
    }
    public HtmlAssertion stepValue(double step) {
        assertThat(getDouble("step", html), is(step));
        return this;
    }
    public HtmlAssertion placeholder(Matcher<String> value) {
        assertThat(html.placeholder(), value);
        return this;
    }
    public HtmlAssertion number(Matcher<Double> matcher) {
        assertThat(getDouble("value", html), matcher);
        return this;
    }
    public HtmlAssertion min(String min) {
        assertThat(html.min(), is(min));
        return this;
    }

    public HtmlAssertion max(String max) {
        assertThat(html.max(), is(max));
        return this;
    }

    public HtmlAssertion volume(Matcher<Integer> matcher) {
        assertThat(getInt("value", html), matcher);
        return this;
    }
    public HtmlAssertion minVolume(int min) {
        assertThat(getInt("min", html), is(min));
        return this;
    }
    public HtmlAssertion maxVolume(int max) {
        assertThat(getInt("max", html), is(max));
        return this;
    }
    public HtmlAssertion step(int step) {
        assertThat(getInt("step", html), is(step));
        return this;
    }

    public HtmlAssertion date(Matcher<String> date) {
        assertThat(html.value(), date);
        return this;
    }

    public HtmlAssertion month(Matcher<String> month) {
        assertThat(html.value(), month);
        return this;
    }

    public HtmlAssertion week(Matcher<String> week) {
        assertThat(html.value(), week);
        return this;
    }
    public HtmlAssertion time(Matcher<String> time) {
        assertThat(html.value(), time);
        return this;
    }
}
