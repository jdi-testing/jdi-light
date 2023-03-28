package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.JApp;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

@JApp(app = "com.apple.reminders")
public class RemindersApp {

    public static RemindersListPage remindersListPage;

    public static RemindersPage remindersPage;

    public static EditDetailsPage editDetailsPage;

    @MobileFindBy(accessibilityId = "Continue")
    public static Button continueButton;

}
