package io.github.com.pages;

import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Icon;

import java.util.List;

public class DatePickersMonthPage extends VuetifyPage {

    // LOCATORS FOR: Allowed month




    // LOCATORS FOR: Colors
    @JDropdown(
            value = "#ColorsMonthPicker > div:nth-child(1) > div.v-picker__title.green.lighten-1 > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ColorsMonthPicker table > tbody button")
    public static Dropdown colorsMonthPicker;



    // LOCATORS FOR: Icons
    @UI("#IconsMonthPicker div.v-date-picker-header.theme--light > button:nth-child(1) i")
    public static Icon leftArrowIconsDP;

    @UI("#IconsMonthPicker div.v-date-picker-header.theme--light > button:nth-child(3) i")
    public static Icon rightArrowIconsDP;

    @UI("#IconsMonthPicker > div > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__year > i")
    public static Icon additionalYearIconIconsDP;


    // LOCATORS FOR: Multiple
    @JDropdown(
            value = "#MultipleMonthPicker > div > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#MultipleMonthPicker table > tbody button")
    public static Dropdown multipleMonthButtons;

    @UI("#MultipleMonthPicker tr button[class*='active']")
    public static List<Button> activeMonthButtonsMultipleDP;

    // LOCATORS FOR: Readonly
    @JDropdown(
            value = "#ReadonlyMonthPicker > div > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ReadonlyMonthPicker table > tbody button")
    public static Dropdown readonlyMonthPicker;

    @UI("#ReadonlyMonthPicker table > tbody button[class*='active']")
    public static Button activeMonthButtonReadonlyPicker;



    // LOCATORS FOR: Show current




    // LOCATORS FOR: Width




    // LOCATORS FOR: Dialog and Menu





    // LOCATORS FOR: Internationalization





    // LOCATORS FOR: Orientation



}
