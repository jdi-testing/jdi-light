package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.ios.PickerWheel;
import com.epam.jdi.light.mobile.elements.common.app.ios.Switch;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EditDetailsPage {

    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Details\"]")
    public NavigationBar detailsNavBar;

    @MobileFindBy(xpath = "//XCUIElementTypeSwitch[contains(@name, 'Date')]")
    public Switch dateSwitch;

    @MobileFindBy(accessibilityId = "Date")
    public Button dateButton;

    @MobileFindBy(accessibilityId = "Show year picker")
    public Button showYearPicker;

    @MobileFindBy(xpath = "//XCUIElementTypeTable[@name=\"ReminderDetail.ID.DetailsTable\"]/XCUIElementTypeCell[4]/XCUIElementTypePicker/XCUIElementTypePickerWheel[2]")
    public PickerWheel yearPicker;

    @MobileFindBy(xpath = "//XCUIElementTypeTable[@name=\"ReminderDetail.ID.DetailsTable\"]/XCUIElementTypeCell[4]/XCUIElementTypePicker/XCUIElementTypePickerWheel[1]")
    public PickerWheel monthPicker;

}
