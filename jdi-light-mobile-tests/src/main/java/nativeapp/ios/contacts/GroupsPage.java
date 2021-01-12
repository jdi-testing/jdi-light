package nativeapp.ios.contacts;

import com.epam.jdi.light.elements.pageobjects.annotations.FindBy;
import com.epam.jdi.light.mobile.elements.common.app.ios.SystemButton;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;

public class GroupsPage {

    @FindBy(xpath = "//XCUIElementTypeNavigationBar[@name='Groups']")
    public static NavigationBar groupsBar;

    @FindBy(name = "Done")
    public static SystemButton doneButton;

}
