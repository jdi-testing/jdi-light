package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.complex.table.TableMatchers;
import org.hamcrest.Matcher;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.BaseSelectorAssert.waitAssert;
import static com.epam.jdi.light.elements.complex.table.TableMatchers.getMatchLines;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TableAssert {
    protected Table table;
    protected String name;

    public TableAssert(Table table) {
        this.table = table;
        this.name = table.toError();
    }

    public TableAssert isEmpty() {
        waitAssert(() -> assertThat(table.isEmpty() ? "is empty" : "is not empty", is("is empty")), name);
        return this;
    }
    public TableAssert isNotEmpty() {
        waitAssert(() -> assertThat(table.isEmpty() ? "is empty" : "is not empty", is("is not empty")), name);
        return this;
    }
    public TableAssert size(int size) {
        waitAssert(() -> assertThat(table.size(), is(size)), name);
        return this;
    }

    public TableAssert hasColumn(String column) {
        waitAssert(() -> assertThat(table.header(), hasItem(column)), name);
        return this;
    }
    public TableAssert hasColumns(List<String> columns) {
        for(String column : columns)
            hasColumn(column);
        return this;
    }
    public TableAssert columns(Matcher<Collection<? extends String>> count) {
        waitAssert(() -> assertThat(table.header(), count), name);
        return this;
    }
    public TableAssert rowsWithValues(int count, TableMatchers... matchers) {
        waitAssert(() -> assertThat(getMatchLines(table, matchers).size(),
            greaterThan(table.header().size()*count-1)), name);
        return this;
    }
    public TableAssert hasRowWithValues(TableMatchers... matchers) {
        waitAssert(() -> assertThat(getMatchLines(table, matchers), is(not(empty()))), name);
        return this;
    }

}
