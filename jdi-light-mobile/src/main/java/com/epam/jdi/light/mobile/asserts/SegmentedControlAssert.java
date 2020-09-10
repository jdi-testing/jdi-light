package com.epam.jdi.light.mobile.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.mobile.elements.composite.ios.app.SegmentedControl;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class SegmentedControlAssert extends UIAssert<SegmentedControlAssert, SegmentedControl> {

    @JDIAction(value = "Assert that {0} segment selected for '{name}'")
    public SegmentedControlAssert selected(String selectedSegment) {
        jdiAssert(element().getSelectedSegmentText(), Matchers.is(selectedSegment));
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has {0} segments")
    public SegmentedControlAssert segments(List<String> segmentTexts) {
        jdiAssert(element().getSegmentTexts(), Matchers.contains(segmentTexts.toArray()));
        return this;
    }
}
