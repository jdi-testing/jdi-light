package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.common.app.ios.Slider;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SliderPage {

    @MobileFindBy(accessibilityId = "SliderId")
    public static Slider slider;

}
