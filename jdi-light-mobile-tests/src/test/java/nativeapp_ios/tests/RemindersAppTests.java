package nativeapp_ios.tests;

import nativeapp_ios.RemindersAppTestsInit;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;

import static nativeapp.ios.reminders.RemindersApp.editDetailsPage;
import static nativeapp.ios.reminders.RemindersApp.remindersListPage;
import static nativeapp.ios.reminders.RemindersApp.remindersPage;

public class RemindersAppTests extends RemindersAppTestsInit {

    @Test
    public void switchTest() {
        remindersListPage.todayRemindersButton.tap();

        remindersPage.newReminderButton.tap();
        remindersPage.editDetailsInfoButton.openDetails();

        editDetailsPage.dateSwitch.setToOff();
        editDetailsPage.dateSwitch.is().off();
        editDetailsPage.dateSwitch.setToOn();
        editDetailsPage.dateSwitch.is().on();
    }

    @Test
    public void infoButtonTest() {
        remindersListPage.todayRemindersButton.tap();

        remindersPage.newReminderButton.tap();
        remindersPage.editDetailsInfoButton.openDetails();

        editDetailsPage.detailsNavBar.is().displayed();
    }

    @Test
    public void pickerWheelTest() {
        remindersListPage.todayRemindersButton.tap();

        remindersPage.newReminderButton.tap();
        remindersPage.editDetailsInfoButton.openDetails();

        editDetailsPage.dateButton.tap();
        editDetailsPage.showYearPicker.tap();

        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        Month month = localDate.getMonth();

        editDetailsPage.yearPicker.movePickerWheelForward("0.1");
        editDetailsPage.yearPicker.is().text(String.valueOf(year + 1));
        editDetailsPage.yearPicker.movePickerWheelBackward("0.1");
        editDetailsPage.yearPicker.is().text(String.valueOf(year));

        editDetailsPage.monthPicker.movePickerWheelBackward("0.1");
        editDetailsPage.monthPicker.is().text(onlyFirstLetterToUpperCase(month.minus(1)));
        editDetailsPage.monthPicker.movePickerWheelForward("0.1");
        editDetailsPage.monthPicker.is().text(onlyFirstLetterToUpperCase(month));
    }

    private String onlyFirstLetterToUpperCase(Month month) {
        return month.toString().substring(0, 1).toUpperCase() + month.toString().substring(1).toLowerCase();
    }
}
