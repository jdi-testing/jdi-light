package com.epam.jdi.light.vuetify.asserts;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.GridSystem;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class GridSystemAssert extends UIAssert<GridSystemAssert, GridSystem> {

    @JDIAction("Assert that '{name}' is displayed")
    public GridSystemAssert displayed() {
        Timer.waitCondition(element()::isDisplayed);
        jdiAssert(element().isDisplayed(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that '{name}' has expected text in in column {1}")
    public GridSystemAssert columnText(String text, int rowIndex, int columnIndex) {
        jdiAssert(element().getColumnByIndex(rowIndex, columnIndex).text(), Matchers.is(text));
        return this;
    }

    @JDIAction("Assert that '{name}' row {0} has expected alignment")
    public GridSystemAssert rowVerticalAlignment(int rowIndex, String alignment) {
        jdiAssert(element().getRowVerticalAlignment(rowIndex), Matchers.is(String.format("align-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' row {0} has expected alignment")
    public GridSystemAssert rowHorizontalAlignment(int rowIndex, String alignment) {
        jdiAssert(element().getRowHorizontalAlignment(rowIndex), Matchers.is(String.format("justify-%s", alignment)));
        return this;
    }

    @JDIAction("Assert that '{name}' column {1} has expected alignment")
    public GridSystemAssert columnVerticalAlignment(int rowIndex, int columnIndex, String alignment) {
        jdiAssert(element().getColumnVerticalAlignment(rowIndex, columnIndex), Matchers.is(String.format("align-self-%s", alignment)));
        return this;
    }


}
