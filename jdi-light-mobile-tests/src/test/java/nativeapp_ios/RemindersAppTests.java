package nativeapp_ios;

import nativeapp.ios.reminders.EditDetailsPage;
import nativeapp.ios.reminders.RemindersApp;
import nativeapp.ios.reminders.RemindersListPage;
import nativeapp.ios.reminders.RemindersPage;
import org.testng.annotations.Test;

public class RemindersAppTests extends RemindersAppTestsInit {

    @Test
    public void infoButtonTest() {
        if (RemindersApp.continueButton.isDisplayed())
            RemindersApp.continueButton.click();

        RemindersListPage.todayRemindersButton.tap();

        RemindersPage.newReminderButton.tap();
        RemindersPage.editDetailsInfoButton.openDetails();

        EditDetailsPage.detailsNavBar.is().displayed();
    }
}
