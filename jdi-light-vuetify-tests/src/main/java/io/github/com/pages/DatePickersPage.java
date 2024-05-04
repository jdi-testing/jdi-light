package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.vuetify.annotations.JDatePicker;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.DatePicker;

import java.util.List;

public class DatePickersPage extends VuetifyPage {

    @JDatePicker(
            root = "#AllowedDatesDatePicker > .v-picker--date")
    public static DatePicker allowedDatePicker;

    @JDatePicker(
            root = "#ColorsDatePicker > .v-picker--date")
    public static DatePicker colorFirstDatePicker;

    @JDatePicker(
            root = "#ColorsDatePicker > div:nth-child(2)")
    public static DatePicker colorSecondDatePicker;

    @JDatePicker(
            root = "#ElevationDatePicker > div:last-child")
    public static DatePicker elevationWithElevationDatePicker;

    @JDatePicker(
            root = "#IconsDatePicker > .v-picker--date")
    public static DatePicker iconsDatePicker;

    @JDatePicker(
            root = "#MultipleDatePicker .v-picker--date")
    public static DatePicker multipleDatePicker;

    @JDatePicker(
            root = "#MultipleDatePicker > div:nth-child(2)",
            expandedRoot = "#app > div.v-menu__content.theme--light.menuable__content__active")
    public static DatePicker multipleInMenuDatePicker;

    @JDatePicker(
            root = "#PickerDateDatePicker .v-picker--date")
    public static DatePicker pickerDateDatePicker;

    @UI("#PickerDateDatePicker div.text-h6")
    public static Text textWithChosenMonth;

    @UI("#PickerDateDatePicker ul.ma-4 > li")
    public static List<Text> news;

    @JDatePicker(
            root = "#RangeDatePicker .v-picker--date")
    public static DatePicker rangeDatePicker;

    @UI("//div[@id='RangeDatePicker']//div[text()[contains(.,'model')]]")
    public static Label modelDateRange;

    @JDatePicker(
            root = "#ReadonlyDatePicker > .v-picker--date")
    public static DatePicker readOnlyDatePicker;

    @JDatePicker(
            root = "#ShowCurrentDatePicker > .v-picker--date")
    public static DatePicker firstShowCurrentDatePicker;

    @JDatePicker(
            root = "#ShowCurrentDatePicker > div:nth-child(2)")
    public static DatePicker secondShowCurrentDatePicker;

    @JDatePicker(
            root = "#WidthDatePicker > .v-picker--date")
    public static DatePicker firstWidthDatePicker;

    @JDatePicker(
            root = "#WidthDatePicker > div:nth-child(2)")
    public static DatePicker secondWidthDatePicker;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindow;

    @JDatePicker(
            root = "#DateEventsDatePicker > div:nth-child(1)")
    public static DatePicker firstDateEventsDatePicker;

    @JDatePicker(
            root = "#DateEventsDatePicker > div:nth-child(2)")
    public static DatePicker secondDateEventsDatePicker;

    // @todo #5362 Looks like this is not a picker, but input with date type, so datepicker
    //  appears to select value. Should be checked
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

    @UI(".v-input--checkbox")
    public static VueCheckbox orientationSwitcher;

    @JDatePicker(
            root = "#OrientationDatePicker .v-picker--date")
    public static DatePicker orientationDatePicker;

    // @todo #5362 These controls are in the picker, should be used from the picker only
    @UI(".v-menu__content .v-picker__actions .v-btn:last-child")
    public static Button buttonOkMenu;

    @UI(".v-menu__content .v-picker__actions .v-btn:nth-child(2)")
    public static Button buttonCancelMenu;

    @UI(".v-dialog__content .v-picker__actions .v-btn:last-child")
    public static Button buttonOkDialog;

}
