package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JDITimePickers;
import com.epam.jdi.light.vuetify.elements.complex.TimePickers;

public class TimePickersPage extends VuetifyPage {

    @JDITimePickers(
            root = "#AllowedTimesTimePicker > div:first-child .v-time-picker-clock__inner",
            items = ".v-time-picker-clock__item")
    public static TimePickers allowedTimesTimePicker;

    @JDITimePickers(
            root = "#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner",
            items = ".v-time-picker-clock__item")
    public static TimePickers readOnlyTimePicker;

    @JDITimePickers(
            root = "#DisabledTimePicker > div:first-child .v-time-picker-clock__inner",
            items = ".v-time-picker-clock__item")
    public static TimePickers disabledTimePicker;
}
