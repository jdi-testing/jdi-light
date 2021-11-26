package io.github.com.pages;

import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.annotations.JDatePickerMonth;
import com.epam.jdi.light.vuetify.elements.complex.DatePickerMonth;

public class DatePickersMonthPage extends VuetifyPage {
    // LOCATORS FOR: Allowed month
    @JDatePickerMonth(
            root = "#AllowedMonthPicker > div")
    public static DatePickerMonth allowedMP;

    // LOCATORS FOR: Colors
    @JDatePickerMonth(
            root = "#ColorsMonthPicker > div:nth-child(1)")
    public static DatePickerMonth firstColorMP;

    @JDatePickerMonth(
            root = "#ColorsMonthPicker > div:nth-child(2)")
    public static DatePickerMonth secondColorMP;

    // LOCATORS FOR: Icons
    @JDatePickerMonth(
            root = "#IconsMonthPicker > div")
    public static DatePickerMonth iconsMP;

    // LOCATORS FOR: Multiple
    @JDatePickerMonth(
            root = "#MultipleMonthPicker > div")
    public static DatePickerMonth multipleMP;

    // LOCATORS FOR: Readonly
    @JDatePickerMonth(
            root = "#ReadonlyMonthPicker > div")
    public static DatePickerMonth readonlyMP;

    // LOCATORS FOR: Show current
    @JDatePickerMonth(
            root = "#ShowCurrentMonthPicker > div:nth-child(1)")
    public static DatePickerMonth firstShowCurrentMP;

    @JDatePickerMonth(
            root = "#ShowCurrentMonthPicker > div:nth-child(2)")
    public static DatePickerMonth secondShowCurrentMP;

    // LOCATORS FOR: Width
    @JDatePickerMonth(
            root = "#WidthMonthPicker > div:nth-child(1)")
    public static DatePickerMonth firstWidthMP;

    @JDatePickerMonth(
            root = "#WidthMonthPicker > div.v-picker.v-card.v-picker--date.mt-4.v-picker--full-width.theme--light")
    public static DatePickerMonth secondWidthMP;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindow;

    // LOCATORS FOR: Dialog and Menu
    @JDatePickerMonth(
            root = "#DialogMenuMonthPicker > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePickerMonth pickerInMenuMP;

    @JDatePickerMonth(
            root = "#DialogMenuMonthPicker > div:nth-child(3)",
            expandedRoot = "#app > div.v-dialog__content.v-dialog__content--active")
    public static DatePickerMonth pickerInDialogMP;

    // LOCATORS FOR: Internationalization
    @JDatePickerMonth(
            root = "#InternationalizationMonthPicker > div:nth-child(1)")
    public static DatePickerMonth thaiMP;

    @JDatePickerMonth(
            root = "#InternationalizationMonthPicker > div:nth-child(2)")
    public static DatePickerMonth swedishMP;

    // LOCATORS FOR: Orientation
    @JDatePickerMonth(
            root = "#OrientationMonthPicker")
    public static DatePickerMonth orientationMP;
}
