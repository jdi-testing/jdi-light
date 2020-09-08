package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.BottomSheet;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomSheetAssert extends UIAssert<BottomSheetAssert, BottomSheet> {

    @JDIAction("Assert that '{name}' has values '{0}'")
    public BottomSheetAssert values(final Matcher<? super List> condition) {
        jdiAssert(element().values(), condition);
        return this;
    }

    public BottomSheetAssert isOpened() {
        jdiAssert(element().isOpened(), Matchers.is(true));
        return this;
    }

    public BottomSheetAssert isClosed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }
}
