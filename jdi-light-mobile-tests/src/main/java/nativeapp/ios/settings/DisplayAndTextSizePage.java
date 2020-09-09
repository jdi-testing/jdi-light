package nativeapp.ios.settings;

import com.epam.jdi.light.mobile.elements.common.app.ios.MenuItem;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class DisplayAndTextSizePage {
    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"Larger Text\"]")
    public static MenuItem largerTextMenuItem;
}
