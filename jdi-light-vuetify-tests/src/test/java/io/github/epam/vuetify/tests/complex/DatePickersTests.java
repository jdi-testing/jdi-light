package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.datePickersPage;
import static io.github.com.pages.DatePickersPage.activeDateButtonReadOnlyDP;
import static io.github.com.pages.DatePickersPage.activeDateButtonsMultipleDP;
import static io.github.com.pages.DatePickersPage.additionalYearIconIconsDP;
import static io.github.com.pages.DatePickersPage.allActiveDateButtonsRangeDP;
import static io.github.com.pages.DatePickersPage.birthdayDayDropdown;
import static io.github.com.pages.DatePickersPage.birthdayMonthDropdown;
import static io.github.com.pages.DatePickersPage.birthdayYearDropdown;
import static io.github.com.pages.DatePickersPage.blueCircle;
import static io.github.com.pages.DatePickersPage.changeMonthButton;
import static io.github.com.pages.DatePickersPage.changeMonthButtonDateButtonsDP;
import static io.github.com.pages.DatePickersPage.changeMonthButtonMultipleDP;
import static io.github.com.pages.DatePickersPage.changeMonthButtonRangeDP;
import static io.github.com.pages.DatePickersPage.changeYearButtonDateButtonsDP;
import static io.github.com.pages.DatePickersPage.chineseDateField;
import static io.github.com.pages.DatePickersPage.chosenDatesListMultipleDP;
import static io.github.com.pages.DatePickersPage.clickYearCheckbox;
import static io.github.com.pages.DatePickersPage.colorsFirstDatePicker;
import static io.github.com.pages.DatePickersPage.currentDateFieldFromFirstShowCurrentDP;
import static io.github.com.pages.DatePickersPage.currentDateFieldFromSecondShowCurrentDP;
import static io.github.com.pages.DatePickersPage.cursorOverMonthCheckbox;
import static io.github.com.pages.DatePickersPage.dateFieldFormattingDP;
import static io.github.com.pages.DatePickersPage.dateFieldReadOnlyFormattingDP;
import static io.github.com.pages.DatePickersPage.dateISOFormat;
import static io.github.com.pages.DatePickersPage.doubleClickAnyDateCheckbox;
import static io.github.com.pages.DatePickersPage.elevatedDatePicker;
import static io.github.com.pages.DatePickersPage.elevatedSecondDatePicker;
import static io.github.com.pages.DatePickersPage.elevatedSection;
import static io.github.com.pages.DatePickersPage.finalMonthDateButtonsDP;
import static io.github.com.pages.DatePickersPage.firstAllowedDate;
import static io.github.com.pages.DatePickersPage.firstColorField;
import static io.github.com.pages.DatePickersPage.firstDateButtonsDP;
import static io.github.com.pages.DatePickersPage.firstDateShowSiblingMonthsDP;
import static io.github.com.pages.DatePickersPage.firstNotAllowedDate;
import static io.github.com.pages.DatePickersPage.firstSectionWidthDP;
import static io.github.com.pages.DatePickersPage.formattingDropdown;
import static io.github.com.pages.DatePickersPage.formattingExternalLibFirstDropdown;
import static io.github.com.pages.DatePickersPage.formattingExternalLibSecondDropdown;
import static io.github.com.pages.DatePickersPage.fourthWeekAllowedDate;
import static io.github.com.pages.DatePickersPage.fourthWeekNotAllowedDate;
import static io.github.com.pages.DatePickersPage.greenCircle;
import static io.github.com.pages.DatePickersPage.iconDateFieldFormattingDP;
import static io.github.com.pages.DatePickersPage.landscapeOrientedSection;
import static io.github.com.pages.DatePickersPage.lastDateShowSiblingMonthsDP;
import static io.github.com.pages.DatePickersPage.latestYearButtonDateButtonsDP;
import static io.github.com.pages.DatePickersPage.leftArrowIconsDP;
import static io.github.com.pages.DatePickersPage.mainWindow;
import static io.github.com.pages.DatePickersPage.modelDateRangeDP;
import static io.github.com.pages.DatePickersPage.monthColorDPDropdown;
import static io.github.com.pages.DatePickersPage.mousePointerMonthText;
import static io.github.com.pages.DatePickersPage.multipleDPButtons;
import static io.github.com.pages.DatePickersPage.newsPickerDateDP;
import static io.github.com.pages.DatePickersPage.nextMonthButtonColorsDP;
import static io.github.com.pages.DatePickersPage.nextMonthButtonPickerDateDP;
import static io.github.com.pages.DatePickersPage.orientaionSwitcher;
import static io.github.com.pages.DatePickersPage.outlinedDateShowDP;
import static io.github.com.pages.DatePickersPage.pickerInDialogDate;
import static io.github.com.pages.DatePickersPage.pickerInDialogDropdown;
import static io.github.com.pages.DatePickersPage.pickerInDialogOkButton;
import static io.github.com.pages.DatePickersPage.pickerInMenuButton;
import static io.github.com.pages.DatePickersPage.pickerInMenuDropdown;
import static io.github.com.pages.DatePickersPage.pickerWithoutButtonsCancelButton;
import static io.github.com.pages.DatePickersPage.pickerWithoutButtonsDropdown;
import static io.github.com.pages.DatePickersPage.pickerWithoutButtonsOkButton;
import static io.github.com.pages.DatePickersPage.portraitOrientedSection;
import static io.github.com.pages.DatePickersPage.previousMonthButtonColorsDP;
import static io.github.com.pages.DatePickersPage.previousMonthButtonPickerDateDP;
import static io.github.com.pages.DatePickersPage.rangeDPButtons;
import static io.github.com.pages.DatePickersPage.readOnlyDropdown;
import static io.github.com.pages.DatePickersPage.redCircle;
import static io.github.com.pages.DatePickersPage.rightArrowIconsDP;
import static io.github.com.pages.DatePickersPage.secondColorField;
import static io.github.com.pages.DatePickersPage.secondSectionWidthDP;
import static io.github.com.pages.DatePickersPage.swedish2020YearButton;
import static io.github.com.pages.DatePickersPage.swedishDateButton;
import static io.github.com.pages.DatePickersPage.swedishDateField;
import static io.github.com.pages.DatePickersPage.swedishDatesDropdown;
import static io.github.com.pages.DatePickersPage.swedishMonthDropdown;
import static io.github.com.pages.DatePickersPage.swedishYearButton;
import static io.github.com.pages.DatePickersPage.textWithChosenMonthPickerDateDP;
import static io.github.com.pages.DatePickersPage.yearColorDPDropdown;
import static io.github.com.pages.DatePickersPage.yellowCircle;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;

