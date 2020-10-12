package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.openMethodDatepicker;

public class OpenMethodDatepickerTests extends TestsDatepickerBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.open();
        openMethodDatepicker.show();
    }

    @Test
    public void checkPlaceholderValue() {
        openMethodDatepicker.has().placeholder(CHOOSE_A_DATE);
    }

    @Test
    public void checkExpanded() {
        openMethodDatepicker.expand();
        openMethodDatepicker.is().expanded();
    }

    @Test
    public void checkCollapsed() {
        openMethodDatepicker.collapse();
        openMethodDatepicker.is().collapsed();
    }

    @Test
    public void checkSelectedDate() {
        openMethodDatepicker.setDate(LocalDate.of(1997, 3, 10));
        openMethodDatepicker.is().selectedDate(LocalDate.of(1997, 3, 10));
    }

    @Test
    public void checkSelectDate() {
        openMethodDatepicker.select(LocalDate.of(2017, 7, 2));
        openMethodDatepicker.is().text("7/2/2017");
    }
}
