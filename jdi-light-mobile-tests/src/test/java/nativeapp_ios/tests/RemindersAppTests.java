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
    public void pickerTest() {
        RemindersListPage.todayRemindersButton.tap();

        RemindersPage.newReminderButton.tap();
        RemindersPage.editDetailsInfoButton.openDetails();

        EditDetailsPage.alarm.tap();
        EditDetailsPage.yearPicker.sendKeys("2015");
        EditDetailsPage.yearPicker.is().text("2015");

        EditDetailsPage.yearPicker.movePickerWheel("next", "0.1");
        EditDetailsPage.yearPicker.is().text("2016");
    }
}