public class DatePickersTests extends TestsInit {
    LocalDate date = LocalDate.now();
    LocalDate currentDatePlusOneMonth = date.plusMonths(1);
    LocalDate currentDateMinusOneMonth = date.minusMonths(1);
    DateTimeFormatter formatterDow = DateTimeFormatter.ofPattern("ccc, LLL d");
    DateTimeFormatter formatterMonth = DateTimeFormatter.ofPattern("MMMM YYYY");
    DateTimeFormatter formatterYearHyphenMonth = DateTimeFormatter.ofPattern("YYYY-MM");
    DateTimeFormatter formatterMMDDYYYY = DateTimeFormatter.ofPattern("MM/dd/uuuu");

    public static final int THIRD_MONTH_OF_YEAR = 3;
    public static final int FIRST_DAY_OF_MONTH = 1;
    public static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;
    public static final int CHOSEN_DAY = 12;
    public static final int CHOSEN_DAY_TWO = 20;
    public static final int CHOSEN_DAY_THREE = 25;
    public static final String CHOSEN_MONTH = "may";
    public static final String CHOSEN_YEAR = "1980";
    public static final String CHOSEN_MONTH_SWEDISH = "maj";
    public static final String CHOSEN_DATE_SWEDISH = "tis 12 maj";
    public static final String CHOSEN_DATE_CHINESE = "5月12日周二";
    public static final String GREEN_COLOR_HEX = "#66bb6a";
    public static final String BLUE_COLOR_HEX = "#1976d2";
    public static final String BLUE_CIRCLE_COLOR_HEX = "#0000ff";
    public static final String RED_CIRCLE_COLOR_HEX = "#f44336";
    public static final String YELLOW_CIRCLE_COLOR_HEX = "#ffeb3b";
    public static final String BIRTHDAY_DAY = "1980-05-12";
    public static final String FORMATTING_DATE = "02/05/2021";
    public static final String FORMATTING_DATE_ISO = "2021-02-05";

