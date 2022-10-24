package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolBarAssert extends BasicBarAssert<ToolBar, ToolBarAssert> {

    @JDIAction("Assert that '{name}' is flat")
    public ToolBarAssert flat() {
        jdiAssert(element().isFLat() ? "is flat" : "is not flat", Matchers.is("is flat"));
        return this;
    }

}
