package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Locale;

import static com.epam.jdi.light.angular.entities.DatepickerNavigation.*;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.basicDatepicker;

public class BasicDatepickerTests extends TestsDatepickerBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.open();
        basicDatepicker.show();
    }

    @Test
    public void checkDisplayed() {
        basicDatepicker.is().displayed();
    }

    @Test
    public void checkExpanded() {
        basicDatepicker.expand();
        basicDatepicker.is().expanded();
    }

    @Test
    public void checkEnabled() {
        basicDatepicker.is().enabled();
    }

    @Test
    public void checkEnabledToggle() {
        basicDatepicker.has().enabledToggle();
    }

    @Test
    public void checkEnabledInput() {
        basicDatepicker.has().enabledInput();
    }

    @Test
    public void checkCollapsed() {
        basicDatepicker.collapse();
        basicDatepicker.is().collapsed();
    }

    @Test
    public void checkFocus() {
        basicDatepicker.focus();
        basicDatepicker.is().focused();
    }

    @Test
    public void checkBasicLocale() {
        basicDatepicker.show();
        basicDatepicker.has().locale(Locale.US);
    }

    @Test
    public void checkLabelValue() {
        basicDatepicker.label().has().value(CHOOSE_A_DATE);
    }

    @Test
    public void checkTodayDayValue() {
        basicDatepicker.has().todayDay(LocalDate.now().getDayOfMonth());
    }

    @Test
    public void checkSelectDayValue() {
        basicDatepicker.clear();
        LocalDate now = LocalDate.now();
        basicDatepicker.selectDay(now.getDayOfMonth());
        basicDatepicker.has().day(now.getDayOfMonth()).month(now.getMonth()).year(Year.of(now.getYear()));
    }

    @Test
    public void checkEmptyDateValue() {
        basicDatepicker.has().value("");
    }

    @Test
    public void checkSendKeysDate() {
        basicDatepicker.sendKeys("11/25/2012");
        basicDatepicker.is().date("11/25/2012");
    }

    @Test
    public void checkSelectedDate() {
        basicDatepicker.setDate(LocalDate.of(1990, 11, 16));
        basicDatepicker.is().selectedDate(LocalDate.of(1990, 11, 16));
    }

    @Test
    public void checkInputMonthDayYear() {
        basicDatepicker.input("20-nov-2014");
        basicDatepicker.is().month(Month.NOVEMBER).day(20).year(Year.of(2014));
    }

    @Test
    public void checkSelectedMonthDayYear() {
        basicDatepicker.setText("04-OCTOBER-2000");
        basicDatepicker.is().selectedMonth(Month.OCTOBER).selectedDay(4).selectedYear(Year.of(2000));
    }

    @Test
    public void checkSelectDayInPreviousMonth() {
        int currentMonth = LocalDate.now().getMonth().getValue();
        int previousMonth = currentMonth == 1 ? 12 : currentMonth - 1;
        basicDatepicker.selectDayInPreviousMonth(1);
        basicDatepicker.has().selectedMonth(Month.of(previousMonth));
    }

    @Test
    public void checkSelectDayInNextMonth() {
        int currentMonth = LocalDate.now().getMonth().getValue();
        int nextMonth = currentMonth == 12 ? 1 : currentMonth + 1;
        basicDatepicker.selectDayInNextMonth(2);
        basicDatepicker.has().selectedMonth(Month.of(nextMonth));
    }

    @Test
    public void checkSelectDate() {
        basicDatepicker.select(LocalDate.of(2019, 12, 21));
        basicDatepicker.is().text("12/21/2019");
    }

    @Test
    public void checkSelectStringDate() {
        basicDatepicker.select("11/25/2020");
        basicDatepicker.is().value("11/25/2020");
    }

    @Test
    public void checkNavigateToDayInPreviousMonths() {
        int currentMonth = LocalDate.now().getMonth().getValue();
        int monthCountEarlier = 4;
        int monthCount = monthCountEarlier % 12;
        int previousMonth = monthCount == 0 ?
                currentMonth :
                (currentMonth - monthCount) == 0 ? 12 : currentMonth - monthCount;
        basicDatepicker.navigateToDayInPreviousMonths(monthCountEarlier, 12);
        basicDatepicker.has().selectedMonth(Month.of(previousMonth));
    }

    @Test
    public void checkNavigateToDayInNextMonths() {
        int currentMonth = LocalDate.now().getMonth().getValue();
        int monthCountLater = 5;
        int monthCount = monthCountLater % 12;
        int nextMonth = monthCount == 0 ?
                currentMonth :
                (currentMonth + monthCount) > 12 ? (currentMonth + monthCount) - 12 : currentMonth + monthCount;
        basicDatepicker.navigateToDayInNextMonths(monthCountLater, 12);
        basicDatepicker.has().selectedMonth(Month.of(nextMonth));
    }

    @Test
    public void checkEnabledMonthsAndYearsNavigation() {
        String firstEnabledYearCell = String.format(CELL.getName(), 2016);
        String lastEnabledYearCell = String.format(CELL.getName(), 2039);
        basicDatepicker.setDate(LocalDate.of(2020, 1, 1));
        basicDatepicker.openYearsView();
        basicDatepicker.has()
                .enabledNavigation(PREVIOUS_TWENTY_YEARS.getName(), NEXT_TWENTY_YEARS.getName(), firstEnabledYearCell,
                                   lastEnabledYearCell);
    }
}
