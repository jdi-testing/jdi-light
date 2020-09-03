package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.MarkupLocator;
import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.support.ui.Quotes;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class TableMatcher {
    public static JFunc2<BaseTable, TableMatcher[], WebList> TABLE_MATCHER = (table, matchers) -> {
        String locator = format("./%s/ancestor::*/td", print(map(matchers, m ->
                m.getLocator(table)),"/ancestor::*"));
        return $$(locator, table);
    };
    public static TableMatcher hasValue(String value, Column column) {
        return new TableMatcher("/td[%s][normalize-space(.)="+ Quotes.escape(value)+"]",
                column, "has '"+value +"'");
    }
    public static TableMatcher containsValue(String value, Column column) {
        return new TableMatcher("/td[%s][contains(normalize-space(.),"+ Quotes.escape(value)+")]",
                column, "contains '"+value +"'");
    }

    private String locator;
    private Column column;
    public TableMatcher setColumn(Column column) {
        this.column = column;
        return this;
    }
    private String name;
    TableMatcher(@MarkupLocator String locator, Column column, String name) {
        this.locator = locator;
        this.column = column;
        this.name = name;
    }
    public String getLocator(BaseTable table) { return format(locator, column.getIndex(table.header())); }
    @Override
    public String toString() {
        return name;
    }
}
