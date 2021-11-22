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
    public static DatePicker allowedNewDP;

    // LOCATORS FOR: Colors date picker
    @JDatePicker(
            root = "#ColorsDatePicker > div:nth-child(1)")
    public static DatePicker colorFirstNewDP;

    @JDatePicker(
            root = "#ColorsDatePicker > div:nth-child(2)")
    public static DatePicker colorSecondNewDP;

    // LOCATORS FOR: Elevation date picker
    @JDatePicker(
            root = "#ElevationDatePicker > div.v-picker.v-card.v-picker--date.v-picker--flat.theme--light")
    public static DatePicker elevationWithoutElevationNewDP;

    @JDatePicker(
            root = "#ElevationDatePicker > div.v-picker.v-card.v-picker--date.theme--light.elevation-15")
    public static DatePicker elevationWithElevationNewDP;

    // LOCATORS FOR: Icons date picker
    @JDatePicker(
            root = "#IconsDatePicker > div")
    public static DatePicker iconsNewDP;

    // LOCATORS FOR: Multiple date picker
    @JDatePicker(
            root = "#MultipleDatePicker > div:nth-child(1)")
    public static DatePicker multipleNewDP;

    @JDatePicker(
            root = "#MultipleDatePicker > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker multipleInMenuNewDP;

    // LOCATORS FOR: Picker date date picker
    @JDatePicker(
            root = "#PickerDateDatePicker > div:nth-child(1)")
    public static DatePicker pickerDateNewDP;

    @UI("#PickerDateDatePicker div.text-h6")
    public static Text textWithChosenMonthPickerDateDP;

    @UI("#PickerDateDatePicker ul.ma-4 > li")
    public static List<Text> newsPickerDateDP;

    // LOCATORS FOR: Range date picker
    @JDatePicker(
            root = "#RangeDatePicker > div:nth-child(1)")
    public static DatePicker rangeNewDP;

    @UI("//div[@id='RangeDatePicker']//div[text()[contains(.,'model')]]")
    public static Label modelDateRangeDP;

    // LOCATORS FOR: Read only date picker
    @JDatePicker(
            root = "#ReadonlyDatePicker > div")
    public static DatePicker readOnlyNewDP;

    // LOCATORS FOR: Show current date picker
    @JDatePicker(
            root = "#ShowCurrentDatePicker > div:nth-child(1)")
    public static DatePicker firstShowCurrentNewDP;

    @JDatePicker(
            root = "#ShowCurrentDatePicker > div:nth-child(2)")
    public static DatePicker secondShowCurrentNewDP;

    // LOCATORS FOR: Show sibling months date picker
    @JDatePicker(
            root = "#ShowSiblingMonthsDatePicker")
    public static DatePicker showSiblingMonthsNewDP;

    // LOCATORS FOR: Width date picker
    @JDatePicker(
            root = "#WidthDatePicker > div:nth-child(1)")
    public static DatePicker firstWidthNewDP;

    @JDatePicker(
            root = "#WidthDatePicker > div.v-picker.v-card.v-picker--date.mt-4.v-picker--full-width.theme--light")
    public static DatePicker secondWidthNewDP;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindow;

    // LOCATORS FOR: Date buttons date picker
    @JDatePicker(
            root = "#DateButtonsDatePicker > div:nth-child(1)")
    public static DatePicker dateButtonsNewDP;

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
    public static DatePicker firstDateEventsNewDP;

    @JDatePicker(
            root = "#DateEventsDatePicker > div:nth-child(2)")
    public static DatePicker secondDateEventsNewDP;

    // LOCATORS FOR: Active picker date picker
    @JDatePicker(
            root = "#ActivePickerDatePicker",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker activePickerNewDP;

    // LOCATORS FOR: Dialog and menu date picker
    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker pickerInMenuNewDP;

    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(3)",
            expandedRoot = "#app > div.v-dialog__content.v-dialog__content--active")
    public static DatePicker pickerInDialogNewDP;

    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(4)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker pickerWithoutButtonsNewDP;

    // LOCATORS FOR: Formatting date picker
    @JDatePicker(
            root = "#FormattingDatePicker > div > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker writableFormattingNewDP;

    @JDatePicker(
            root = "#FormattingDatePicker > div > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker readonlyFormattingNewDP;

    // LOCATORS FOR: Formatting with external libraries date picker
    @JDatePicker(
            root = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker formattedMomentJsNewDP;

    @JDatePicker(
            root = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker formattedDatefnsNewDP;

    // LOCATORS FOR: Internationalization date picker
    @JDatePicker(
            root = "#InternationalizationDatePicker > div:nth-child(1)")
    public static DatePicker chineseNewDP;

    @JDatePicker(
            root = "#InternationalizationDatePicker > div:nth-child(2)")
    public static DatePicker swedishNewDP;

    // LOCATORS FOR: Orientation date picker
    @JDatePicker(
            root = "#OrientationDatePicker")
    public static DatePicker orientationNewDP;
}
