package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.base.mobileappuielement;
import com.epam.jdi.light.mobile.elements.composite.ios.app.ContextMenu;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactContextMenu extends ContextMenu {

    @MobileFindBy(accessibilityId = "Contact photo for Daniel Higgins Jr.")
    public static mobileappuielement mensPhoto;

    @MobileFindBy(accessibilityId = "Message")
    public static mobileappuielement messageOptionExpand;

    @MobileFindBy(accessibilityId = "Mail")
    public static mobileappuielement mensMail;

}

