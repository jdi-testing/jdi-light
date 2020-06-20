package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.common.ios.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class RemindersListPage {
    @MobileFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Today')]")
    public static Button todayRemindersButton;
}
