package nativeapp_ios.tests;

import nativeapp.ios.calendar.AddCalendarPage;
import nativeapp.ios.calendar.CalendarPage;
import nativeapp.ios.calendar.CalendarsListPage;
import nativeapp.ios.calendar.EditCalendarPage;
import nativeapp.ios.calendar.InboxPage;
import nativeapp_ios.CalendarAppTestsInit;
import org.testng.annotations.Test;

import java.util.Arrays;

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

    @Test
    public void segmentedControlTest() {
        CalendarPage.inboxButton.tap();

        InboxPage.eventTypesSegmentedControl.has().values(Arrays.asList("New", "Replied"));

        InboxPage.eventTypesSegmentedControl.tapSegment("Replied");
        InboxPage.eventTypesSegmentedControl.is().selected("Replied");
        InboxPage.eventsInfoText.is().text("No Events You’ve Replied To");
    }
}
