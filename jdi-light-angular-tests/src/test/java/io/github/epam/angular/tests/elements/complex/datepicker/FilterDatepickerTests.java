package io.github.epam.angular.tests.elements.complex.datepicker;

import com.epam.jdi.light.angular.entities.DatepickerNavigation;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.filterDatepicker;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class FilterDatepickerTests extends TestsDatepickerBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.shouldBeOpened();
        filterDatepicker.show();
    }

    @Test
    public void checkLabelValue() {
        filterDatepicker.label().has().value(CHOOSE_A_DATE);
    }

    @Test
    public void checkTodayDayValue() {
        filterDatepicker.has().todayDay(LocalDate.now().getDayOfMonth());
    }

    @Test
    public void checkEmptyDateValue() {
        filterDatepicker.clear();
        filterDatepicker.has().value("");
    }

    @Test
    public void checkDisabledSaturdays() {
        filterDatepicker.has().disabledNavigation(filterDatepicker.getWeekDayNumbers(DatepickerNavigation.SATURDAY));
    }

    @Test
    public void checkDisabledSundays() {
        filterDatepicker.has().disabledNavigation(filterDatepicker.getWeekDayNumbers(DatepickerNavigation.SUNDAY));
    }

    @Test
    public void checkEnabledMondays() {
        filterDatepicker.has().enabledNavigation(filterDatepicker.getWeekDayNumbers(DatepickerNavigation.MONDAY));
    }

    @Test
    public void checkEnabledWednesdays() {
        filterDatepicker.has().enabledNavigation(filterDatepicker.getWeekDayNumbers(DatepickerNavigation.WEDNESDAY));
    }
}
