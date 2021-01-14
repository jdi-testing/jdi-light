package nativeapp.ios.settings;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.common.app.ios.MenuItem;
import com.epam.jdi.light.mobile.elements.composite.ios.app.PullDownMenu;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class DisplayAndTextSizePage {

    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"Larger Text\"]")
    public static MenuItem largerTextMenuItem;

    @MobileFindBy(xpath = "//XCUIElementTypeCollectionView")
    public static PullDownMenu settingsPullDownMenu;

    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name=\"Accessibility\"]")
    public static Button backButton;

}
