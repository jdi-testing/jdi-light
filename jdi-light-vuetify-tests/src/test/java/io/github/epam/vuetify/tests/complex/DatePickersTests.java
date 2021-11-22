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
import static io.github.com.pages.DatePickersPage.activePickerNewDP;
import static io.github.com.pages.DatePickersPage.allowedNewDP;
import static io.github.com.pages.DatePickersPage.chineseNewDP;
import static io.github.com.pages.DatePickersPage.clickYearCheckbox;
import static io.github.com.pages.DatePickersPage.colorFirstNewDP;
import static io.github.com.pages.DatePickersPage.colorSecondNewDP;
import static io.github.com.pages.DatePickersPage.cursorOverMonthCheckbox;
import static io.github.com.pages.DatePickersPage.dateButtonsNewDP;
import static io.github.com.pages.DatePickersPage.doubleClickAnyDateCheckbox;
import static io.github.com.pages.DatePickersPage.elevationWithElevationNewDP;
import static io.github.com.pages.DatePickersPage.firstDateEventsNewDP;
import static io.github.com.pages.DatePickersPage.firstShowCurrentNewDP;
import static io.github.com.pages.DatePickersPage.firstWidthNewDP;
import static io.github.com.pages.DatePickersPage.formattedDatefnsNewDP;
import static io.github.com.pages.DatePickersPage.formattedMomentJsNewDP;
import static io.github.com.pages.DatePickersPage.iconsNewDP;
import static io.github.com.pages.DatePickersPage.mainWindow;
import static io.github.com.pages.DatePickersPage.modelDateRangeDP;
import static io.github.com.pages.DatePickersPage.mousePointerMonthText;
import static io.github.com.pages.DatePickersPage.multipleInMenuNewDP;
import static io.github.com.pages.DatePickersPage.multipleNewDP;
import static io.github.com.pages.DatePickersPage.newsPickerDateDP;
import static io.github.com.pages.DatePickersPage.orientationNewDP;
import static io.github.com.pages.DatePickersPage.pickerDateNewDP;
import static io.github.com.pages.DatePickersPage.pickerInDialogNewDP;
import static io.github.com.pages.DatePickersPage.pickerInMenuNewDP;
import static io.github.com.pages.DatePickersPage.pickerWithoutButtonsNewDP;
import static io.github.com.pages.DatePickersPage.rangeNewDP;
import static io.github.com.pages.DatePickersPage.readOnlyNewDP;
import static io.github.com.pages.DatePickersPage.readonlyFormattingNewDP;
import static io.github.com.pages.DatePickersPage.secondDateEventsNewDP;
import static io.github.com.pages.DatePickersPage.secondShowCurrentNewDP;
import static io.github.com.pages.DatePickersPage.secondWidthNewDP;
import static io.github.com.pages.DatePickersPage.showSiblingMonthsNewDP;
import static io.github.com.pages.DatePickersPage.swedishNewDP;
import static io.github.com.pages.DatePickersPage.textWithChosenMonthPickerDateDP;
import static io.github.com.pages.DatePickersPage.writableFormattingNewDP;
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
        allowedNewDP.has().disabledDatesNonEmptyList();
        allowedNewDP.has().nonClickableDisabledDates();
        allowedNewDP.has().clickableEnabledDates();
    }

    @Test
    public void testColorDatePicker() {
        String nextMonth = date.plusMonths(1).getMonth().toString().substring(0, 1)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().substring(0, 1)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
        colorFirstNewDP.has().date(date.format(formatterDow));
        colorFirstNewDP.has().color(GREEN_COLOR_HEX);
        colorSecondNewDP.has().color(BLUE_COLOR_HEX);
        colorFirstNewDP.selectDay(Integer.toString(CHOSEN_DAY));
        colorFirstNewDP.has().dayOfMonth(Integer.toString(CHOSEN_DAY));
        colorFirstNewDP.selectDay(Integer.toString(CHOSEN_DAY_TWO));
        colorFirstNewDP.has().dayOfMonth(Integer.toString(CHOSEN_DAY_TWO));
        colorFirstNewDP.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        colorFirstNewDP.has().dayOfMonth(Integer.toString(CHOSEN_DAY_THREE));
        colorFirstNewDP.nextMonth();
        colorFirstNewDP.has().month(nextMonth);
        colorFirstNewDP.previousMonth();
        colorFirstNewDP.previousMonth();
        colorFirstNewDP.has().month(previousMonth);
        colorFirstNewDP.changeMonth();
        colorFirstNewDP.selectMonth(CHOSEN_MONTH);
        colorFirstNewDP.has().month(CHOSEN_MONTH);
        colorFirstNewDP.changeMonth();
        colorFirstNewDP.changeYear();
        colorFirstNewDP.selectYear(Integer.toString(currentYear + 100));
        colorFirstNewDP.has().year(Integer.toString(currentYear + 100));
        colorFirstNewDP.changeYear();
        colorFirstNewDP.selectYear(Integer.toString(currentYear));
        colorFirstNewDP.changeYear();
        colorFirstNewDP.selectYear(Integer.toString(currentYear - 100));
        colorFirstNewDP.has().year(Integer.toString(currentYear - 100));
        colorFirstNewDP.changeYearCornerButton();
        colorFirstNewDP.selectYear(Integer.toString(currentYear));
        colorFirstNewDP.has().year(Integer.toString(currentYear ));
    }

    @Test
    public void testElevationDatePicker() {
        Timer.waitCondition(() -> elevationWithElevationNewDP.isVisible());
        elevationWithElevationNewDP.has().elevation(ELEVATION);
    }

    @Test
    public void testIconsDatePicker() {
        Timer.waitCondition(() -> iconsNewDP.isVisible());
        iconsNewDP.has().nextMonthIconClass(NEXT_MONTH_ICON_CLASS);
        iconsNewDP.has().previousMonthIconClass(PREVIOUS_MONTH_ICON_CLASS);
        iconsNewDP.has().additionalYearIcon();
    }

    @Test
    public void testMultipleDatePicker() {
        Timer.waitCondition(() -> multipleNewDP.isVisible());
        String monthMultipleDP = multipleNewDP.getMonth(Locale.ENGLISH);
        List<String> firstlyActiveDaysOfMonth = multipleNewDP.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysOfMonth.contains(elem)) {
                multipleNewDP.selectDay(elem);
            }
        });
        firstlyActiveDaysOfMonth.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDays = new HashSet<>(firstlyActiveDaysOfMonth);
        multipleNewDP.has().properSetOfActiveDays(allExpectedChosenDays);
        multipleNewDP.has().date(allExpectedChosenDays.size() + SELECTION_TEXT);
        allExpectedChosenDays.stream().forEach(elem -> multipleNewDP.selectDay(elem));
        multipleNewDP.has().date(EMPTY_DATE_FIELD);
        multipleNewDP.selectDay(Integer.toString(CHOSEN_DAY));
        multipleNewDP.has().date(LocalDate.of(Integer.parseInt(multipleNewDP.getYear()),
                Month.valueOf(monthMultipleDP.toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(formatterDow));

        multipleInMenuNewDP.expand();
        List<String> firstlyActiveDaysInMenu = multipleInMenuNewDP.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysInMenu.contains(elem)) {
                multipleInMenuNewDP.selectDay(elem);
            }
        });
        firstlyActiveDaysInMenu.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDaysInMenu = new HashSet<>(firstlyActiveDaysInMenu);
        multipleInMenuNewDP.has().properSetOfActiveDays(allExpectedChosenDaysInMenu);
        multipleInMenuNewDP.has().properShownMultipleDates();
    }

    @Test
    public void testPickerDateDatePicker() {
        List<String> currentMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        pickerDateNewDP.previousMonth();
        List<String> previousMonthNews = newsPickerDateDP.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        jdiAssert(textWithChosenMonthPickerDateDP.getText(),
                containsString(date.minusMonths(1).format(formatterYearHyphenMonth)),
                "Month in news section does not correspond to chosen previous month");
        pickerDateNewDP.nextMonth();
        pickerDateNewDP.nextMonth();
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
        Timer.waitCondition(() -> rangeNewDP.isVisible());
        rangeNewDP.selectDay(Integer.toString(CHOSEN_DAY));
        rangeNewDP.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        rangeNewDP.has().properRangeDates(CHOSEN_DAY, CHOSEN_DAY_THREE);
        rangeNewDP.has().date(RANGE_SELECTION_TEXT);
        String dateFirstFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeNewDP.getYear()),
                Month.valueOf(rangeNewDP.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY).toString();
        String dateSecondFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeNewDP.getYear()),
                Month.valueOf(rangeNewDP.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY_THREE).toString();
        jdiAssert(modelDateRangeDP.getText(), allOf(containsString(dateFirstFormattedRangeDP),
                        containsString(dateSecondFormattedRangeDP)),
                "Model for Range date picker does not contain selected dates");
    }

    @Test
    public void testReadOnlyDatePicker() {
        String firstlyActiveDay = readOnlyNewDP.getActiveDayOfMonth();
        String checkedDay;
        if (Integer.parseInt(firstlyActiveDay) > 2 | Integer.parseInt(firstlyActiveDay) < 27) {
            checkedDay = firstlyActiveDay;
        } else checkedDay = "15";
        readOnlyNewDP.selectDay(Integer.toString(Integer.parseInt(checkedDay) - 1));
        readOnlyNewDP.has().dayOfMonth(firstlyActiveDay);
        readOnlyNewDP.selectDay(Integer.toString(Integer.parseInt(checkedDay) + 1));
        readOnlyNewDP.has().dayOfMonth(firstlyActiveDay);
    }

    @Test
    public void testShowCurrentDatePicker() {
        firstShowCurrentNewDP.has().date(date.format(formatterDow));
        secondShowCurrentNewDP.has().properOutlinedDateBorder(DATE_BORDER);
    }

    @Test
    public void testShowSiblingMonthsDatePicker() {
        showSiblingMonthsNewDP.has().disabledDatesNonEmptyList();
    }

    @Test
    public void testWidthDatePicker() {
        Timer.waitCondition(() -> firstWidthNewDP.isVisible());
        firstWidthNewDP.has().pickerWidth(WIDTH_OF_PREDEFINED_WIDTH_DP);
        secondWidthNewDP.has().pickerWidth(mainWindow.getSize().getWidth());
    }

    @Test
    public void testDateButtonsDatePicker() {
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(false),
                "Before clicking any date: Checkbox 'Double click on any date' is selected");
        dateButtonsNewDP.doubleClickDay(Integer.toString(CHOSEN_DAY));
        Alert alert_window = WebDriverFactory.getDriver().switchTo().alert();
        alert_window.accept();
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(true),
                "After clicking the date: Checkbox 'Double click on any date' is not selected");
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(false),
                "Before moving the cursor to any month: " +
                        "Checkbox 'Move mouse cursor over any month button' is selected");
        dateButtonsNewDP.changeMonth();
        dateButtonsNewDP.hoverMonth(CHOSEN_MONTH);
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(true),
                "After moving the cursor to the month: Checkbox 'Move mouse cursor " +
                        "over any month button' is not selected");
        String chosenDate = LocalDate.of(currentYear, FIFTH_MONTH_OF_YEAR,
                FIRST_DAY_OF_MONTH).format(formatterYearHyphenMonth);
        jdiAssert(mousePointerMonthText.getText(), containsString(chosenDate),
                "After clicking the month: Mouse pointer date text is absent");
        jdiAssert(clickYearCheckbox.isExist(), is(false),
                "Before clicking any year: Checkbox 'Right click on any year' is selected");
        dateButtonsNewDP.changeYear();
        dateButtonsNewDP.rightClickYear(CHOSEN_YEAR);
        alert_window.accept();
        jdiAssert(clickYearCheckbox.isExist(), is(true),
                "Before clicking the year: Checkbox 'Right click on any year' is not selected");
    }

    @Test
    public void testDateEventsDatePicker() {
        firstDateEventsNewDP.has().eventColorCirclesNonEmptyList();
        secondDateEventsNewDP.has().eventColorCirclesNonEmptyList();
        List<String> al = new ArrayList<>();
        al.add(GREEN_COLOR_HEX);
        firstDateEventsNewDP.has().properColorsOfEventCircles(GREEN_COLOR_HEX);
        secondDateEventsNewDP.has().properColorsOfEventCircles(
                BLUE_CIRCLE_COLOR_HEX, RED_CIRCLE_COLOR_HEX, YELLOW_CIRCLE_COLOR_HEX);
    }

    @Test
    public void testActivePickerDatePicker() {
        Timer.waitCondition(() -> activePickerNewDP.isVisible());
        jdiAssert(activePickerNewDP.getCode(), is("null"), "Before any date in Active date picker " +
                "is selected: active picker code is not null");
        activePickerNewDP.expand();
        activePickerNewDP.selectYear(CHOSEN_YEAR);
        activePickerNewDP.selectMonth(CHOSEN_MONTH);
        activePickerNewDP.selectDay(Integer.toString(CHOSEN_DAY));
        activePickerNewDP.has().resultDate(LocalDate.of(Integer.parseInt(CHOSEN_YEAR),
                Month.valueOf(CHOSEN_MONTH.toUpperCase(Locale.ROOT)), CHOSEN_DAY).toString());
        jdiAssert(activePickerNewDP.getCode(), is("DATE"), "After some date in Active date picker " +
                "was selected: active picker code is not correct");
    }

    @Test
    public void testDialogAndMenuDatePicker() {
        Timer.waitCondition(() -> pickerInMenuNewDP.isVisible());
        String nextMonth = date.plusMonths(1).getMonth().toString().substring(0, 1)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().substring(0, 1)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
        pickerInMenuNewDP.expand();
        pickerInMenuNewDP.has().resultDate(date.toString());
        pickerInMenuNewDP.selectDay(Integer.toString(CHOSEN_DAY));
        pickerInMenuNewDP.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).toString());
        pickerInMenuNewDP.selectDay(Integer.toString(CHOSEN_DAY_TWO));
        pickerInMenuNewDP.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY_TWO).toString());
        pickerInMenuNewDP.nextMonth();
        pickerInMenuNewDP.has().month(nextMonth);
        pickerInMenuNewDP.previousMonth();
        pickerInMenuNewDP.previousMonth();
        pickerInMenuNewDP.has().month(previousMonth);
        pickerInMenuNewDP.changeMonth();
        pickerInMenuNewDP.selectMonth(CHOSEN_MONTH);
        pickerInMenuNewDP.has().month(CHOSEN_MONTH);
        pickerInMenuNewDP.changeMonth();
        pickerInMenuNewDP.has().visibleChangeYearButton();
        pickerInMenuNewDP.changeYear();
        pickerInMenuNewDP.selectYear(Integer.toString(currentYear + 99));
        pickerInMenuNewDP.has().year(Integer.toString(currentYear + 99));
        pickerInMenuNewDP.has().visibleChangeYearButton();
        pickerInMenuNewDP.changeYear();
        pickerInMenuNewDP.selectYear(Integer.toString(currentYear));
        pickerInMenuNewDP.has().visibleChangeYearButton();
        pickerInMenuNewDP.changeYear();
        pickerInMenuNewDP.selectYear(Integer.toString(currentYear - 99));
        pickerInMenuNewDP.has().year(Integer.toString(currentYear - 99));
        pickerInMenuNewDP.clickOk();
        pickerInMenuNewDP.expand();
        pickerInMenuNewDP.has().mainDateFieldIsNotExist();
        pickerInMenuNewDP.clickCancel();
        pickerInDialogNewDP.expand();
        pickerInDialogNewDP.has().mainDateField();
        pickerInDialogNewDP.clickOk();
        pickerWithoutButtonsNewDP.expand();
        pickerWithoutButtonsNewDP.has().cancelButtonIsNotExist();
        pickerWithoutButtonsNewDP.has().okButtonIsNotExist();
    }

    @Test
    public void testFormattingDatePicker() {
        Timer.waitCondition(() -> writableFormattingNewDP.isVisible());
        writableFormattingNewDP.expand();
        writableFormattingNewDP.selectDay(Integer.toString(CHOSEN_DAY));
        writableFormattingNewDP.has().resultDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY).format(formatterMMDDYYYY));
        writableFormattingNewDP.clear();
        writableFormattingNewDP.setDate(FORMATTING_DATE);
        writableFormattingNewDP.has().resultDate(FORMATTING_DATE);
        writableFormattingNewDP.has().formattedDate(FORMATTING_DATE_ISO);
        readonlyFormattingNewDP.has().dateFieldReadonlyAttribute();
    }

    @Test
    public void testFormattingWithExternalLibrariesDatePicker() {
        Timer.waitCondition(() -> formattedMomentJsNewDP.isVisible());
        formattedMomentJsNewDP.expand();
        formattedMomentJsNewDP.selectDay(Integer.toString(CHOSEN_DAY));
        formattedMomentJsNewDP.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY));
        formattedDatefnsNewDP.expand();
        formattedDatefnsNewDP.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        formattedDatefnsNewDP.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY_THREE));
    }

    @Test
    public void testInternationalizationDatePicker() {
        Timer.waitCondition(() -> swedishNewDP.isVisible());
        swedishNewDP.changeMonth();
        swedishNewDP.has().visibleChangeYearButton();
        swedishNewDP.changeYear();
        swedishNewDP.selectYear(CHOSEN_YEAR);
        swedishNewDP.has().year(CHOSEN_YEAR);
        swedishNewDP.selectMonth(CHOSEN_MONTH_SWEDISH);
        List<String> shownSwedishDaysOfWeek = new ArrayList<>();
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            swedishNewDP.selectDay(Integer.toString(i));
            swedishNewDP.has().dayOfMonth(Integer.toString(i), new Locale("sv", "SE"));
            Pattern swedishDayOfWeekPattern = Pattern.compile("^[a-zwåäöÅÄÖ]+");
            Matcher matcher = swedishDayOfWeekPattern.matcher(swedishNewDP.getDate());
            while (matcher.find()) {
                shownSwedishDaysOfWeek.add(matcher.group());
            }
        }
        jdiAssert(shownSwedishDaysOfWeek, containsInAnyOrder(SWEDISH_SHORT_DAYS_OF_WEEK.toArray()),
                "For Swedish picker: shown and expected days of week are not the same");
        swedishNewDP.changeMonth();
        swedishNewDP.has().visibleChangeYearButton();
        jdiAssert(swedishNewDP.getAllMonths(), is(SWEDISH_SHORT_MONTHS),
                "For Swedish picker: shown and expected days of week are not the same");
        List<String> shownSwedishMonths = new ArrayList<>();
        SWEDISH_SHORT_MONTHS.stream().forEach(elem -> {
            swedishNewDP.selectMonth(elem.toLowerCase());
            swedishNewDP.has().visibleChangeYearButton();
            shownSwedishMonths.add(swedishNewDP.getMonth(new Locale("sv", "SE")));
            swedishNewDP.changeMonth();
        });
        jdiAssert(shownSwedishMonths, is(SWEDISH_FULL_MONTHS),
                "For Swedish picker: shown and expected full month names are not the same");

        chineseNewDP.changeMonth();
        chineseNewDP.has().visibleChangeYearButton();
        chineseNewDP.changeYear();
        chineseNewDP.selectYear(CHOSEN_YEAR);
        chineseNewDP.has().year(CHOSEN_YEAR, Locale.CHINESE);
        chineseNewDP.selectMonth(CHOSEN_MONTH_CHINESE);
        chineseNewDP.has().month(CHOSEN_MONTH_CHINESE, Locale.CHINESE);
        List<String> shownChineseDaysOfWeek = new ArrayList<>();
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            chineseNewDP.selectDay(Integer.toString(i));
            chineseNewDP.has().dayOfMonth(Integer.toString(i), Locale.CHINESE);
            Pattern chineseDayOfWeekPattern = Pattern.compile(
                    "([\\d]+)([\\u4E00-\\u9FA5]+)(\\d+)([\\u4E00-\\u9FA5]+)");
            Matcher matcher = chineseDayOfWeekPattern.matcher(chineseNewDP.getDate());
            while (matcher.find()) {
                shownChineseDaysOfWeek.add(matcher.group(4));
            }
        }
        jdiAssert(shownChineseDaysOfWeek, containsInAnyOrder(CHINESE_DAYS_OF_WEEK.toArray()),
                "For Chinese picker: shown and expected days of week are not the same");
        chineseNewDP.changeMonth();
        chineseNewDP.has().visibleChangeYearButton();
        jdiAssert(chineseNewDP.getAllMonths(), is(CHINESE_MONTHS),
                "For Chinese picker: shown and expected days of week are not the same");
        List<String> shownChineseMonths = new ArrayList<>();
        CHINESE_MONTHS.stream().forEach(elem -> {
            chineseNewDP.selectMonth(elem);
            chineseNewDP.has().visibleChangeYearButton();
            shownChineseMonths.add(chineseNewDP.getMonth(Locale.CHINESE));
            chineseNewDP.changeMonth();
        });
        jdiAssert(shownChineseMonths, is(CHINESE_MONTHS),
                "For Chinese picker: shown and expected month names are not the same");
    }

    @Test
    public void testOrientationDatePicker() {
        Timer.waitCondition(() -> orientationNewDP.isVisible());
        orientationNewDP.has().portraitOrientation();
        orientationNewDP.switchOrientation();
        orientationNewDP.has().landscapeOrientation();
    }
}
