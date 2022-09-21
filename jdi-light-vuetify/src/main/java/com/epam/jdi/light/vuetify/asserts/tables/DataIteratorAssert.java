package com.epam.jdi.light.vuetify.asserts.tables;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import org.hamcrest.Matchers;

public class DataIteratorAssert extends DataTableAssert {

    private String noResultsText = "No matching records found";

    @Override
    public DataIterator element() {
        return (DataIterator) super.element();
    }

    @Override
    public DataIteratorAssert and() {
        return (DataIteratorAssert) super.and();
    }

    @JDIAction("Assert that {name} column is expanded")
    public DataIteratorAssert columnExpanded(int colNum) {
        jdiAssert(element().columnIsExpanded(colNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} column is collapsed")
    public DataIteratorAssert columnCollapsed(int colNum) {
        jdiAssert(element().columnIsExpanded(colNum), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} column is empty")
    public DataIteratorAssert columnEmpty(int colNum) {
        jdiAssert(element().columnIsEmpty(colNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} column is not empty")
    public DataIteratorAssert columnNotEmpty(int colNum) {
        jdiAssert(element().columnIsEmpty(colNum), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} column has title")
    public DataIteratorAssert columnTitle(int colNum, String requiredTitle) {
        jdiAssert(element().getColumnTitle(colNum), Matchers.is(requiredTitle));
        return this;
    }

    @JDIAction("Assert that {name} text shown when search prop is used and there are no results")
    public DataIteratorAssert noResultsText() {
        jdiAssert(element().getNoResultsText(), Matchers.is(noResultsText));
        return this;
    }

    @JDIAction("Assert that {name} shows no matching records found message")
    public DataIteratorAssert groupByItem(String name) {
        jdiAssert(element().getGroupByItemText(), Matchers.containsString(name));
        return this;
    }


    @JDIAction("Assert that {name} has footer")
    public DataIteratorAssert footer(String requiredFooter) {
        jdiAssert(element().getTableFooter(), Matchers.is(requiredFooter));
        return this;
    }

    @JDIAction("Assert that {name} has header")
    public DataIteratorAssert header(String requiredHeader) {
        jdiAssert(element().getTableHeader(), Matchers.is(requiredHeader));
        return this;
    }

    @JDIAction("Assert that {name} has required number of columns per page")
    public DataIteratorAssert number(int value) {
        jdiAssert(element().getColumnsValue(), Matchers.is(value));
        return this;
    }
}
