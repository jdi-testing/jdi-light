package com.epam.jdi.light.elements.complex.table.matchers;

import com.epam.jdi.light.elements.complex.table.BaseTable;
import com.epam.jdi.light.elements.complex.table.Column;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;

import java.text.MessageFormat;

import static com.epam.jdi.light.elements.complex.table.matchers.TableMatcherSettings.*;
import static java.lang.String.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ColumnMatcher {
    public static ColumnMatcher hasValue(String value, Column column) {
        return new ColumnMatcher(MessageFormat.format(HAS_VALUE_TEMPLATE, quotesEscape(value)),
                column, format("has '%s' in column '%s'", value, column));
    }
    public static ColumnMatcher containsValue(String value, Column column) {
        return new ColumnMatcher(MessageFormat.format(CONTAINS_VALUE_TEMPLATE, quotesEscape(value)),
                column, format("contains '%s' in column '%s'", value, column));
    }

    protected String locator;
    protected Column column;
    public ColumnMatcher setColumn(Column column) {
        this.column = column;
        return this;
    }
    protected String name;
    public ColumnMatcher(@MarkupLocator String locator, Column column, String name) {
        this.locator = locator;
        this.column = column;
        this.name = name;
    }
    public String getLocator(BaseTable<?,?> table) { return format(locator, column.getIndex(table.header(), table.getStartIndex())); }
    @Override
    public String toString() {
        return name;
    }
}
