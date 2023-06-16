package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.common.Text;
import com.epam.jdi.light.mobile.elements.composite.ios.app.SegmentedControl;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class InboxPage {

    @MobileFindBy(xpath = "//XCUIElementTypeSegmentedControl")
    public static SegmentedControl eventTypesSegmentedControl;

    @MobileFindBy(xpath = "//XCUIElementTypeTable/XCUIElementTypeStaticText")
    public static Text eventsInfoText;

}
