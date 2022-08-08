package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.composite.BottomSheet;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class BottomSheetAssert extends UIAssert<BottomSheetAssert, BottomSheet> {
    @JDIAction("Assert that option titles are presented")
    public BottomSheetAssert optionTitlesPresented(String optionName) {
        jdiAssert(element().isOptionTitlesPresented(optionName) ? "option title is presented"
                : "option title is not presented", Matchers.is("option title is presented"));
        return this;
    }
}
