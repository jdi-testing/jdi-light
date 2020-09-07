package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static com.epam.jdi.light.angular.entities.DatepickerNavigation.*;
import static io.github.com.pages.sections.DatepickerSection.minMaxDatepicker;

public class MinMaxDatepickerTests extends TestsDatepickerBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        minMaxDatepicker.show();
    }

    @Test
    public void checkLabelValue() {
        minMaxDatepicker.label().has().value(CHOOSE_A_DATE);
    }

    @Test
    public void checkTodayDayValue() {
        minMaxDatepicker.has().todayDay(LocalDate.now().getDayOfMonth());
    }

    @Test
    public void checkEmptyDateValue() {
        minMaxDatepicker.clear();
        minMaxDatepicker.has().value("");
    }

    @Test
    public void checkDisabledPreviousMonthNavigation() {
        String minDate = getMinDate();
        minMaxDatepicker.input(minDate);
        minMaxDatepicker.is().date(minDate).and().disabledNavigation(PREVIOUS_MONTH.getName());
    }

    @Test
    public void checkDisabledNextMonthNavigation() {
        String maxDate = getMaxDate();
        minMaxDatepicker.input(maxDate);
        minMaxDatepicker.is().month(Month.DECEMBER).day(31).year(Year.of(LocalDate.now().getYear() + 1))
                        .and().disabledNavigation(NEXT_MONTH.getName());
    }

    @Test
    public void checkDisabledMonthsAndYearsNavigation() {
        String firstDisabledYearCell = String.format(CELL.getName(), MIN_YEAR - 2);
        String secondDisabledYearCell = String.format(CELL.getName(), MIN_YEAR - 1);
        minMaxDatepicker.openYearsView();
        minMaxDatepicker.has().disabledNavigation(PREVIOUS_TWENTY_YEARS.getName(),
                                                  NEXT_TWENTY_YEARS.getName(),
                                                  firstDisabledYearCell,
                                                  secondDisabledYearCell);
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (minMaxDatepicker.isExpanded()) {
            minMaxDatepicker.collapse();
        }
        if (!minMaxDatepicker.isEmpty()) {
            minMaxDatepicker.clear();
        }
    }
}
