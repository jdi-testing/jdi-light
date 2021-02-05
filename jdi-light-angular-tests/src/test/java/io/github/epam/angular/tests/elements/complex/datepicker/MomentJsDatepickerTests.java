package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static com.epam.jdi.light.elements.composite.WebPage.refresh;
import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.momentJsDatepicker;
import static io.github.epam.site.steps.States.shouldBeLoggedIn;

public class MomentJsDatepickerTests extends TestsDatepickerBase {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.shouldBeOpened();
        momentJsDatepicker.show();
        momentJsDatepicker.clear();
    }

    @Test
    public void checkLabelValue() {
        String momentDatepicker = "Moment.js datepicker";
        momentJsDatepicker.label().has().value(momentDatepicker);
    }

    @Test
    public void checkMomentDate() {
        refresh();
        momentJsDatepicker.is().selectedDate(LocalDate.of(2017, 1, 1));
    }

    @Test
    public void checkInputDate() {
        momentJsDatepicker.input("5/10/1996");
        momentJsDatepicker.is().selectedDate(LocalDate.of(1996, 5, 10));
    }

    @Test
    public void checkSetTextDate() {
        momentJsDatepicker.setText("4/14/2009");
        momentJsDatepicker.is().date("4/14/2009");
    }

    @Test
    public void checkSelectValidDate() {
        momentJsDatepicker.select("1/31/2007");
        momentJsDatepicker.is().valid();
    }

    @Test
    public void checkSetInvalidDate() {
        momentJsDatepicker.input("January-31-2007");
        momentJsDatepicker.is().invalid();
    }

    @Test
    public void checkSendKeysDate() {
        momentJsDatepicker.sendKeys("11/03/2008");
        momentJsDatepicker.is().selectedDate(LocalDate.of(2008, 11, 3));
    }
}
