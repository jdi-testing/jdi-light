package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static io.github.com.pages.sections.DatepickerSection.momentJsDatepicker;

public class MomentJsDatepickerTests extends TestsDatepickerBase {
    private final String momentDatepicker = "Moment.js datepicker";

    @BeforeMethod(alwaysRun = true)
    public void before() {
        momentJsDatepicker.show();
        momentJsDatepicker.clear();
    }

    @Test
    public void checkLabelValue() {
        momentJsDatepicker.label().has().value(momentDatepicker);
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

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (momentJsDatepicker.isExpanded()) {
            momentJsDatepicker.collapse();
        }
        if (!momentJsDatepicker.isEmpty()) {
            momentJsDatepicker.clear();
        }
    }
}
