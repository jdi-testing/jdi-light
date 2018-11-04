package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.ui.html.utils.HtmlUtils.getDouble;
import static com.epam.jdi.light.ui.html.utils.HtmlUtils.getInt;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HtmlAssertion extends IsAssert implements ImageAssert, TextAssert,
        LinkAssert, TextAreaAssert, ColorAssert, CheckboxAssert, DateTimeAssert,
        RangeAssert, NumberAssert {

    HtmlElement html;
    public HtmlAssertion(HtmlElement html) { super(html); this.html = html; }

    public void isSelected(Matcher<Boolean> condition) { assertThat(html.isSelected(), condition); }
    public void src(Matcher<String> condition) { assertThat(html.src(), condition); }
    public void alt(Matcher<String> condition) { assertThat(html.alt(), condition); }
    public void ref(Matcher<String> condition) { assertThat(html.ref(), condition); }

    public void height(int value) {
        assertThat(getInt("height", html), is(value));
    }
    public void width(int value) {
        assertThat(getInt("width", html), is(value));
    }

    public void rows(Matcher<Integer> condition) { assertThat(html.rows(), condition); }
    public void cols(Matcher<Integer> condition) { assertThat(html.cols(), condition); }
    public void minlength(Matcher<Integer> condition) { assertThat(html.minlength(), condition); }
    public void maxlength(Matcher<Integer> condition) { assertThat(html.maxlength(), condition); }

    public void color(String color) {
        assertThat(html.color(), is(color));
    }
    public void selected(Boolean value) {
        assertThat(html.isSelected(), is(value));
    }
    public void minValue(double min) {
        assertThat(getDouble("min", html), is(min));
    }
    public void maxValue(double max) {
        assertThat(getDouble("max", html), is(max));}
    public void stepValue(double step) {
        assertThat(getDouble("step", html), is(step));}
    public void placeholder(Matcher<String> value) {
        assertThat(html.placeholder(), value);
    }
    public void number(Matcher<Double> matcher) {
        assertThat(getDouble("value", html), matcher);
    }
    public void min(String min) {
        assertThat(html.min(), is(min));
    }

    public void max(String max) {
        assertThat(html.max(), is(max));
    }

    public void volume(Matcher<Integer> matcher) {
        assertThat(getInt("value", html), matcher);
    }
    public void minVolume(int min) {
        assertThat(getInt("min", html), is(min));
    }
    public void maxVolume(int max) {
        assertThat(getInt("max", html), is(max));
    }
    public void step(int step) {
        assertThat(getInt("step", html), is(step));
    }

    public void date(Matcher<String> date) {
        assertThat(html.value(), date);
    }

    public void month(Matcher<String> month) {
        assertThat(html.value(), month);
    }

    public void week(Matcher<String> week) {
        assertThat(html.value(), week);
    }
    public void time(Matcher<String> time) {
        assertThat(html.value(), time);
    }
}
