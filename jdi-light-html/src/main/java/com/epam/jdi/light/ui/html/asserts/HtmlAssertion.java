package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
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
        waitAssert(() -> assertThat(html.src(), condition), name);
        return this;
    }

    /**
     * Custom match alt attribute and passed condition
     * @param condition
     */
    public HtmlAssertion alt(Matcher<String> condition) {
        waitAssert(() -> assertThat(html.alt(), condition), name);
        return this;
    }

    /**
     * Custom match href attribute and passed condition
     * @param condition
     */
    public HtmlAssertion ref(Matcher<String> condition) {
        waitAssert(() -> assertThat(html.ref(), condition), name);
        return this;
    }

    /**
     * Match passed value with html element height
     * @param value to compare
     */
    public HtmlAssertion height(int value) {
        waitAssert(() -> assertThat(getInt("height", html), is(value)), name);
        return this;
    }

    /**
     * Match passed value with html element width
     * @param value to compare
     */
    public HtmlAssertion width(int value) {
        waitAssert(() -> assertThat(getInt("width", html), is(value)), name);
        return this;
    }

    public HtmlAssertion rows(Matcher<Integer> condition) {
        waitAssert(() -> assertThat(html.rows(), condition), name);
        return this;
    }
    public HtmlAssertion cols(Matcher<Integer> condition) {
        waitAssert(() -> assertThat(html.cols(), condition), name);
        return this;
    }
    public HtmlAssertion minlength(Matcher<Integer> condition) {
        waitAssert(() -> assertThat(html.minlength(), condition), name);
        return this;
    }
    public HtmlAssertion maxlength(Matcher<Integer> condition) {
        waitAssert(() -> assertThat(html.maxlength(), condition), name);
        return this;
    }

    public HtmlAssertion color(String color) {
        waitAssert(() -> assertThat(html.color(), is(color)), name);
        return this;
    }
    public HtmlAssertion selected(Boolean value) {
        waitAssert(() -> assertThat(html.isSelected(), is(value)), name);
        return this;
    }
    public HtmlAssertion minValue(double min) {
        waitAssert(() -> assertThat(getDouble("min", html), is(min)), name);
        return this;
    }
    public HtmlAssertion maxValue(double max) {
        waitAssert(() -> assertThat(getDouble("max", html), is(max)), name);
        return this;
    }
    public HtmlAssertion stepValue(double step) {
        waitAssert(() -> assertThat(getDouble("step", html), is(step)), name);
        return this;
    }
    public HtmlAssertion placeholder(Matcher<String> value) {
        waitAssert(() -> assertThat(html.placeholder(), value), name);
        return this;
    }
    public HtmlAssertion number(Matcher<Double> matcher) {
        waitAssert(() -> assertThat(getDouble("value", html), matcher), name);
        return this;
    }
    public HtmlAssertion min(String min) {
        waitAssert(() -> assertThat(html.min(), is(min)), name);
        return this;
    }

    public HtmlAssertion max(String max) {
        waitAssert(() -> assertThat(html.max(), is(max)), name);
        return this;
    }

    public HtmlAssertion volume(Matcher<Integer> matcher) {
        waitAssert(() -> assertThat(getInt("value", html), matcher), name);
        return this;
    }
    public HtmlAssertion minVolume(int min) {
        waitAssert(() -> assertThat(getInt("min", html), is(min)), name);
        return this;
    }
    public HtmlAssertion maxVolume(int max) {
        waitAssert(() -> assertThat(getInt("max", html), is(max)), name);
        return this;
    }
    public HtmlAssertion step(int step) {
        waitAssert(() -> assertThat(getInt("step", html), is(step)), name);
        return this;
    }

    public HtmlAssertion date(Matcher<String> date) {
        waitAssert(() -> assertThat(html.value(), date), name);
        return this;
    }

    public HtmlAssertion month(Matcher<String> month) {
        waitAssert(() -> assertThat(html.value(), month), name);
        return this;
    }

    public HtmlAssertion week(Matcher<String> week) {
        waitAssert(() -> assertThat(html.value(), week), name);
        return this;
    }
    public HtmlAssertion time(Matcher<String> time) {
        waitAssert(() -> assertThat(html.value(), time), name);
        return this;
    }
}
