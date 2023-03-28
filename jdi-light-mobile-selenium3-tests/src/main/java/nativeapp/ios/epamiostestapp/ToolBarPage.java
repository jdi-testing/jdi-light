package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.base.MobileUIElement;
import com.epam.jdi.light.mobile.elements.composite.ios.app.ToolBar;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ToolBarPage {

    @MobileFindBy(accessibilityId = "Toolbar")
    public static ToolBar toolBar;

    @MobileFindBy(xpath = "//XCUIElementTypeCell[@name=\"New string generated\"]")
    public static MobileUIElement listOfStrings;

}
