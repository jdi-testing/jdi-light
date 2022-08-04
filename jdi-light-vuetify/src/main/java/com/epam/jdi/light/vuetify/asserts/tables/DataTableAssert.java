package com.epam.jdi.light.vuetify.asserts.tables;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;
import org.hamcrest.Matchers;

public class DataTableAssert extends SimpleTableAssert {

    @Override
    public DataTable element() {
        return (DataTable) super.element();
    }

    @Override
    public DataTableAssert and() {
        return this;
    }

    @JDIAction("Assert that {name} element has required name")
    public DataTableAssert elementHasName(int elNum, String elName) {
        jdiAssert(element().getColumn(1).get(elNum).getText(), Matchers.is(elName));
        return this;
    }

    @JDIAction("Assert that {name} has required value")
    public DataTableAssert elementValue(int colNum, int elNum, String elName) {
        jdiAssert(element().columnElement(colNum, elNum), Matchers.is(elName));
        return this;
    }

    @JDIAction("Assert that {name} is loading")
    public DataTableAssert loading() {
        jdiAssert(element().isLoading(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} columns are sorted by {0}")
    public DataTableAssert sortedBy(String value) {
        jdiAssert(element().isSortedBy(value), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} columns aren't sorted by {0}")
    public DataTableAssert notSortedBy(String value) {
        jdiAssert(element().isSortedBy(value), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} element is selected")
    public DataTableAssert cellSelected(int colNum, int elNum) {
        jdiAssert(element().isSelected(colNum, elNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} element isn't selected")
    public DataTableAssert cellNotSelected(int colNum, int elNum) {
        jdiAssert(element().isSelected(colNum, elNum), Matchers.is(false));
        return this;
    }

    @JDIAction("Assert that {name} column header is {0}")
    public DataTableAssert header(int colNum, String value) {
        jdiAssert(element().headerUI().get(colNum).text(), Matchers.is(value));
        return this;
    }

    @JDIAction("Assert that {name} element is expanded")
    public DataTableAssert rowExpanded(int elNum) {
        jdiAssert(element().rowIsExpanded(elNum), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} element is collapsed")
    public DataTableAssert rowCollapsed(int elNum) {
        jdiAssert(element().rowIsExpanded(elNum), Matchers.is(false));
        return this;
    }

    public DataTableAssert groupCollapsed(String groupName) {
        jdiAssert(element().groupIsExpanded(groupName), Matchers.is(false));
        return this;
    }

    public DataTableAssert groupExpanded(String groupName) {
        jdiAssert(element().groupIsExpanded(groupName), Matchers.is(true));
        return this;
    }

    public DataTableAssert hasGroup(String groupName) {
        jdiAssert(element().hasGroup(groupName), Matchers.is(true));
        return this;
    }
}
