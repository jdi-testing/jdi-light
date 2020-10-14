package io.github.epam.angular.tests.elements.complexgroups.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.customFormatsDatepicker;

public class CustomFormatsDatepickerTests extends TestsDatepickerBase {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.open();
        customFormatsDatepicker.show();
        customFormatsDatepicker.clear();
    }

    @Test
    public void checkLabelValue() {
        String verboseDatepicker = "Verbose datepicker";
        customFormatsDatepicker.label().has().value(verboseDatepicker);
    }

    @Test
    public void checkInputDate() {
        customFormatsDatepicker.input("MAR-10-1997");
        customFormatsDatepicker.is().selectedDate(LocalDate.of(1997, 3, 10));
    }

    @Test
    public void checkSetTextDate() {
        customFormatsDatepicker.setText("January-31-2007");
        customFormatsDatepicker.is().date("January 31, 2007");
    }

    @Test
    public void checkSendKeysDate() {
        customFormatsDatepicker.sendKeys("November 03, 2008");
        customFormatsDatepicker.is().selectedDate(LocalDate.of(2008, 11, 3));
    }

    @Test
    public void checkSelectDate() {
        customFormatsDatepicker.select(LocalDate.of(2017, 7, 2));
        customFormatsDatepicker.is().text("July 2, 2017");
    }
}
