package com.epam.jdi.light.vuetify.asserts.tables;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.vuetify.enums.Themes.THEME_DARK;
import static com.epam.jdi.light.vuetify.enums.Themes.THEME_LIGHT;

public class DataIteratorAssert extends UIAssert<DataIteratorAssert, DataIterator>
implements ThemeAssert<DataIteratorAssert, DataIterator> {

    @Override
    public DataIterator element() {
        return super.element();
    }

    @Override
    public DataIteratorAssert and() {
        return super.and();
    }

    @JDIAction("Assert that '{name}' has footer")
    public DataIteratorAssert footer(String footer) {
        String actualFooter = element().getTableFooter();
        jdiAssert(actualFooter, Matchers.is(footer), String.format("Element's actual footer '%s' is not equal to " +
                "expected '%s'", actualFooter, footer));
        return this;
    }

    @JDIAction("Assert that '{name}' has header")
    public DataIteratorAssert header(String header) {
        String actualHeader = element().getTableHeader();
        jdiAssert(actualHeader, Matchers.is(header), String.format("Element's actual header '%s' is not equal to " +
                "expected '%s'", actualHeader, header));
        return this;
    }

    @JDIAction("Assert that '{name}' has required number of columns per page")
    public DataIteratorAssert numberOfColumns(int n) {
        int actualNumberOfColumns = element().getColumnsValue();
        jdiAssert(actualNumberOfColumns, Matchers.is(n), String.format("Element's actual number of columns '%s' " +
                "is not equal to expected '%s'", actualNumberOfColumns, n));
        return this;
    }

    @JDIAction("Assert that '{name}' header theme is light")
    public DataIteratorAssert headerWithLightTheme() {
        jdiAssert(element().headerTheme(), Matchers.is(THEME_LIGHT.getValue()), "Element's header has dark theme");
        return this;
    }

    @JDIAction("Assert that '{name}' header theme is dark")
    public DataIteratorAssert headerWithDarkTheme() {
        jdiAssert(element().headerTheme(), Matchers.is(THEME_DARK.getValue()), "Element's header has light theme");
        return this;
    }

    @JDIAction("Assert that '{name}' footer theme is dark")
    public DataIteratorAssert footerWithLightTheme() {
        jdiAssert(element().footerTheme(), Matchers.is(THEME_LIGHT.getValue()), "Element's footer has dark theme");
        return this;
    }

    @JDIAction("Assert that '{name}' footer theme is dark")
    public DataIteratorAssert footerWithDarkTheme() {
        jdiAssert(element().footerTheme(), Matchers.is(THEME_DARK.getValue()), "Element's footer has light theme");
        return this;
    }

    @JDIAction("Assert that '{name}' text {0}")
    public DataIteratorAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
