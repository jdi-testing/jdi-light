package nativeapp_ios.tests;

import nativeapp.ios.reminders.EditDetailsPage;
import nativeapp.ios.reminders.RemindersListPage;
import nativeapp.ios.reminders.RemindersPage;
import nativeapp_ios.RemindersAppTestsInit;
import org.testng.annotations.Test;

public class RemindersAppTests extends RemindersAppTestsInit {

    @Test
    public void infoButtonTest() {
        RemindersListPage.todayRemindersButton.tap();

        RemindersPage.newReminderButton.tap();
        RemindersPage.editDetailsInfoButton.openDetails();

        EditDetailsPage.detailsNavBar.is().displayed();
    }

    @Test
    public void switchTest() {
        RemindersListPage.todayRemindersButton.tap();

        RemindersPage.newReminderButton.tap();
        RemindersPage.editDetailsInfoButton.openDetails();

        EditDetailsPage.remindSwitch.setToOff();
        EditDetailsPage.remindSwitch.is().off();
        EditDetailsPage.remindSwitch.setToOn();
        EditDetailsPage.remindSwitch.is().on();
    }

    @Test
    public void pickerWheelTest() {
        RemindersListPage.todayRemindersButton.tap();

        RemindersPage.newReminderButton.tap();
        RemindersPage.editDetailsInfoButton.openDetails();

        EditDetailsPage.alarmMenuItem.tap();
        EditDetailsPage.yearPicker.setPickerWheelValue("2015");
        EditDetailsPage.yearPicker.is().text("2015");

        EditDetailsPage.yearPicker.movePickerWheelForward("0.1");
        EditDetailsPage.yearPicker.is().text("2016");

        EditDetailsPage.monthPicker.setPickerWheelValue("April");
        EditDetailsPage.monthPicker.movePickerWheelBackward("0.1");
        EditDetailsPage.monthPicker.is().text("March");
    }
}
