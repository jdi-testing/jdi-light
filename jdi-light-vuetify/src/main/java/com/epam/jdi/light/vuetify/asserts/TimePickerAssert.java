package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import java.util.Arrays;
import org.hamcrest.Matchers;

import java.time.LocalTime;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static java.lang.String.format;

public class TimePickerAssert extends UIAssert<TimePickerAssert, TimePicker> implements
        ColorAssert<TimePickerAssert, TimePicker>, ThemeAssert<TimePickerAssert, TimePicker>,
        ElevationAssert<TimePickerAssert, TimePicker>, ReadOnlyAssert<TimePickerAssert, TimePicker>,
        MeasurementAssert<TimePickerAssert, TimePicker> {

    @JDIAction("Assert that '{name}' time in title is '{0}'")
    public TimePickerAssert title(final String titleTimeText) {
        jdiAssert(element().titleText(), Matchers.is(titleTimeText));
        return this;
    }

    @JDIAction("Assert that '{name}' time in title is '{0}'")
    public TimePickerAssert time(final LocalTime localTime) {
        jdiAssert(element().titleTime(), Matchers.is(localTime));
        return this;
    }

    @JDIAction("Assert that '{name}' in title are '{0}'")
    public TimePickerAssert hours(int hours) {
        jdiAssert(element().titleHours(), Matchers.is(hours));
        return this;
    }

    @JDIAction("Assert that '{name}' in title are '{0}'")
    public TimePickerAssert minutes(int minutes) {
        jdiAssert(element().titleMinutes(), Matchers.is(minutes));
        return this;
    }

    @JDIAction("Assert that '{name}' in title are '{0}'")
    public TimePickerAssert seconds(int seconds) {
        jdiAssert(element().titleSeconds(), Matchers.is(seconds));
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' disabled numbers")
    public TimePickerAssert disabledNumbers(Integer... expectedDisabledNumbers) {
        List<Integer> actualDisabledNumbers = element().disabledClockNumbers();
        String errorMsg = format("Expecting '%s' numbers to be disabled. But disabled numbers were '%s'",
            Arrays.asList(expectedDisabledNumbers), actualDisabledNumbers);
        jdiAssert(actualDisabledNumbers, Matchers.containsInAnyOrder(expectedDisabledNumbers), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' enabled numbers")
    public TimePickerAssert enabledNumbers(Integer... expectedEnabledNumbers) {
        List<Integer> actualEnabledNumbers = element().enabledClockNumbers();
        String errorMsg = format("Expecting '%s' numbers to be enabled. But enabled numbers were '%s'",
            Arrays.asList(expectedEnabledNumbers), actualEnabledNumbers);
        jdiAssert(actualEnabledNumbers, Matchers.contains(expectedEnabledNumbers), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' has '{0}' selected number")
    public TimePickerAssert selectedNumber(int expectedSelectedNumber) {
        jdiAssert(element().selectedNumber(), Matchers.is(expectedSelectedNumber));
        return this;
    }

    @JDIAction("Assert that '{name}' is 12h")
    public TimePickerAssert format12() {
        jdiAssert(element().is12h() ? "12h" : "24h", Matchers.is("12h"));
        return this;
    }

    @JDIAction("Assert that '{name}' is 24h")
    public TimePickerAssert format24() {
        jdiAssert(element().is12h() ? "12h" : "24h", Matchers.is("24h"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' background color is {0}")
    public TimePickerAssert backgroundColor(String color) {
        String actualBackgroundColor = element().titleBackgroundColor();
        String errorMsg = format("Expecting '%s' title background color, but was '%s'", color, actualBackgroundColor);
        jdiAssert(actualBackgroundColor, Matchers.is(color), errorMsg);
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is disabled")
    public TimePickerAssert disabled() {
        jdiAssert(element().isDisabled() ? "disabled" : "enabled", Matchers.is("disabled"));
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public TimePickerAssert enabled() {
        jdiAssert(element().isDisabled() ? "disabled" : "enabled", Matchers.is("enabled"));
        return this;
    }

    @JDIAction("Assert that '{name}' title field has AM period")
    public TimePickerAssert amPeriod() {
        return period("AM");
    }

    @JDIAction("Assert that '{name}' title field has PM period")
    public TimePickerAssert pmPeriod() {
        return period("PM");
    }

    private TimePickerAssert period(final String amPmPeriod) {
        jdiAssert(element().amPmPeriod(), Matchers.is(amPmPeriod));
        return this;
    }

    @JDIAction("Assert that '{name}' is landscape")
    public TimePickerAssert landscape() {
        jdiAssert(element().isLandscape() ? "landscape" : "not landscape", Matchers.is("landscape"));
        return this;
    }

    @JDIAction("Assert that '{name}' is not landscape")
    public TimePickerAssert notLandscape() {
        jdiAssert(element().isLandscape() ? "landscape" : "not landscape", Matchers.is("not landscape"));
        return this;
    }
}
