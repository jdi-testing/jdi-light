package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Month;
import java.time.Year;
import java.util.Locale;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.startDateDatepicker;

public class StartDateDatepickerTests extends TestsDatepickerBase {
    @BeforeMethod
    public void before() {
        angularPage.shouldBeOpened();
        startDateDatepicker.show();
    }

    @Test
    public void checkLabelValue() {
        startDateDatepicker.label().has().value(CHOOSE_A_DATE);
    }

    @Test
    public void checkStartYearValue() {
        startDateDatepicker.has().startYear(Year.of(1990));
    }

    @Test
    public void checkStartMonthValue() {
        startDateDatepicker.has().startMonth(Month.JANUARY);
    }

    @Test
    public void checkStartDayValue() {
        startDateDatepicker.has().startDay(1);
    }

    @Test
    public void checkStartDayWithLocaleValue() {
        startDateDatepicker.has().startDay(1, Locale.US);
    }
}
