package com.epam.jdi.light.elements.complex.table.matchers;

import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.BaseTable;
import com.epam.jdi.tools.func.JFunc2;
import org.openqa.selenium.support.ui.Quotes;

import static com.epam.jdi.light.elements.init.UIFactory.$$;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static java.lang.String.format;
import static java.util.Arrays.asList;

public class TableMatcherSettings {
    public static String HAS_VALUE_TEMPLATE = "/td[%s][normalize-space(.)={0}]";
    public static String SINGLE_HAS_VALUE_TEMPLATE = "/td[%s]//*/text()[normalize-space(.)={0}]";
    public static String CONTAINS_VALUE_TEMPLATE = "/td[%s][contains(normalize-space(.),{0})]";
    public static String SINGLE_CONTAINS_VALUE_TEMPLATE = "/td[%s]//*/text()[contains(normalize-space(.),{0})]";
    public static boolean escapeQuotes = true;
    public static JFunc2<BaseTable<?, ?>, ColumnMatcher[], WebList> TABLE_MATCHER = (table, matchers) -> {
        String locator = format("./%s/ancestor::*/td", print(map(matchers, m ->
                m.getLocator(table)),"/ancestor::*"));
        return $$(locator, table).setName("Matcher: " + print(asList(matchers), Object::toString));
    };
    static String quotesEscape(String value) {
        return escapeQuotes ? Quotes.escape(value) : value;
    }
}
