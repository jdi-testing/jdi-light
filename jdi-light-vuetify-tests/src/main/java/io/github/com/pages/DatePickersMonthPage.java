package io.github.com.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.vuetify.annotations.JDatePickerMonth;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.DatePickerMonth;

public class DatePickersMonthPage extends VuetifyPage {

    @JDatePickerMonth(
            root = "#AllowedMonthPicker > .v-picker--date")
    public static DatePickerMonth allowedMonthPicker;

    @JDatePickerMonth(
            root = "#ColorsMonthPicker > .v-picker--date")
    public static DatePickerMonth firstColorMonthPicker;

    @JDatePickerMonth(
            root = "#IconsMonthPicker > .v-picker--date")
    public static DatePickerMonth iconsMonthPicker;

    @JDatePickerMonth(
            root = "#MultipleMonthPicker > .v-picker--date")
    public static DatePickerMonth multipleMonthPicker;

    @JDatePickerMonth(
            root = "#ReadonlyMonthPicker > .v-picker--date")
    public static DatePickerMonth readonlyMonthPicker;

    @JDatePickerMonth(
            root = "#WidthMonthPicker > .v-picker--date")
    public static DatePickerMonth firstWidthMonthPicker;

    @JDatePickerMonth(
            root = "#DialogMenuMonthPicker > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePickerMonth pickerInMenuMonthPicker;

    @JDatePickerMonth(
            root = "#DialogMenuMonthPicker > div:nth-child(3)",
            expandedRoot = "#app > div.v-dialog__content.v-dialog__content--active")
    public static DatePickerMonth pickerInDialogMonthPicker;

    @JDatePickerMonth(
            root = "#InternationalizationMonthPicker > .v-picker--date")
    public static DatePickerMonth thaiMonthPicker;

    @JDatePickerMonth(
            root = "#InternationalizationMonthPicker > div:nth-child(2)")
    public static DatePickerMonth swedishMonthPicker;

    @JDatePickerMonth(
            root = "#OrientationMonthPicker > .v-picker")
    public static DatePickerMonth orientationMonthPicker;

    @UI("#OrientationMonthPicker > .v-input--checkbox")
    public static VueCheckbox orientationSwitcher;

    @UI(".v-menu__content .v-picker__actions .v-btn:last-child")
    public static Button buttonOkMenu;

    @UI(".v-menu__content .v-picker__actions .v-btn:nth-child(2)")
    public static Button buttonCancelMenu;

    @UI(".v-dialog__content .v-picker__actions .v-btn:last-child")
    public static Button buttonOkDialog;
}
