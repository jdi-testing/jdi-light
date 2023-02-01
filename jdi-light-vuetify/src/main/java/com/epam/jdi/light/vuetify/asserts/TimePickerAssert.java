package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import java.util.Arrays;
import java.util.stream.IntStream;
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
        String actualTitleText = element().titleText();
        String errorMsg = format("Expecting '%s' title, but was '%s'", titleTimeText, actualTitleText);
        jdiAssert(actualTitleText, Matchers.is(titleTimeText), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' time in title is '{0}'")
    public TimePickerAssert time(final LocalTime localTime) {
        LocalTime actualLocalTime = element().titleTime();
        String errorMsg = format("Expecting '%s' title time, but was '%s'", localTime, actualLocalTime);
        jdiAssert(actualLocalTime, Matchers.is(localTime), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' in title are '{0}'")
    public TimePickerAssert hours(int hours) {
        int actualHours = element().titleHours();
        String errorMsg = format("Expecting '%s' hours in title, but was '%s'", actualHours, hours);
        jdiAssert(actualHours, Matchers.is(hours), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' in title are '{0}'")
    public TimePickerAssert minutes(int minutes) {
        int actualMinutes = element().titleMinutes();
        String errorMsg = format("Expecting '%s' hours in title, but was '%s'", actualMinutes, minutes);
        jdiAssert(actualMinutes, Matchers.is(minutes), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' in title are '{0}'")
    public TimePickerAssert seconds(int seconds) {
        int actualSeconds = element().titleSeconds();
        String errorMsg = format("Expecting '%s' hours in title, but was '%s'", actualSeconds, seconds);
        jdiAssert(actualSeconds, Matchers.is(seconds), errorMsg);
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
        int actualSelectedNumber = element().selectedNumber();
        String errorMsg = format("Expecting '%s' numbers to be selected, But selected number was '%s'",
            expectedSelectedNumber, actualSelectedNumber);
        jdiAssert(actualSelectedNumber, Matchers.is(expectedSelectedNumber), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' has disabled numbers from {0} to {1} inclusive")
    public TimePickerAssert disabledNumbersRange(int from, int to) {
        return disabledNumbers(IntStream.rangeClosed(from, to).boxed().toArray(Integer[]::new));
    }

    @JDIAction("Assert that '{name}' has enabled numbers from {0} to {1} inclusive")
    public TimePickerAssert enabledNumbersRange(int from, int to) {
        return enabledNumbers(IntStream.rangeClosed(from, to).boxed().toArray(Integer[]::new));
    }

    @JDIAction("Assert that '{name}' is 12h")
    public TimePickerAssert format12() {
        String errorMsg = "Timepicker have 24h format";
        jdiAssert(element().isAmPm() ? "12h" : "24h", Matchers.is("12h"), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' is 24h")
    public TimePickerAssert format24() {
        String errorMsg = "Timepicker have 12h format";
        jdiAssert(element().isAmPm() ? "12h" : "24h", Matchers.is("24h"), errorMsg);
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
        String actualAmPmPeriod = element().amPmPeriod();
        String errorMsg = format("Expecting '%s' period, but was '%s'", amPmPeriod, actualAmPmPeriod);
        jdiAssert(actualAmPmPeriod, Matchers.is(amPmPeriod), errorMsg);
        return this;
    }

    @JDIAction("Assert that '{name}' is landscape")
    public TimePickerAssert landscape() {
        jdiAssert(element().isLandscape() ? "landscape" : "not landscape", Matchers.is("landscape"), "Element is not landscape");
        return this;
    }

    @JDIAction("Assert that '{name}' is not landscape")
    public TimePickerAssert notLandscape() {
        jdiAssert(element().isLandscape() ? "landscape" : "not landscape", Matchers.is("not landscape"), "Element is landscape");
        return this;
    }
}
