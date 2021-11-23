package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.driver.WebDriverFactory;
import com.epam.jdi.tools.Timer;
import io.github.epam.TestsInit;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static io.github.com.StaticSite.datePickersPage;
import static io.github.com.pages.DatePickersPage.activePickerDP;
import static io.github.com.pages.DatePickersPage.allowedDP;
import static io.github.com.pages.DatePickersPage.chineseDP;
import static io.github.com.pages.DatePickersPage.clickYearCheckbox;
import static io.github.com.pages.DatePickersPage.colorFirstDP;
import static io.github.com.pages.DatePickersPage.colorSecondDP;
import static io.github.com.pages.DatePickersPage.cursorOverMonthCheckbox;
import static io.github.com.pages.DatePickersPage.dateButtonsDP;
import static io.github.com.pages.DatePickersPage.doubleClickAnyDateCheckbox;
import static io.github.com.pages.DatePickersPage.elevationWithElevationDP;
import static io.github.com.pages.DatePickersPage.firstDateEventsDP;
import static io.github.com.pages.DatePickersPage.firstShowCurrentDP;
import static io.github.com.pages.DatePickersPage.firstWidthDP;
import static io.github.com.pages.DatePickersPage.formattedDatefnsDP;
import static io.github.com.pages.DatePickersPage.formattedMomentJsDP;
import static io.github.com.pages.DatePickersPage.iconsDP;
import static io.github.com.pages.DatePickersPage.mainWindow;
import static io.github.com.pages.DatePickersPage.modelDateRangeDP;
import static io.github.com.pages.DatePickersPage.mousePointerMonthText;
import static io.github.com.pages.DatePickersPage.multipleInMenuDP;
import static io.github.com.pages.DatePickersPage.multipleDP;
import static io.github.com.pages.DatePickersPage.newsPickerDateDP;
import static io.github.com.pages.DatePickersPage.orientationDP;
import static io.github.com.pages.DatePickersPage.pickerDateDP;
import static io.github.com.pages.DatePickersPage.pickerInDialogDP;
import static io.github.com.pages.DatePickersPage.pickerInMenuDP;
import static io.github.com.pages.DatePickersPage.pickerWithoutButtonsDP;
import static io.github.com.pages.DatePickersPage.rangeDP;
import static io.github.com.pages.DatePickersPage.readOnlyDP;
import static io.github.com.pages.DatePickersPage.readonlyFormattingDP;
import static io.github.com.pages.DatePickersPage.secondDateEventsDP;
import static io.github.com.pages.DatePickersPage.secondShowCurrentDP;
import static io.github.com.pages.DatePickersPage.secondWidthDP;
import static io.github.com.pages.DatePickersPage.showSiblingMonthsDP;
import static io.github.com.pages.DatePickersPage.swedishDP;
import static io.github.com.pages.DatePickersPage.textWithChosenMonthPickerDateDP;
import static io.github.com.pages.DatePickersPage.writableFormattingDP;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class DatePickersTests extends TestsInit {
    LocalDate date = LocalDate.now();
    DateTimeFormatter formatterDow = DateTimeFormatter.ofPattern("ccc, LLL d");
    DateTimeFormatter formatterYearHyphenMonth = DateTimeFormatter.ofPattern("YYYY-MM");
    DateTimeFormatter formatterMMDDYYYY = DateTimeFormatter.ofPattern("MM/dd/uuuu");

    public static final int FIFTH_MONTH_OF_YEAR = 5;
    public static final int FIRST_DAY_OF_MONTH = 1;
    public static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;
    public static final int CHOSEN_DAY = 12;
    public static final int CHOSEN_DAY_TWO = 20;
    public static final int CHOSEN_DAY_THREE = 25;
    public static final String CHOSEN_MONTH = "May";
    public static final String CHOSEN_YEAR = "1980";
    public static final String CHOSEN_MONTH_SWEDISH = "maj";
    public static final String CHOSEN_MONTH_CHINESE = "5月";
    public static final String GREEN_COLOR_HEX = "#66bb6a";
    public static final String BLUE_COLOR_HEX = "#1976d2";
    public static final String BLUE_CIRCLE_COLOR_HEX = "#0000ff";
    public static final String RED_CIRCLE_COLOR_HEX = "#f44336";
    public static final String YELLOW_CIRCLE_COLOR_HEX = "#ffeb3b";
    public static final String FORMATTING_DATE = "02/05/2021";
    public static final String FORMATTING_DATE_ISO = "2021-02-05";
    public static final String NEXT_MONTH_ICON_CLASS = "mdi-skip-next";
    public static final String PREVIOUS_MONTH_ICON_CLASS = "mdi-skip-previous";
    public static final String ELEVATION = "15px";
    public static final String EMPTY_DATE_FIELD = "-";
    public static final String SELECTION_TEXT = " selected";
    public static final String RANGE_SELECTION_TEXT = "2 selected";
    public static final String DATE_BORDER = "1px";

    int currentYear = Year.now().getValue();
    int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;

    public static final List<String> CHECKED_MULTIPLE_DATES = Arrays.asList("1", "10", "15", "16",
            "20", "23", "29");
    public static final List<String> SWEDISH_SHORT_DAYS_OF_WEEK = Arrays.asList("mån", "tis", "ons", "tors",
            "fre", "lör", "sön");
    public static final List<String> SWEDISH_SHORT_MONTHS = Arrays.asList("JAN.", "FEB.", "MARS", "APR.",
            "MAJ", "JUNI", "JULI", "AUG.", "SEP.", "OKT.", "NOV.", "DEC.");
    public static final List<String> SWEDISH_FULL_MONTHS = Arrays.asList("januari", "februari", "mars",
            "april", "maj", "juni", "juli", "augusti", "september", "oktober", "november", "december");
    public static final List<String> CHINESE_DAYS_OF_WEEK = Arrays.asList("日周一", "日周二", "日周三",
            "日周四", "日周五", "日周六", "日周日");
    public static final List<String> CHINESE_MONTHS = Arrays.asList("1月", "2月", "3月", "4月",
            "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月");

    @BeforeClass
    public void beforeTest() {
        datePickersPage.open();
    }

    @Test
    public void testAllowedDatesPicker() {
        Timer.waitCondition(() -> allowedDP.isVisible());
        allowedDP.has().disabledDatesNonEmptyList();
        allowedDP.getEnabledDates();
        allowedDP.has().clickableEnabledDates();
        allowedDP.has().nonClickableDisabledDates();
    }

    @Test
    public void testColorDatePicker() {
        Timer.waitCondition(() -> colorFirstDP.isVisible());
        Timer.waitCondition(() -> colorSecondDP.isVisible());
        String nextMonth = date.plusMonths(1).getMonth().toString().substring(0, 1)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().substring(0, 1)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
        colorFirstDP.has().date(date.format(formatterDow));
        colorFirstDP.has().color(GREEN_COLOR_HEX);
        colorSecondDP.has().color(BLUE_COLOR_HEX);
        colorFirstDP.selectDay(Integer.toString(CHOSEN_DAY));
        colorFirstDP.has().dayOfMonth(Integer.toString(CHOSEN_DAY));
        colorFirstDP.selectDay(Integer.toString(CHOSEN_DAY_TWO));
        colorFirstDP.has().dayOfMonth(Integer.toString(CHOSEN_DAY_TWO));
        colorFirstDP.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        colorFirstDP.has().dayOfMonth(Integer.toString(CHOSEN_DAY_THREE));
        colorFirstDP.nextMonth();
        colorFirstDP.has().month(nextMonth);
        colorFirstDP.previousMonth();
        colorFirstDP.previousMonth();
        colorFirstDP.has().month(previousMonth);
        colorFirstDP.changeMonth();
        colorFirstDP.selectMonth(CHOSEN_MONTH);
        colorFirstDP.has().month(CHOSEN_MONTH);
        colorFirstDP.changeMonth();
        colorFirstDP.changeYear();
        colorFirstDP.selectYear(Integer.toString(currentYear + 100));
        colorFirstDP.has().year(Integer.toString(currentYear + 100));
        colorFirstDP.changeYear();
        colorFirstDP.selectYear(Integer.toString(currentYear));
        colorFirstDP.changeYear();
        colorFirstDP.selectYear(Integer.toString(currentYear - 100));
        colorFirstDP.has().year(Integer.toString(currentYear - 100));
        colorFirstDP.changeYearCornerButton();
        colorFirstDP.selectYear(Integer.toString(currentYear));
        colorFirstDP.has().year(Integer.toString(currentYear ));
    }

    @Test
    public void testElevationDatePicker() {
        Timer.waitCondition(() -> elevationWithElevationDP.isVisible());
        elevationWithElevationDP.has().elevation(ELEVATION);
    }

    @Test
    public void testIconsDatePicker() {
        Timer.waitCondition(() -> iconsDP.isVisible());
        iconsDP.has().nextMonthIconClass(NEXT_MONTH_ICON_CLASS);
        iconsDP.has().previousMonthIconClass(PREVIOUS_MONTH_ICON_CLASS);
        iconsDP.has().additionalYearIcon();
    }

    @Test
    public void testMultipleDatePicker() {
        Timer.waitCondition(() -> multipleDP.isVisible());
        String monthMultipleDP = multipleDP.getMonth(Locale.ENGLISH);
        List<String> firstlyActiveDaysOfMonth = multipleDP.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysOfMonth.contains(elem)) {
                multipleDP.selectDay(elem);
            }
        });
        firstlyActiveDaysOfMonth.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDays = new HashSet<>(firstlyActiveDaysOfMonth);
        multipleDP.has().properSetOfActiveDays(allExpectedChosenDays);
        multipleDP.has().date(allExpectedChosenDays.size() + SELECTION_TEXT);
        allExpectedChosenDays.stream().forEach(elem -> multipleDP.selectDay(elem));
        multipleDP.has().date(EMPTY_DATE_FIELD);
        multipleDP.selectDay(Integer.toString(CHOSEN_DAY));
        multipleDP.has().date(LocalDate.of(Integer.parseInt(multipleDP.getYear()),
                Month.valueOf(monthMultipleDP.toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(formatterDow));

        multipleInMenuDP.expand();
        List<String> firstlyActiveDaysInMenu = multipleInMenuDP.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysInMenu.contains(elem)) {
                multipleInMenuDP.selectDay(elem);
            }
        });
        firstlyActiveDaysInMenu.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDaysInMenu = new HashSet<>(firstlyActiveDaysInMenu);
        multipleInMenuDP.has().properSetOfActiveDays(allExpectedChosenDaysInMenu);
        multipleInMenuDP.has().properShownMultipleDates();
    }

    @Test
    public void testPickerDateDatePicker() {
        List<String> currentMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        pickerDateDP.previousMonth();
        List<String> previousMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        jdiAssert(textWithChosenMonthPickerDateDP.getText(),
                containsString(date.minusMonths(1).format(formatterYearHyphenMonth)),
                "Month in news section does not correspond to chosen previous month");
        pickerDateDP.nextMonth();
        pickerDateDP.nextMonth();
        List<String> nextMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        jdiAssert(textWithChosenMonthPickerDateDP.getText(),
                containsString(date.plusMonths(1).format(formatterYearHyphenMonth)),
                "Month in news section does not correspond to chosen next month");
        jdiAssert(currentMonthNews, is(not(previousMonthNews)),
                "List of news for current month and previous month are the same");
        jdiAssert(currentMonthNews, is(not(nextMonthNews)),
                "List of news for current month and next month are the same");
    }

    @Test
    public void testRangeDatePicker() {
        Timer.waitCondition(() -> rangeDP.isVisible());
        rangeDP.selectDay(Integer.toString(CHOSEN_DAY));
        rangeDP.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        rangeDP.has().properRangeDates(CHOSEN_DAY, CHOSEN_DAY_THREE);
        rangeDP.has().date(RANGE_SELECTION_TEXT);
        String dateFirstFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeDP.getYear()),
                Month.valueOf(rangeDP.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY).toString();
        String dateSecondFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeDP.getYear()),
                Month.valueOf(rangeDP.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY_THREE).toString();
        jdiAssert(modelDateRangeDP.getText(), allOf(containsString(dateFirstFormattedRangeDP),
                        containsString(dateSecondFormattedRangeDP)),
                "Model for Range date picker does not contain selected dates");
    }

    @Test
    public void testReadOnlyDatePicker() {
        String firstlyActiveDay = readOnlyDP.getActiveDayOfMonth();
        String checkedDay;
        if (Integer.parseInt(firstlyActiveDay) > 2 | Integer.parseInt(firstlyActiveDay) < 27) {
            checkedDay = firstlyActiveDay;
        } else checkedDay = "15";
        readOnlyDP.selectDay(Integer.toString(Integer.parseInt(checkedDay) - 1));
        readOnlyDP.has().dayOfMonth(firstlyActiveDay);
        readOnlyDP.selectDay(Integer.toString(Integer.parseInt(checkedDay) + 1));
        readOnlyDP.has().dayOfMonth(firstlyActiveDay);
    }

    @Test
    public void testShowCurrentDatePicker() {
        firstShowCurrentDP.has().date(date.format(formatterDow));
        secondShowCurrentDP.has().properOutlinedDateBorder(DATE_BORDER);
    }

    @Test
    public void testShowSiblingMonthsDatePicker() {
        showSiblingMonthsDP.has().disabledDatesNonEmptyList();
    }

    @Test
    public void testWidthDatePicker() {
        Timer.waitCondition(() -> firstWidthDP.isVisible());
        firstWidthDP.has().pickerWidth(WIDTH_OF_PREDEFINED_WIDTH_DP);
        secondWidthDP.has().pickerWidth(mainWindow.getSize().getWidth());
    }

    @Test
    public void testDateButtonsDatePicker() {
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(false),
                "Before clicking any date: Checkbox 'Double click on any date' is selected");
        dateButtonsDP.doubleClickDay(Integer.toString(CHOSEN_DAY));
        Alert alert_window = WebDriverFactory.getDriver().switchTo().alert();
        alert_window.accept();
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(true),
                "After clicking the date: Checkbox 'Double click on any date' is not selected");
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(false),
                "Before moving the cursor to any month: " +
                        "Checkbox 'Move mouse cursor over any month button' is selected");
        dateButtonsDP.changeMonth();
        dateButtonsDP.hoverMonth(CHOSEN_MONTH);
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(true),
                "After moving the cursor to the month: Checkbox 'Move mouse cursor " +
                        "over any month button' is not selected");
        String chosenDate = LocalDate.of(currentYear, FIFTH_MONTH_OF_YEAR,
                FIRST_DAY_OF_MONTH).format(formatterYearHyphenMonth);
        jdiAssert(mousePointerMonthText.getText(), containsString(chosenDate),
                "After clicking the month: Mouse pointer date text is absent");
        jdiAssert(clickYearCheckbox.isExist(), is(false),
                "Before clicking any year: Checkbox 'Right click on any year' is selected");
        dateButtonsDP.changeYear();
        dateButtonsDP.rightClickYear(CHOSEN_YEAR);
        alert_window.accept();
        jdiAssert(clickYearCheckbox.isExist(), is(true),
                "Before clicking the year: Checkbox 'Right click on any year' is not selected");
    }

    @Test
    public void testDateEventsDatePicker() {
        firstDateEventsDP.has().eventColorCirclesNonEmptyList();
        secondDateEventsDP.has().eventColorCirclesNonEmptyList();
        List<String> al = new ArrayList<>();
        al.add(GREEN_COLOR_HEX);
        firstDateEventsDP.has().properColorsOfEventCircles(GREEN_COLOR_HEX);
        secondDateEventsDP.has().properColorsOfEventCircles(
                BLUE_CIRCLE_COLOR_HEX, RED_CIRCLE_COLOR_HEX, YELLOW_CIRCLE_COLOR_HEX);
    }

    @Test
    public void testActivePickerDatePicker() {
        Timer.waitCondition(() -> activePickerDP.isVisible());
        jdiAssert(activePickerDP.getCode(), is("null"), "Before any date in Active date picker " +
                "is selected: active picker code is not null");
        activePickerDP.expand();
        activePickerDP.selectYear(CHOSEN_YEAR);
        activePickerDP.selectMonth(CHOSEN_MONTH);
        activePickerDP.selectDay(Integer.toString(CHOSEN_DAY));
        activePickerDP.has().resultDate(LocalDate.of(Integer.parseInt(CHOSEN_YEAR),
                Month.valueOf(CHOSEN_MONTH.toUpperCase(Locale.ROOT)), CHOSEN_DAY).toString());
        jdiAssert(activePickerDP.getCode(), is("DATE"), "After some date in Active date picker " +
                "was selected: active picker code is not correct");
    }

    @Test
    public void testDialogAndMenuDatePicker() {
        Timer.waitCondition(() -> pickerInMenuDP.isVisible());
        String nextMonth = date.plusMonths(1).getMonth().toString().substring(0, 1)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().substring(0, 1)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
        pickerInMenuDP.expand();
        pickerInMenuDP.has().resultDate(date.toString());
        pickerInMenuDP.selectDay(Integer.toString(CHOSEN_DAY));
        pickerInMenuDP.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).toString());
        pickerInMenuDP.selectDay(Integer.toString(CHOSEN_DAY_TWO));
        pickerInMenuDP.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY_TWO).toString());
        pickerInMenuDP.nextMonth();
        pickerInMenuDP.has().month(nextMonth);
        pickerInMenuDP.previousMonth();
        pickerInMenuDP.previousMonth();
        pickerInMenuDP.has().month(previousMonth);
        pickerInMenuDP.changeMonth();
        pickerInMenuDP.selectMonth(CHOSEN_MONTH);
        pickerInMenuDP.has().month(CHOSEN_MONTH);
        pickerInMenuDP.changeMonth();
        pickerInMenuDP.has().visibleChangeYearButton();
        pickerInMenuDP.changeYear();
        pickerInMenuDP.selectYear(Integer.toString(currentYear + 99));
        pickerInMenuDP.has().year(Integer.toString(currentYear + 99));
        pickerInMenuDP.has().visibleChangeYearButton();
        pickerInMenuDP.changeYear();
        pickerInMenuDP.selectYear(Integer.toString(currentYear));
        pickerInMenuDP.has().visibleChangeYearButton();
        pickerInMenuDP.changeYear();
        pickerInMenuDP.selectYear(Integer.toString(currentYear - 99));
        pickerInMenuDP.has().year(Integer.toString(currentYear - 99));
        pickerInMenuDP.clickOk();
        pickerInMenuDP.expand();
        pickerInMenuDP.has().mainDateFieldIsNotExist();
        pickerInMenuDP.clickCancel();
        pickerInDialogDP.expand();
        pickerInDialogDP.has().mainDateField();
        pickerInDialogDP.clickOk();
        pickerWithoutButtonsDP.expand();
        pickerWithoutButtonsDP.has().cancelButtonIsNotExist();
        pickerWithoutButtonsDP.has().okButtonIsNotExist();
    }

    @Test
    public void testFormattingDatePicker() {
        Timer.waitCondition(() -> writableFormattingDP.isVisible());
        writableFormattingDP.expand();
        writableFormattingDP.selectDay(Integer.toString(CHOSEN_DAY));
        writableFormattingDP.has().resultDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY).format(formatterMMDDYYYY));
        writableFormattingDP.clear();
        writableFormattingDP.setDate(FORMATTING_DATE);
        writableFormattingDP.has().resultDate(FORMATTING_DATE);
        writableFormattingDP.has().formattedDate(FORMATTING_DATE_ISO);
        readonlyFormattingDP.has().dateFieldReadonlyAttribute();
    }

    @Test
    public void testFormattingWithExternalLibrariesDatePicker() {
        Timer.waitCondition(() -> formattedMomentJsDP.isVisible());
        formattedMomentJsDP.expand();
        formattedMomentJsDP.selectDay(Integer.toString(CHOSEN_DAY));
        formattedMomentJsDP.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY));
        formattedDatefnsDP.expand();
        formattedDatefnsDP.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        formattedDatefnsDP.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY_THREE));
    }

    @Test
    public void testInternationalizationDatePicker() {
        Timer.waitCondition(() -> swedishDP.isVisible());
        swedishDP.changeMonth();
        swedishDP.has().visibleChangeYearButton();
        swedishDP.changeYear();
        swedishDP.selectYear(CHOSEN_YEAR);
        swedishDP.has().year(CHOSEN_YEAR);
        swedishDP.selectMonth(CHOSEN_MONTH_SWEDISH);
        List<String> shownSwedishDaysOfWeek = new ArrayList<>();
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            swedishDP.selectDay(Integer.toString(i));
            swedishDP.has().dayOfMonth(Integer.toString(i), new Locale("sv", "SE"));
            Pattern swedishDayOfWeekPattern = Pattern.compile("^[a-zwåäöÅÄÖ]+");
            Matcher matcher = swedishDayOfWeekPattern.matcher(swedishDP.getDate());
            while (matcher.find()) {
                shownSwedishDaysOfWeek.add(matcher.group());
            }
        }
        jdiAssert(shownSwedishDaysOfWeek, containsInAnyOrder(SWEDISH_SHORT_DAYS_OF_WEEK.toArray()),
                "For Swedish picker: shown and expected days of week are not the same");
        swedishDP.changeMonth();
        swedishDP.has().visibleChangeYearButton();
        jdiAssert(swedishDP.getAllMonths(), is(SWEDISH_SHORT_MONTHS),
                "For Swedish picker: shown and expected days of week are not the same");
        List<String> shownSwedishMonths = new ArrayList<>();
        SWEDISH_SHORT_MONTHS.stream().forEach(elem -> {
            swedishDP.selectMonth(elem.toLowerCase());
            swedishDP.has().visibleChangeYearButton();
            shownSwedishMonths.add(swedishDP.getMonth(new Locale("sv", "SE")));
            swedishDP.changeMonth();
        });
        jdiAssert(shownSwedishMonths, is(SWEDISH_FULL_MONTHS),
                "For Swedish picker: shown and expected full month names are not the same");

        chineseDP.changeMonth();
        chineseDP.has().visibleChangeYearButton();
        chineseDP.changeYear();
        chineseDP.selectYear(CHOSEN_YEAR);
        chineseDP.has().year(CHOSEN_YEAR, Locale.CHINESE);
        chineseDP.selectMonth(CHOSEN_MONTH_CHINESE);
        chineseDP.has().month(CHOSEN_MONTH_CHINESE, Locale.CHINESE);
        List<String> shownChineseDaysOfWeek = new ArrayList<>();
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            chineseDP.selectDay(Integer.toString(i));
            chineseDP.has().dayOfMonth(Integer.toString(i), Locale.CHINESE);
            Pattern chineseDayOfWeekPattern = Pattern.compile(
                    "([\\d]+)([\\u4E00-\\u9FA5]+)(\\d+)([\\u4E00-\\u9FA5]+)");
            Matcher matcher = chineseDayOfWeekPattern.matcher(chineseDP.getDate());
            while (matcher.find()) {
                shownChineseDaysOfWeek.add(matcher.group(4));
            }
        }
        jdiAssert(shownChineseDaysOfWeek, containsInAnyOrder(CHINESE_DAYS_OF_WEEK.toArray()),
                "For Chinese picker: shown and expected days of week are not the same");
        chineseDP.changeMonth();
        chineseDP.has().visibleChangeYearButton();
        jdiAssert(chineseDP.getAllMonths(), is(CHINESE_MONTHS),
                "For Chinese picker: shown and expected days of week are not the same");
        List<String> shownChineseMonths = new ArrayList<>();
        CHINESE_MONTHS.stream().forEach(elem -> {
            chineseDP.selectMonth(elem);
            chineseDP.has().visibleChangeYearButton();
            shownChineseMonths.add(chineseDP.getMonth(Locale.CHINESE));
            chineseDP.changeMonth();
        });
        jdiAssert(shownChineseMonths, is(CHINESE_MONTHS),
                "For Chinese picker: shown and expected month names are not the same");
    }

    @Test
    public void testOrientationDatePicker() {
        Timer.waitCondition(() -> orientationDP.isVisible());
        orientationDP.has().portraitOrientation();
        orientationDP.switchOrientation();
        orientationDP.has().landscapeOrientation();
    }
}
