package nativeapp.ios.epamiostestapp;

import com.epam.jdi.light.mobile.elements.base.mobileappuielement;
import com.epam.jdi.light.mobile.elements.composite.ios.app.SegmentedControl;
import com.epam.jdi.light.mobile.elements.pageobjects.annotations.MobileFindBy;

public class SegmentedControlPage {

    @MobileFindBy(accessibilityId = "SegmentedControld")
    public static SegmentedControl segmentedControl;

    @MobileFindBy(accessibilityId = "Selected value is: One")
    public static mobileappuielement selectedValueOne;

    @MobileFindBy(accessibilityId = "Selected value is: Two")
    public static mobileappuielement selectedValueTwo;

    @MobileFindBy(accessibilityId = "Selected value is: Three")
    public static mobileappuielement selectedValueThree;

}
