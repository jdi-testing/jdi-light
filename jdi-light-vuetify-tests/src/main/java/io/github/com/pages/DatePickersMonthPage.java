package io.github.com.pages;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Icon;

import java.util.List;

public class DatePickersMonthPage extends VuetifyPage {

    // LOCATORS FOR: Allowed month
    @JDropdown(
            value = "#AllowedMonthPicker > div > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#AllowedMonthPicker table > tbody button")
    public static Dropdown allowedMonthPicker;

    @UI("#AllowedMonthPicker table > tbody button:disabled")
    public static List<Button> disabledMonths;

    @UI("#AllowedMonthPicker tr button[class*='active']")
    public static Button activeMonthButtonsAllowedMP;

    // LOCATORS FOR: Colors
    @JDropdown(
            value = "#ColorsMonthPicker > div:nth-child(1) > div.v-picker__title.green.lighten-1 > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ColorsMonthPicker table > tbody button")
    public static Dropdown colorsMonthPicker;

    @JDropdown(
            value = "#ColorsMonthPicker > div:nth-child(1) div.v-date-picker-header.theme--light > div > div > button",
            list = "#ColorsMonthPicker > div:nth-child(1) > div.v-picker__body.theme--light li",
            expand = "#ColorsMonthPicker > div:nth-child(1) div.v-date-picker-header.theme--light > div button")
    public static Dropdown yearColorMPDropdown;

    @UI("#ColorsMonthPicker > div:nth-child(1) > div.v-picker__title.green.lighten-1 > div > div.v-picker__title__btn.v-date-picker-title__year")
    public static Button yearSmallButton;



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
    @JDropdown(
            value = "#ShowCurrentMonthPicker > div:nth-child(1) > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ShowCurrentMonthPicker > div:nth-child(1) > div.v-picker__body.theme--light > div > div.v-date-picker-table.v-date-picker-table--month.theme--light > table > tbody button")
    public static Dropdown firstShowCurrentMonthPicker;

    @UI("#ShowCurrentMonthPicker > div:nth-child(1) table > tbody button[class*='active']")
    public static Button activeMonthButtonFirstShowCurrentPicker;

    @JDropdown(
            value = "#ShowCurrentMonthPicker > div:nth-child(2) > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ShowCurrentMonthPicker > div:nth-child(2) > div.v-picker__body.theme--light > div > div.v-date-picker-table.v-date-picker-table--month.theme--light > table > tbody button")
    public static Dropdown secondShowCurrentMonthPicker;

//    @UI("#ShowCurrentMonthPicker > div:nth-child(2) table > tbody button[class*='active']")
//    public static Button activeMonthButtonSecondShowCurrentPicker;

    @UI("#ShowCurrentMonthPicker > div:nth-child(2) table > tbody button[class*='outlined']")
    public static Button outlinedButtonShowCurrentPicker;

    // LOCATORS FOR: Width
    @UI("#WidthMonthPicker > div:nth-child(1)")
    public static Section firstSectionWidthMP;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindowMonthPickers;

    @UI("#WidthMonthPicker > div:nth-child(2)")
    public static Section secondSectionWidthMP;

    // LOCATORS FOR: Dialog and Menu
    @JDropdown(
            value = "#DialogMenuMonthPicker > div:nth-child(1) > div.v-input.v-input--is-label-active.v-input--is-dirty.v-input--is-readonly.theme--light.v-text-field.v-text-field--is-booted > div.v-input__control > div.v-input__slot > div input",
            list = "#app > div.v-menu__content.theme--light.menuable__content__active > div > div.v-picker__body.v-picker__body--no-title.theme--light > div > div.v-date-picker-table.v-date-picker-table--month.theme--light > table > tbody button",
            expand = "#DialogMenuMonthPicker > div:nth-child(1) > div.v-input.v-input--is-label-active.v-input--is-dirty.v-input--is-readonly.theme--light.v-text-field.v-text-field--is-booted > div.v-input__control > div.v-input__slot > div")
    public static Dropdown monthPickerInMenu;

    @JDropdown(
            value = "#DialogMenuMonthPicker > div:nth-child(3) > div.v-input.v-input--is-label-active.v-input--is-dirty.v-input--is-readonly.theme--light.v-text-field.v-text-field--is-booted > div.v-input__control > div.v-input__slot > div input",
            list = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-picker__body.theme--light > div > div.v-date-picker-table.v-date-picker-table--month.theme--light > table > tbody button",
            expand = "#DialogMenuMonthPicker > div:nth-child(3) > div.v-input.v-input--is-label-active.v-input--is-dirty.v-input--is-readonly.theme--light.v-text-field.v-text-field--is-booted > div.v-input__control > div.v-input__slot > div")
    public static Dropdown monthPickerInDialog;

    @UI("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div")
    public static Button pickerInDialogMonthField;

    @UI("//div[@id='app']//span[text()[contains(.,'OK')]]")
    public static Button pickerInDialogMonthOkButton;

    // LOCATORS FOR: Internationalization
    @JDropdown(
            value = "#InternationalizationMonthPicker > div:nth-child(1) > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#InternationalizationMonthPicker > div:nth-child(1) > div.v-picker__body.theme--light > div > div.v-date-picker-table.v-date-picker-table--month.theme--light > table > tbody button")
    public static Dropdown thaiMonthPicker;

    @JDropdown(
            value = "#InternationalizationMonthPicker > div:nth-child(2) > div.v-picker__title.primary > div > div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#InternationalizationMonthPicker > div:nth-child(2) > div.v-picker__body.theme--light > div > div.v-date-picker-table.v-date-picker-table--month.theme--light > table > tbody button")
    public static Dropdown swedishMonthPicker;

    // LOCATORS FOR: Orientation
    @UI("#OrientationMonthPicker > div.v-picker.v-card.v-picker--date.theme--light > div.v-picker__title.primary")
    public static Section landscapeOrientedMonthSection;

    @UI("#OrientationMonthPicker div.v-input--selection-controls__ripple")
    public static Checkbox orientationSwitcher;

    @UI("#OrientationMonthPicker div.v-picker__title.v-picker__title--landscape.primary")
    public static Section portraitOrientedMonthSection;

}
