package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.common.app.ios.Switch;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class ToggleSwitchPage {

    @MobileFindBy(accessibilityId = "ToggleId")
    public static Switch switchButton;

}
