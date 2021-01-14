package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class CalendarPage {

    @MobileFindBy(accessibilityId = "DayViewContainerView")
    public static NavigationBar dayViewNavBar;

    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name='Calendars']")
    public static Button calendarsButton;

    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name='Inbox']")
    public static Button inboxButton;

}
