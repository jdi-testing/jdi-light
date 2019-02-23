package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.complex.table.TableMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TableAssert extends IsAssert {
    protected Table table;
    protected String name;

    public TableAssert(Table table) {
        super(table);
        this.table = table;
        this.name = table.toError();
    }

    @JDIAction("Assert is '{name}' empty")
    public TableAssert empty() {
        assertThat(table.isEmpty() ? "is empty" : "is not empty", is("is empty"));
        return this;
    }
    @JDIAction("Assert is '{name}' not empty")
    public TableAssert notEmpty() {
        assertThat(table.isEmpty() ? "is empty" : "is not empty", is("is not empty"));
        return this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public TableAssert size(Matcher<Integer> condition) {
        assertThat(table.count(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public TableAssert size(int size) {
        return size(is(size));
    }
    @JDIAction("Assert that '{name}' has column'{0}'")
    public TableAssert hasColumn(String column) {
        assertThat(table.header(), hasItem(column));
        return this;
    }
    @JDIAction("Assert that '{name}' has columns '{0}'")
    public TableAssert hasColumns(List<String> columns) {
        for(String column : columns)
            hasColumn(column);
        return this;
    }
    @JDIAction("Assert that '{name}' columns {0}")
    public TableAssert columns(Matcher<Collection<? extends String>> condition) {
        assertThat(table.header(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' has at least '{0}' rows that {0}")
    public TableAssert rowsWithValues(int count, TableMatcher... matchers) {
        assertThat(TABLE_MATCHER.execute(table, matchers).size(),
            greaterThan(table.header().size()*count-1));
        return this;
    }
    @JDIAction("Assert that '{name}' has at least one row that {0}}")
    public TableAssert hasRowWithValues(TableMatcher... matchers) {
        assertThat(TABLE_MATCHER.execute(table, matchers), is(not(Matchers.empty())));
        return this;
    }
}
