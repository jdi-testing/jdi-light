package com.epam.jdi.light.material.asserts.displaydata.table;

import com.epam.jdi.light.asserts.core.SoftAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.table.MUITableCellContainer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

public class MUITableCellContainerAssert<A extends UIAssert<?, ?>, E extends MUITableCellContainer<?>> extends UIAssert<A, E> {

    @JDIAction(value = "Check that '{name}' is exist", isAssert = true)
    public MUITableCellContainerAssert<A, E> exist() {
        SoftAssert.jdiAssert(element().isExist() ? "is exist" : "is not exist", Matchers.is("is exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' is not exist", isAssert = true)
    public MUITableCellContainerAssert<A, E> notExist() {
        SoftAssert.jdiAssert(element().isNotExist() ? "is not exist" : "is exist", Matchers.is("is not exist"));
        return this;
    }

    @JDIAction(value = "Check that '{name}' has index {0}", isAssert = true)
    public MUITableCellContainerAssert<A, E> index(int index) {
        SoftAssert.jdiAssert(element().index(), Matchers.is(index));
        return this;
    }

    @JDIAction(value = "Check that '{name}' size is {0}", isAssert = true)
    public MUITableCellContainerAssert<A, E> size(int size) {
        SoftAssert.jdiAssert(element().size(), Matchers.is(size));
        return this;
    }

    @JDIAction(value = "Check that '{name}' size {0}", isAssert = true)
    public MUITableCellContainerAssert<A, E> size(Matcher<Integer> condition) {
        SoftAssert.jdiAssert(element().size(), condition);
        return this;
    }

}
