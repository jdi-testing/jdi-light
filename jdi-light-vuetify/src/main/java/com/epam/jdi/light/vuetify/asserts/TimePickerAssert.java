package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.time.LocalTime;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TimePickerAssert extends UIAssert<TimePickerAssert, TimePicker> {

    @JDIAction("Assert that list of disabled hours/minutes is not empty")
    public TimePickerAssert disabledHoursOrMinutesNonEmptyList() {
        jdiAssert(element().getDisabledHoursOrMinutes().size(), Matchers.greaterThanOrEqualTo(1));
        return this;
    }

    @JDIAction("Assert that enabled hours/minutes are clickable")
    public TimePickerAssert clickableEnabledHoursOrMinutes() {
        element().getEnabledHoursOrMinutesElements().stream().forEach(elem -> {
                    elem.hover();
                    Timer.waitCondition(() -> elem.isClickable());
                    jdiAssert(elem.isClickable(), Matchers.is(true));
                }
        );
        return this;
    }

    @JDIAction("Assert that disabled hours/minutes are non-clickable")
    public TimePickerAssert nonClickableDisabledHoursOrMinutes() {
        element().getDisabledHoursOrMinutesElements().stream().forEach(elem ->
                jdiAssert(!elem.isClickable(), Matchers.is(true))
        );
        return this;
    }

    @JDIAction("Assert that all enabled hours/minutes are correct")
    public TimePickerAssert properEnabledHoursOrMinutes(List<String> enabledHoursOrMinutes) {
        Timer.waitCondition(() -> element().getEnabledHoursOrMinutes().equals(enabledHoursOrMinutes));
        jdiAssert(element().getEnabledHoursOrMinutes(), Matchers.containsInAnyOrder(enabledHoursOrMinutes.toArray()));
        return this;
    }

    @JDIAction("Assert that all disabled hours/minutes are correct")
    public TimePickerAssert properDisabledHoursOrMinutes(List<String> disabledHoursOrMinutes) {
        Timer.waitCondition(() -> element().getDisabledHoursOrMinutes().equals(disabledHoursOrMinutes));
        jdiAssert(element().getDisabledHoursOrMinutes(), Matchers.containsInAnyOrder(disabledHoursOrMinutes.toArray()));
        return this;
    }

    @JDIAction("Assert that picker has twelve hour format")
    public TimePickerAssert twelveHourFormat() {
        jdiAssert(element().getAllHoursElements().size(), Matchers.equalTo(12));
        return this;
    }

    @JDIAction("Assert that picker has twenty-four hour format")
    public TimePickerAssert twentyFourHourFormat() {
        jdiAssert(element().getAllHoursElements().size(), Matchers.equalTo(24));
        return this;
    }

    @JDIAction("Assert that field color is correct")
    public TimePickerAssert color(String expectedColor) {
        jdiAssert(element().getColor(), Matchers.is(expectedColor));
        return this;
    }

    @JDIAction("Assert that title field has correct hours")
    public TimePickerAssert hours(String expectedHours) {
        jdiAssert(element().getHours(), Matchers.is(expectedHours));
        return this;
    }

    @JDIAction("Assert that title field has correct minutes")
    public TimePickerAssert minutes(String expectedMinutes) {
        jdiAssert(element().getMinutes(), Matchers.is(expectedMinutes));
        return this;
    }

    @JDIAction("Assert that title field has correct seconds")
    public TimePickerAssert seconds(String expectedSeconds) {
        jdiAssert(element().getSeconds(), Matchers.is(expectedSeconds));
        return this;
    }

    @JDIAction("Assert that title field has AM period")
    public TimePickerAssert amPeriod() {
        jdiAssert(element().amPmStatus(), Matchers.is("AM"));
        return this;
    }

    @JDIAction("Assert that title field has PM period")
    public TimePickerAssert pmPeriod() {
        jdiAssert(element().amPmStatus(), Matchers.is("PM"));
        return this;
    }

    @JDIAction("Assert that picker is disabled")
    public TimePickerAssert disabled() {
        if (element().getAllHoursElements().size() == 12) {
            jdiAssert(element().getDisabledHoursOrMinutesElements().size(), Matchers.is(12));
        } else {
            jdiAssert(element().getDisabledHoursOrMinutesElements().size(), Matchers.is(24));
        }
        return this;
    }

    @JDIAction("Assert that active hours/minutes are correct")
    public TimePickerAssert activeHoursOrMinutes(String expectedValue) {
        jdiAssert(element().getActiveHoursMinutes(), Matchers.is(expectedValue));
        return this;
    }

    @JDIAction("Assert that non-active hours/minutes are correct")
    public TimePickerAssert nonActiveHoursOrMinutes(String expectedValue) {
        jdiAssert(element().getActiveHoursMinutes(), Matchers.not(expectedValue));
        return this;
    }

    @JDIAction("Assert that elevation level is correct")
    public TimePickerAssert elevation(String expectedElevation) {
        Timer.waitCondition(() -> element().getElevation().equals(expectedElevation));
        jdiAssert(element().getElevation(), Matchers.containsString(expectedElevation));
        return this;
    }

    @JDIAction("Assert that title does not exist")
    public TimePickerAssert noTitle() {
        jdiAssert(element().getTitleElement().isNotExist(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that width of the picker is correct")
    public TimePickerAssert pickerWidth(int expectedWidth) {
        jdiAssert(element().getPickerWidth(), Matchers.is(expectedWidth));
        return this;
    }

    @JDIAction("Assert that time shown in title is correct")
    public TimePickerAssert time(String expectedTime) {
        jdiAssert(element().getTime(), Matchers.is(expectedTime));
        return this;
    }

    @JDIAction("Assert that time shown in title is correct, using local time format")
    public TimePickerAssert localTime(LocalTime expectedLocalTime) {
        jdiAssert(element().getLocalTime(), Matchers.is(expectedLocalTime));
        return this;
    }

    @JDIAction("Assert that time shown in result time field is  correct")
    public TimePickerAssert resultTime(String expectedResultTime) {
        jdiAssert(element().getResultTime(), Matchers.is(expectedResultTime));
        return this;
    }

    @JDIAction("Assert that time shown in result time field is  correct, using local time format")
    public TimePickerAssert resultLocalTime(LocalTime expectedResultLocalTime) {
        jdiAssert(element().getResultLocalTime(), Matchers.is(expectedResultLocalTime));
        return this;
    }
}
