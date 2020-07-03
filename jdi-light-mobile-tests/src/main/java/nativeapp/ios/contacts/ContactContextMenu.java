package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.composite.ios.app.ContextMenu;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactContextMenu extends ContextMenu {
    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name='Contact photo for John Appleseed']/XCUIElementTypeImage")
    public static MobileAppUIElement johnApplessedPhoto;
    @MobileFindBy(xpath = "//*[contains(@name, 'Message')]/../*[@name='Expand']")
    public static MobileAppUIElement messageOptionExpand;
    @MobileFindBy(xpath = ".//*[contains(@name, 'John-Appleseed@mac.com')]")
    public static MobileAppUIElement johnAppleseedEmail;
}
