package epamiostestapp.tests;

import epamiostestapp.IosApplicationInit;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
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
        jdiAssert(selectedValueTwo.isDisplayed(), Matchers.is(true));

        segmentedControl.tapSegment("Three");
        jdiAssert(selectedValueThree.isDisplayed(), Matchers.is(true));

        segmentedControl.tapSegment("One");
        jdiAssert(selectedValueOne.isDisplayed(), Matchers.is(true));
    }
}