    int currentYear = Year.now().getValue();
    int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
    int currentDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

    String getDayOfMonthSuffix(int n) {
        if (n >= 11 && n <= 13) {
            return "th";
        }
        switch (n % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    Timer timer;
    WebDriverWait wait;

    @BeforeClass
    public void beforeTest() {
        datePickersPage.open();
    }

    @Test
    public void testAllowedDatesPicker() {
        firstAllowedDate.click();
        jdiAssert(firstAllowedDate.isEnabled(), is(true),
                "Allowed elements in Allowed dates date picker are disabled");
        fourthWeekAllowedDate.click();
        jdiAssert(fourthWeekAllowedDate.isEnabled(), is(true),
                "Allowed elements in Allowed dates date picker are disabled");
        jdiAssert(firstNotAllowedDate.attr("disabled"), is("true"),
                "Not allowed elements in Allowed dates date picker are enabled");
        jdiAssert(fourthWeekNotAllowedDate.attr("disabled"), is("true"),
                "Not allowed elements in Allowed dates date picker are enabled");
    }

    @Test
    public void testColorDatePicker() throws InterruptedException {
        wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        timer = new Timer(5000L);
        timer.wait(() -> firstColorField.isVisible());
        jdiAssert(colorsFirstDatePicker.getText(), is(date.format(formatterDow)),
                "Current date is incorrect");
        jdiAssert(Color.fromString(firstColorField.css("background-color")).asHex(),
                is(GREEN_COLOR_HEX), "Colors in Colors date picker are incorrect");
        jdiAssert(Color.fromString(secondColorField.css("background-color")).asHex(),
                is(BLUE_COLOR_HEX), "Colors in Colors date picker are incorrect");
        colorsFirstDatePicker.select(CHOSEN_DAY);
        wait.until(ExpectedConditions.textToBePresentInElement(colorsFirstDatePicker.core(),
                Integer.toString(CHOSEN_DAY)));
        jdiAssert(colorsFirstDatePicker.getText(), containsString(Integer.toString(CHOSEN_DAY)),
                "After clicking chosen day of month: shown date is wrong");
        colorsFirstDatePicker.select(CHOSEN_DAY_THREE);
        wait.until(ExpectedConditions.textToBePresentInElement(colorsFirstDatePicker.core(),
                Integer.toString(CHOSEN_DAY_THREE)));
        jdiAssert(colorsFirstDatePicker.getText(), containsString(Integer.toString(CHOSEN_DAY_THREE)),
                "After clicking chosen day of month: shown date is wrong");
        nextMonthButtonColorsDP.click();
        String nextMonth = currentDatePlusOneMonth.getMonth().toString().substring(0, 1)
                + currentDatePlusOneMonth.getMonth().toString().substring(1).toLowerCase();
        wait.until(ExpectedConditions.textToBePresentInElement(changeMonthButton.core(), nextMonth));
        jdiAssert(changeMonthButton.getText(), is(currentDatePlusOneMonth.format(formatterMonth)),
                "After clicking next month button: shown month is wrong");
        previousMonthButtonColorsDP.click();
        previousMonthButtonColorsDP.click();
        String previousMonth = currentDateMinusOneMonth.getMonth().toString().substring(0, 1)
                + currentDateMinusOneMonth.getMonth().toString().substring(1).toLowerCase();
        wait.until(ExpectedConditions.textToBePresentInElement(changeMonthButton.core(), previousMonth));
        jdiAssert(changeMonthButton.getText(), is(currentDateMinusOneMonth.format(formatterMonth)),
                "After clicking previous month button: shown month is wrong");
        timer.wait(() -> monthColorDPDropdown.isVisible());
        monthColorDPDropdown.expand();
        monthColorDPDropdown.select(CHOSEN_MONTH);
        String chosenMonth = CHOSEN_MONTH.substring(0, 1).toUpperCase(Locale.ROOT) + CHOSEN_MONTH.substring(1);
        wait.until(ExpectedConditions.textToBePresentInElement(monthColorDPDropdown.core(), chosenMonth));
        jdiAssert(monthColorDPDropdown.getText(), containsString(chosenMonth),
                "After changing of month using month button: shown month is wrong");
        yearColorDPDropdown.expand();
        yearColorDPDropdown.select(Integer.toString(currentYear + 100));
        monthColorDPDropdown.select(CHOSEN_MONTH);
        jdiAssert(monthColorDPDropdown.getText(), containsString(Integer.toString(currentYear + 100)),
                "After changing of year to latest accessible: shown year is wrong");
        yearColorDPDropdown.expand();
        yearColorDPDropdown.select(Integer.toString(currentYear));
        yearColorDPDropdown.expand();
        yearColorDPDropdown.select(Integer.toString(currentYear - 100));
        monthColorDPDropdown.select(CHOSEN_MONTH);
        jdiAssert(monthColorDPDropdown.getText(), containsString(Integer.toString(currentYear - 100)),
                "After changing of year to earliest accessible: shown year is wrong");
    }

    @Test
    public void testElevationDatePicker() {
        wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        timer = new Timer(5000L);
        timer.wait(() -> elevatedSection.isVisible());
        jdiAssert(elevatedSection.css("box-shadow"), is(not("none")),
                "There is no elevation for Elevation date picker cause shadow is absent");
        elevatedDatePicker.select(CHOSEN_DAY);
        wait.until(ExpectedConditions.textToBePresentInElement(elevatedDatePicker.core(), " "));
        jdiAssert(elevatedDatePicker.getText(), containsString(Integer.toString(CHOSEN_DAY)),
                "After clicking chosen date for Elevation date picker: shown date in first Section is wrong");
        jdiAssert(elevatedSecondDatePicker.getText(), containsString(Integer.toString(CHOSEN_DAY)),
                "After clicking chosen date for Elevation date picker: shown date in second Section is wrong");
    }

    @Test
    public void testIconsDatePicker() {
        timer = new Timer(1000L);
        timer.wait(() -> leftArrowIconsDP.isVisible());
        jdiAssert(leftArrowIconsDP.attr("class"), containsString("mdi-skip-previous"),
                "Left arrow in Icons date picker does not have required attributes");
        jdiAssert(rightArrowIconsDP.attr("class"), containsString("mdi-skip-next"),
                "Right arrow in Icons date picker does not have required attributes");
        jdiAssert(additionalYearIconIconsDP.isEnabled(), is(true),
                "There is no required additional picture for year area of Icons date picker");
    }

    @Test
    public void testMultipleDatePicker() {
        timer = new Timer(1000L);
        timer.wait(() -> multipleDPButtons.isVisible());
        multipleDPButtons.select(CHOSEN_DAY);
        multipleDPButtons.select(CHOSEN_DAY_THREE);
        String currentMonthAndYearMultipleDP = changeMonthButtonMultipleDP.getText();
        String currentYearMultipleDP = currentMonthAndYearMultipleDP.
                substring(currentMonthAndYearMultipleDP.indexOf(" ") + 1);
        String currentMonthMultipleDP = currentMonthAndYearMultipleDP.
                substring(0, currentMonthAndYearMultipleDP.indexOf(" "));
        List<String> allChosenButtonDates = activeDateButtonsMultipleDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        List<String> allDisplayedRightMenuDates = allChosenButtonDates.stream().map(elem
                -> LocalDate.of(Integer.parseInt(currentYearMultipleDP),
                Month.valueOf(currentMonthMultipleDP.toUpperCase(Locale.ROOT)).getValue(),
                Integer.parseInt(elem)).toString()).collect(Collectors.toList());
        List<String> allDatesInList = chosenDatesListMultipleDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        assertThat("The dates in right menu of Multiple date picker are not corresponded " +
                        "with chosen date buttons", allDatesInList,
                containsInAnyOrder(allDisplayedRightMenuDates.toArray()));
    }

    @Test
    public void testPickerDateDatePicker() {
        List<String> currentMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        previousMonthButtonPickerDateDP.click();
        List<String> previousMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        jdiAssert(textWithChosenMonthPickerDateDP.getText(),
                containsString(date.minusMonths(1).format(formatterYearHyphenMonth).toString()),
                "Month in news section does not correspond to chosen previous month");
        nextMonthButtonPickerDateDP.click();
        nextMonthButtonPickerDateDP.click();
        List<String> nextMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        jdiAssert(textWithChosenMonthPickerDateDP.getText(),
                containsString(date.plusMonths(1).format(formatterYearHyphenMonth).toString()),
                "Month in news section does not correspond to chosen next month");
        jdiAssert(currentMonthNews, is(not(previousMonthNews)),
                "List of news for current month and previous month are the same");
        jdiAssert(currentMonthNews, is(not(nextMonthNews)),
                "List of news for current month and next month are the same");
    }

    @Test
    public void testRangeDatePicker() {
        timer = new Timer(1000L);
        timer.wait(() -> rangeDPButtons.isVisible());
        rangeDPButtons.select(CHOSEN_DAY);
        rangeDPButtons.select(CHOSEN_DAY_THREE);
        List<String> allChosenDatesInRange = allActiveDateButtonsRangeDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        List<String> expectedNumbersInRange = new ArrayList<>();
        for (int i = CHOSEN_DAY; i < CHOSEN_DAY_THREE + 1; i++) {
            expectedNumbersInRange.add(Integer.toString(i));
        }
        jdiAssert(allChosenDatesInRange, is(expectedNumbersInRange),
                "Not all of dates in range have been chosen");
        String currentMonthAndYearRangeDP = changeMonthButtonRangeDP.getText();
        String currentYearRangeDP = currentMonthAndYearRangeDP.
                substring(currentMonthAndYearRangeDP.indexOf(" ") + 1);
        String currentMonthRangeDP = currentMonthAndYearRangeDP.
                substring(0, currentMonthAndYearRangeDP.indexOf(" "));
        String dateFirstFormattedRangeDP = LocalDate.of(Integer.parseInt(currentYearRangeDP),
                Month.valueOf(currentMonthRangeDP.toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY).toString();
        String dateLastFormattedRangeDP = LocalDate.of(Integer.parseInt(currentYearRangeDP),
                Month.valueOf(currentMonthRangeDP.toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY_THREE).toString();
        jdiAssert(modelDateRangeDP.getText(), allOf(containsString(dateFirstFormattedRangeDP),
                        containsString(dateLastFormattedRangeDP)),
                "Model for Range date picker does not contain selected dates");
    }

    @Test
    public void testReadOnlyDatePicker() {
        timer = new Timer(1000L);
        timer.wait(() -> readOnlyDropdown.isVisible());
        if (currentDay > 1) {
            readOnlyDropdown.select(Integer.toString(currentDay - 1));
            jdiAssert(activeDateButtonReadOnlyDP.getText(), is(not(Integer.toString(currentDay - 1))),
                    "Read only date was active although it has to be read only");
        }
        if (currentDay < 28) {
            readOnlyDropdown.select(Integer.toString(currentDay + 1));
            jdiAssert(activeDateButtonReadOnlyDP.getText(), is(not(Integer.toString(currentDay + 1))),
                    "Read only date was active although it has to be read only");
        }
    }

    @Test
    public void testShowCurrentDatePicker() throws InterruptedException {
        jdiAssert(currentDateFieldFromFirstShowCurrentDP.getText(), is(date.format(formatterDow)),
                "Current date and the date in first Show current date picker are not the same");
        jdiAssert(currentDateFieldFromSecondShowCurrentDP.getText(), is(not(date.format(formatterDow))),
                "Current date and the date in second Show current date picker are the same");
        jdiAssert(outlinedDateShowDP.css("border"), containsString("1px solid"),
                "Outlined date in Show current date picker does not have the border of 1 px");
    }

    @Test
    public void testShowSiblingMonthsDatePicker() {
        if (!firstDateShowSiblingMonthsDP.getText().equals("1")) {
            jdiAssert(firstDateShowSiblingMonthsDP.attr("class"), containsString("disabled"),
                    "Although first date in Show sibling month date picker is not equal to 1, " +
                            "it is not disabled");
        }
        if (Integer.parseInt(lastDateShowSiblingMonthsDP.getText()) < 7) {
            jdiAssert(lastDateShowSiblingMonthsDP.attr("class"), containsString("disabled"),
                    "Although last date in Show sibling month date picker is less than 7, " +
                            "it is not disabled");
        }
    }

    @Test
    public void testWidthDatePicker() {
        timer = new Timer(1000L);
        timer.wait(() -> firstSectionWidthDP.isVisible());
        jdiAssert(firstSectionWidthDP.getSize().getWidth(), is(WIDTH_OF_PREDEFINED_WIDTH_DP),
                "Width of first Width date picker is not equal to predefined value");
        jdiAssert(secondSectionWidthDP.getSize().getWidth(), is(mainWindow.getSize().getWidth()),
                "Width of full width date picker is not equal to width of main window");
    }

    @Test
    public void testDateButtonsDatePicker() {
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(false),
                "Before clicking any date: Checkbox 'Double click on any date' is selected");
        firstDateButtonsDP.doubleClick();
        Alert alert_window = WebDriverFactory.getDriver().switchTo().alert();
        alert_window.accept();
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(true),
                "After clicking the date: Checkbox 'Double click on any date' is not selected");
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(false),
                "Before moving the cursor to any month: " +
                        "Checkbox 'Move mouse cursor over any month button' is selected");
        changeMonthButtonDateButtonsDP.click();
        finalMonthDateButtonsDP.hover();
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(true),
                "After moving the cursor to the month: Checkbox 'Move mouse cursor " +
                        "over any month button' is not selected");
        String chosenDate = LocalDate.of(currentYear, THIRD_MONTH_OF_YEAR,
                FIRST_DAY_OF_MONTH).format(formatterYearHyphenMonth);
        jdiAssert(mousePointerMonthText.getText(), containsString(chosenDate),
                "After clicking the month: Mouse pointer date text is absent");
        jdiAssert(clickYearCheckbox.isExist(), is(false),
                "Before clicking any year: Checkbox 'Right click on any year' is selected");
        changeYearButtonDateButtonsDP.click();
        latestYearButtonDateButtonsDP.rightClick();
        alert_window.accept();
        jdiAssert(clickYearCheckbox.isExist(), is(true),
                "Before clicking the year: Checkbox 'Right click on any year' is not selected");
    }

