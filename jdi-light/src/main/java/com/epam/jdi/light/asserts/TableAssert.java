package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.complex.table.TableMatcher;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static com.epam.jdi.light.asserts.SoftAssert.softAssertThat;
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

    @JDIAction("Assert is '{name}' empty")
    public T empty() {
        softAssertThat(table().isEmpty() ? "is empty" : "is not empty", is("is empty"));
        return (T) this;
    }
    @JDIAction("Assert is '{name}' not empty")
    public T notEmpty() {
        softAssertThat(table().isEmpty() ? "is empty" : "is not empty", is("is not empty"));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public T size(Matcher<Integer> condition) {
        softAssertThat(table().count(), condition);
        return (T) this;
    }
    @JDIAction("Assert that '{name}' size {0}")
    public T size(int size) {
        return size(is(size));
    }
    @JDIAction("Assert that '{name}' has column'{0}'")
    public T hasColumn(String column) {
        softAssertThat(table().header(), hasItem(column));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' has columns '{0}'")
    public T hasColumns(List<String> columns) {
        for(String column : columns)
            hasColumn(column);
        return (T) this;
    }
    @JDIAction("Assert that '{name}' columns {0}")
    public T columns(Matcher<Collection<? extends String>> condition) {
        softAssertThat(table().header(), condition);
        return (T) this;
    }
    @JDIAction("Assert that '{name}' has at least '{0}' rows that {0}")
    public T rowsWithValues(int count, TableMatcher... matchers) {
        softAssertThat(TABLE_MATCHER.execute(table, matchers).size(),
            greaterThan(table().header().size()*count-1));
        return (T) this;
    }
    @JDIAction("Assert that '{name}' has at least one row that {0}}")
    public T hasRowWithValues(TableMatcher... matchers) {
        softAssertThat(TABLE_MATCHER.execute(table(), matchers), is(not(Matchers.empty())));
        return (T) this;
    }
}
