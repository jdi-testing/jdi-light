package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.ios.PickerWheel;
import com.epam.jdi.light.mobile.elements.common.app.ios.Switch;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EditDetailsPage {
    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Details\"]")
    public static NavigationBar detailsNavBar;

    @MobileFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name, 'Date')]")
    public static Switch dateSwitch;

    @MobileFindBy(accessibilityId = "Date")
    public static Button dateButton;

    @MobileFindBy(accessibilityId = "Show year picker")
    public static Button showYearPicker;

    @MobileFindBy(xpath = "//XCUIElementTypeTable[@name=\"ReminderDetail.ID.DetailsTable\"]/XCUIElementTypeCell[4]/XCUIElementTypePicker/XCUIElementTypePickerWheel[2]")
    public static PickerWheel yearPicker;

    @MobileFindBy(xpath = "//XCUIElementTypeTable[@name=\"ReminderDetail.ID.DetailsTable\"]/XCUIElementTypeCell[4]/XCUIElementTypePicker/XCUIElementTypePickerWheel[1]")
    public static PickerWheel monthPicker;

}
