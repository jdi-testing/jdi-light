package io.github.com.pages;

import com.epam.jdi.light.vuetify.annotations.JTimePicker;
import com.epam.jdi.light.vuetify.elements.complex.TimePicker;

public class TimePickersPage extends VuetifyPage {

    @JTimePicker(
            root = "#AllowedTimesTimePicker > div:nth-child(1)")
    public static TimePicker allowedTimesTimePicker;

    @JTimePicker(
            root = "#AMPMInTitleTimePicker > div:nth-child(1)")
    public static TimePicker amPmInTitleTimePicker;

    @JTimePicker(
            root = "#AMPMInTitleTimePicker > div:nth-child(2)")
    public static TimePicker secondAmPmInTitleTimePicker;

    @JTimePicker(
            root = "#ColorsTimePicker > div:nth-child(1)")
    public static TimePicker firstColorTimePicker;

    @JTimePicker(
            root = "#DisabledTimePicker > div:nth-child(1)")
    public static TimePicker disabledTimePicker;

    @JTimePicker(
            root = "#ElevationTimePicker > div:nth-child(2)")
    public static TimePicker elevatedTimePicker;

    @JTimePicker(
            root = "#FormatTimePicker > div")
    public static TimePicker formatTimePicker;

    @JTimePicker(
            root = "#NoTitleTimePicker > div:nth-child(1)")
    public static TimePicker noTitleTimePicker;

    @JTimePicker(
            root = "#ScrollableTimePicker > .v-picker")
    public static TimePicker scrollableTimePicker;

    @JTimePicker(
            root = "#ReadOnlyTimePicker > div:nth-child(1)")
    public static TimePicker readOnlyTimePicker;

    @JTimePicker(
            root = "#UseSecondsTimePicker > div:nth-child(1)")
    public static TimePicker useSecondsTimePicker1;

    @JTimePicker(
            root = "#UseSecondsTimePicker > div:nth-child(2)")
    public static TimePicker useSecondsTimePicker2;

    @JTimePicker(
            root = "#WidthTimePicker > div:nth-child(1)")
    public static TimePicker firstWidthTimePicker;

    @JTimePicker(
            root = "#DialogAndMenuTimePicker > div:nth-child(3)",
            expandedRoot = "#app > div.v-dialog__content.v-dialog__content--active > div > div")
    public static TimePicker pickerInDialogTimePicker;
}
