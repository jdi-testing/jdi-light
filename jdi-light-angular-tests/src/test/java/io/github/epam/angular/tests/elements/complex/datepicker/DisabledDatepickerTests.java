package io.github.epam.angular.tests.elements.complex.datepicker;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;

import static io.github.com.StaticSite.angularPage;
import static io.github.com.pages.sections.DatepickerSection.*;

public class DisabledDatepickerTests extends TestsDatepickerBase {

    @BeforeMethod(alwaysRun = true)
    public void before() {
        angularPage.open();
        completelyDisabledDatepicker.show();
    }

    @Test
    public void checkLabelValue() {
        String completelyDisabled = "Completely disabled";
        completelyDisabledDatepicker.label().has().value(completelyDisabled);
        String popupDisabled = "Popup disabled";
        popupDisabledDatepicker.label().has().value(popupDisabled);
        String inputDisabled = "Input disabled";
        inputDisabledDatepicker.label().has().value(inputDisabled);
    }

    @Test
    public void checkCompletelyDisabled() {
        completelyDisabledDatepicker.is().disabled();
    }

    @Test
    public void checkToggleDisabled() {
        completelyDisabledDatepicker.has().disabledToggle();
        popupDisabledDatepicker.has().disabledToggle();
    }

    @Test
    public void checkInputDisabled() {
        completelyDisabledDatepicker.has().disabledInput();
        inputDisabledDatepicker.has().disabledInput();
    }

    @Test
    public void checkSetDateToEnabledInput() {
        popupDisabledDatepicker.setDate(LocalDate.of(2030, 1, 19));
        popupDisabledDatepicker.is().date("1/19/2030");
    }

    @Test
    public void checkSelectDateByEnabledToggle() {
        inputDisabledDatepicker.select(LocalDate.of(2029, 2, 28));
        inputDisabledDatepicker.is().selectedDate(LocalDate.of(2029, 2, 28));
    }

    @AfterMethod(alwaysRun = true)
    public void after() {
        if (completelyDisabledDatepicker.isExpanded()) {
            completelyDisabledDatepicker.collapse();
        }
        if (!completelyDisabledDatepicker.isEmpty()) {
            completelyDisabledDatepicker.clear();
        }
    }
}
