package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDatePickerMonth;
import com.epam.jdi.light.vuetify.elements.complex.DatePickerMonth;

public class DatePickersMonthPage extends VuetifyPage {
    // LOCATORS FOR: Allowed month
    @JDatePickerMonth(
            root = "#AllowedMonthPicker > div")
    public static DatePickerMonth allowedMonthPicker;

    // LOCATORS FOR: Colors
    @JDatePickerMonth(
            root = "#ColorsMonthPicker > div:nth-child(1)")
    public static DatePickerMonth firstColorMonthPicker;

    @JDatePickerMonth(
            root = "#ColorsMonthPicker > div:nth-child(2)")
    public static DatePickerMonth secondColorMonthPicker;

    // LOCATORS FOR: Icons
    @JDatePickerMonth(
            root = "#IconsMonthPicker > div")
    public static DatePickerMonth iconsMonthPicker;

    // LOCATORS FOR: Multiple
    @JDatePickerMonth(
            root = "#MultipleMonthPicker > div")
    public static DatePickerMonth multipleMonthPicker;

    // LOCATORS FOR: Readonly
    @JDatePickerMonth(
            root = "#ReadonlyMonthPicker > div")
    public static DatePickerMonth readonlyMonthPicker;

    // LOCATORS FOR: Show current
    @JDatePickerMonth(
            root = "#ShowCurrentMonthPicker > div:nth-child(1)")
    public static DatePickerMonth firstShowCurrentMonthPicker;

    @JDatePickerMonth(
            root = "#ShowCurrentMonthPicker > div:nth-child(2)")
    public static DatePickerMonth secondShowCurrentMonthPicker;

    // LOCATORS FOR: Width
    @JDatePickerMonth(
            root = "#WidthMonthPicker > div:nth-child(1)")
    public static DatePickerMonth firstWidthMonthPicker;

    @JDatePickerMonth(
            root = "#WidthMonthPicker > div:nth-child(2)")
    public static DatePickerMonth secondWidthMonthPicker;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindow;

    // LOCATORS FOR: Dialog and Menu
    @JDatePickerMonth(
            root = "#DialogMenuMonthPicker > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePickerMonth pickerInMenuMonthPicker;

    @JDatePickerMonth(
            root = "#DialogMenuMonthPicker > div:nth-child(3)",
            expandedRoot = "#app > div.v-dialog__content.v-dialog__content--active")
    public static DatePickerMonth pickerInDialogMonthPicker;

    // LOCATORS FOR: Internationalization
    @JDatePickerMonth(
            root = "#InternationalizationMonthPicker > div:nth-child(1)")
    public static DatePickerMonth thaiMonthPicker;

    @JDatePickerMonth(
            root = "#InternationalizationMonthPicker > div:nth-child(2)")
    public static DatePickerMonth swedishMonthPicker;

    // LOCATORS FOR: Orientation
    @JDatePickerMonth(
            root = "#OrientationMonthPicker")
    public static DatePickerMonth orientationMonthPicker;
}
