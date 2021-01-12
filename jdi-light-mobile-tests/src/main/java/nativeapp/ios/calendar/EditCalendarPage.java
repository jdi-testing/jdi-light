package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.common.app.ios.SystemButton;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EditCalendarPage {

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Edit Calendar\"]")
    public static NavigationBar editCalendarNavBar;

    @MobileFindBy(accessibilityId = "Cancel")
    public static SystemButton cancelButton;

}
