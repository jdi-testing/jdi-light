package io.github.epam.vuetify.tests.complex;

import io.github.epam.TestsInit;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.jdiai.tools.Timer.waitCondition;
import static io.github.com.StaticSite.datePickersPage;
import static io.github.com.pages.DatePickersPage.activePickerDatePicker;
import static io.github.com.pages.DatePickersPage.allowedDatePicker;
import static io.github.com.pages.DatePickersPage.buttonCancelMenu;
import static io.github.com.pages.DatePickersPage.buttonOkDialog;
import static io.github.com.pages.DatePickersPage.buttonOkMenu;
import static io.github.com.pages.DatePickersPage.chineseDatePicker;
import static io.github.com.pages.DatePickersPage.colorFirstDatePicker;
import static io.github.com.pages.DatePickersPage.colorSecondDatePicker;
import static io.github.com.pages.DatePickersPage.elevationWithElevationDatePicker;
import static io.github.com.pages.DatePickersPage.firstDateEventsDatePicker;
import static io.github.com.pages.DatePickersPage.firstShowCurrentDatePicker;
import static io.github.com.pages.DatePickersPage.firstWidthDatePicker;
import static io.github.com.pages.DatePickersPage.formattedDatesDatePicker;
import static io.github.com.pages.DatePickersPage.formattedMomentJsDatePicker;
import static io.github.com.pages.DatePickersPage.iconsDatePicker;
import static io.github.com.pages.DatePickersPage.mainWindow;
import static io.github.com.pages.DatePickersPage.multipleDatePicker;
import static io.github.com.pages.DatePickersPage.multipleInMenuDatePicker;
import static io.github.com.pages.DatePickersPage.orientationDatePicker;
import static io.github.com.pages.DatePickersPage.orientationSwitcher;
import static io.github.com.pages.DatePickersPage.pickerDateDatePicker;
import static io.github.com.pages.DatePickersPage.pickerInDialogDatePicker;
import static io.github.com.pages.DatePickersPage.pickerInMenuDatePicker;
import static io.github.com.pages.DatePickersPage.rangeDatePicker;
import static io.github.com.pages.DatePickersPage.readOnlyDatePicker;
import static io.github.com.pages.DatePickersPage.readonlyFormattingDatePicker;
import static io.github.com.pages.DatePickersPage.secondDateEventsDatePicker;
import static io.github.com.pages.DatePickersPage.secondWidthDatePicker;
import static io.github.com.pages.DatePickersPage.swedishDatePicker;
import static io.github.com.pages.DatePickersPage.textWithChosenMonth;
import static io.github.com.pages.DatePickersPage.writableFormattingDatePicker;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;

public class DatePickersTests extends TestsInit {
    private static final int WIDTH_OF_PREDEFINED_WIDTH_DP = 290;
    private static final int CHOSEN_DAY = 12;
    private static final int CHOSEN_DAY_TWO = 20;
    private static final int CHOSEN_DAY_THREE = 25;
    private static final String CHOSEN_MONTH = "May";
    private static final String CHOSEN_YEAR = "1980";
    private static final String CHOSEN_MONTH_SWEDISH = "maj";
    private static final String CHOSEN_MONTH_CHINESE = "5月";
    private static final String GREEN_COLOR = "rgba(102, 187, 106, 1)";
    private static final String BLUE_COLOR = "rgba(25, 118, 210, 1)";
    private static final String BLUE_CIRCLE_COLOR_HEX = "rgba(0, 0, 255, 1)";
    private static final String RED_CIRCLE_COLOR_HEX = "rgba(244, 67, 54, 1)";
    private static final String YELLOW_CIRCLE_COLOR_HEX = "rgba(255, 235, 59, 1)";
    private static final String FORMATTING_DATE = "02/05/2021";
    private static final String FORMATTING_DATE_ISO = "2021-02-05";
    private static final String NEXT_MONTH_ICON_CLASS = "mdi-skip-next";
    private static final String PREVIOUS_MONTH_ICON_CLASS = "mdi-skip-previous";
    private static final String EMPTY_DATE_FIELD = "-";
    private static final String SELECTION_TEXT = " selected";
    private static final String RANGE_SELECTION_TEXT = "2 selected";
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
    private DateTimeFormatter dateFormatHeader = DateTimeFormatter.ofPattern("ccc, MMM d").withLocale(Locale.ENGLISH);
    private DateTimeFormatter formatterMMDDYYYY = DateTimeFormatter.ofPattern("MM/dd/uuuu").withLocale(Locale.ENGLISH);

