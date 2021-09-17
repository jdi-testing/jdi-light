package io.github.epam.angular.tests.unit;

import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.epam.jdi.light.angular.entities.DatepickerNavigation.*;
import static com.epam.jdi.light.elements.composite.WebPage.reload;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.*;
import static io.github.epam.angular.tests.elements.complex.datepicker.TestsDatepickerBase.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DatepickerUnitTests extends TestsInit {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        shouldBeLoggedIn();
        angularPage.shouldBeOpened();
        basicDatepicker.show();
    }

    public void reInit() {
        reload();
        basicDatepicker.show();
    }

    @Test
    public void checkLabelTest() {
        assertEquals(basicDatepicker.labelText(), CHOOSE_A_DATE);
    }

    @Test
    public void checkExpandedTest() {
        basicDatepicker.expand();
        assertTrue(basicDatepicker.isExpanded());
    }

    @Test
    public void checkOpenByButtonTest() {
        openMethodDatepicker.show();
        openMethodDatepicker.expand();
        assertTrue(openMethodDatepicker.isExpanded());
        openMethodDatepicker.collapse();
    }

    @Test
    public void checkEnabledTest() {
        assertTrue(basicDatepicker.isEnabled());
    }

    @Test
    public void checkDisabledTest() {
        completelyDisabledDatepicker.show();
        assertTrue(completelyDisabledDatepicker.isDisabled());
    }

    @Test
    public void checkEnabledToggleTest() {
        assertTrue(basicDatepicker.isToggleEnabled());
    }

    @Test
    public void checkDisabledToggleTest() {
        completelyDisabledDatepicker.show();
        assertTrue(completelyDisabledDatepicker.isToggleDisabled());
    }

    @Test
    public void checkEnabledInputTest() {
        completelyDisabledDatepicker.show();
        assertTrue(basicDatepicker.isInputEnabled());
    }

    @Test
    public void checkDisabledInputTest() {
        completelyDisabledDatepicker.show();
        assertTrue(completelyDisabledDatepicker.isInputDisabled());
    }

    @Test
    public void checkCollapsedTest() {
        basicDatepicker.collapse();
        assertTrue(basicDatepicker.isCollapsed());
    }

    @Test
    public void checkClearTest() {
        basicDatepicker.select(LocalDate.now());
        basicDatepicker.clear();
        assertTrue(basicDatepicker.isEmpty());
    }

    @Test
    public void checkFocusTest() {
        basicDatepicker.focus();
        assertTrue(basicDatepicker.isFocused());
    }

    @Test
    public void checkSetNotValidTextTest() {
        basicDatepicker.setText("2008-13-08");
        assertEquals(basicDatepicker.getText(), "2008-13-08");
    }

    @Test
    public void checkInputTest() {
        basicDatepicker.input("12/8/2017");
        assertEquals(basicDatepicker.value(), "12/8/2017");
    }

    @Test
    public void checkSendKeysTest() {
        reInit();
        basicDatepicker.sendKeys("31-DEC-1812");
        assertEquals(basicDatepicker.getValue(), "12/31/1812");
    }

    @Test
    public void checkSelectDateTest() {
        basicDatepicker.select(LocalDate.of(2019, 11, 1));
        assertEquals(basicDatepicker.selectedDate(), LocalDate.of(2019, 11, 1));
    }

    @Test
    public void checkSelectWithLocaleDateTest() {
        basicDatepicker.select(LocalDate.of(2010, 1, 18), Locale.US);
        assertEquals(basicDatepicker.selectedDate(), LocalDate.of(2010, 1, 18));
    }

    @Test
    public void checkSelectWithDifferentLocaleDateTest() {
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.select(LocalDate.of(2008, 1, 12), Locale.FRANCE);
        assertEquals(differentLocaleDatepicker.selectedDate(Locale.FRANCE), LocalDate.of(2008, 1, 12));
    }

    @Test
    public void checkSelectStringDateWithLocaleTest() {
        basicDatepicker.select("3/24/2041", Locale.US);
        assertEquals(basicDatepicker.selectedDate(), LocalDate.of(2041, 3, 24));
    }

    @Test
    public void checkSelectStringDateWithDifferentLocaleTest() {
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.select("7/17/2040", Locale.JAPAN);
        assertEquals(differentLocaleDatepicker.selectedDate(Locale.JAPAN), LocalDate.of(2040, 7, 17));
    }

    @Test
    public void checkSelectStringDateFromNextRangeOfYearsTest() {
        basicDatepicker.select("2/12/2044");
        assertEquals(basicDatepicker.selectedDate(), LocalDate.of(2044, 2, 12));
    }

    @Test
    public void checkSelectDateFromPreviousRangeOfYearsTest() {
        basicDatepicker.select(LocalDate.of(2009, 7, 18));
        assertEquals(basicDatepicker.selectedDate(), LocalDate.of(2009, 7, 18));
    }

    @Test
    public void checkInputMonthTest() {
        basicDatepicker.input(LocalDate.now().toString());
        assertEquals(basicDatepicker.getMonth(), LocalDate.now().getMonth());
    }

    @Test
    public void checkSelectedMonthTest() {
        basicDatepicker.setDate(LocalDate.of(2019, 6, 1));
        assertEquals(basicDatepicker.selectedMonth(), Month.JUNE);
    }

    @Test
    public void checkStartMonthTest() {
        reInit();
        startDateDatepicker.show();
        assertEquals(startDateDatepicker.startMonth(), Month.JANUARY);
    }

    @Test
    public void checkSelectDayInPreviousMonthTest() {
        reInit();
        int currentMonth = LocalDate.now().getMonth().getValue();
        int previousMonth = currentMonth == 1 ? 12 : currentMonth - 1;
        basicDatepicker.selectDayInPreviousMonth(1);
        assertEquals(basicDatepicker.selectedMonth().getValue(), previousMonth);
    }

    @Test
    public void checkSelectDayInNextMonthTest() {
        reInit();
        int currentMonth = LocalDate.now().getMonth().getValue();
        int nextMonth = currentMonth == 12 ? 1 : currentMonth + 1;
        basicDatepicker.selectDayInNextMonth(2);
        assertEquals(basicDatepicker.selectedMonth().getValue(), nextMonth);
    }

    @Test
    public void checkNavigateToDayInPreviousMonthsTest() {
        reInit();
        int currentMonth = LocalDate.now().getMonth().getValue();
        int monthCountEarlier = 2;
        int monthCount = monthCountEarlier % 12;
        int previousMonth = monthCount == 0 ?
                currentMonth :
                (currentMonth - monthCount) == 0 ? 12 : currentMonth - monthCount;
        basicDatepicker.navigateToDayInPreviousMonths(monthCountEarlier, 12);
        assertEquals(basicDatepicker.selectedMonth().getValue(), previousMonth);
    }

    @Test
    public void checkNavigateToDayInNextMonthsTest() {
        reInit();
        int currentMonth = LocalDate.now().getMonth().getValue();
        int monthCountLater = 3;
        int monthCount = monthCountLater % 12;
        int nextMonth = monthCount == 0 ?
                currentMonth :
                (currentMonth + monthCount) > 12 ? (currentMonth + monthCount) - 12 : currentMonth + monthCount;
        basicDatepicker.navigateToDayInNextMonths(monthCountLater, 12);
        assertEquals(basicDatepicker.selectedMonth().getValue(), nextMonth);
    }

    @Test
    public void checkInputYearTest() {
        basicDatepicker.input("07-OCTOBER-2021");
        assertEquals(basicDatepicker.getYear(), Year.of(2021));
    }

    @Test
    public void checkSelectedYearTest() {
        basicDatepicker.setText("16-sep-2003");
        assertEquals(basicDatepicker.selectedYear(), Year.of(2003));
    }

    @Test
    public void checkStartYearTest() {
        startDateDatepicker.show();
        assertEquals(startDateDatepicker.startYear(), Year.of(1990));
    }

    @Test
    public void checkTodayDayTest() {
        assertEquals(basicDatepicker.todayDay(), LocalDate.now().getDayOfMonth());
    }

    @Test
    public void checkStartDayTest() {
        startDateDatepicker.show();
        assertEquals(startDateDatepicker.startDay(), 1);
    }

    @Test
    public void checkStartDayWithLocaleTest() {
        startDateDatepicker.show();
        assertEquals(startDateDatepicker.startDay(Locale.US), 1);
    }

    @Test
    public void checkSetDayTest() {
        basicDatepicker.setText("5/25/2005");
        assertEquals(basicDatepicker.selectedDay(), 25);
    }

    @Test
    public void checkSelectedDayTest() {
        basicDatepicker.selectDay(14);
        assertEquals(basicDatepicker.getDay(), 14);
        assertEquals(basicDatepicker.selectedDay(), 14);
    }

    @Test
    public void checkInputValidDateValueTest() {
        deserializeDatepicker.show();
        deserializeDatepicker.input("12/12/2020");
        assertTrue(deserializeDatepicker.isValid());
    }

    @Test
    public void checkInputInvalidDateValueTest() {
        deserializeDatepicker.show();
        deserializeDatepicker.input("13/1/2020");
        assertTrue(deserializeDatepicker.isInvalid());
    }

    @Test
    public void checkEnabledPreviousMonthNavigationTest() {
        String minDate = getMinDate();
        basicDatepicker.setText(minDate);
        assertTrue(basicDatepicker.isEnabledNavigationElements(PREVIOUS_MONTH.getName()));
    }

    @Test
    public void checkDisabledPreviousMonthNavigationTest() {
        String minDate = getMinDate();
        minMaxDatepicker.show();
        minMaxDatepicker.setText(minDate);
        assertTrue(minMaxDatepicker.isDisabledNavigationElements(PREVIOUS_MONTH.getName()));
    }

    @Test
    public void checkEnabledNextMonthNavigationTest() {
        String maxDate = getMaxDate();
        basicDatepicker.setText(maxDate);
        assertTrue(basicDatepicker.isEnabledNavigationElements(NEXT_MONTH.getName()));
    }

    @Test
    public void checkDisabledNextMonthNavigationTest() {
        String maxDate = getMaxDate();
        minMaxDatepicker.show();
        minMaxDatepicker.setText(maxDate);
        assertTrue(minMaxDatepicker.isDisabledNavigationElements(NEXT_MONTH.getName()));
    }

    @Test
    public void checkEnabledYearsNavigationTest() {
        basicDatepicker.openYearsView();
        assertTrue(basicDatepicker
                           .isEnabledNavigationElements(PREVIOUS_TWENTY_YEARS.getName(), NEXT_TWENTY_YEARS.getName()));
    }

    @Test
    public void checkDisabledYearsNavigationTest() {
        String firstDisabledYearCell = format(CELL.getName(), MIN_YEAR - 2);
        String secondDisabledYearCell = format(CELL.getName(), MIN_YEAR - 1);
        minMaxDatepicker.show();
        minMaxDatepicker.clear();
        minMaxDatepicker.openYearsView();
        assertTrue(minMaxDatepicker
                           .isDisabledNavigationElements(PREVIOUS_TWENTY_YEARS.getName(), NEXT_TWENTY_YEARS.getName(),
                                                         firstDisabledYearCell, secondDisabledYearCell));
    }

    @Test
    public void checkDisabledSaturdaysTest() {
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2019, 9, 1));
        String[] disabledElemtnts = filterDatepicker.getWeekDayNumbers(SATURDAY);
        assertTrue(filterDatepicker.isDisabledNavigationElements(disabledElemtnts));
    }

    @Test
    public void checkDisabledSundaysTest() {
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2019, 12, 1));
        assertTrue(filterDatepicker.isDisabledNavigationElements(filterDatepicker.getWeekDayNumbers(SUNDAY)));
    }

    @Test
    public void checkEnabledTuesdaysTest() {
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2020, 8, 1));
        assertTrue(filterDatepicker.isEnabledNavigationElements(filterDatepicker.getWeekDayNumbers(TUESDAY)));
    }

    @Test
    public void basicLocaleTest() {
        assertTrue(basicDatepicker.isSelectedLocale(Locale.US));
    }

    @Test
    public void differentLocaleTest() {
        reInit();
        differentLocaleDatepicker.show();
        assertTrue(differentLocaleDatepicker.isSelectedLocale(Locale.JAPAN));

    }

    @Test
    public void switchLocaleTest() {
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.switchLocale();
        assertTrue(differentLocaleDatepicker.isSelectedLocale(Locale.FRANCE));
    }

    @Test
    public void selectFirstInputChangeEventsTest() {
        reInit();
        LocalDate firstEventDate = LocalDate.of(2020, 9, 14);
        List<String> inputChangeEvents = getInputChangeEvents(firstEventDate);
        inputChangeEventsDatepicker.show();
        inputChangeEventsDatepicker.select(firstEventDate);
        inputChangeEventsDatepicker.select(LocalDate.of(2021, 11, 3));
        assertTrue(inputChangeEventsDatepicker.isFirstInputChangeEvents(inputChangeEvents));
    }

    @Test
    public void selectLastInputChangeEventsTest() {
        LocalDate lastEventDate = LocalDate.of(2020, 8, 25);
        List<String> inputChangeEvents = getInputChangeEvents(lastEventDate);
        inputChangeEventsDatepicker.show();
        inputChangeEventsDatepicker.select(LocalDate.of(2019, 12, 4));
        inputChangeEventsDatepicker.select(lastEventDate);
        assertTrue(inputChangeEventsDatepicker.isLastInputChangeEvents(inputChangeEvents));
    }

    @Test
    public void selectLastNullInputChangeEventsTest() {
        LocalDate eventDate = LocalDate.now();
        List<String> inputChangeEvents = new ArrayList<>(Arrays.asList("input: null", "change: null"));
        inputChangeEventsDatepicker.show();
        inputChangeEventsDatepicker.select(eventDate);
        inputChangeEventsDatepicker.clear();
        assertTrue(inputChangeEventsDatepicker.isLastInputChangeEvents(inputChangeEvents));
    }

    @Test
    public void selectLastNullChangeEventTest() {
        LocalDate eventDate = LocalDate.now();
        String changeEvent = "change: null";
        inputChangeEventsDatepicker.show();
        inputChangeEventsDatepicker.select(eventDate);
        inputChangeEventsDatepicker.clear();
        assertTrue(inputChangeEventsDatepicker.isLastChangeEvent(changeEvent));
    }

    @Test
    public void selectLastNullInputEventTest() {
        String inputEvent = "input: null";
        inputChangeEventsDatepicker.show();
        inputChangeEventsDatepicker.sendKeys("1");
        inputChangeEventsDatepicker.clear();
        assertTrue(inputChangeEventsDatepicker.isLastInputEvent(inputEvent));
    }

    @Test
    public void selectLastUndefinedChangeEventTest() {
        reInit();
        String changeEvent = "change: undefined";
        inputChangeEventsDatepicker.show();
        inputChangeEventsDatepicker.setText("wrong date");
        inputChangeEventsDatepicker.clear();
        assertTrue(inputChangeEventsDatepicker.isLastChangeEvent(changeEvent));
    }
}
