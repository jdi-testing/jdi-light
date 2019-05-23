package com.epam.jdi.light.ui.html.asserts;

import com.epam.jdi.light.asserts.IsAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.ui.html.base.HtmlElement;
import org.hamcrest.Matcher;

import static com.epam.jdi.light.ui.html.utils.HtmlUtils.*;
import static org.hamcrest.Matchers.is;
import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;

public class HtmlAssertion extends IsAssert<HtmlAssertion> implements ImageAssert, TextAssert,
        LinkAssert, TextAreaAssert, ColorAssert, CheckboxAssert, DateTimeAssert,
        RangeAssert, NumberAssert, ProgressAssert, ComboboxAssert {

    HtmlElement html;
    public HtmlAssertion(HtmlElement html) { super(html); this.html = html; }

    /**
     * Custom match src attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' label {0}")
    public HtmlAssertion label(Matcher<String> condition) {
        jdiAssert(html.labelText(), condition);
        return this;
    }
    /**
     * Custom match src attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' src {0}")
    public HtmlAssertion src(Matcher<String> condition) {
        jdiAssert(html.src(), condition);
        return this;
    }

    /**
     * Custom match alt attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' alt {0}")
    public HtmlAssertion alt(Matcher<String> condition) {
        jdiAssert(html.alt(), condition);
        return this;
    }

    /**
     * Custom match href attribute and passed condition
     * @param condition
     */
    @JDIAction("Assert that '{name}' ref {0}")
    public HtmlAssertion ref(Matcher<String> condition) {
        jdiAssert(html.ref(), condition);
        return this;
    }

    /**
     * Match passed value with html element height
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' height {0}")
    public HtmlAssertion height(Matcher<Integer> condition) {
        jdiAssert(getInt("height", html), condition);
        return this;
    }

    /**
     * Match passed value with html element width
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' width {0}")
    public HtmlAssertion width(Matcher<Integer> condition) {
        jdiAssert(getInt("width", html), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' rows count {0}")
    public HtmlAssertion rowsCount(Matcher<Integer> condition) {
        jdiAssert(html.rows(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' columns count {0}")
    public HtmlAssertion colsCount(Matcher<Integer> condition) {
        jdiAssert(html.cols(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' minlength {0}")
    public HtmlAssertion minlength(Matcher<Integer> condition) {
        jdiAssert(html.minlength(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' maxlength {0}")
    public HtmlAssertion maxlength(Matcher<Integer> condition) {
        jdiAssert(html.maxlength(), condition);
        return this;
    }

    @JDIAction("Assert that '{name}' color is {0}")
    public HtmlAssertion color(String color) {
        jdiAssert(html.color(), is(color));
        return this;
    }
    @JDIAction("Assert that '{name}' is selected")
    public HtmlAssertion selected() {
        jdiAssert(html.isSelected() ? "selected" : "not selected", is("selected"));
        return this;
    }
    @JDIAction("Assert that '{name}' is not selected")
    public HtmlAssertion deselected() {
        jdiAssert(html.isSelected() ? "selected" : "not selected", is("not selected"));
        return this;
    }
    @JDIAction("Assert that '{name}' minValue {0}")
    public HtmlAssertion minValue(Matcher<Double> min) {
        jdiAssert(getDouble("min", html), min);
        return this;
    }
    @JDIAction("Assert that '{name}' maxValue {0}")
    public HtmlAssertion maxValue(Matcher<Double> max) {
        jdiAssert(getDouble("max", html), max);
        return this;
    }
    @JDIAction("Assert that '{name}' step {0}")
    public HtmlAssertion stepValue(Matcher<Double> step) {
        jdiAssert(getDouble("step", html), step);
        return this;
    }
    @JDIAction("Assert that '{name}' placeholder {0}")
    public HtmlAssertion placeholder(Matcher<String> placeholder) {
        jdiAssert(html.placeholder(), placeholder);
        return this;
    }
    @JDIAction("Assert that '{name}' number {0}")
    public HtmlAssertion number(Matcher<Double> number) {
        jdiAssert(getDouble("value", html), number);
        return this;
    }
    @JDIAction("Assert that '{name}' min {0}")
    public HtmlAssertion min(Matcher<Float> min) {
        jdiAssert(getFloat("min", html), min);
        return this;
    }

    @JDIAction("Assert that '{name}' max {0}")
    public HtmlAssertion max(Matcher<Float> max) {
        jdiAssert(getFloat("max", html), max);
        return this;
    }

    @JDIAction("Assert that '{name}' volume {0}")
    public HtmlAssertion volume(Matcher<Integer> volume) {
        jdiAssert(getInt("value", html), volume);
        return this;
    }
    @JDIAction("Assert that '{name}' min volume {0}")
    public HtmlAssertion minVolume(Matcher<Integer> min) {
        jdiAssert(getInt("min", html), min);
        return this;
    }
    @JDIAction("Assert that '{name}' max volume {0}")
    public HtmlAssertion maxVolume(Matcher<Integer> max) {
        jdiAssert(getInt("max", html), max);
        return this;
    }
    @JDIAction("Assert that '{name}' step {0}")
    public HtmlAssertion step(Matcher<Integer> step) {
        jdiAssert(getInt("step", html), step);
        return this;
    }

    @JDIAction("Assert that '{name}' date {0}")
    public HtmlAssertion date(Matcher<String> date) {
        jdiAssert(html.value(), date);
        return this;
    }

    @JDIAction("Assert that '{name}' month {0}")
    public HtmlAssertion month(Matcher<String> month) {
        jdiAssert(html.value(), month);
        return this;
    }

    @JDIAction("Assert that '{name}' week {0}")
    public HtmlAssertion week(Matcher<String> week) {
        jdiAssert(html.value(), week);
        return this;
    }
    @JDIAction("Assert that '{name}' time {0}")
    public HtmlAssertion time(Matcher<String> time) {
        jdiAssert(html.value(), time);
        return this;
    }
}
