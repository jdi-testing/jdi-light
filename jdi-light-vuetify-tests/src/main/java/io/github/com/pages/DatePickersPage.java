package io.github.com.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.dropdown.Dropdown;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.WaitAfterAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.JDropdown;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Checkbox;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.jdi.light.ui.html.elements.common.Text;
import com.epam.jdi.light.ui.html.elements.common.TextField;

import java.util.List;

public class DatePickersPage extends VuetifyPage {

    // LOCATORS FOR: Allowed dates date picker
    @UI("#AllowedDatesDatePicker tr:first-child button[class*='rounded theme']")
    public static Button firstAllowedDate;

    @UI("#AllowedDatesDatePicker tr:nth-child(4) button[class*='rounded']:enabled")
    public static Button fourthWeekAllowedDate;

    @UI("#AllowedDatesDatePicker tr:first-child button[class*='v-btn--disabled']")
    public static Button firstNotAllowedDate;

    @UI("#AllowedDatesDatePicker tr:nth-child(4) button[class*='v-btn--disabled']")
    public static Button fourthWeekNotAllowedDate;

    // LOCATORS FOR: Colors date picker
    @UI("#ColorsDatePicker button[aria-label='Next month']")
    public static Button nextMonthButtonColorsDP;

    @UI("#ColorsDatePicker button[aria-label='Previous month']")
    public static Button previousMonthButtonColorsDP;

    @JDropdown(
            value = "#ColorsDatePicker " +
                    "div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ColorsDatePicker table > tbody button")
    public static Dropdown colorsFirstDatePicker;

    @UI("#ColorsDatePicker div.v-picker__title.green.lighten-1")
    public static Button firstColorField;

    @UI("#ColorsDatePicker > div:nth-child(2) div.v-picker__title.primary")
    public static Button secondColorField;

    @UI("#ColorsDatePicker div.green--text.text--lighten-1 button")
    public static Button changeMonthButton;

    @JDropdown(
            value = "#ColorsDatePicker div.green--text.text--lighten-1 button",
            list = "#ColorsDatePicker div[class*='table--month'] table > tbody button")
    public static Dropdown monthColorDPDropdown;

    @JDropdown(
            value = "#ColorsDatePicker div.v-date-picker-header.theme--light > div > div > button",
            list = "#ColorsDatePicker div.v-picker__body.theme--light li",
            expand = "#ColorsDatePicker div.v-picker__title__btn.v-date-picker-title__year")
    public static Dropdown yearColorDPDropdown;

    // LOCATORS FOR: Elevation date picker
    @UI("#ElevationDatePicker div.v-picker.v-card.v-picker--date.theme--light.elevation-15")
    public static Section elevatedSection;

    @JDropdown(
            value = "#ElevationDatePicker > div:first-child " +
                    "div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ElevationDatePicker table > tbody button")
    public static Dropdown elevatedDatePicker;

    @JDropdown(
            value = "#ElevationDatePicker > div:nth-child(2) " +
                    "div.v-picker__title__btn.v-date-picker-title__date.v-picker__title__btn--active > div",
            list = "#ElevationDatePicker > nth-child(2) table > tbody button")
    public static Dropdown elevatedSecondDatePicker;

    // LOCATORS FOR: Icons date picker
    @UI("div#IconsDatePicker button[aria-label='Previous month'] i")
    public static Icon leftArrowIconsDP;

    @UI("div#IconsDatePicker button[aria-label='Next month'] i")
    public static Icon rightArrowIconsDP;

    @UI("div#IconsDatePicker div.v-picker__title__btn.v-date-picker-title__year i:only-child")
    public static Icon additionalYearIconIconsDP;

    // LOCATORS FOR: Multiple date picker
    @JDropdown(list = "#MultipleDatePicker table > tbody button")
    public static Dropdown multipleDPButtons;

    @UI("#MultipleDatePicker tr button[class*='active']")
    public static List<Button> activeDateButtonsMultipleDP;

    @UI("#MultipleDatePicker div.v-select__selections > span > span")
    public static List<Text> chosenDatesListMultipleDP;

    @UI("#MultipleDatePicker div.v-date-picker-header__value button")
    public static Button changeMonthButtonMultipleDP;

    // LOCATORS FOR: Picker date date picker
    @UI("#PickerDateDatePicker button[aria-label='Previous month']")
    public static Button previousMonthButtonPickerDateDP;

    @UI("#PickerDateDatePicker button[aria-label='Next month']")
    public static Button nextMonthButtonPickerDateDP;

    @UI("#PickerDateDatePicker div.text-h6")
    public static Text textWithChosenMonthPickerDateDP;

    @UI("#PickerDateDatePicker ul.ma-4 > li")
    public static List<Text> newsPickerDateDP;

    // LOCATORS FOR: Range date picker
    @JDropdown(list = "#RangeDatePicker table > tbody button")
    public static Dropdown rangeDPButtons;

    @UI("#RangeDatePicker tr button[class*='active']")
    public static List<Button> allActiveDateButtonsRangeDP;

