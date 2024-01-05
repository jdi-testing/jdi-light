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
    @JDIAction(value = "Check that '{name}' text {0}", isAssert = true)
    public MUITableDefaultCellAssert text(Matcher<String> condition) {
        SoftAssert.jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Check that '{name}' has button '{0}'", isAssert = true)
    public MUITableDefaultCellAssert button(String label) {
        SoftAssert.jdiAssert(element().button(label).isExist() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has checkbox element", isAssert = true)
    public MUITableDefaultCellAssert checkbox() {
        SoftAssert.jdiAssert(element().checkbox().isExist() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has select element", isAssert = true)
    public MUITableDefaultCellAssert select() {
        SoftAssert.jdiAssert(element().select().isExist() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return this;
    }

}
