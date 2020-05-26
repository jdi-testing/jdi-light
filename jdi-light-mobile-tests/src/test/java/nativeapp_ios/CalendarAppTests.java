package nativeapp_ios;

import nativeapp.ios.calendar.*;
import org.testng.annotations.Test;

public class CalendarAppTests extends CalendarAppTestsInit {

    @Test
    public void detailDisclosureButtonTest() {
        if(WelcomePage.continueButton.isDisplayed())
            WelcomePage.continueButton.tap();

        CalendarPage.calendarsButton.tap();
        CalendarsListPage.calendarsNavBar.is().visible();

        CalendarsListPage.firstCalendarDetailsButton.openDetails();
        EditCalendarPage.editCalendarNavBar.is().visible();

        EditCalendarPage.cancelButton.cancel();
        CalendarsListPage.calendarsNavBar.is().visible();

        CalendarsListPage.doneButton.done();
    }

    @Test
    public void buttonTest() {
        if(WelcomePage.continueButton.isDisplayed())
            WelcomePage.continueButton.tap();

        CalendarPage.calendarsButton.has().text("Calendars");
        CalendarPage.calendarsButton.tap();
        CalendarsListPage.calendarsNavBar.is().visible();

        CalendarsListPage.addCalendarButton.has().text("Add Calendar");
        CalendarsListPage.addCalendarButton.tap();

        AddCalendarPage.cancelButton.cancel();
    }
}
