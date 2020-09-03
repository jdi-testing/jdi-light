package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.BottomSheet;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomSheetAssert extends UIAssert<BottomSheetAssert, BottomSheet> {
    @JDIAction("Assert that {name} option values are correct")
    public BottomSheetAssert checkValue(String expectedValue, String actualValue) {
        jdiAssert(element().checkValue(expectedValue, actualValue), Matchers.is(true));
        return this;
    }
}
