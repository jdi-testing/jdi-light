package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.eclipse.core.runtime.Assert;
import org.testng.annotations.Test;

import static nativeapp.ios.epamiostestapp.MainPage.menuSegmentedControl;
import static nativeapp.ios.epamiostestapp.SegmentedControlPage.*;

public class SegmentedControlTest extends IosApplicationInit {

    @Test
    public void segmentedControlJdiAssertTest() {
        menuSegmentedControl.tap();

        segmentedControl.tapSegment("Two");
        segmentedControl.is().selected("Two");

        segmentedControl.tapSegment("Three");
        segmentedControl.is().selected("Three");

        segmentedControl.tapSegment("One");
        segmentedControl.is().selected("One");
    }

    @Test
    public void segmentedControlAssertTest() {
        menuSegmentedControl.tap();

        segmentedControl.tapSegment("Two");
        Assert.isTrue(selectedValueTwo.isDisplayed());

        segmentedControl.tapSegment("Three");
        Assert.isTrue(selectedValueThree.isDisplayed());

        segmentedControl.tapSegment("One");
        Assert.isTrue(selectedValueOne.isDisplayed());
    }
}