    @Test
    public void testDateEventsDatePicker() {
        Timer timer = new Timer(1000L);
        timer.wait(() -> greenCircle.isVisible());
        jdiAssert(Color.fromString(greenCircle.css("background-color")).asHex(), is(GREEN_COLOR_HEX),
                "Green color of event sign is wrong");
        jdiAssert(Color.fromString(redCircle.css("background-color")).asHex(), is(RED_CIRCLE_COLOR_HEX),
                "Red color of event sign is wrong");
        jdiAssert(Color.fromString(yellowCircle.css("background-color")).asHex(), is(YELLOW_CIRCLE_COLOR_HEX),
                "Yellow color of event sign is wrong");
        jdiAssert(Color.fromString(blueCircle.css("background-color")).asHex(), is(BLUE_CIRCLE_COLOR_HEX),
                "Blue color of event sign is wrong");
    }

    @Test
    public void testActivePickerDatePicker() {
        Timer timer = new Timer(1000L);
        timer.wait(() -> birthdayYearDropdown.isVisible());
        birthdayYearDropdown.expand();
        birthdayYearDropdown.select(CHOSEN_YEAR);
        birthdayMonthDropdown.select(CHOSEN_MONTH);
        birthdayDayDropdown.select(CHOSEN_DAY);
        jdiAssert(birthdayYearDropdown.getText(), is(BIRTHDAY_DAY),
                "After birthday choosing: shown date is wrong");
    }

