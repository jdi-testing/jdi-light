package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.SegmentedControlPage.segmentedControl;

public class SegmentedContolTest extends IosApplicationInit {
    @Test
    public void SegmentedControlTest() {
        menuSegmentedControl.tap();

        segmentedControl.tapSegment("Two");
        segmentedControl.is().selected("Two");

        segmentedControl.tapSegment("Three");
        segmentedControl.is().selected("Three");

        segmentedControl.tapSegment("One");
        segmentedControl.is().selected("One");
    }

}
