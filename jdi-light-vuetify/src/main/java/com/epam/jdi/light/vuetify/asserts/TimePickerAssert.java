package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;
import com.epam.jdi.light.asserts.generic.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

import java.time.LocalTime;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;


public class TimePickerAssert extends UIAssert<TimePickerAssert, TimePicker> implements
        ColorAssert<TimePickerAssert, TimePicker>, ThemeAssert<TimePickerAssert, TimePicker>,
        ElevationAssert<TimePickerAssert, TimePicker>, ReadOnlyAssert<TimePickerAssert, TimePicker>,
        MeasurementAssert<TimePickerAssert, TimePicker> {

    @JDIAction(value = "Assert that '{name}' time in title is '{0}'", isAssert = true)
    public TimePickerAssert title(final String titleTimeText) {
        jdiAssert(element().titleText(), Matchers.is(titleTimeText));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' time in title is '{0}'", isAssert = true)
    public TimePickerAssert time(final LocalTime localTime) {
        jdiAssert(element().titleTime(), Matchers.is(localTime));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' hours in title are '{0}'", isAssert = true)
    public TimePickerAssert hours(int hours) {
        jdiAssert(element().titleHours(), Matchers.is(hours));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' minutes in title are '{0}'", isAssert = true)
    public TimePickerAssert minutes(int minutes) {
        jdiAssert(element().titleMinutes(), Matchers.is(minutes));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' seconds in title are '{0}'", isAssert = true)
    public TimePickerAssert seconds(int seconds) {
        jdiAssert(element().titleSeconds(), Matchers.is(seconds));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' disabled numbers", isAssert = true)
    public TimePickerAssert disabledNumbers(Integer... expectedDisabledNumbers) {
        jdiAssert(element().disabledClockNumbers(), Matchers.containsInAnyOrder(expectedDisabledNumbers));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' enabled numbers", isAssert = true)
    public TimePickerAssert enabledNumbers(Integer... expectedEnabledNumbers) {
        jdiAssert(element().enabledClockNumbers(), Matchers.contains(expectedEnabledNumbers));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has '{0}' selected number", isAssert = true)
    public TimePickerAssert selectedNumber(int expectedSelectedNumber) {
        jdiAssert(element().selectedNumber(), Matchers.is(expectedSelectedNumber));
        return this;
    }

    // @todo #5048 Fix required. Not only h can be used (regional specific)
    @JDIAction(value = "Assert that '{name}' is 12h", isAssert = true)
    public TimePickerAssert format12() {
        jdiAssert(element().is12h() ? "12h" : "24h", Matchers.is("12h"));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is 24h", isAssert = true)
    public TimePickerAssert format24() {
        jdiAssert(element().is12h() ? "12h" : "24h", Matchers.is("24h"));
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' background color is {0}", isAssert = true)
    public TimePickerAssert backgroundColor(String color) {
        jdiAssert(element().titleBackgroundColor(), Matchers.is(color));
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is disabled", isAssert = true)
    public TimePickerAssert disabled() {
        jdiAssert(element().isDisabled(), Matchers.is(true), "TimePicker is enabled");
        return this;
    }

    @Override
    @JDIAction(value = "Assert that '{name}' is enabled", isAssert = true)
    public TimePickerAssert enabled() {
        jdiAssert(element().isDisabled(), Matchers.is(false), "TimePicker is disabled");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' title field has AM period", isAssert = true)
    public TimePickerAssert amPeriod() {
        return period("AM");
    }

    @JDIAction(value = "Assert that '{name}' title field has PM period", isAssert = true)
    public TimePickerAssert pmPeriod() {
        return period("PM");
    }

    private TimePickerAssert period(final String amPmPeriod) {
        jdiAssert(element().amPmPeriod(), Matchers.is(amPmPeriod));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is landscape", isAssert = true)
    public TimePickerAssert landscape() {
        jdiAssert(element().isLandscape(), Matchers.is(true), "TimePicker is not landscape");
        return this;
    }

    @JDIAction(value = "Assert that '{name}' is not landscape", isAssert = true)
    public TimePickerAssert notLandscape() {
        jdiAssert(element().isLandscape(), Matchers.is(false), "TimePicker is landscape");
        return this;
    }
}
