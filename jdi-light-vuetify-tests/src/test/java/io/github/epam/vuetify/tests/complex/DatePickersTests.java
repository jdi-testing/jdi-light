package io.github.epam.vuetify.tests.complex;

import com.epam.jdi.light.driver.WebDriverFactory;
import io.github.epam.TestsInit;
import org.openqa.selenium.Alert;
import org.testng.annotations.BeforeMethod;
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
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.datePickersPage;
import static io.github.com.pages.DatePickersPage.activePickerDatePicker;
import static io.github.com.pages.DatePickersPage.allowedDatePicker;
import static io.github.com.pages.DatePickersPage.chineseDatePicker;
import static io.github.com.pages.DatePickersPage.clickYearCheckbox;
import static io.github.com.pages.DatePickersPage.colorFirstDatePicker;
import static io.github.com.pages.DatePickersPage.colorSecondDatePicker;
import static io.github.com.pages.DatePickersPage.cursorOverMonthCheckbox;
import static io.github.com.pages.DatePickersPage.dateButtonsDatePicker;
import static io.github.com.pages.DatePickersPage.doubleClickAnyDateCheckbox;
import static io.github.com.pages.DatePickersPage.elevationWithElevationDatePicker;
import static io.github.com.pages.DatePickersPage.firstDateEventsDatePicker;
import static io.github.com.pages.DatePickersPage.firstShowCurrentDatePicker;
import static io.github.com.pages.DatePickersPage.firstWidthDatePicker;
import static io.github.com.pages.DatePickersPage.formattedDatefnsDatePicker;
import static io.github.com.pages.DatePickersPage.formattedMomentJsDatePicker;
import static io.github.com.pages.DatePickersPage.iconsDatePicker;
import static io.github.com.pages.DatePickersPage.mainWindow;
import static io.github.com.pages.DatePickersPage.modelDateRange;
import static io.github.com.pages.DatePickersPage.mousePointerMonthText;
import static io.github.com.pages.DatePickersPage.multipleInMenuDatePicker;
import static io.github.com.pages.DatePickersPage.multipleDatePicker;
import static io.github.com.pages.DatePickersPage.news;
import static io.github.com.pages.DatePickersPage.orientationDatePicker;
import static io.github.com.pages.DatePickersPage.pickerDateDatePicker;
import static io.github.com.pages.DatePickersPage.pickerInDialogDatePicker;
import static io.github.com.pages.DatePickersPage.pickerInMenuDatePicker;
import static io.github.com.pages.DatePickersPage.pickerWithoutButtonsDatePicker;
import static io.github.com.pages.DatePickersPage.rangeDatePicker;
import static io.github.com.pages.DatePickersPage.readOnlyDatePicker;
import static io.github.com.pages.DatePickersPage.readonlyFormattingDatePicker;
import static io.github.com.pages.DatePickersPage.secondDateEventsDatePicker;
import static io.github.com.pages.DatePickersPage.secondShowCurrentDatePicker;
import static io.github.com.pages.DatePickersPage.secondWidthDatePicker;
import static io.github.com.pages.DatePickersPage.showSiblingMonthsDatePicker;
import static io.github.com.pages.DatePickersPage.swedishDatePicker;
import static io.github.com.pages.DatePickersPage.textWithChosenMonth;
import static io.github.com.pages.DatePickersPage.writableFormattingDatePicker;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

