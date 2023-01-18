package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableDefaultCell;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class MUITableDefaultCellAssert extends MUITableCellAssert<MUITableDefaultCellAssert, MUITableDefaultCell>
        implements ITextAssert<MUITableDefaultCellAssert> {

    @Override
    @JDIAction("Check that '{name}' text {0}")
    public MUITableDefaultCellAssert text(Matcher<String> condition) {
        SoftAssert.jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction("Check that '{name}' has button '{0}'")
    public MUITableDefaultCellAssert button(String label) {
        SoftAssert.jdiAssert(element().button(label).isExist() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction("Check that '{name}' has checkbox element")
    public MUITableDefaultCellAssert checkbox() {
        SoftAssert.jdiAssert(element().checkbox().isExist() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction("Check that '{name}' has select element")
    public MUITableDefaultCellAssert select() {
        SoftAssert.jdiAssert(element().select().isExist() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

}
