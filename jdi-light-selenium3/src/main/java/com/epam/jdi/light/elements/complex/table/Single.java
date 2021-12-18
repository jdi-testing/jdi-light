package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.elements.complex.table.matchers.ValueMatcher;
import org.openqa.selenium.support.ui.Quotes;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Single {
    @Deprecated
    public static ValueMatcher hasValue(String value) {
        return new ValueMatcher("/td[%s]//*/text()[normalize-space(.) = "+ Quotes.escape(value)+"]",
                 "has '"+value +"'");
    }
    @Deprecated
    public static ValueMatcher containsValue(String value) {
        return new ValueMatcher("/td[%s]//*/text()[contains(normalize-space(.),"+ Quotes.escape(value)+")]",
                "contains '"+value +"'");
    }
}
