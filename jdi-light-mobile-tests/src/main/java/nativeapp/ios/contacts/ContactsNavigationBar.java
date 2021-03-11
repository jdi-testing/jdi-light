package nativeapp.ios.contacts;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.ios.SystemButton;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContactsNavigationBar extends NavigationBar {

    @MobileFindBy(accessibilityId = "Groups")
    public SystemButton groupsButton;

    @MobileFindBy(accessibilityId = "Add")
    public Button addButton;

}