    @UI("#RangeDatePicker div.v-text-field__slot input#input-740")
    public static Label textWithTopDateRange;

    @UI("//div[@id='RangeDatePicker']//div[text()[contains(.,'model')]]")
    public static Label modelDateRangeDP;

    @UI("#RangeDatePicker div.v-date-picker-header__value button")
    public static Button changeMonthButtonRangeDP;

    // LOCATORS FOR: Read only date picker
    @JDropdown(list = "#ReadonlyDatePicker table > tbody button")
    public static Dropdown readOnlyDropdown;

    @UI("#ReadonlyDatePicker tr button[class*='active']")
    public static Button activeDateButtonReadOnlyDP;

    // LOCATORS FOR: Show current date picker
    @UI("#ShowCurrentDatePicker > div:first-child div[class*='title__btn--active']")
    public static Label currentDateFieldFromFirstShowCurrentDP;

    @UI("#ShowCurrentDatePicker > div:last-child div[class*='title__btn--active']")
    public static Label currentDateFieldFromSecondShowCurrentDP;

    @UI("#ShowCurrentDatePicker > div:last-child button[class*='outlined theme']")
    public static Button outlinedDateShowDP;

    // LOCATORS FOR: Show sibling months date picker
    @UI("#ShowSiblingMonthsDatePicker td:first-child button")
    public static Button firstDateShowSiblingMonthsDP;

    @UI("#ShowSiblingMonthsDatePicker tr:last-child td:last-child button")
    public static Button lastDateShowSiblingMonthsDP;

    // LOCATORS FOR: Width date picker
    @UI("#WidthDatePicker div.v-picker.v-card.v-picker--date.mt-4.theme--light")
    public static Section firstSectionWidthDP;

    @UI("div.v-main__wrap > div.container > div")
    public static Section mainWindow;

    @UI("#WidthDatePicker div[class*='full-width']")
    public static Section secondSectionWidthDP;

    // LOCATORS FOR: Date buttons date picker
    @UI("#DateButtonsDatePicker div.text-body-1.mb-2 > i[class*='checkbox-marked']")
    public static Checkbox doubleClickAnyDateCheckbox;

    @UI("#DateButtonsDatePicker div.text-body-1:nth-child(2) > i[class*='checkbox-marked']")
    public static Checkbox cursorOverMonthCheckbox;

    @UI("#DateButtonsDatePicker div.text-h6.mb-2:nth-child(3)")
    public static Text mousePointerMonthText;

    @UI("#DateButtonsDatePicker div.text-body-1:last-child > i[class*='checkbox-marked']")
    public static Button clickYearCheckbox;

    @UI("#DateButtonsDatePicker tr:first-child button[class*='rounded theme']")
    public static Button firstDateButtonsDP;

    @UI("#DateButtonsDatePicker div.v-date-picker-header__value button")
    public static Button changeMonthButtonDateButtonsDP;

    @UI("#DateButtonsDatePicker div.v-date-picker-table.v-date-picker-table--month.theme--light td:nth-child(3)")
    public static Button finalMonthDateButtonsDP;

    @UI("div#DateButtonsDatePicker div[class*='title__year']")
    public static Button changeYearButtonDateButtonsDP;

    @UI("div#DateButtonsDatePicker ul.v-date-picker-years li:first-child")
    public static Button latestYearButtonDateButtonsDP;

    // LOCATORS FOR: Date events date picker
    @UI("#DateEventsDatePicker div:first-child tbody tr td button div.green.lighten-1")
    public static Icon greenCircle;

    @UI("#DateEventsDatePicker div:last-child tbody tr td button div.red")
    public static Icon redCircle;

    @UI("#DateEventsDatePicker div:last-child tbody tr td button div.v-date-picker-table__events div:nth-child(2)")
    public static Icon blueCircle;

    @UI("#DateEventsDatePicker div:last-child tbody tr td button div.yellow")
    public static Icon yellowCircle;

    // LOCATORS FOR: Active picker date picker
    @JDropdown(
            value = "#ActivePickerDatePicker div.v-input__slot > div input",
            list = "#app div[class*='menuable__content__active'] ul > li",
            expand = "#ActivePickerDatePicker div.v-input__slot > div input")
    public static Dropdown birthdayYearDropdown;

    @JDropdown(list = "#app > div[class*='menuable__content__active'] table > tbody button")
    public static Dropdown birthdayMonthDropdown;

    @JDropdown(list = "#app > div[class*='menuable__content__active'] " +
            "div.v-date-picker-table.v-date-picker-table--date.theme--light > table > tbody button")
    public static Dropdown birthdayDayDropdown;

    // LOCATORS FOR: Dialog and menu date picker
    @JDropdown(
            value = "#DialogAndMenuDatePicker > div:first-child div.v-input__slot > div.v-text-field__slot input",
            list = "#app > div.v-menu__content.theme--light.menuable__content__active > div button",
            expand = "#DialogAndMenuDatePicker > div:first-child div.v-input__slot > div")
    public static Dropdown pickerInMenuDropdown;

