package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.ios.InfoButton;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class RemindersPage {

    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name=\"New Reminder\"]")
    public Button newReminderButton;

    @MobileFindBy(accessibilityId = "Edit Details")
    public InfoButton editDetailsInfoButton;

}
