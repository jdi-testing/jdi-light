package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.*;

public class SelectedValueDatepickerTests extends TestsDatepickerBase {
    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.shouldBeOpened();
        selectedDatepicker.show();
        selectedDatepicker.clear();
    }

    @Test
    public void checkLabelValue() {
        String angularForms = "Angular forms";
        selectedDatepicker.label().has().value(angularForms);
        String angularFormsDeserialization = "Angular forms (w/ deserialization)";
        deserializeDatepicker.label().has().value(angularFormsDeserialization);
        String valueBinding = "Value binding";
        bindingDatepicker.label().has().value(valueBinding);
    }

    @Test
    public void checkValid() {
        selectedDatepicker.is().valid();
    }

    @Test
    public void checkTodayDayBindingValue() {
        bindingDatepicker.clear();
        selectedDatepicker.has().todayDay(LocalDate.now().getDayOfMonth());
        bindingDatepicker.has().todayDay(LocalDate.now().getDayOfMonth());
    }

    @Test
    public void checkEmptyDateBindingValue() {
        bindingDatepicker.has().value("");
    }

    @Test
    public void checkInputDateBinding() {
        selectedDatepicker.input("7/28/2014");
        bindingDatepicker.is().date("7/28/2014");
    }

    @Test
    public void checkSelectedDateBinding() {
        selectedDatepicker.setDate(LocalDate.of(1988, 1, 12));
        bindingDatepicker.is().selectedDate(LocalDate.of(1988, 1, 12));
    }

    @Test
    public void checkInputMonthDayYearBinding() {
        selectedDatepicker.input("2/15/1997");
        bindingDatepicker.is().month(Month.FEBRUARY).day(15).year(Year.of(1997));
    }

    @Test
    public void checkSelectDateBinding() {
        selectedDatepicker.select(LocalDate.of(2017, 12, 24));
        bindingDatepicker.is().text("12/24/2017");
    }

    @Test
    public void checkHasNoReverseBinding() {
        bindingDatepicker.select("1/1/2020");
        selectedDatepicker.is().value("");
    }

    @Test
    public void checkSetInvalidAdditionalTextValue() {
        deserializeDatepicker.setText("day");
        deserializeDatepicker.is().invalid();
    }

    @Test
    public void checkSetInvalidTextValue() {
        deserializeDatepicker.clear();
        deserializeDatepicker.setText("year");
        deserializeDatepicker.is().invalid();
    }

    @Test
    public void checkInputInvalidDateValue() {
        deserializeDatepicker.clear();
        deserializeDatepicker.input("13/1/2020");
        deserializeDatepicker.is().invalid();
    }

    @Test
    public void checkSetInvalidDateValue() {
        deserializeDatepicker.clear();
        deserializeDatepicker.setText("2020-13-02");
        deserializeDatepicker.is().invalid();
    }
}
