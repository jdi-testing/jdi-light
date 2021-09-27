package com.epam.jdi.light.vuetify.asserts.bars;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class ToolBarAssert extends BasicBarAssert<ToolBar, ToolBarAssert> {

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert backgroundImage() {
        jdiAssert(element().hasBackgroundImage(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that banner has proper title")
    public ToolBarAssert exportButton() {
        jdiAssert(element().hasExportButton(), Matchers.is(true));
        return this;
    }
}
