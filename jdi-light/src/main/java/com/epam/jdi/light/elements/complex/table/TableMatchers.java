package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.base.UIElement;
import com.epam.jdi.light.elements.complex.WebList;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

public class TableMatchers {
    public static String GET_ROW = "./%s/td";
    public static TableMatchers hasValue(String value, Column column) {
        return new TableMatchers("/td[%s][text()='"+value+"']", column);
    }
    public static TableMatchers containsValue(String value, Column column) {
        return new TableMatchers("/td[%s][contains(text(),'"+value+"')]", column);
    }

    private String locator;
    private Column column;
    TableMatchers(String locator, Column column) {
        this.locator = locator;
        this.column = column;
    }
    public String getLocator(Table table) { return format(locator, column.getIndex(table.header())); }


    public static WebList<UIElement> getMatchLines(Table table, TableMatchers... matchers) {
        String locator = format(GET_ROW, print(map(matchers, m ->
                m.getLocator(table) + "/.."),""));
        return $$(locator, table);
    }
}