public class DatePickersTests extends TestsInit {
    private static final int FIFTH_MONTH_OF_YEAR = 5;
    private static final int FIRST_DAY_OF_MONTH = 1;
    private static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;
    private static final int CHOSEN_DAY = 12;
    private static final int CHOSEN_DAY_TWO = 20;
    private static final int CHOSEN_DAY_THREE = 25;
    private static final String CHOSEN_MONTH = "May";
    private static final String CHOSEN_YEAR = "1980";
    private static final String CHOSEN_MONTH_SWEDISH = "maj";
    private static final String CHOSEN_MONTH_CHINESE = "5月";
    private static final String GREEN_COLOR_HEX = "#66bb6a";
    private static final String BLUE_COLOR_HEX = "#1976d2";
    private static final String BLUE_CIRCLE_COLOR_HEX = "#0000ff";
    private static final String RED_CIRCLE_COLOR_HEX = "#f44336";
    private static final String YELLOW_CIRCLE_COLOR_HEX = "#ffeb3b";
    private static final String FORMATTING_DATE = "02/05/2021";
    private static final String FORMATTING_DATE_ISO = "2021-02-05";
    private static final String NEXT_MONTH_ICON_CLASS = "mdi-skip-next";
    private static final String PREVIOUS_MONTH_ICON_CLASS = "mdi-skip-previous";
    private static final String ELEVATION = "15px";
    private static final String EMPTY_DATE_FIELD = "-";
    private static final String SELECTION_TEXT = " selected";
    private static final String RANGE_SELECTION_TEXT = "2 selected";
    private static final String DATE_BORDER = "1px";
    private static final List<String> CHECKED_MULTIPLE_DATES = Arrays.asList("1", "10", "15", "16",
            "20", "23", "29");
    private static final List<String> SWEDISH_SHORT_DAYS_OF_WEEK = Arrays.asList("mån", "tis", "ons", "tors",
            "fre", "lör", "sön");
    private static final List<String> SWEDISH_SHORT_MONTHS = Arrays.asList("JAN.", "FEB.", "MARS", "APR.",
            "MAJ", "JUNI", "JULI", "AUG.", "SEP.", "OKT.", "NOV.", "DEC.");
    private static final List<String> SWEDISH_FULL_MONTHS = Arrays.asList("januari", "februari", "mars",
            "april", "maj", "juni", "juli", "augusti", "september", "oktober", "november", "december");
    private static final List<String> CHINESE_DAYS_OF_WEEK = Arrays.asList("日周一", "日周二", "日周三",
            "日周四", "日周五", "日周六", "日周日");
    private static final List<String> CHINESE_MONTHS = Arrays.asList("1月", "2月", "3月", "4月",
            "5月", "6月", "7月", "8月", "9月", "10月", "11月", "12月");
    private LocalDate date = LocalDate.now();
    private DateTimeFormatter formatterRow = DateTimeFormatter.ofPattern("ccc, MMM d").withLocale(Locale.ENGLISH);
    private DateTimeFormatter formatterRow2 = DateTimeFormatter.ofPattern("ccc, MMMM d").withLocale(Locale.ENGLISH);
    private DateTimeFormatter formatterYearHyphenMonth =
            DateTimeFormatter.ofPattern("uuuu-MM").withLocale(Locale.ENGLISH);
    private DateTimeFormatter formatterMMDDYYYY = DateTimeFormatter.ofPattern("MM/dd/uuuu").withLocale(Locale.ENGLISH);

    private int currentYear = Year.now().getValue();
    private int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;

    @BeforeMethod
    public void beforeTest() {
        datePickersPage.open();
        waitCondition(() -> datePickersPage.isOpened());
        datePickersPage.checkOpened();
    }

    @Test
    public void testAllowedDatesPicker() {
        waitCondition(() -> allowedDatePicker.isVisible());
        allowedDatePicker.has().disabledDatesNonEmptyList();
        allowedDatePicker.getEnabledDates();
        allowedDatePicker.has().clickableEnabledDates();
        allowedDatePicker.has().nonClickableDisabledDates();
    }

