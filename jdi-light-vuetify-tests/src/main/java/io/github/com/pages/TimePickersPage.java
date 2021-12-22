package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JTimePicker;
import com.epam.jdi.light.vuetify.elements.complex.TimePickers;

public class TimePickersPage extends VuetifyPage {

    //    @JDatePicker(
    //            root = "#MultipleDatePicker > div:nth-child(2)",
    //            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    //    public static DatePicker multipleInMenuDatePicker;

    @JTimePicker(
            root = "#AllowedTimesTimePicker > div:nth-child(1)")
    public static TimePickers allowedTimesTimePicker;

//    @UI("#AllowedTimesTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
//    public static TimePickers allowedTimesTimePicker;

    @JTimePicker(
            root = "#AMPMInTitleTimePicker > div:nth-child(1)")
    public static TimePickers amPmInTitleTimePicker;

    @JTimePicker(
            root = "#ColorsTimePicker > div:nth-child(1)")
    public static TimePickers firstColorTimePicker;

    @JTimePicker(
            root = "#ColorsTimePicker > div:nth-child(2)")
    public static TimePickers secondColorTimePicker;

    @UI("#DisabledTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    public static TimePickers disabledTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers elevationTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers formatTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers noTitleTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers planEventTimePicker;

    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    public static TimePickers readOnlyTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers scrollableTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers useSecondsTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers widthTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers pickerInMenuTimePicker;

    //    @UI("#ReadOnlyTimePicker > div:first-child .v-time-picker-clock__inner .v-time-picker-clock__item")
    //    public static TimePickers pickerInDialogTimePicker;
}
