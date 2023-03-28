package nativeapp.ios.settings;

import com.epam.jdi.light.mobile.elements.common.app.ios.Slider;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class LargerTextPage {

    @MobileFindBy(xpath = "//XCUIElementTypeSlider")
    public static Slider largerTextSlider;

}
