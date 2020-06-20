package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EditDetailsPage {
    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Details\"]")
    public static MobileAppUIElement detailsNavBar;
}
