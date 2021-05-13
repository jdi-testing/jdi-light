package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.common.app.Button;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class AlertDialogPage {

    @MobileFindBy(accessibilityId = "Show Alert")
    public static Button buttonShowAlert;

    @MobileFindBy(xpath = "//XCUIElementTypeAlert[@name=\"Important message\"]")
    public static Button alert;

}
