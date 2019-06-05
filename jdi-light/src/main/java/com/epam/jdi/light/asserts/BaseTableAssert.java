package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.*;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class BaseTableAssert<T extends BaseTable, A extends BaseTableAssert> extends IsAssert<A> {
    protected T table;
    protected String name;
    protected T table() {
        table.refresh();
        return table;
    }

    public BaseTableAssert(T table) {
        super(table);
        this.table = table;
        this.name = table.toError();
    }
    /**
     * Check that the table is empty
     */
    @JDIAction("Assert is '{name}' empty")
    public A empty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", is("is empty"));
        return (A) this;
    }

    /**
     * Check that the table isn't empty
     */
    @JDIAction("Assert is '{name}' not empty")
    public A notEmpty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", is("is not empty"));
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
        return size(is(size));
    }

    private List<String> header() {
        return table().header();
    }
    /**
     * Check that the table has the specified column
     * @param column to compare
     */
    @JDIAction("Assert that '{name}' has column'{0}'")
    public A column(String column) {
        assertThat(header(), hasItem(column));
        //TEST jdiAssert(table().header(), hasItem(column));
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
        jdiAssert(header(), condition);
        return (A) this;
    }
    /**
     * Check that the table has at list one specified row
     * @param matchers to compare
     */
    @JDIAction("Assert that '{name}' has at least one row that {0}}")
    public A rowThat(TableMatcher... matchers) {
        jdiAssert(TABLE_MATCHER.execute(table(), matchers), is(not(Matchers.empty())));
        return (A) this;
    }
    /**
     * Check that the table has at list one specified row
     * @param matcher to compare
     */
    @JDIAction("Assert that '{name}' has at least one row that {0}}")
    public A rowThat(Single matcher, Column column) {
        jdiAssert(TABLE_MATCHER.execute(table(), new TableMatcher[] {matcher.toTableMatcher(column)}), is(not(Matchers.empty())));
        return (A) this;
    }

    /**
     * Check that the table has rows that meet expected condition
     * @param matcher to compare
     * @return Table
     */
    @JDIAction("Assert that '{name}' has rows that meet expected condition")
    public A row(Matcher<String> matcher, Column column) {
        jdiAssert(table().row(matcher, column), not(nullValue()));
        return (A) this;
    }
}
