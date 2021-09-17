package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.matchers.ColumnMatcher;
import org.openqa.selenium.support.ui.Quotes;

import static com.jdiai.tools.StringUtils.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TableMatcher {
    @Deprecated
    public static ColumnMatcher hasValue(String value, Column column) {
        return new ColumnMatcher("/td[%s][normalize-space(.)="+ Quotes.escape(value)+"]",
                column, format("has '%s' in column '%s'", value, column));
    }
    @Deprecated
    public static ColumnMatcher containsValue(String value, Column column) {
        return new ColumnMatcher("/td[%s][contains(normalize-space(.),"+ Quotes.escape(value)+")]",
                column, format("contains '%s' in column '%s'", value, column));
    }
}
