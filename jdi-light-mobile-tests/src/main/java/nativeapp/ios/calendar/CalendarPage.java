package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.ios.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class CalendarPage {

    @MobileFindBy(accessibilityId = "DayViewContainerView")
    public static MobileAppUIElement dayViewNavBar;
    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name='Calendars']")
    public static Button calendarsButton;
}
