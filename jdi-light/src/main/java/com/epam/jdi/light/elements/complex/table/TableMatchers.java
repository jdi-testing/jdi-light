package com.epam.jdi.light.elements.complex.table;

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

}
