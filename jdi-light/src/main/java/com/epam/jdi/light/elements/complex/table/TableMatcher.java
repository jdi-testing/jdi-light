package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

public class TableMatcher {
    public static String GET_ROW = "./%s/td";
    public static TableMatcher hasValue(String value, Column column) {
        return new TableMatcher("/td[%s][text()='"+value+"']", column, "has '"+value +"'");
    }
    public static TableMatcher containsValue(String value, Column column) {
        return new TableMatcher("/td[%s][contains(text(),'"+value+"')]", column, "contains '"+value +"'");
    }

    private String locator;
    private Column column;
    private String name;
    TableMatcher(String locator, Column column, String name) {
        this.locator = locator;
        this.column = column;
        this.name = name;
    }
    public String getLocator(Table table) { return format(locator, column.getIndex(table.header())); }
    @Override
    public String toString() {
        return name;
    }

    public static WebList getMatchLines(Table table, TableMatcher... matchers) {
        String locator = format(GET_ROW, print(map(matchers, m ->
                m.getLocator(table) + "/.."),""));
        return $$(locator, table);
    }
}
