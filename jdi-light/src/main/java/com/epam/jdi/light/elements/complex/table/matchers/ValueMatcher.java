package com.epam.jdi.light.elements.complex.table.matchers;

import com.epam.jdi.light.elements.complex.table.Column;

import java.text.MessageFormat;

import static com.epam.jdi.light.elements.complex.table.matchers.TableMatcherSettings.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ValueMatcher {
    public static ValueMatcher hasValue(String value) {
        return new ValueMatcher(MessageFormat.format(SINGLE_HAS_VALUE_TEMPLATE, quotesEscape(value)),
                 "has '"+value +"'");
    }
    public static ValueMatcher containsValue(String value) {
        return new ValueMatcher(MessageFormat.format(SINGLE_CONTAINS_VALUE_TEMPLATE, quotesEscape(value)),
                "contains '"+value +"'");
    }

    protected String locator;
    protected String name;
    public ValueMatcher(String locator, String name) {
        this.locator = locator;
        this.name = name;
    }
    public ColumnMatcher toTableMatcher(Column column) {
        return new ColumnMatcher(locator, column, name);
    }
    @Override
    public String toString() {
        return name;
    }
}
