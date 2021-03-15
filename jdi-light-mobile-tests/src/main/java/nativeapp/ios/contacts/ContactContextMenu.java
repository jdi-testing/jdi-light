package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.base.MobileAppUIElement;
import com.epam.jdi.light.mobile.elements.composite.ios.app.ContextMenu;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactContextMenu extends ContextMenu {

    @MobileFindBy(accessibilityId = "Contact photo for Daniel Higgins Jr.")
    public static MobileAppUIElement mensPhoto;

    @MobileFindBy(accessibilityId = "Message")
    public static MobileAppUIElement messageOptionExpand;

    @MobileFindBy(accessibilityId = "Mail")
    public static MobileAppUIElement mensMail;

}

