package nativeapp_ios.tests;

import nativeapp.ios.calendar.AddCalendarPage;
import nativeapp.ios.calendar.CalendarPage;
import nativeapp.ios.calendar.CalendarsListPage;
import nativeapp.ios.calendar.EditCalendarPage;
import nativeapp_ios.CalendarAppTestsInit;
import org.testng.annotations.Test;

public class CalendarAppTests extends CalendarAppTestsInit {

    @Test
    public void detailDisclosureButtonTest() {
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
        CalendarPage.calendarsButton.has().text("Calendars");
        CalendarPage.calendarsButton.tap();
        CalendarsListPage.calendarsNavBar.is().visible();

        CalendarsListPage.addCalendarButton.has().text("Add Calendar");
        CalendarsListPage.addCalendarButton.tap();

        AddCalendarPage.cancelButton.cancel();
    }
}
