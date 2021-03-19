package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.common.app.ios.SystemButton;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AddNewContactPage {

    @MobileFindBy(accessibilityId = "Cancel")
    public static SystemButton cancelButton;

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"New Contact\"]")
    public static NavigationBar newContactNavBar;

}
