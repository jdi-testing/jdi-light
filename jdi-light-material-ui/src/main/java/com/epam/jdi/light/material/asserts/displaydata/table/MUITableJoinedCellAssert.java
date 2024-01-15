package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableJoinedCell;

public class MUITableJoinedCellAssert extends MUITableCellAssert<MUITableJoinedCellAssert, MUITableJoinedCell> implements ITextAssert<MUITableJoinedCellAssert> {

    @JDIAction(value = "Assert that '{name}' has text matched condition", isAssert = true)
    @Override
    public MUITableJoinedCellAssert text(Matcher<String> condition) {
        SoftAssert.jdiAssert(element().getText(), condition);
        return this;
    }

    @JDIAction(value = "Assert that '{name}' has text {0}", isAssert = true)
    @Override
    public MUITableJoinedCellAssert text(String condition) {
        return text(Matchers.equalTo(condition));
    }
}
