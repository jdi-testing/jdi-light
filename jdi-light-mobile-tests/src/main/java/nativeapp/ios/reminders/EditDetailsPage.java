package nativeapp.ios.reminders;

import com.epam.jdi.light.mobile.elements.common.ios.app.MenuItem;
import com.epam.jdi.light.mobile.elements.common.ios.app.PickerWheel;
import com.epam.jdi.light.mobile.elements.composite.ios.app.NavigationBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class EditDetailsPage {
    @MobileFindBy(xpath = "//XCUIElementTypeNavigationBar[@name=\"Details\"]")
    public static NavigationBar detailsNavBar;

    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"Alarm\"]")
    public static MenuItem alarm;

    @MobileFindBy(xpath = "//XCUIElementTypePickerWheel[3]")
    public static PickerWheel yearPicker;

    @MobileFindBy(xpath = "//XCUIElementTypePickerWheel[1]")
    public static PickerWheel monthPicker;
}
