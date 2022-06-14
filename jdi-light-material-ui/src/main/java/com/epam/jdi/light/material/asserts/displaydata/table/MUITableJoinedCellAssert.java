package com.epam.jdi.light.material.asserts.displaydata.table;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableJoinedCell;

public class MUITableJoinedCellAssert extends MUITableCellAssert<MUITableJoinedCellAssert, MUITableJoinedCell> implements ITextAssert<MUITableJoinedCellAssert> {

    @Override
    public MUITableJoinedCellAssert text(Matcher<String> condition) {
        SoftAssert.jdiAssert(element().getText(), condition);
        return this;
    }
    
    @Override
    public MUITableJoinedCellAssert text(String condition) {
        return text(Matchers.equalTo(condition));
    } 
}
