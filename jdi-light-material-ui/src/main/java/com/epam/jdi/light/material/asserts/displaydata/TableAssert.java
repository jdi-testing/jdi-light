package com.epam.jdi.light.material.asserts.displaydata;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.material.elements.displaydata.Table;
import com.epam.jdi.tools.Timer;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class TableAssert  extends UIAssert<TableAssert, Table> {
    @JDIAction("Assert that chip label with index {index} is displayed")
    public TableAssert headerDisplayed(final int index) {
        boolean isDisplayed = new Timer(base().getTimeout() * 1000L)
                .wait(() -> element().getHeader(index).isDisplayed());
        jdiAssert(isDisplayed, Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that table header {index} text is '{condition}'")
    public TableAssert textHeader(final int index, Matcher<String> condition) {
        jdiAssert(element().getHeader(index).getText(), condition);
        return this;
    }

    @JDIAction("Assert that table row {index} text is '{condition}'")
    public TableAssert textRow(final int idRow, final int idColumn, Matcher<String> condition) {
        jdiAssert(element().getRowColumn(idRow, idColumn).getText(), condition);
        return this;
    }

    @JDIAction("Assert that row {index} column 1 item < row {index + 1} column 1")
    public TableAssert increaseValue(final int index){
        jdiAssert(Integer.parseInt(element().getRowColumn(index, 2).getText()), Matchers.is(Matchers.lessThanOrEqualTo(Integer.parseInt(element().getRowColumn(index + 1, 2).getText()))));
        return this;
    }

    @JDIAction("Assert that row {index} column 1 item < row {index + 1} column 1")
    public TableAssert decreaseValue(final int index){
        jdiAssert(Integer.parseInt(element().getRowColumn(index + 1, 2).getText()), Matchers.is(Matchers.lessThanOrEqualTo(Integer.parseInt(element().getRowColumn(index, 2).getText()))));
        return this;
    }

    @JDIAction("Check that subtotal has correct value, number of rows - {rowsNumber}")
    public TableAssert checkSubtotal(final int rowsNumber){
        int sum = 0;
        for (int i = 1; i <= rowsNumber; i++){
            sum += Integer.parseInt(element().getRowColumn(i, 2).getText());
        }
        jdiAssert(Integer.parseInt(element().getRowColumn(rowsNumber + 1, 2).getText()), Matchers.equalTo(sum));
        return this;
    }
}
