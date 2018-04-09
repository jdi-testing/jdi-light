package com.epam.jdi.light.elements.pageobjects.annotations.objects;

public enum TableHeaderTypes {
    ALL_HEADERS(true, true),
    NO_HEADERS(false, false),
    COLUMNS_HEADERS(false, true),
    ROWS_HEADERS(true, false);
    public boolean row;
    public boolean column;
    TableHeaderTypes(boolean row, boolean column) {
        this.row = row;
        this.column = column;
    }
}