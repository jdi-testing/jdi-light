package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JDatePicker;
import com.epam.jdi.light.vuetify.elements.complex.DatePicker;
import java.util.List;

public class DatePickersPage extends VuetifyPage {
    @JDatePicker(
            root = "#AllowedDatesDatePicker > div")
    public static DatePicker allowedDatePicker;

    @JDatePicker(
            root = "#ColorsDatePicker > div:nth-child(1)")
    public static DatePicker colorFirstDatePicker;

    @JDatePicker(
            root = "#ColorsDatePicker > div:nth-child(2)")
    public static DatePicker colorSecondDatePicker;

    @JDatePicker(
            root = "#ElevationDatePicker > div:last-child")
    public static DatePicker elevationWithElevationDatePicker;

    @JDatePicker(
            root = "#IconsDatePicker > div")
    public static DatePicker iconsDatePicker;

    @JDatePicker(
            root = "#MultipleDatePicker .v-picker")
    public static DatePicker multipleDatePicker;

    @JDatePicker(
            root = "#MultipleDatePicker > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker multipleInMenuDatePicker;

    @JDatePicker(
            root = "#PickerDateDatePicker > div:nth-child(1)")
    public static DatePicker pickerDateDatePicker;

    @UI("#PickerDateDatePicker div.text-h6")
    public static Text textWithChosenMonth;

    @UI("#PickerDateDatePicker ul.ma-4 > li")
    public static List<Text> news;

    @JDatePicker(
            root = "#RangeDatePicker .v-picker")
    public static DatePicker rangeDatePicker;

    @UI("//div[@id='RangeDatePicker']//div[text()[contains(.,'model')]]")
    public static Label modelDateRange;

    @JDatePicker(
            root = "#ReadonlyDatePicker > div")
    public static DatePicker readOnlyDatePicker;

    @JDatePicker(
            root = "#ShowCurrentDatePicker > div:nth-child(1)")
    public static DatePicker firstShowCurrentDatePicker;

    @JDatePicker(
            root = "#ShowCurrentDatePicker > div:nth-child(2)")
    public static DatePicker secondShowCurrentDatePicker;

    @JDatePicker(
            root = "#WidthDatePicker > div:nth-child(1)")
    public static DatePicker firstWidthDatePicker;

    @JDatePicker(
            root = "#WidthDatePicker > div.v-picker.v-card.v-picker--date.mt-4.v-picker--full-width.theme--light")
    public static DatePicker secondWidthDatePicker;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindow;

    @JDatePicker(
            root = "#DateEventsDatePicker > div:nth-child(1)")
    public static DatePicker firstDateEventsDatePicker;

    @JDatePicker(
            root = "#DateEventsDatePicker > div:nth-child(2)")
    public static DatePicker secondDateEventsDatePicker;

    @JDatePicker(
            root = "#ActivePickerDatePicker",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker activePickerDatePicker;

    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker pickerInMenuDatePicker;

    @JDatePicker(
            root = "#DialogAndMenuDatePicker > div:nth-child(3)",
            expandedRoot = "#app > div.v-dialog__content.v-dialog__content--active")
    public static DatePicker pickerInDialogDatePicker;

    @JDatePicker(
            root = "#FormattingDatePicker > div > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker writableFormattingDatePicker;

    @JDatePicker(
            root = "#FormattingDatePicker > div > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker readonlyFormattingDatePicker;

    @JDatePicker(
            root = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(1)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker formattedMomentJsDatePicker;

    @JDatePicker(
            root = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker formattedDatesDatePicker;

    @JDatePicker(
            root = "#InternationalizationDatePicker > div:nth-child(1)")
    public static DatePicker chineseDatePicker;

    @JDatePicker(
            root = "#InternationalizationDatePicker > div:nth-child(2)")
    public static DatePicker swedishDatePicker;

    @UI("//div[contains(@class, 'v-input--selection-controls__ripple')]")
    public static Checkbox orientationSwitcher;

    @JDatePicker(
            root = "#OrientationDatePicker .v-picker")
    public static DatePicker orientationDatePicker;
}
