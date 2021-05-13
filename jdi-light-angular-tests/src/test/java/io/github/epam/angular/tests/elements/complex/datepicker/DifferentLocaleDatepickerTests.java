package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Locale;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.differentLocaleDatepicker;

public class DifferentLocaleDatepickerTests extends TestsDatepickerBase {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.shouldBeOpened();
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.clear();
    }

    @Test
    public void checkLabelValue() {
        String differentLocale = "Different locale";
        differentLocaleDatepicker.label().has().value(differentLocale);
    }

    @Test
    public void checkInputDate() {
        refresh();
        differentLocaleDatepicker.input("2002/12/13");
        differentLocaleDatepicker.is().selectedDate(LocalDate.of(2002, 12, 13), Locale.JAPAN);
    }

    @Test
    public void checkSetTextDate() {
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.setText("31/2/2012");
        differentLocaleDatepicker.is().date("31/2/2012");
    }

    @Test
    public void checkSendKeysDate() {
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.sendKeys("06/10/2009");
        differentLocaleDatepicker.is().selectedDate(LocalDate.of(2009, 10, 6), Locale.FRANCE);
    }

    @Test
    public void checkSelectedDate() {
        refresh();
        differentLocaleDatepicker.select("09/16/2009", Locale.JAPAN);
        differentLocaleDatepicker.is().selectedDate(LocalDate.of(2009, 9, 16), Locale.JAPAN);
    }

    @Test
    public void checkSelectStringDate() {
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.select("02/07/2015", Locale.FRANCE);
        differentLocaleDatepicker.is().text("7/2/2015");
    }

    @Test
    public void checkSelectDate() {
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.select(LocalDate.of(2016, 7, 2), Locale.FRANCE);
        differentLocaleDatepicker.is().value("2/7/2016");
    }

    @Test
    public void checkStartDayValue() {
        differentLocaleDatepicker.has().todayDay(LocalDate.now().getDayOfMonth());
    }

    @Test
    public void checkDifferentLocale() {
        refresh();
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.has().locale(Locale.JAPAN);

    }

    @Test
    public void checkSwitchLocale() {
        differentLocaleDatepicker.show();
        differentLocaleDatepicker.switchLocale();
        differentLocaleDatepicker.has().locale(Locale.FRANCE);
    }
}
