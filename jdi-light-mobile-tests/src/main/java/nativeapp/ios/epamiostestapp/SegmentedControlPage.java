package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.composite.ios.app.SegmentedControl;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SegmentedControlPage {

    @MobileFindBy(accessibilityId = "SegmentedControld")
    public static SegmentedControl segmentedControl;

}