    private int currentYear = Year.now().getValue();
    private int currentMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;

    @BeforeClass
    public void beforeTest() {
        datePickersPage.open();
        waitCondition(() -> datePickersPage.isOpened());
        datePickersPage.checkOpened();
    }

    @Test(description = "Test checks that date picker has clickable enabled and non-clickable disabled dates")
    public void allowedDatesDatePickerTest() {
        allowedDatePicker.show();
        allowedDatePicker.has().enabledDatesNonEmptyList()
                .and().clickableEnabledDates()
                .and().disabledDatesNonEmptyList()
                .and().nonClickableDisabledDates();
    }

    // @todo #5446 Change checks from checking date and month to check the full labels from the component
    @Test(description = "Test checks that dates are changing correctly")
    public void changeDateDatePickerTest() {
        colorFirstDatePicker.show();
        String nextMonth = date.plusMonths(1).getMonth().toString().charAt(0)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().charAt(0)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();

        colorFirstDatePicker.has().date(date.format(dateFormatHeader));
        colorFirstDatePicker.clickDay(Integer.toString(CHOSEN_DAY));
        //colorFirstDatePicker.has().dayOfMonth(Integer.toString(CHOSEN_DAY));
        colorFirstDatePicker.clickDay(Integer.toString(CHOSEN_DAY_TWO));
        //colorFirstDatePicker.has().dayOfMonth(Integer.toString(CHOSEN_DAY_TWO));
        colorFirstDatePicker.clickDay(Integer.toString(CHOSEN_DAY_THREE));
        //colorFirstDatePicker.has().dayOfMonth(Integer.toString(CHOSEN_DAY_THREE));
        colorFirstDatePicker.toNextMonth();
        //colorFirstDatePicker.has().month(nextMonth);

        colorFirstDatePicker.toPreviousMonth();
        colorFirstDatePicker.toPreviousMonth();
        //colorFirstDatePicker.has().month(previousMonth);

        colorFirstDatePicker.changeMonth();
        colorFirstDatePicker.selectMonth(CHOSEN_MONTH);
       // colorFirstDatePicker.has().month(CHOSEN_MONTH);

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
        colorFirstDatePicker.changeYearCornerButton().click();
        colorFirstDatePicker.selectYear(Integer.toString(currentYear));
        colorFirstDatePicker.has().year(Integer.toString(currentYear));
    }

    @Test(description = "Test checks date picker's color")
    public void colorDatePickerTest() {
        colorFirstDatePicker.show();
        colorFirstDatePicker.has().color(GREEN_COLOR);
        colorSecondDatePicker.has().color(BLUE_COLOR);
    }

    @Test(description = "Test checks if element has elevation or not")
    public void elevationDatePickerTest() {
        elevationWithElevationDatePicker.show();
        elevationWithElevationDatePicker.is().elevated()
                .and().has().elevation(15);
        iconsDatePicker.show();
        iconsDatePicker.is().notElevated();
    }