    @UI("#DialogAndMenuDatePicker > div:first-child div.v-input__slot > div")
    public static Button pickerInMenuButton;

    @JDropdown(
            value = "#DialogAndMenuDatePicker > div:nth-child(3) div.v-input__slot > div.v-text-field__slot input",
            list = "#app > div.v-dialog__content.v-dialog__content--active > div button",
            expand = "#DialogAndMenuDatePicker > div:nth-child(3) div.v-input__slot > div")
    public static Dropdown pickerInDialogDropdown;

    @UI("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-picker__title.primary " +
            "div[class*='btn--active']")
    public static Button pickerInDialogDate;

    @UI("//div[@id='app']//span[text()[contains(.,'OK')]]")
    public static Button pickerInDialogOkButton;

    @JDropdown(
            value = "#DialogAndMenuDatePicker > div:nth-child(4) div.v-input__slot > div.v-text-field__slot input",
            list = "#app > div.v-menu__content.theme--light.menuable__content__active > div button",
            expand = "#DialogAndMenuDatePicker > div:nth-child(4) div.v-input__slot > div")
    public static Dropdown pickerWithoutButtonsDropdown;

    @UI("//div[@id='app']/div[@class='div.v-menu__content.theme--light.menuable__content__active']" +
            "//span[text()[contains(.,'OK')]]")
    public static Button pickerWithoutButtonsOkButton;

    @UI("//div[@id='app']/div[@class='div.v-menu__content.theme--light.menuable__content__active']" +
            "//span[text()[contains(.,'Cancel')]]")
    public static Button pickerWithoutButtonsCancelButton;

    // LOCATORS FOR: Formatting date picker
    @JDropdown(
            list = "#app > div.v-menu__content.theme--light.menuable__content__active > div button",
            expand = "#FormattingDatePicker div.v-input__slot > div > input")
    public static Dropdown formattingDropdown;

    @UI("#FormattingDatePicker div.v-input__slot > div > input")
    public static TextField dateFieldFormattingDP;

    @UI("#FormattingDatePicker div.v-input__prepend-outer > div")
    public static Icon iconDateFieldFormattingDP;

    @UI("#FormattingDatePicker > div > div:nth-child(1) > p > strong")
    public static Text dateISOFormat;

    @UI("#FormattingDatePicker > div > div:nth-child(2) div.v-input__slot > div > input")
    public static Button dateFieldReadOnlyFormattingDP;

    // LOCATORS FOR: Formatting with external libraries date picker
    @JDropdown(
            value = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(1) " +
                    "div.v-input__slot > div > input",
            list = "#app > div.v-menu__content.theme--light.menuable__content__active > div button",
            expand = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(1) " +
                    "div.v-input__slot > div > input")
    public static Dropdown formattingExternalLibFirstDropdown;

    @JDropdown(
            value = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(2) " +
                    "div.v-input__slot > div > input",
            list = "#app > div.v-menu__content.theme--light.menuable__content__active > div button",
            expand = "#FormattingWithExternalLibrariesDatePicker > div > div:nth-child(2) " +
                    "div.v-input__slot > div > input")
    public static Dropdown formattingExternalLibSecondDropdown;

    // LOCATORS FOR: Internationalization date picker
    @WaitAfterAction(1)
    @UI("#InternationalizationDatePicker > div:nth-child(2) div.v-date-picker-header__value button")
    public static Button swedishDateButton;

    @WaitAfterAction(1)
    @UI("#InternationalizationDatePicker > div:nth-child(2) div.v-date-picker-header.theme--light > div button")
    public static Button swedishYearButton;

    @WaitAfterAction(1)
    @UI("//div[@id='InternationalizationDatePicker']//li[text()[contains(.,'2020')]]")
    public static Button swedish2020YearButton;

    @JDropdown(list = "#InternationalizationDatePicker > div:nth-child(2) " +
            "div.v-date-picker-table.v-date-picker-table--month.theme--light > table button")
    public static Dropdown swedishMonthDropdown;

    @JDropdown(list = "#InternationalizationDatePicker > div:nth-child(2) " +
            "div.v-date-picker-table.v-date-picker-table--date.theme--light > table > tbody button")
    public static Dropdown swedishDatesDropdown;

    @UI("#InternationalizationDatePicker > div:nth-child(2) div[class*='title__btn--active'] > div")
    public static Text swedishDateField;

    @UI("#InternationalizationDatePicker > div:nth-child(1) div[class*='title__btn--active'] > div")
    public static Text chineseDateField;

    // LOCATORS FOR: Orientation date picker
    @UI("#OrientationDatePicker > div.v-picker.v-card.v-picker--date.theme--light > div.v-picker__title.primary")
    public static Section landscapeOrientedSection;

    @UI("#OrientationDatePicker div.v-input--selection-controls__ripple")
    public static Checkbox orientaionSwitcher;

    @UI("#OrientationDatePicker div.v-picker__title.v-picker__title--landscape.primary")
    public static Section portraitOrientedSection;
}
