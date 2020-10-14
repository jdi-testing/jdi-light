package io.github.epam.angular.tests.elements.complexgroups.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.touchUiDatepicker;

public class TuchUiDatepickerTests extends TestsDatepickerBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.open();
        touchUiDatepicker.show();
    }

    @Test
    public void checkLabelValue() {
        touchUiDatepicker.label().has().value(CHOOSE_A_DATE);
    }

    @Test
    public void checkTodayDayValue() {
        touchUiDatepicker.has().todayDay(LocalDate.now().getDayOfMonth());
    }

    @Test
    public void checkSendKeysDate() {
        touchUiDatepicker.sendKeys("11/25/2012");
        touchUiDatepicker.is().date("11/25/2012");
    }

    @Test
    public void checkSelectedDate() {
        touchUiDatepicker.setDate(LocalDate.of(1990, 11, 16));
        touchUiDatepicker.is().selectedDate(LocalDate.of(1990, 11, 16));
    }

    @Test
    public void checkInputMonthDayYear() {
        touchUiDatepicker.input("20-nov-2014");
        touchUiDatepicker.is().month(Month.NOVEMBER).day(20).year(Year.of(2014));
    }

    @Test
    public void checkSelectDate() {
        touchUiDatepicker.select(LocalDate.of(2019, 12, 21));
        touchUiDatepicker.is().text("12/21/2019");
    }

    @Test
    public void checkSelectStringDate() {
        touchUiDatepicker.select("11/25/2020");
        touchUiDatepicker.is().value("11/25/2020");
    }
}
