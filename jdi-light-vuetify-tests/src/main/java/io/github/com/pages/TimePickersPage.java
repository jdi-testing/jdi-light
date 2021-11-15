package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.complex.TimePickers;

public class TimePickersPage extends VuetifyPage {

    @UI("#AllowedTimesTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    public static TimePickers allowedTimesTimePicker;

    @UI("#DisabledTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    public static TimePickers disabledTimePicker;

    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    public static TimePickers readOnlyTimePicker;
}