    @Test
    public void testDialogAndMenuDatePicker() {
        Timer timer = new Timer(3000L);
        timer.wait(() -> pickerInMenuButton.isVisible());
        jdiAssert(pickerInMenuDropdown.attr("readonly"), is("true"),
                "Date field in Picker in menu does not have read-only property");
        jdiAssert(pickerInDialogDropdown.attr("readonly"), is("true"),
                "Date field in Picker in dialog does not have read-only property");
        jdiAssert(pickerWithoutButtonsDropdown.attr("readonly"), is("true"),
                "Date field in Picker in menu does not have read-only property");
        pickerInMenuDropdown.expand();
        pickerInMenuDropdown.select(Integer.toString(CHOSEN_DAY));
        String chosenDate = LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).toString();
        jdiAssert(pickerInMenuDropdown.getText(), is(chosenDate),
                "After clicking the date in Picker in menu: shown date in the field is wrong");
        pickerInDialogDropdown.expand();
        pickerInDialogDropdown.select(Integer.toString(CHOSEN_DAY_TWO));
        LocalDate chosenDateTwo = LocalDate.of(currentYear, currentMonth, CHOSEN_DAY_TWO);
        String chosenDateTwoFormatted = chosenDateTwo.format(formatterDow);
        pickerInDialogDropdown.hover();
        jdiAssert(pickerInDialogDate.getText(), is(chosenDateTwoFormatted),
                "After clicking the date in Picker in dialog: shown date in the dialog field is wrong");
        jdiAssert(pickerInDialogDropdown.getText(), is(chosenDateTwo.toString()),
                "After clicking the date in Picker in dialog: shown date in the main field is wrong");
        pickerInDialogOkButton.click();
        pickerWithoutButtonsDropdown.expand();
        jdiAssert(pickerWithoutButtonsOkButton.isExist(), is(false),
                "There is OK button in Picker without buttons");
        jdiAssert(pickerWithoutButtonsCancelButton.isExist(), is(false),
                "There is Cancel button in Picker without buttons");
        pickerWithoutButtonsDropdown.select(Integer.toString(CHOSEN_DAY_THREE));
        String chosenDateThree = LocalDate.of(currentYear, currentMonth, CHOSEN_DAY_THREE).toString();
        jdiAssert(pickerWithoutButtonsDropdown.getText(), is(chosenDateThree),
                "After clicking the date in Picker without buttons: shown date in the field is wrong");
    }

    @Test
    public void testFormattingDatePicker() throws InterruptedException {
        Timer timer = new Timer(1000L);
        timer.wait(() -> dateFieldFormattingDP.isVisible());
        formattingDropdown.expand();
        formattingDropdown.select(Integer.toString(CHOSEN_DAY));
        jdiAssert(dateFieldFormattingDP.getText(),
                is(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).format(formatterMMDDYYYY)),
                "After clicking the date in Formatting: shown date in the main field is wrong");
        jdiAssert(dateISOFormat.getText(), is(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).toString()),
                "After clicking the date in Formatting: shown date in ISO format is wrong");
        for (int i = 0; i < 11; i++) {
            dateFieldFormattingDP.sendKeys(Keys.BACK_SPACE);
        }
        dateFieldFormattingDP.setValue(FORMATTING_DATE);
        iconDateFieldFormattingDP.click();
        jdiAssert(dateISOFormat.getText(), is(FORMATTING_DATE_ISO),
                "After putting the date in Formatting using key sending: shown date in ISO format is wrong");
        jdiAssert(dateFieldReadOnlyFormattingDP.attr("readonly"), is("true"),
                "Main date field in Formatting read only date picker does not have read-only attribute");
    }

    @Test
    public void testFormattingWithExternalLibrariesDatePicker() {
        Timer timer = new Timer(1000L);
        timer.wait(() -> formattingExternalLibFirstDropdown.isVisible());
        formattingExternalLibFirstDropdown.expand();
        formattingExternalLibFirstDropdown.select(Integer.toString(CHOSEN_DAY));
        DateTimeFormatter formatterJS = DateTimeFormatter.
                ofPattern("cccc, MMMM d'" + getDayOfMonthSuffix(CHOSEN_DAY) + "' yyyy");
        jdiAssert(formattingExternalLibFirstDropdown.getText(),
                is(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).format(formatterJS)),
                "After clicking the date in Formatting with first external library: " +
                        "shown date in the main field is wrong");
        formattingExternalLibSecondDropdown.expand();
        formattingExternalLibSecondDropdown.select(Integer.toString(CHOSEN_DAY));
        jdiAssert(formattingExternalLibSecondDropdown.getText(),
                is(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).format(formatterJS)),
                "After clicking the date in Formatting with second external library: " +
                        "shown date in the main field is wrong");
    }

    @Test
    public void testInternationalizationDatePicker() {
        wait = new WebDriverWait(WebDriverFactory.getDriver(), 5);
        timer = new Timer(10000L);
        timer.wait(() -> swedishDateButton.isExist());
        swedishDateButton.click();
        swedishYearButton.click();
        swedish2020YearButton.click();
        swedishMonthDropdown.select(CHOSEN_MONTH_SWEDISH);
        swedishDatesDropdown.select(CHOSEN_DAY);
        wait.until(ExpectedConditions.textToBePresentInElement(swedishDateField.core(), CHOSEN_MONTH_SWEDISH));
        wait.until(ExpectedConditions.textToBePresentInElement(swedishDateField.core(), Integer.toString(CHOSEN_DAY)));
        jdiAssert(swedishDateField.getText(), is(CHOSEN_DATE_SWEDISH),
                "After clicking the date in Swedish date picker: shown date in the main field is wrong");
        jdiAssert(chineseDateField.getText(), is(CHOSEN_DATE_CHINESE),
                "After clicking the date in Chinese date picker: shown date in the main field is wrong");
    }

    @Test
    public void testOrientationDatePicker() {
        Timer timer = new Timer(3000L);
        timer.wait(() -> landscapeOrientedSection.isExist());
        int landscapeOrientedTitleWidth = landscapeOrientedSection.getSize().getWidth();
        int landscapeOrientedTitleHeight = landscapeOrientedSection.getSize().getHeight();
        orientaionSwitcher.check();
        int portraitOrientedTitleHeight = portraitOrientedSection.getSize().getHeight();
        jdiAssert(landscapeOrientedTitleWidth, is(portraitOrientedTitleHeight),
                "Width of landscape oriented title section is not equal to height " +
                        "of portrait oriented section");
        jdiAssert(landscapeOrientedTitleHeight, lessThan(portraitOrientedTitleHeight),
                "Height of landscape oriented title section is more than height " +
                        "of portrait oriented section");
    }
}