    @Test
    public void testColorDatePicker() {
        waitCondition(() -> colorFirstDatePicker.isVisible());
        waitCondition(() -> colorSecondDatePicker.isVisible());
        String nextMonth = date.plusMonths(1).getMonth().toString().substring(0, 1)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().substring(0, 1)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
        colorFirstDatePicker.has().date(date.format(formatterRow2)).and().color(GREEN_COLOR_HEX);
        colorSecondDatePicker.has().color(BLUE_COLOR_HEX);
        colorFirstDatePicker.selectDay(Integer.toString(CHOSEN_DAY));
        colorFirstDatePicker.has().dayOfMonth(Integer.toString(CHOSEN_DAY));
        colorFirstDatePicker.selectDay(Integer.toString(CHOSEN_DAY_TWO));
        colorFirstDatePicker.has().dayOfMonth(Integer.toString(CHOSEN_DAY_TWO));
        colorFirstDatePicker.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        colorFirstDatePicker.has().dayOfMonth(Integer.toString(CHOSEN_DAY_THREE));
        colorFirstDatePicker.nextMonth();
        colorFirstDatePicker.has().month(nextMonth);
        colorFirstDatePicker.previousMonth();
        colorFirstDatePicker.previousMonth();
        colorFirstDatePicker.has().month(previousMonth);
        colorFirstDatePicker.changeMonth();
        colorFirstDatePicker.selectMonth(CHOSEN_MONTH);
        colorFirstDatePicker.has().month(CHOSEN_MONTH);
        colorFirstDatePicker.changeMonth();
        waitCondition(() -> colorFirstDatePicker.getChangeYearButton().isVisible());
        colorFirstDatePicker.has().visibleChangeYearButton();
        colorFirstDatePicker.changeYear();
        colorFirstDatePicker.selectYear(Integer.toString(currentYear + 99));
        colorFirstDatePicker.has().year(Integer.toString(currentYear + 99));
        colorFirstDatePicker.changeYear();
        colorFirstDatePicker.selectYear(Integer.toString(currentYear));
        colorFirstDatePicker.changeYear();
        colorFirstDatePicker.selectYear(Integer.toString(currentYear - 100));
        colorFirstDatePicker.has().year(Integer.toString(currentYear - 100));
        colorFirstDatePicker.changeYearCornerButton();
        colorFirstDatePicker.selectYear(Integer.toString(currentYear));
        colorFirstDatePicker.has().year(Integer.toString(currentYear));
    }

    @Test
    public void testElevationDatePicker() {
        waitCondition(() -> elevationWithElevationDatePicker.isVisible());
        elevationWithElevationDatePicker.has().elevation(ELEVATION);
    }

    @Test
    public void testIconsDatePicker() {
        waitCondition(() -> iconsDatePicker.isVisible());
        iconsDatePicker.has().nextMonthIconClass(NEXT_MONTH_ICON_CLASS);
        iconsDatePicker.has().previousMonthIconClass(PREVIOUS_MONTH_ICON_CLASS);
        iconsDatePicker.has().additionalYearIcon();
    }

