package nativeapp.ios.calendar;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class WelcomePage {

    @MobileFindBy(xpath = "//XCUIElementTypeButton[@name=\"Continue\"]")
    public static Button continueButton;

}
