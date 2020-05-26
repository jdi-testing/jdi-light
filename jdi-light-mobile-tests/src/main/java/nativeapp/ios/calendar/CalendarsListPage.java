package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.ios.app.Button;
import com.epam.jdi.light.mobile.elements.common.ios.app.DetailsDisclosureButton;
import com.epam.jdi.light.mobile.elements.common.ios.app.SystemButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class CalendarsListPage {

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Calendars\"]")
    public static MobileAppUIElement calendarsNavBar;
    @MobileFindBy(accessibilityId = "Done")
    public static SystemButton doneButton;
    @MobileFindBy(xpath = "(//XCUIElementTypeButton[@name=\"More Info\"])[1]")
    public static DetailsDisclosureButton firstCalendarDetailsButton;
    @MobileFindBy(accessibilityId = "Add Calendar")
    public static Button addCalendarButton;

}
