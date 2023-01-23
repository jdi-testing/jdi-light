package com.epam.jdi.light.vuetify.asserts.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataIterator;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DataIteratorAssert extends DataTableAssert {

    @Override
    public DataIterator element() {
        return (DataIterator) super.element();
    }

    @Override
    public DataIteratorAssert and() {
        return (DataIteratorAssert) super.and();
    }

    @JDIAction("Assert that '{name}' column is expanded")
    public DataIteratorAssert columnExpanded(int colNum) {
        jdiAssert(element().columnIsExpanded(colNum), Matchers.is(true), String.format("Element's column " +
                "number '%s' is collapsed", colNum));
        return this;
    }

    @JDIAction("Assert that '{name}' column is collapsed")
    public DataIteratorAssert columnCollapsed(int colNum) {
        jdiAssert(element().columnIsExpanded(colNum), Matchers.is(false), String.format("Element's column " +
                "number '%s' is expanded", colNum));
        return this;
    }

    @JDIAction("Assert that '{name}' column is empty")
    public DataIteratorAssert columnEmpty(int colNum) {
        jdiAssert(element().columnIsEmpty(colNum), Matchers.is(true), String.format("Column number '%s' is not " +
                "empty", colNum));
        return this;
    }

    @JDIAction("Assert that '{name}' column is not empty")
    public DataIteratorAssert columnNotEmpty(int colNum) {
        jdiAssert(element().columnIsEmpty(colNum), Matchers.is(false), String.format("Column number '%s' is " +
                "empty", colNum));
        return this;
    }

    @JDIAction("Assert that '{name}' column has title")
    public DataIteratorAssert columnTitle(int colNum, String title) {
        String actualColumnTitle = element().getColumnTitle(colNum);
        jdiAssert(actualColumnTitle, Matchers.is(title), String.format("Column actual title '%s' is not equal to " +
                "expected '%s'", actualColumnTitle, title));
        return this;
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
        jdiAssert(element().headerTheme(), Matchers.is("theme--light"), "Element's header has dark theme");
        return this;
    }

    @JDIAction("Assert that '{name}' header theme is dark")
    public DataIteratorAssert headerWithDarkTheme() {
        jdiAssert(element().headerTheme(), Matchers.is("theme--dark"), "Element's header has light theme");
        return this;
    }

    @JDIAction("Assert that '{name}' footer theme is dark")
    public DataIteratorAssert footerWithLightTheme() {
        jdiAssert(element().footerTheme(), Matchers.is("theme--light"), "Element's footer has dark theme");
        return this;
    }

    @JDIAction("Assert that '{name}' footer theme is dark")
    public DataIteratorAssert footerWithDarkTheme() {
        jdiAssert(element().footerTheme(), Matchers.is("theme--dark"), "Element's footer has light theme");
        return this;
    }

    @JDIAction("Assert that '{name}' text {0}")
    public DataIteratorAssert text(Matcher<String> condition) {
        jdiAssert(element().getText(), condition);
        return this;
    }
}
