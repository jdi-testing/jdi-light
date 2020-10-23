package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.BottomSheet;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.tools.LinqUtils.toStringArray;
import static org.hamcrest.Matchers.hasItems;

public class BottomSheetAssert extends UIAssert<BottomSheetAssert, BottomSheet> {

    @JDIAction("Assert that '{name}' has values '{0}'")
    public BottomSheetAssert values(final Matcher<? super List<String>> condition) {
        jdiAssert(element().values(), condition);
        return this;
    }

    public BottomSheetAssert values(final String... values) {
        return values(hasItems(values));
    }

    public BottomSheetAssert values(final List<String> values) {
        return values(toStringArray(values));
    }

    public BottomSheetAssert opened() {
        jdiAssert(element().isOpened(), Matchers.is(true));
        return this;
    }

    public BottomSheetAssert closed() {
        jdiAssert(element().isClosed(), Matchers.is(true));
        return this;
    }
}
