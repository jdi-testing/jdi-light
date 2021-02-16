package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class RemindersListPage {

    @MobileFindBy(xpath = "//XCUIElementTypeButton[contains(@name, 'Today')]")
    public Button todayRemindersButton;

}
