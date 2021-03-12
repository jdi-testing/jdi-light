package nativeapp.ios.settings;

import com.epam.jdi.light.mobile.elements.common.app.ios.MenuItem;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AccessibilityPage {

    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"Display & Text Size\"]")
    public static MenuItem displayAndTextSizeMenuItem;

}
