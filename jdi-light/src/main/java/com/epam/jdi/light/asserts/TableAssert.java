package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.complex.table.Column;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TableAssert {
    Table table;

    public TableAssert(Table table) {

        //this.elements = new MapArray<>(header, LinqUtils.map(elements, WebElement::getText));
    }

    public void isEmpty() {
        assertThat(table.isEmpty() ? "is empty" : "is not empty", is("is empty"));
    }
    public void isNotEmpty() {
        assertThat(table.isEmpty() ? "is empty" : "is not empty", is("is not empty"));
    }
    public void size(int size) {
        assertThat(table.size(), is(size));
    }

    public void hasColumn(String column) {
        assertThat(table.header(), hasItem(column));
    }
    public void hasColumns(List<String> columns) {
        for(String column : columns)
            hasColumn(column);
    }
    public void columnsCount(int count) {
        assertThat(table.header(), hasSize(count));
    }
    public void hasRowsWhereValue(Matcher<String> matcher, Column column) {
        assertThat(table.row(matcher, column), notNullValue());
    }
    public void hasRowsWhereValue(Pair<Matcher<String>, Column>... matchers) {
        for (Pair<Matcher<String>, Column> matcher : matchers)
            hasRowsWhereValue(matcher.key, matcher.value);
    }

}
