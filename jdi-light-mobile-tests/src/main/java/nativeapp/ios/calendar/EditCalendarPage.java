package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.common.ios.app.SystemButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EditCalendarPage {

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Edit Calendar\"]")
    public static MobileAppUIElement editCalendarNavBar;
    @MobileFindBy(accessibilityId = "Cancel")
    public static SystemButton cancelButton;

}
