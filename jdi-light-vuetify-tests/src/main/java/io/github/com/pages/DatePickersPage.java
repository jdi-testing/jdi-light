package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JDatePicker;
import com.epam.jdi.light.vuetify.elements.complex.DatePicker;

import java.util.List;

public class DatePickersPage extends VuetifyPage {
    // LOCATORS FOR: Allowed dates date picker
    @JDatePicker(
            root = "#AllowedDatesDatePicker > div")
    public static DatePicker allowedDP;

    // LOCATORS FOR: Colors date picker
    @JDatePicker(
            root = "#ColorsDatePicker > div:nth-child(1)")
    public static DatePicker colorFirstDP;

    @JDatePicker(
            root = "#ColorsDatePicker > div:nth-child(2)")
    public static DatePicker colorSecondDP;

    // LOCATORS FOR: Elevation date picker
    @JDatePicker(
            root = "#ElevationDatePicker > div.v-picker.v-card.v-picker--date.v-picker--flat.theme--light")
    public static DatePicker elevationWithoutElevationDP;

    @JDatePicker(
            root = "#ElevationDatePicker > div.v-picker.v-card.v-picker--date.theme--light.elevation-15")
    public static DatePicker elevationWithElevationDP;

    // LOCATORS FOR: Icons date picker
    @JDatePicker(
            root = "#IconsDatePicker > div")
    public static DatePicker iconsDP;

    // LOCATORS FOR: Multiple date picker
    @JDatePicker(
            root = "#MultipleDatePicker > div:nth-child(1)")
    public static DatePicker multipleDP;

    @JDatePicker(
            root = "#MultipleDatePicker > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker multipleInMenuDP;

    // LOCATORS FOR: Picker date date picker
    @JDatePicker(
            root = "#PickerDateDatePicker > div:nth-child(1)")
    public static DatePicker pickerDateDP;

    @UI("#PickerDateDatePicker div.text-h6")
    public static Text textWithChosenMonthPickerDateDP;

    @UI("#PickerDateDatePicker ul.ma-4 > li")
    public static List<Text> newsPickerDateDP;

    // LOCATORS FOR: Range date picker
    @JDatePicker(
            root = "#RangeDatePicker > div:nth-child(1)")
    public static DatePicker rangeDP;

    @UI("//div[@id='RangeDatePicker']//div[text()[contains(.,'model')]]")
    public static Label modelDateRangeDP;

    // LOCATORS FOR: Read only date picker
    @JDatePicker(
            root = "#ReadonlyDatePicker > div")
    public static DatePicker readOnlyDP;

    // LOCATORS FOR: Show current date picker
    @JDatePicker(
            root = "#ShowCurrentDatePicker > div:nth-child(1)")
    public static DatePicker firstShowCurrentDP;

    @JDatePicker(
            root = "#ShowCurrentDatePicker > div:nth-child(2)")
    public static DatePicker secondShowCurrentDP;

    // LOCATORS FOR: Show sibling months date picker
    @JDatePicker(
            root = "#ShowSiblingMonthsDatePicker")
    public static DatePicker showSiblingMonthsDP;

    // LOCATORS FOR: Width date picker
    @JDatePicker(
            root = "#WidthDatePicker > div:nth-child(1)")
    public static DatePicker firstWidthDP;

    @JDatePicker(
            root = "#WidthDatePicker > div.v-picker.v-card.v-picker--date.mt-4.v-picker--full-width.theme--light")
    public static DatePicker secondWidthDP;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindow;

    // LOCATORS FOR: Date buttons date picker
    @JDatePicker(
            root = "#DateButtonsDatePicker > div:nth-child(1)")
    public static DatePicker dateButtonsDP;

    @UI("#DateButtonsDatePicker div.text-body-1.mb-2 > i[class*='checkbox-marked']")
    public static Checkbox doubleClickAnyDateCheckbox;

    @UI("#DateButtonsDatePicker div.text-body-1:nth-child(2) > i[class*='checkbox-marked']")
    public static Checkbox cursorOverMonthCheckbox;

    @UI("#DateButtonsDatePicker div.text-h6.mb-2:nth-child(3)")
    public static Text mousePointerMonthText;

    @UI("#DateButtonsDatePicker div.text-body-1:last-child > i[class*='checkbox-marked']")
    public static Button clickYearCheckbox;

    // LOCATORS FOR: Date events date picker
    @JDatePicker(
            root = "#DateEventsDatePicker > div:nth-child(1)")
    public static DatePicker firstDateEventsDP;

    @JDatePicker(
            root = "#DateEventsDatePicker > div:nth-child(2)")
    public static DatePicker secondDateEventsDP;

    // LOCATORS FOR: Active picker date picker
    @JDatePicker(
            root = "#ActivePickerDatePicker",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker activePickerDP;

    // LOCATORS FOR: Dialog and menu date picker
    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker pickerInMenuDP;

    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(3)",
            expandedRoot = "#app > div.v-dialog__content.v-dialog__content--active")
    public static DatePicker pickerInDialogDP;

    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(4)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker pickerWithoutButtonsDP;

    // LOCATORS FOR: Formatting date picker
    @JDatePicker(
            root = "#FormattingDatePicker > div > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker writableFormattingDP;

    @JDatePicker(
            root = "#FormattingDatePicker > div > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker readonlyFormattingDP;

    // LOCATORS FOR: Formatting with external libraries date picker
    @JDatePicker(
            root = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker formattedMomentJsDP;

    @JDatePicker(
            root = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker formattedDatefnsDP;

    // LOCATORS FOR: Internationalization date picker
    @JDatePicker(
            root = "#InternationalizationDatePicker > div:nth-child(1)")
    public static DatePicker chineseDP;

    @JDatePicker(
            root = "#InternationalizationDatePicker > div:nth-child(2)")
    public static DatePicker swedishDP;

    // LOCATORS FOR: Orientation date picker
    @JDatePicker(
            root = "#OrientationDatePicker")
    public static DatePicker orientationDP;
}