    @Test(description = "Test checks multiple dates selection")
    public void multipleChosenDatesDatePickerTest() {
        multipleDatePicker.show();
        //String monthMultipleDP = multipleDatePicker.getMonth(Locale.ENGLISH);
        List<String> firstlyActiveDaysOfMonth = multipleDatePicker.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysOfMonth.contains(elem)) {
                multipleDatePicker.clickDay(elem);
            }
        });
        firstlyActiveDaysOfMonth.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDays = new HashSet<>(firstlyActiveDaysOfMonth);
        multipleDatePicker.has().properSetOfActiveDays(allExpectedChosenDays);
        multipleDatePicker.has().date(allExpectedChosenDays.size() + SELECTION_TEXT);
        allExpectedChosenDays.stream().forEach(elem -> multipleDatePicker.clickDay(elem));
        multipleDatePicker.has().date(EMPTY_DATE_FIELD);
        multipleDatePicker.clickDay(Integer.toString(CHOSEN_DAY));
       // multipleDatePicker.has().date(LocalDate.of(Integer.parseInt(multipleDatePicker.getYear()),
        //       Month.valueOf(monthMultipleDP.toUpperCase(Locale.ROOT)), CHOSEN_DAY).format(dateFormatHeader));

        multipleInMenuDatePicker.expand();
        List<String> firstlyActiveDaysInMenu = multipleInMenuDatePicker.getAllActiveDaysOfMonth();
        CHECKED_MULTIPLE_DATES.stream().forEach(elem -> {
            if (!firstlyActiveDaysInMenu.contains(elem)) {
                multipleInMenuDatePicker.clickDay(elem);
            }
        });
        firstlyActiveDaysInMenu.addAll(CHECKED_MULTIPLE_DATES);
        Set<String> allExpectedChosenDaysInMenu = new HashSet<>(firstlyActiveDaysInMenu);
        multipleInMenuDatePicker.has().properSetOfActiveDays(allExpectedChosenDaysInMenu);
        //multipleInMenuDatePicker.has().properShownMultipleDates();
    }

    @Test(description = "Test checks that month news for different months are different")
    public void newsDatePickerTest() throws Exception {
        SimpleDateFormat calendarFormat = new SimpleDateFormat("MMMM yyyy", Locale.ENGLISH);
        SimpleDateFormat newsFormat = new SimpleDateFormat("yyyy-MM", Locale.ENGLISH);
        String calendarMonth = pickerDateDatePicker.getMonthAndYear();
        Date calendarDate = calendarFormat.parse(calendarMonth);
        textWithChosenMonth.is().text(String.format("Month news (%s)", newsFormat.format(calendarDate)));

        pickerDateDatePicker.toNextMonth();
        pickerDateDatePicker.toNextMonth();

        jdiAssert(pickerDateDatePicker.getMonthAndYear(), Matchers.not(calendarMonth));

    }

    @Test(description = "Test checks that dates in certain range are active")
    public void testRangeDatePicker() {
        rangeDatePicker.show();
        rangeDatePicker.clickDay(Integer.toString(CHOSEN_DAY));
        rangeDatePicker.clickDay(Integer.toString(CHOSEN_DAY_THREE));
        rangeDatePicker.has().activeDatesInRange(CHOSEN_DAY, CHOSEN_DAY_THREE);
        rangeDatePicker.has().date(RANGE_SELECTION_TEXT);
        /*String dateFirstFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeDatePicker.getYear()),
                Month.valueOf(rangeDatePicker.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY).toString();
        String dateSecondFormattedRangeDP = LocalDate.of(Integer.parseInt(rangeDatePicker.getYear()),
                Month.valueOf(rangeDatePicker.getMonth(Locale.ENGLISH).toUpperCase(Locale.ROOT)).getValue(),
                CHOSEN_DAY_THREE).toString();*/
        /*jdiAssert(modelDateRange.getText(), allOf(containsString(dateFirstFormattedRangeDP),
                        containsString(dateSecondFormattedRangeDP)));*/
    }

    @Test(description = "Test checks that date picker is readonly")
    public void testReadOnlyDatePicker() {
        String firstlyActiveDay = readOnlyDatePicker.getActiveDayOfMonth();
        String checkedDay;
        if (Integer.parseInt(firstlyActiveDay) > 2 | Integer.parseInt(firstlyActiveDay) < 27) {
            checkedDay = firstlyActiveDay;
        } else {
            checkedDay = "15";
        }
        readOnlyDatePicker.clickDay(Integer.toString(Integer.parseInt(checkedDay) - 1));
        //readOnlyDatePicker.has().dayOfMonth(firstlyActiveDay);
    }

    @Test(description = "Test checks that date picker has readonly date field")
    public void readonlyDateFieldDatePickerTest() {
        readonlyFormattingDatePicker.show();
        readonlyFormattingDatePicker.has().dateFieldReadonlyAttribute();
    }

    @Test(description = "Test checks that date picker shows current date")
    public void showCurrentDatePickerTest() {
        firstShowCurrentDatePicker.show();
        firstShowCurrentDatePicker.has().date(date.format(dateFormatHeader));
    }

    @Test(description = "Test checks that date picker has proper width")
    public void widthDatePickerTest() {
        firstWidthDatePicker.show();
        firstWidthDatePicker.has().width(WIDTH_OF_PREDEFINED_WIDTH_DP);
        secondWidthDatePicker.has().width(mainWindow.getSize().getWidth());
    }

    @Test(description = "Test checks color of event circles")
    public void dateEventsDatePickerTest() {
        firstDateEventsDatePicker.has().eventColorCirclesNonEmptyList()
                .and().properColorsOfEventCircles(GREEN_COLOR);
        secondDateEventsDatePicker.has().eventColorCirclesNonEmptyList()
                .and().properColorsOfEventCircles(BLUE_CIRCLE_COLOR_HEX, RED_CIRCLE_COLOR_HEX, YELLOW_CIRCLE_COLOR_HEX);
    }

    @Test(description = "Test checks date picker code before and after date selection")
    public void testActivePickerDatePicker() {
        waitCondition(() -> activePickerDatePicker.isVisible());
        // @todo #5446 Fix code check in tests, it is not a part of the picker
        /*jdiAssert(activePickerDatePicker.getCode(), is("null"), "Before any date in Active date picker " +
                "is selected: active picker code is not null");*/
        activePickerDatePicker.expand();
        activePickerDatePicker.selectYear(CHOSEN_YEAR);
        activePickerDatePicker.selectMonth(CHOSEN_MONTH);
        activePickerDatePicker.clickDay(Integer.toString(CHOSEN_DAY));
        activePickerDatePicker.has().resultDate(LocalDate.of(Integer.parseInt(CHOSEN_YEAR),
                Month.valueOf(CHOSEN_MONTH.toUpperCase(Locale.ROOT)), CHOSEN_DAY).toString());
        /*jdiAssert(activePickerDatePicker.getCode(), is("DATE"), "After some date in Active date picker " +
                "was selected: active picker code is not correct");*/
    }

    @Test(description = "Expandable date picker test")
    public void expandableDatePicker() {
        pickerInMenuDatePicker.show();
        String nextMonth = date.plusMonths(1).getMonth().toString().substring(0, 1)
                + date.plusMonths(1).getMonth().toString().substring(1).toLowerCase();
        String previousMonth = date.minusMonths(1).getMonth().toString().substring(0, 1)
                + date.minusMonths(1).getMonth().toString().substring(1).toLowerCase();
        pickerInMenuDatePicker.expand();
        pickerInMenuDatePicker.is().expanded()
                .and().has().resultDate(date.toString());
        pickerInMenuDatePicker.clickDay(Integer.toString(CHOSEN_DAY));
        pickerInMenuDatePicker.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY).toString());
        pickerInMenuDatePicker.clickDay(Integer.toString(CHOSEN_DAY_TWO));
        pickerInMenuDatePicker.has().resultDate(LocalDate.of(currentYear, currentMonth, CHOSEN_DAY_TWO).toString());
        pickerInMenuDatePicker.toNextMonth();
        //pickerInMenuDatePicker.has().month(nextMonth);
        pickerInMenuDatePicker.toPreviousMonth();
        pickerInMenuDatePicker.toPreviousMonth();
        //pickerInMenuDatePicker.has().month(previousMonth);
        pickerInMenuDatePicker.changeMonth();
        pickerInMenuDatePicker.selectMonth(CHOSEN_MONTH);
        //pickerInMenuDatePicker.has().month(CHOSEN_MONTH);
        //pickerInMenuDatePicker.changeMonth();
        // @todo #5446 Change logic to search existed button to change month and year
        //pickerInMenuDatePicker.has().visibleChangeYearButton();
        //pickerInMenuDatePicker.changeYear();
        //pickerInMenuDatePicker.selectYear(Integer.toString(currentYear + 99));
        //pickerInMenuDatePicker.has().year(Integer.toString(currentYear + 99));
        //pickerInMenuDatePicker.has().visibleChangeYearButton();
        buttonOkMenu.click();
        pickerInMenuDatePicker.expand();
        pickerInMenuDatePicker.has().mainDateFieldIsNotExist();
        buttonCancelMenu.click();
        pickerInDialogDatePicker.expand();
        pickerInDialogDatePicker.has().mainDateField();
        buttonOkDialog.click();
    }

    @Test(description = "Test shows haw to work with formatted dates")
    public void formattedDateDatePickerTest() {
        writableFormattingDatePicker.show();
        writableFormattingDatePicker.expand();
        writableFormattingDatePicker.clickDay(Integer.toString(CHOSEN_DAY));
        writableFormattingDatePicker.has().resultDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY).format(formatterMMDDYYYY));
        writableFormattingDatePicker.clear();
        writableFormattingDatePicker.setDate(FORMATTING_DATE);
        writableFormattingDatePicker.has().resultDate(FORMATTING_DATE);
        readonlyFormattingDatePicker.has().dateFieldReadonlyAttribute();
    }

    @Test(description = "Test checks formatting with external libraries")
    public void testFormattingWithExternalLibrariesDatePicker() {
        formattedMomentJsDatePicker.show();
        formattedMomentJsDatePicker.clear();
        formattedMomentJsDatePicker.has().emptyResultDate();
        formattedMomentJsDatePicker.expand();
        formattedMomentJsDatePicker.is().expanded();
        formattedMomentJsDatePicker.clickDay(Integer.toString(CHOSEN_DAY));
        formattedMomentJsDatePicker.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY));
        formattedDatesDatePicker.expand();
        formattedDatesDatePicker.clickDay(Integer.toString(CHOSEN_DAY_THREE));
        formattedDatesDatePicker.has().properExternalLibFormattingDate(LocalDate.of(
                currentYear, currentMonth, CHOSEN_DAY_THREE));
    }

    @Test(description = "Test shows how to work with time pickers in different locales")
    public void testSwedenDatePicker() {
        waitCondition(() -> swedishDatePicker.isVisible());
        swedishDatePicker.changeMonth();
        swedishDatePicker.hoverMonth(CHOSEN_MONTH_SWEDISH);
        swedishDatePicker.has().visibleChangeYearButton();
        swedishDatePicker.changeYear();
        swedishDatePicker.selectYear(CHOSEN_YEAR);
        swedishDatePicker.has().year(CHOSEN_YEAR);
        swedishDatePicker.selectMonth(CHOSEN_MONTH_SWEDISH);
        List<String> shownSwedishDaysOfWeek = new ArrayList<>();
        Pattern swedishDayOfWeekPattern = Pattern.compile("^[a-zwåäöÅÄÖ]+");
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            swedishDatePicker.clickDay(Integer.toString(i));
            swedishDatePicker.has().activeDate(Integer.toString(i));
            //swedishDatePicker.has().dayOfMonth(Integer.toString(i), new Locale("sv", "SE"));
            Matcher matcher = swedishDayOfWeekPattern.matcher(swedishDatePicker.getDate());
            while (matcher.find()) {
                shownSwedishDaysOfWeek.add(matcher.group());
            }
        }
        jdiAssert(shownSwedishDaysOfWeek, containsInAnyOrder(SWEDISH_SHORT_DAYS_OF_WEEK.toArray()));
        swedishDatePicker.changeMonth();
        waitCondition(() -> swedishDatePicker.getChangeYearButton().isVisible());
        swedishDatePicker.has().visibleChangeYearButton();
        jdiAssert(swedishDatePicker.getAllMonths(), is(SWEDISH_SHORT_MONTHS));
        List<String> shownSwedishMonths = new ArrayList<>();
        SWEDISH_SHORT_MONTHS.stream().forEach(elem -> {
            swedishDatePicker.selectMonth(elem.toLowerCase());
            waitCondition(() -> swedishDatePicker.getChangeYearButton().isVisible());
            swedishDatePicker.has().visibleChangeYearButton();
            //shownSwedishMonths.add(swedishDatePicker.getMonth(new Locale("sv", "SE")));
            swedishDatePicker.changeMonth();
        });
        jdiAssert(shownSwedishMonths, is(SWEDISH_FULL_MONTHS),
                "For Swedish picker: shown and expected full month names are not the same");
    }

    @Test(description = "Test shows how to work with time pickers in Chinese")
    public void testChineseDatePicker() {
        chineseDatePicker.changeMonth();
        waitCondition(() -> chineseDatePicker.getChangeYearButton().isVisible());
        chineseDatePicker.has().visibleChangeYearButton();
        chineseDatePicker.changeYear();
        chineseDatePicker.selectYear(CHOSEN_YEAR);
        chineseDatePicker.has().year(Matchers.startsWith(CHOSEN_YEAR));
        chineseDatePicker.selectMonth(CHOSEN_MONTH_CHINESE);
        //chineseDatePicker.has().month(CHOSEN_MONTH_CHINESE, Locale.CHINESE);
        List<String> shownChineseDaysOfWeek = new ArrayList<>();
        Pattern chineseDayOfWeekPattern = Pattern.compile(
                "([\\d]+)([\\u4E00-\\u9FA5]+)(\\d+)([\\u4E00-\\u9FA5]+)");
        for (int i = CHOSEN_DAY; i < (CHOSEN_DAY + 7); i++) {
            chineseDatePicker.clickDay(Integer.toString(i));
            //chineseDatePicker.has().dayOfMonth(Integer.toString(i), Locale.CHINESE);
            chineseDatePicker.has().activeDate(Matchers.startsWith(Integer.toString(i)));
            Matcher matcher = chineseDayOfWeekPattern.matcher(chineseDatePicker.getDate());
            while (matcher.find()) {
                shownChineseDaysOfWeek.add(matcher.group(4));
            }
        }
        jdiAssert(shownChineseDaysOfWeek, containsInAnyOrder(CHINESE_DAYS_OF_WEEK.toArray()));
        chineseDatePicker.changeMonth();
        waitCondition(() -> chineseDatePicker.getChangeYearButton().isVisible());
        chineseDatePicker.has().visibleChangeYearButton();
        jdiAssert(chineseDatePicker.getAllMonths(), is(CHINESE_MONTHS));
        List<String> shownChineseMonths = new ArrayList<>();
        CHINESE_MONTHS.stream().forEach(elem -> {
            chineseDatePicker.selectMonth(elem);
            waitCondition(() -> chineseDatePicker.getChangeYearButton().isVisible());
            chineseDatePicker.has().visibleChangeYearButton();
            // shownChineseMonths.add(chineseDatePicker.getMonth(Locale.CHINESE));
            chineseDatePicker.changeMonth();
        });
        jdiAssert(shownChineseMonths, is(CHINESE_MONTHS));
    }

    @Test (description = "Test checks date picker's orientation")
    public void testOrientationDatePicker() {
        orientationDatePicker.show();
        orientationDatePicker.has().portraitOrientation();
        orientationSwitcher.check();
        orientationDatePicker.has().landscapeOrientation();
    }

    @Test(description = "Text checks date picker's theme")
    public void themeDatePickerTest() {
        orientationDatePicker.show();
        orientationDatePicker.has().darkTheme();
        chineseDatePicker.show();
        chineseDatePicker.has().lightTheme();
    }
}
