package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;
import com.epam.jdi.light.vuetify.interfaces.asserts.ColorAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ElevationAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.MeasurementAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ReadOnlyAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import com.jdiai.tools.Timer;
import org.hamcrest.Matchers;

import java.time.LocalTime;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TimePickerAssert extends UIAssert<TimePickerAssert, TimePicker> implements
        ColorAssert<TimePickerAssert, TimePicker>, ThemeAssert<TimePickerAssert, TimePicker>,
        ElevationAssert<TimePickerAssert, TimePicker>, ReadOnlyAssert<TimePickerAssert, TimePicker>,
        MeasurementAssert<TimePickerAssert, TimePicker> {

    @JDIAction("Assert that '{name}' list of disabled hours/minutes is not empty")
    public TimePickerAssert disabledHoursOrMinutesNonEmptyList() {
        jdiAssert(element().getDisabledHoursOrMinutes().size(), Matchers.greaterThanOrEqualTo(1),
                "List of disabled hours/minutes is empty");
        return this;
    }

    @JDIAction("Assert that '{name}' enabled hours/minutes are clickable")
    public TimePickerAssert clickableEnabledHoursOrMinutes() {
        element().getEnabledHoursOrMinutesElements().stream().forEach(elem -> {
                    elem.hover();
                    Timer.waitCondition(() -> elem.isClickable());
                    jdiAssert(elem.isClickable(), Matchers.is(true), "Enabled hours/minutes are clickable");
                }
        );
        return this;
    }

    @JDIAction("Assert that '{name}' disabled hours/minutes are non-clickable")
    public TimePickerAssert nonClickableDisabledHoursOrMinutes() {
        element().getDisabledHoursOrMinutesElements().stream().forEach(elem ->
                jdiAssert(!elem.isClickable(), Matchers.is(true), "Disabled hours/minutes are clickable")
        );
        return this;
    }

    @JDIAction("Assert that all '{name}' enabled hours/minutes are correct")
    public TimePickerAssert properEnabledHoursOrMinutes(List<String> enabledHoursOrMinutes) {
        Timer.waitCondition(() -> element().getEnabledHoursOrMinutes().equals(enabledHoursOrMinutes));
        List<String> actualEnabledHoursOrMinutes = element().getEnabledHoursOrMinutes();
        jdiAssert(actualEnabledHoursOrMinutes, Matchers.containsInAnyOrder(enabledHoursOrMinutes.toArray()),
                String.format("Actual enabled hours/minutes '%s' are not equal to expected '%s'",
                        actualEnabledHoursOrMinutes, enabledHoursOrMinutes));
        return this;
    }

    @JDIAction("Assert that all '{name}' disabled hours/minutes are correct")
    public TimePickerAssert properDisabledHoursOrMinutes(List<String> disabledHoursOrMinutes) {
        Timer.waitCondition(() -> element().getDisabledHoursOrMinutes().equals(disabledHoursOrMinutes));
        List<String> actualDisabledHoursOrMinutes = element().getDisabledHoursOrMinutes();
        jdiAssert(actualDisabledHoursOrMinutes, Matchers.containsInAnyOrder(disabledHoursOrMinutes.toArray()),
                String.format("Actual disabled hours/minutes '%s' are not equal to expected '%s'",
                        actualDisabledHoursOrMinutes, disabledHoursOrMinutes));
        return this;
    }

    @JDIAction("Assert that '{name}' has twelve hour format")
    public TimePickerAssert twelveHourFormat() {
        jdiAssert(element().getAllHoursElements().size(), Matchers.equalTo(12), "Element has not " +
                "12 hours format");
        return this;
    }

    @JDIAction("Assert that '{name}' has twenty-four hour format")
    public TimePickerAssert twentyFourHourFormat() {
        jdiAssert(element().getAllHoursElements().size(), Matchers.equalTo(24), "Element has not " +
                "24 hours format");
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' field's color is correct")
    public TimePickerAssert backgroundColor(String color) {
        String actualFieldBackgroundColor = element().fieldBackgroundColor();
        jdiAssert(actualFieldBackgroundColor, Matchers.is(color), String.format("Actual field background color '%s' " +
                "is not equal to expected '%s'", actualFieldBackgroundColor, color));
        return this;
    }

    @JDIAction("Assert that '{name}' title field has correct hours")
    public TimePickerAssert hours(String hours) {
        String actualHours = element().getHours();
        jdiAssert(actualHours, Matchers.is(hours), String.format("Actual hours '%s' are not equal to expected '%s'",
                actualHours, hours));
        return this;
    }

    @JDIAction("Assert that '{name}' title field has correct minutes")
    public TimePickerAssert minutes(String minutes) {
        String actualMinutes = element().getMinutes();
        jdiAssert(actualMinutes, Matchers.is(minutes), String.format("Actual minutes '%s' are not equal to " +
                "expected '%s'", actualMinutes, minutes));
        return this;
    }

    @JDIAction("Assert that '{name}' title field has correct seconds")
    public TimePickerAssert seconds(String seconds) {
        String actualSeconds = element().getSeconds();
        jdiAssert(actualSeconds, Matchers.is(seconds), String.format("Actual seconds '%s' are not equal to " +
                "expected '%s'", actualSeconds, seconds));
        return this;
    }

    @JDIAction("Assert that '{name}' title field has AM period")
    public TimePickerAssert amPeriod() {
        jdiAssert(element().amPmStatus(), Matchers.is("AM"), "Element has not AM period");
        return this;
    }

    @JDIAction("Assert that '{name}' title field has PM period")
    public TimePickerAssert pmPeriod() {
        jdiAssert(element().amPmStatus(), Matchers.is("PM"), "Element has not PM period");
        return this;
    }

    @JDIAction("Assert that '{name}' is disabled")
    public TimePickerAssert disabled() {
        String errorMessage = "Element is not disabled";
        if (element().getAllHoursElements().size() == 12) {
            jdiAssert(element().getDisabledHoursOrMinutesElements().size(), Matchers.is(12), errorMessage);
        } else {
            jdiAssert(element().getDisabledHoursOrMinutesElements().size(), Matchers.is(24), errorMessage);
        }
        return this;
    }

    @Override
    @JDIAction("Assert that '{name}' is enabled")
    public TimePickerAssert enabled() {
        String errorMessage = "Element is disabled";
        if (element().getAllHoursElements().size() == 12) {
            jdiAssert(element().getEnabledHoursOrMinutesElements().size() > 0, Matchers.is(true), errorMessage);
        } else {
            jdiAssert(element().getEnabledHoursOrMinutesElements().size() > 0, Matchers.is(true), errorMessage);
        }
        return this;
    }

    @JDIAction("Assert that '{name}' active hours/minutes are correct")
    public TimePickerAssert activeHoursOrMinutes(String value) {
        String actualActiveHoursOrMinutes = element().getActiveHoursMinutes();
        jdiAssert(actualActiveHoursOrMinutes, Matchers.is(value), String.format("Element's actual hours or minutes '%s' " +
                "are not equal to expected '%s'", actualActiveHoursOrMinutes, value));
        return this;
    }

    @JDIAction("Assert that '{name}' active hours/minutes are not equal to '{0}'")
    public TimePickerAssert nonActiveHoursOrMinutes(String value) {
        String activeHoursOrMinutes = element().getActiveHoursMinutes();
        jdiAssert(activeHoursOrMinutes, Matchers.not(value), String.format("Element's actual hours or minutes " +
                "'%s' are equal to expected '%s'", activeHoursOrMinutes, value));
        return this;
    }

    @JDIAction("Assert that '{name}' has title")
    public TimePickerAssert title() {
        jdiAssert(element().getTitleElement().isExist(), Matchers.is(true), "Element has not title");
        return this;
    }

    @JDIAction("Assert that '{name}' title does not exist")
    public TimePickerAssert noTitle() {
        jdiAssert(element().getTitleElement().isNotExist(), Matchers.is(true), "Element has title");
        return this;
    }

    @JDIAction("Assert that '{name}' time shown in title is correct")
    public TimePickerAssert time(String time) {
        String actualTime = element().getTime();
        jdiAssert(actualTime, Matchers.is(time), String.format("Actual name time '%s' is not equal to expected '%s'",
                actualTime, time));
        return this;
    }

    @JDIAction("Assert that '{name}' time shown in title is correct, using local time format")
    public TimePickerAssert localTime(LocalTime localTime) {
        LocalTime actualLocalTime = element().getLocalTime();
        jdiAssert(actualLocalTime, Matchers.is(localTime), String.format("Actual local time '%s' is not equal to " +
                "expected '%s'", actualLocalTime, localTime));
        return this;
    }

    @JDIAction("Assert that '{name}' time shown in result time field is  correct")
    public TimePickerAssert resultTime(String resultTime) {
        String actualResultTime = element().getResultTime();
        jdiAssert(actualResultTime, Matchers.is(resultTime), String.format("Actual result time '%s' is not " +
                "equal to '%s'", actualResultTime, resultTime));
        return this;
    }

    @JDIAction("Assert that '{name}' time shown in result time field is  correct, using local time format")
    public TimePickerAssert resultLocalTime(LocalTime resultLocalTime) {
        LocalTime actualResultLocalTime = element().getResultLocalTime();
        jdiAssert(actualResultLocalTime, Matchers.is(resultLocalTime), String.format("Actual result local time '%s' " +
                "is not equal to expected '%s'", actualResultLocalTime, resultLocalTime));
        return this;
    }

    @JDIAction("Assert that '{name}' is landscape")
    public TimePickerAssert landscape() {
        jdiAssert(element().isLandscape(), Matchers.is(true), "Element is not landscape");
        return this;
    }

    @JDIAction("Assert that '{name}' is not landscape")
    public TimePickerAssert notLandscape() {
        jdiAssert(element().isLandscape(), Matchers.is(false), "Element is landscape");
        return this;
    }
}
