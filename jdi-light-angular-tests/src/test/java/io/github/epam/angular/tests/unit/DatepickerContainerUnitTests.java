package io.github.epam.angular.tests.unit;

import com.epam.jdi.light.angular.elements.composite.DatepickerContainer;
import com.epam.jdi.light.angular.entities.DatepickerNavigation;
import io.github.epam.TestsInit;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.epam.jdi.light.angular.entities.DatepickerNavigation.*;
import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.*;
import static io.github.epam.angular.tests.elements.complex.datepicker.TestsDatepickerBase.*;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DatepickerContainerUnitTests extends TestsInit {
    private DatepickerContainer container;

    @BeforeMethod(alwaysRun = true)
    public void before() {
        skipForFirefox();
        shouldBeLoggedIn();
        angularPage.open();
        container = new DatepickerContainer();
    }

    @Test
    public void displayedTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        assertTrue(container.isDisplayed());
    }

    @Test
    public void hiddenTest() {
        basicDatepicker.show();
        assertTrue(container.isHidden());
    }

    @Test
    public void monthTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        assertEquals(container.selectedMonth(), LocalDate.now().getMonth());
    }

    @Test
    public void startMonthTest() {
        startDateDatepicker.show();
        startDateDatepicker.expand();
        assertEquals(container.startMonth(), Month.JANUARY);
    }

    @Test
    public void startMonthWithLocaleTest() {
        startDateDatepicker.show();
        startDateDatepicker.expand();
        assertEquals(container.startMonth(Locale.US), Month.JANUARY);
    }

    @Test
    public void selectedMonthWithLocaleTest() {
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.expand();
        assertEquals(container.selectedMonth(Locale.FRANCE), LocalDate.now().getMonth());
    }

    @Test
    public void yearTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        assertEquals(container.selectedYear(), Year.now());
    }

    @Test
    public void startYearTest() {
        startDateDatepicker.show();
        startDateDatepicker.expand();
        assertEquals(container.startYear(), Year.of(1990));
    }

    @Test
    public void todayDayTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        assertEquals(container.todayDay(), LocalDate.now().getDayOfMonth());
    }

    @Test
    public void startDayTest() {
        startDateDatepicker.show();
        startDateDatepicker.expand();
        container.selectActiveMonth();
        assertEquals(container.activeDay(), 1);
    }

    @Test
    public void startDayWithLocaleTest() {
        startDateDatepicker.show();
        startDateDatepicker.expand();
        container.selectActiveMonth(Locale.US);
        assertEquals(container.activeDay(), 1);
    }

    @Test
    public void startDayWithDifferentLocaleTest() {
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.expand();
        assertEquals(container.activeDay(), LocalDate.now().getDayOfMonth());
    }

    @Test
    public void dayInPreviousMonthTest() {
        int currentMonth = LocalDate.now().getMonth().getValue();
        int previousMonth = currentMonth == 1 ? 12 : currentMonth - 1;
        basicDatepicker.show();
        basicDatepicker.expand();
        container.selectPreviousMonth();
        container.selectDay(1);
        basicDatepicker.expand();
        assertEquals(container.selectedMonth().getValue(), previousMonth);
    }

    @Test
    public void dayInNextMonthTest() {
        int currentMonth = LocalDate.now().getMonth().getValue();
        int nextMonth = currentMonth == 12 ? 1 : currentMonth + 1;
        basicDatepicker.show();
        basicDatepicker.expand();
        container.selectNextMonth();
        container.selectDay(2);
        basicDatepicker.expand();
        assertEquals(container.selectedMonth().getValue(), nextMonth);
    }

    @Test
    public void selectDayByStringValueTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.selectDay("25");
        basicDatepicker.expand();
        assertEquals(container.selectedDay(), 25);
    }

    @Test
    public void selectDayByIntegerValueTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.selectDay(4);
        basicDatepicker.expand();
        assertEquals(container.selectedDay(), 4);
    }

    @Test
    public void selectDateTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.select(LocalDate.of(2033, 2, 3));
        basicDatepicker.expand();
        assertEquals(container.selectedDate(), LocalDate.of(2033, 2, 3));
    }

    @Test
    public void selectDateWithLocaleTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.select(LocalDate.of(2030, 12, 4), Locale.US);
        basicDatepicker.expand();
        assertEquals(container.selectedDate(Locale.US), LocalDate.of(2030, 12, 4));
    }

    @Test
    public void selectDateWithDifferentLocaleTest() {
        refresh();
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.expand();
        container.select(LocalDate.of(2017, 6, 14), Locale.JAPAN);
        differentLocaleDatepicker.expand();
        assertEquals(container.selectedDate(Locale.JAPAN), LocalDate.of(2017, 6, 14));
    }

    @Test
    public void selectDateFromPreviousRangeOfYearsTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.select(LocalDate.of(1975, 10, 9), Locale.US);
        basicDatepicker.expand();
        assertEquals(container.selectedDate(), LocalDate.of(1975, 10, 9));
    }

    @Test
    public void selectDateByStringValueTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.select("12/13/2016");
        basicDatepicker.expand();
        assertEquals(container.selectedDate(), LocalDate.of(2016, 12, 13));
    }

    @Test
    public void selectDateWithLocaleValueTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.select("12/7/2018", Locale.US);
        basicDatepicker.expand();
        assertEquals(container.selectedDate(), LocalDate.of(2018, 12, 7));
    }

    @Test
    public void selectDateWithDifferentLocaleValueTest() {
        refresh();
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.expand();
        container.select("4/23/2019", Locale.JAPAN);
        differentLocaleDatepicker.expand();
        assertEquals(container.selectedDate(Locale.JAPAN), LocalDate.of(2019, 4, 23));
    }

    @Test
    public void selectDateFromNextRangeOfYearsTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        container.select("10/09/2075");
        basicDatepicker.expand();
        assertEquals(container.selectedDate(), LocalDate.of(2075, 10, 9));
    }

    @Test
    public void disabledPreviousMonthNavigationTest() {
        String minDate = getMinDate();
        minMaxDatepicker.show();
        minMaxDatepicker.setText(minDate);
        minMaxDatepicker.expand();
        assertTrue(container.disabled(PREVIOUS_MONTH.getName()));
    }

    @Test
    public void disabledNextMonthNavigationTest() {
        String maxDate = getMaxDate();
        minMaxDatepicker.show();
        minMaxDatepicker.setText(maxDate);
        minMaxDatepicker.expand();
        assertTrue(container.disabled(NEXT_MONTH.getName()));
    }

    @Test
    public void disabledMonthsAndYearsNavigationTest() {
        String firstDisabledYearCell = String.format(CELL.getName(), MIN_YEAR - 2);
        String secondDisabledYearCell = String.format(CELL.getName(), MIN_YEAR - 1);
        minMaxDatepicker.show();
        minMaxDatepicker.expand();
        container.openYearsView();
        assertTrue(container.disabled(PREVIOUS_TWENTY_YEARS.getName(), NEXT_TWENTY_YEARS.getName(),
                                      firstDisabledYearCell, secondDisabledYearCell));
    }

    @Test
    public void disabledSaturdayDaysTest() {
        String[] saturdays = new String[5];
        Arrays.stream(new String[] {" 1 ", " 8 ", " 15 ", " 22 ", " 29 "}).map(d -> String.format(CELL.getName(), d))
                .collect(Collectors.toList()).toArray(saturdays);
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2020, 8, 1));
        filterDatepicker.expand();
        assertTrue(container.disabled(saturdays));
    }

    @Test
    public void disabledSundayDaysTest() {
        String[] sundays = new String[4];
        Arrays.stream(new String[] {" 5 ", " 12 ", " 19 ", " 26 "}).map(d -> String.format(CELL.getName(), d))
                .collect(Collectors.toList()).toArray(sundays);
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2020, 7, 1));
        filterDatepicker.expand();
        assertTrue(container.disabled(sundays));
    }

    @Test
    public void disabledSaturdaysTest() {
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2020, 3, 1));
        filterDatepicker.expand();
        assertTrue(container.disabled(container.getWeekDayNumbers(SATURDAY)));
    }

    @Test
    public void checkEnabledThursdaysTest() {
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2020, 8, 1));
        filterDatepicker.expand();
        assertTrue(!container.disabled(container.getWeekDayNumbers(THURSDAY)));
    }

    @Test
    public void disabledSundaysTest() {
        filterDatepicker.show();
        filterDatepicker.setDate(LocalDate.of(2020, 11, 1));
        filterDatepicker.expand();
        assertTrue(container.disabled(container.getWeekDayNumbers(DatepickerNavigation.SUNDAY)));
    }

    @Test
    public void basicLocaleTest() {
        basicDatepicker.show();
        basicDatepicker.expand();
        assertTrue(container.isSelectedLocale(Locale.US));

    }

    @Test
    public void differentLocaleTest() {
        refresh();
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.expand();
        assertTrue(container.isSelectedLocale(Locale.JAPAN));

    }

    @Test
    public void switchLocaleTest() {
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.expand();
        assertTrue(container.isSelectedLocale(Locale.FRANCE));
    }

}
