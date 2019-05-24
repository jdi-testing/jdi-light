package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.complex.table.TableMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.SoftAssert.jdiAssert;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static org.hamcrest.Matchers.*;

public class TableAssert<T extends TableAssert> extends IsAssert<T> {
    protected Table table;
    protected String name;
    protected Table table() {
        table.refresh();
        return table;
    }

    public TableAssert(Table table) {
        super(table);
        this.table = table;
        this.name = table.toError();
    }

    /**
     * Check that the table is empty
     */
    @JDIAction("Assert is '{name}' empty")
    public T empty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", is("is empty"));
        return (T) this;
    }

    /**
     * Check that the table isn't empty
     */
    @JDIAction("Assert is '{name}' not empty")
    public T notEmpty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", is("is not empty"));
        return (T) this;
    }

    /**
     * Match passed value with table size
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' size {0}")
    public T size(Matcher<Integer> condition) {
        jdiAssert(table().count(), condition);
        return (T) this;
    }

    /**
     * Match passed value with table size
     * @param size to compare
     */
    @JDIAction("Assert that '{name}' size {0}")
    public T size(int size) {
        return size(is(size));
    }

    /**
     * Check that the table has the specified column
     * @param column to compare
     */
    @JDIAction("Assert that '{name}' has column'{0}'")
    public T hasColumn(String column) {
        jdiAssert(table().header(), hasItem(column));
        return (T) this;
    }

    /**
     * Check that the table has the specified columns
     * @param columns to compare
     */
    @JDIAction("Assert that '{name}' has columns '{0}'")
    public T hasColumns(List<String> columns) {
        for(String column : columns)
            hasColumn(column);
        return (T) this;
    }

    /**
     * Match passed value with table columns
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' columns {0}")
    public T columns(Matcher<Collection<? extends String>> condition) {
        jdiAssert(table().header(), condition);
        return (T) this;
    }

    /**
     * Make sure that the table has at least a certain number of the specified line
     * @param count
     * @param matchers to compare
     */
    @JDIAction("Assert that '{name}' has at least '{0}' rows that {0}")
    public T rowsWithValues(int count, TableMatcher... matchers) {
        jdiAssert(TABLE_MATCHER.execute(table, matchers).size(),
            greaterThan(table().header().size()*count-1));
        return (T) this;
    }

    /**
     * Check that the table has at list one specified row
     * @param matchers to compare
     */
    @JDIAction("Assert that '{name}' has at least one row that {0}}")
    public T hasRowWithValues(TableMatcher... matchers) {
        jdiAssert(TABLE_MATCHER.execute(table(), matchers), is(not(Matchers.empty())));
        return (T) this;
    }
}
