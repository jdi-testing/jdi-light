package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.composite.ios.app.ContextMenu;
import com.epam.jdi.light.mobile.elements.composite.ios.app.TabBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ContextMenuPage {

    @MobileFindBy(accessibilityId = "Long press to open the menu")
    public static ContextMenu contextMenu;

    @MobileFindBy(xpath = "//XCUIElementTypeApplication[@name=\"EpamIOSTestAPP\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeCollectionView")
    public static TabBar popUpMenu;
}
