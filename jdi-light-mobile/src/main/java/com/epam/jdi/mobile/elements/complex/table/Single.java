package com.epam.jdi.mobile.elements.complex.table;

import org.openqa.selenium.support.ui.Quotes;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Single {
    public static Single hasValue(String value) {
        return new Single("/td[%s]//*/text()[normalize-space(.) = "+ Quotes.escape(value)+"]",
                 "has '"+value +"'");
    }
    public static Single containsValue(String value) {
        return new Single("/td[%s]//*/text()[contains(normalize-space(.),"+ Quotes.escape(value)+")]",
                "contains '"+value +"'");
    }

    private String locator;
    private String name;
    Single(String locator, String name) {
        this.locator = locator;
        this.name = name;
    }
    public TableMatcher toTableMatcher(Column column) {
        return new TableMatcher(locator, column, name);
    }
    @Override
    public String toString() {
        return name;
    }
}
