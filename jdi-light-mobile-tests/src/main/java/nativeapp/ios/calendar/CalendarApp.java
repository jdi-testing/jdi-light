package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;

@JApp(app = "com.apple.mobilecal")
public class CalendarApp {

    public static WelcomePage welcomePage;

    public static CalendarPage calendarPage;

    public static CalendarsListPage calendarsListPage;

    public static EditCalendarPage editCalendarPage;

    public static AddCalendarPage addCalendarPage;

    public static InboxPage inboxPage;

}