    @Test
    public void testMultipleDatePicker() {
        waitCondition(() -> multipleDatePicker.isVisible());
        String monthMultipleDP = multipleDatePicker.getMonth(Locale.ENGLISH);
        List<String> firstlyActiveDaysOfMonth = multipleDatePicker.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysOfMonth.contains(elem)) {
                multipleDatePicker.selectDay(elem);
            }
        });
        firstlyActiveDaysOfMonth.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDays = new HashSet<>(firstlyActiveDaysOfMonth);
        multipleDatePicker.has().properSetOfActiveDays(allExpectedChosenDays);
        multipleDatePicker.has().date(allExpectedChosenDays.size() + SELECTION_TEXT);
        allExpectedChosenDays.stream().forEach(elem -> multipleDatePicker.selectDay(elem));
        multipleDatePicker.has().date(EMPTY_DATE_FIELD);
        multipleDatePicker.selectDay(Integer.toString(CHOSEN_DAY));
        multipleDatePicker.has().date(LocalDate.of(Integer.parseInt(multipleDatePicker.getYear()),
                Month.valueOf(monthMultipleDP.toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(formatterRow));

        multipleInMenuDatePicker.expand();
        List<String> firstlyActiveDaysInMenu = multipleInMenuDatePicker.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysInMenu.contains(elem)) {
                multipleInMenuDatePicker.selectDay(elem);
            }
        });
        firstlyActiveDaysInMenu.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDaysInMenu = new HashSet<>(firstlyActiveDaysInMenu);
        multipleInMenuDatePicker.has().properSetOfActiveDays(allExpectedChosenDaysInMenu);
        multipleInMenuDatePicker.has().properShownMultipleDates();
    }

    @Test
    public void testPickerDateDatePicker() {
        List<String> currentMonthNews = news.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        pickerDateDatePicker.previousMonth();
        List<String> previousMonthNews = news.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        jdiAssert(textWithChosenMonth.getText(),
                containsString(date.minusMonths(1).format(formatterYearHyphenMonth)),
                "Month in news section does not correspond to chosen previous month");
        pickerDateDatePicker.nextMonth();
        pickerDateDatePicker.nextMonth();
        List<String> nextMonthNews = news.stream().map(elem
                -> elem.getText()).collect(Collectors.toList());
        jdiAssert(textWithChosenMonth.getText(),
                containsString(date.plusMonths(1).format(formatterYearHyphenMonth)),
                "Month in news section does not correspond to chosen next month");
        jdiAssert(currentMonthNews, is(not(previousMonthNews)),
                "List of news for current month and previous month are the same");
        jdiAssert(currentMonthNews, is(not(nextMonthNews)),
                "List of news for current month and next month are the same");
    }

    @Test
    public void testRangeDatePicker() {
        waitCondition(() -> rangeDatePicker.isVisible());
        rangeDatePicker.selectDay(Integer.toString(CHOSEN_DAY));
        rangeDatePicker.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        rangeDatePicker.has().properRangeDates(CHOSEN_DAY, CHOSEN_DAY_THREE);
        rangeDatePicker.has().date(RANGE_SELECTION_TEXT);
        String dateFirstFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeDatePicker.getYear()),
                Month.valueOf(rangeDatePicker.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY).toString();
        String dateSecondFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeDatePicker.getYear()),
                Month.valueOf(rangeDatePicker.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY_THREE).toString();
        jdiAssert(modelDateRange.getText(), allOf(containsString(dateFirstFormattedRangeDP),
                        containsString(dateSecondFormattedRangeDP)),
                "Model for Range date picker does not contain selected dates");
    }

    @Test
    public void testReadOnlyDatePicker() {
        String firstlyActiveDay = readOnlyDatePicker.getActiveDayOfMonth();
        String checkedDay;
        if (Integer.parseInt(firstlyActiveDay) > 2 | Integer.parseInt(firstlyActiveDay) < 27) {
            checkedDay = firstlyActiveDay;
        } else {
            checkedDay = "15";
        }
        readOnlyDatePicker.selectDay(Integer.toString(Integer.parseInt(checkedDay) - 1));
        readOnlyDatePicker.has().dayOfMonth(firstlyActiveDay);
    }

    @Test
    public void testShowCurrentDatePicker() {
        firstShowCurrentDatePicker.has().date(date.format(formatterRow));
        secondShowCurrentDatePicker.has().properOutlinedDateBorder(DATE_BORDER);
    }

    @Test
    public void testShowSiblingMonthsDatePicker() {
        showSiblingMonthsDatePicker.has().disabledDatesNonEmptyList();
    }

    @Test
    public void testWidthDatePicker() {
        waitCondition(() -> firstWidthDatePicker.isVisible());
        firstWidthDatePicker.has().pickerWidth(WIDTH_OF_PREDEFINED_WIDTH_DP);
        secondWidthDatePicker.has().pickerWidth(mainWindow.getSize().getWidth());
    }

    @Test
    public void testDateButtonsDatePicker() {
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(false),
                "Before clicking any date: Checkbox 'Double click on any date' is selected");
        dateButtonsDatePicker.doubleClickDay(Integer.toString(CHOSEN_DAY));
        Alert alert_window = WebDriverFactory.getDriver().switchTo().alert();
        alert_window.accept();
        jdiAssert(doubleClickAnyDateCheckbox.isExist(), is(true),
                "After clicking the date: Checkbox 'Double click on any date' is not selected");
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(false),
                "Before moving the cursor to any month: " +
                        "Checkbox 'Move mouse cursor over any month button' is selected");
        dateButtonsDatePicker.changeMonth();
        dateButtonsDatePicker.hoverMonth(CHOSEN_MONTH);
        jdiAssert(cursorOverMonthCheckbox.isExist(), is(true),
                "After moving the cursor to the month: Checkbox 'Move mouse cursor " +
                        "over any month button' is not selected");
        String chosenDate = LocalDate.of(currentYear, FIFTH_MONTH_OF_YEAR,
                FIRST_DAY_OF_MONTH).format(formatterYearHyphenMonth);
        jdiAssert(mousePointerMonthText.getText(), containsString(chosenDate),
                "After clicking the month: Mouse pointer date text is absent");
        jdiAssert(clickYearCheckbox.isExist(), is(false),
                "Before clicking any year: Checkbox 'Right click on any year' is selected");
        dateButtonsDatePicker.changeYear();
        dateButtonsDatePicker.rightClickYear(CHOSEN_YEAR);
        alert_window.accept();
        jdiAssert(clickYearCheckbox.isExist(), is(true),
                "Before clicking the year: Checkbox 'Right click on any year' is not selected");
    }

    @Test
    public void testDateEventsDatePicker() {
        firstDateEventsDatePicker.has().eventColorCirclesNonEmptyList();
        secondDateEventsDatePicker.has().eventColorCirclesNonEmptyList();
        List<String> al = new ArrayList<>();
        al.add(GREEN_COLOR_HEX);
        firstDateEventsDatePicker.has().properColorsOfEventCircles(GREEN_COLOR_HEX);
        secondDateEventsDatePicker.has().properColorsOfEventCircles(
                BLUE_CIRCLE_COLOR_HEX, RED_CIRCLE_COLOR_HEX, YELLOW_CIRCLE_COLOR_HEX);
    }

    @Test
    public void testActivePickerDatePicker() {
        waitCondition(() -> activePickerDatePicker.isVisible());
        jdiAssert(activePickerDatePicker.getCode(), is("null"), "Before any date in Active date picker " +
                "is selected: active picker code is not null");
        activePickerDatePicker.expand();
        activePickerDatePicker.selectYear(CHOSEN_YEAR);
        activePickerDatePicker.selectMonth(CHOSEN_MONTH);
        activePickerDatePicker.selectDay(Integer.toString(CHOSEN_DAY));
        activePickerDatePicker.has().resultDate(LocalDate.of(Integer.parseInt(CHOSEN_YEAR),
                Month.valueOf(CHOSEN_MONTH.toUpperCase(Locale.ROOT)), CHOSEN_DAY).toString());
        jdiAssert(activePickerDatePicker.getCode(), is("DATE"), "After some date in Active date picker " +
                "was selected: active picker code is not correct");
    }

    @Test
    public void testDialogAndMenuDatePicker() {
        waitCondition(() -> pickerInMenuDatePicker.isVisible());
        String nextMonth = date.plusMonths(1).getMonth().toString().substring(0, 1)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().substring(0, 1)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
        pickerInMenuDatePicker.expand();
        pickerInMenuDatePicker.is().expanded();
        pickerInMenuDatePicker.has().resultDate(date.toString());
        pickerInMenuDatePicker.selectDay(Integer.toString(CHOSEN_DAY));
        pickerInMenuDatePicker.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).toString());
        pickerInMenuDatePicker.selectDay(Integer.toString(CHOSEN_DAY_TWO));
        pickerInMenuDatePicker.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY_TWO).toString());
        pickerInMenuDatePicker.nextMonth();
        pickerInMenuDatePicker.has().month(nextMonth);
        pickerInMenuDatePicker.previousMonth();
        pickerInMenuDatePicker.previousMonth();
        pickerInMenuDatePicker.has().month(previousMonth);
        pickerInMenuDatePicker.changeMonth();
        pickerInMenuDatePicker.selectMonth(CHOSEN_MONTH);
        pickerInMenuDatePicker.has().month(CHOSEN_MONTH);
        pickerInMenuDatePicker.changeMonth();
        waitCondition(() -> pickerDateDatePicker.getChangeYearButton().isVisible());
        pickerInMenuDatePicker.has().visibleChangeYearButton();
        pickerInMenuDatePicker.changeYear();
        pickerInMenuDatePicker.selectYear(Integer.toString(currentYear + 99));
        pickerInMenuDatePicker.has().year(Integer.toString(currentYear + 99));
        pickerInMenuDatePicker.has().visibleChangeYearButton();
        pickerInMenuDatePicker.changeYear();
        pickerInMenuDatePicker.selectYear(Integer.toString(currentYear));
        pickerInMenuDatePicker.has().visibleChangeYearButton();
        pickerInMenuDatePicker.changeYear();
        pickerInMenuDatePicker.selectYear(Integer.toString(currentYear - 99));
        pickerInMenuDatePicker.has().year(Integer.toString(currentYear - 99));
        pickerInMenuDatePicker.clickOk();
        pickerInMenuDatePicker.expand();
        pickerInMenuDatePicker.has().mainDateFieldIsNotExist();
        pickerInMenuDatePicker.clickCancel();
        pickerInDialogDatePicker.expand();
        pickerInDialogDatePicker.has().mainDateField();
        pickerInDialogDatePicker.clickOk();
        pickerWithoutButtonsDatePicker.expand();
        pickerWithoutButtonsDatePicker.has().cancelButtonIsNotExist();
        pickerWithoutButtonsDatePicker.has().okButtonIsNotExist();
    }

    @Test
    public void testFormattingDatePicker() {
        waitCondition(() -> writableFormattingDatePicker.isVisible());
        writableFormattingDatePicker.expand();
        writableFormattingDatePicker.selectDay(Integer.toString(CHOSEN_DAY));
        writableFormattingDatePicker.has().resultDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY).format(formatterMMDDYYYY));
        writableFormattingDatePicker.clear();
        writableFormattingDatePicker.setDate(FORMATTING_DATE);
        writableFormattingDatePicker.has().resultDate(FORMATTING_DATE);
        writableFormattingDatePicker.has().formattedDate(FORMATTING_DATE_ISO);
        readonlyFormattingDatePicker.has().dateFieldReadonlyAttribute();
    }

    @Test
    public void testFormattingWithExternalLibrariesDatePicker() {
        waitCondition(() -> formattedMomentJsDatePicker.isVisible());
        formattedMomentJsDatePicker.clear();
        formattedMomentJsDatePicker.has().emptyResultDate();
        formattedMomentJsDatePicker.expand();
        formattedMomentJsDatePicker.is().expanded();
        formattedMomentJsDatePicker.selectDay(Integer.toString(CHOSEN_DAY));
        formattedMomentJsDatePicker.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY));
        formattedDatefnsDatePicker.expand();
        formattedDatefnsDatePicker.selectDay(Integer.toString(CHOSEN_DAY_THREE));
        formattedDatefnsDatePicker.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY_THREE));
    }

    @Test
    public void testInternationalizationDatePicker() {
        waitCondition(() -> swedishDatePicker.isVisible());
        swedishDatePicker.changeMonth();
        swedishDatePicker.hoverMonth(CHOSEN_MONTH_SWEDISH);
        swedishDatePicker.has().visibleChangeYearButton();
        swedishDatePicker.changeYear();
        swedishDatePicker.selectYear(CHOSEN_YEAR);
        swedishDatePicker.has().year(CHOSEN_YEAR);
        swedishDatePicker.selectMonth(CHOSEN_MONTH_SWEDISH);
        List<String> shownSwedishDaysOfWeek = new ArrayList<>();
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            swedishDatePicker.selectDay(Integer.toString(i));
            swedishDatePicker.has().dayOfMonth(Integer.toString(i), new Locale("sv", "SE"));
            Pattern swedishDayOfWeekPattern = Pattern.compile("^[a-zwåäöÅÄÖ]+");
            Matcher matcher = swedishDayOfWeekPattern.matcher(swedishDatePicker.getDate());
            while (matcher.find()) {
                shownSwedishDaysOfWeek.add(matcher.group());
            }
        }
        jdiAssert(shownSwedishDaysOfWeek, containsInAnyOrder(SWEDISH_SHORT_DAYS_OF_WEEK.toArray()),
                "For Swedish picker: shown and expected days of week are not the same");
        swedishDatePicker.changeMonth();
        waitCondition(() -> swedishDatePicker.getChangeYearButton().isVisible());
        swedishDatePicker.has().visibleChangeYearButton();
        jdiAssert(swedishDatePicker.getAllMonths(), is(SWEDISH_SHORT_MONTHS),
                "For Swedish picker: shown and expected days of week are not the same");
        List<String> shownSwedishMonths = new ArrayList<>();
        SWEDISH_SHORT_MONTHS.stream().forEach(elem -> {
            swedishDatePicker.selectMonth(elem.toLowerCase());
            waitCondition(() -> swedishDatePicker.getChangeYearButton().isVisible());
            swedishDatePicker.has().visibleChangeYearButton();
            shownSwedishMonths.add(swedishDatePicker.getMonth(new Locale("sv", "SE")));
            swedishDatePicker.changeMonth();
        });
        jdiAssert(shownSwedishMonths, is(SWEDISH_FULL_MONTHS),
                "For Swedish picker: shown and expected full month names are not the same");

        chineseDatePicker.changeMonth();
        waitCondition(() -> chineseDatePicker.getChangeYearButton().isVisible());
        chineseDatePicker.has().visibleChangeYearButton();
        chineseDatePicker.changeYear();
        chineseDatePicker.selectYear(CHOSEN_YEAR);
        chineseDatePicker.has().year(CHOSEN_YEAR, Locale.CHINESE);
        chineseDatePicker.selectMonth(CHOSEN_MONTH_CHINESE);
        chineseDatePicker.has().month(CHOSEN_MONTH_CHINESE, Locale.CHINESE);
        List<String> shownChineseDaysOfWeek = new ArrayList<>();
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            chineseDatePicker.selectDay(Integer.toString(i));
            chineseDatePicker.has().dayOfMonth(Integer.toString(i), Locale.CHINESE);
            Pattern chineseDayOfWeekPattern = Pattern.compile(
                    "([\\d]+)([\\u4E00-\\u9FA5]+)(\\d+)([\\u4E00-\\u9FA5]+)");
            Matcher matcher = chineseDayOfWeekPattern.matcher(chineseDatePicker.getDate());
            while (matcher.find()) {
                shownChineseDaysOfWeek.add(matcher.group(4));
            }
        }
        jdiAssert(shownChineseDaysOfWeek, containsInAnyOrder(CHINESE_DAYS_OF_WEEK.toArray()),
                "For Chinese picker: shown and expected days of week are not the same");
        chineseDatePicker.changeMonth();
        waitCondition(() -> chineseDatePicker.getChangeYearButton().isVisible());
        chineseDatePicker.has().visibleChangeYearButton();
        jdiAssert(chineseDatePicker.getAllMonths(), is(CHINESE_MONTHS),
                "For Chinese picker: shown and expected days of week are not the same");
        List<String> shownChineseMonths = new ArrayList<>();
        CHINESE_MONTHS.stream().forEach(elem -> {
            chineseDatePicker.selectMonth(elem);
            waitCondition(() -> chineseDatePicker.getChangeYearButton().isVisible());
            chineseDatePicker.has().visibleChangeYearButton();
            shownChineseMonths.add(chineseDatePicker.getMonth(Locale.CHINESE));
            chineseDatePicker.changeMonth();
        });
        jdiAssert(shownChineseMonths, is(CHINESE_MONTHS),
                "For Chinese picker: shown and expected month names are not the same");
    }

    @Test
    public void testOrientationDatePicker() {
        waitCondition(() -> orientationDatePicker.isVisible());
        orientationDatePicker.has().portraitOrientation();
        orientationDatePicker.switchOrientation();
        orientationDatePicker.has().landscapeOrientation();
    }
}
