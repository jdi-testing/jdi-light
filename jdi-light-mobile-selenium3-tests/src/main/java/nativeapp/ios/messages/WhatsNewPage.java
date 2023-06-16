package nativeapp.ios.messages;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class WhatsNewPage {

    @MobileFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Continue\"])[1]")
    public static Button continueButton;

}
