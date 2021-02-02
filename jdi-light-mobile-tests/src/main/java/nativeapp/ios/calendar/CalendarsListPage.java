package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.ios.DetailsDisclosureButton;
import com.epam.jdi.light.mobile.elements.common.app.ios.SystemButton;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class CalendarsListPage {

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Calendars\"]")
    public static NavigationBar calendarsNavBar;

    @MobileFindBy(accessibilityId = "Done")
    public static SystemButton doneButton;

    @MobileFindBy(xpath = "(//XCUIElementTypeButton[@name=\"More Info\"])[1]")
    public static DetailsDisclosureButton firstCalendarDetailsButton;

    @MobileFindBy(accessibilityId = "Add Calendar")
    public static Button addCalendarButton;

}
