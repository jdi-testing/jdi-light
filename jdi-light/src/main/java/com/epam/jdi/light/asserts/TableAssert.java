package com.epam.jdi.light.asserts;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.Column;
import com.epam.jdi.light.elements.complex.table.Table;
import com.epam.jdi.light.elements.complex.table.TableMatchers;
import com.epam.jdi.tools.pairs.Pair;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.elements.complex.table.TableMatchers.GET_ROW;
import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class TableAssert {
    Table table;

    public TableAssert(Table table) {
        this.table = table;
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
    public void columns(Matcher<Collection<? extends String>> count) {
        assertThat(table.header(), count);
    }
    public void rowsWithValues(int count, TableMatchers... matchers) {
        assertThat(getMatchLines(table, matchers).size(),
            greaterThan(table.header().size()*count-1));
    }
    public void hasRowWithValues(TableMatchers... matchers) {
        assertThat(getMatchLines(table, matchers), is(not(empty())));
    }
    public static WebList getMatchLines(Table table, TableMatchers... matchers) {
        String locator = format(GET_ROW, print(map(matchers, m ->
                m.getLocator(table) + "/.."),""));
        return $$(locator, table);
    }

}
