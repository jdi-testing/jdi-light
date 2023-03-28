package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.common.app.ios.TextField;
import com.epam.jdi.light.mobile.elements.composite.ios.app.EditMenu;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class TextFieldPage {

    @MobileFindBy(xpath = "//XCUIElementTypeTextField")
    public static TextField textField;

    public static EditMenu editMenu;

}
