package com.epam.jdi.mobile.asserts.generic.table;

import com.epam.jdi.mobile.asserts.generic.UIAssert;
import com.epam.jdi.mobile.common.JDIAction;
import com.epam.jdi.mobile.elements.complex.table.*;
import com.epam.jdi.mobile.elements.complex.table.*;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.mobile.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.mobile.common.Exceptions.exception;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class BaseTableAssert<T extends BaseTable, A extends BaseTableAssert> extends UIAssert<A, T> {
    protected T table() {
        element.refresh();
        return element;
    }
    /**
     * Check that the table is empty
     */
    @JDIAction("Assert is '{name}' empty")
    public A empty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return (A) this;
    }

    /**
     * Check that the table isn't empty
     */
    @JDIAction("Assert is '{name}' not empty")
    public A notEmpty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", Matchers.is("is not empty"));
        return (A) this;
    }

    /**
     * Match passed value with table size
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' size {0}")
    public A size(Matcher<Integer> condition) {
        jdiAssert(table().count(), condition);
        return (A) this;
    }

    /**
     * Match passed value with table size
     * @param size to compare
     */
    @JDIAction("Assert that '{name}' size {0}")
    public A size(int size) {
        return size(Matchers.is(size));
    }

    /**
     * Check that the table has the specified column
     * @param column to compare
     */
    @JDIAction("Assert that '{name}' has column'{0}'")
    public A column(String column) {
        jdiAssert(table().header(), hasItem(column));
        return (A) this;
    }

    /**
     * Check that the table has the specified columns
     * @param columns to compare
     */
    @JDIAction("Assert that '{name}' has columns '{0}'")
    public A columns(List<String> columns) {
        for(String column : columns)
            column(column);
        return (A) this;
    }

    /**
     * Match passed value with table columns
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' columns {0}")
    public A columns(Matcher<Collection<? extends String>> condition) {
        jdiAssert(table().header(), condition);
        return (A) this;
    }
    /**
     * Check that the table has at list one specified row
     * @param matchers to compare
     */
    @JDIAction("Assert that '{name}' has at least one row that {0}}")
    public A rowThat(TableMatcher... matchers) {
        jdiAssert(TableMatcher.TABLE_MATCHER.execute(table(), matchers), Matchers.is(not(Matchers.empty())));
        return (A) this;
    }
    /**
     * Check that the table has at list one specified row
     * @param matcher to compare
     */
    @JDIAction("Assert that '{name}' has at least one row that {0}}")
    public A rowThat(Single matcher, Column column) {
        jdiAssert(TableMatcher.TABLE_MATCHER.execute(table(), new TableMatcher[] {matcher.toTableMatcher(column)}), Matchers.is(not(Matchers.empty())));
        return (A) this;
    }

    /**
     * Check that the table has rows that meet expected condition
     * @param matcher to compare
     * @return Table
     */
    @JDIAction("Assert that '{name}' has rows that {0} in column {1}")
    public A row(Matcher<String> matcher, Column column) {
        jdiAssert(table().row(matcher, column), not(nullValue()));
        return (A) this;
    }

    @JDIAction("Assert that '{name}' row {0} equals to other row")
    public A rowVisualValidation(String rowName, Line row) {
        jdiAssert(table().row(rowName).visualCompareTo(row), Matchers.is(true));
        return (A) this;
    }
    @JDIAction("Assert that '{name}' row {0} equals to other row")
    public A rowsVisualValidation(String keyColumn, List<Line> rows) {
        List<Line> tableRows = table().rowsImages();
        for (int i = 0; i < table().count(); i++) {
            Line tableRow = tableRows.get(i);
            jdiAssert(tableRow.visualCompareTo(findRow(rows, tableRow.get(keyColumn), keyColumn)), Matchers.is(true));
        }
        return (A) this;
    }
    private Line findRow(List<Line> rows, String name, String columnName) {
        for (Line line : rows)
            if (line.get(columnName).equals(name))
                return line;
        throw exception("Can't find %s row with column %s", name, columnName);
    }
}
