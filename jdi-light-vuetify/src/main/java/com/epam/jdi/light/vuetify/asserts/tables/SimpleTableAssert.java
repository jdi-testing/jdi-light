package com.epam.jdi.light.vuetify.asserts.tables;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.table.BaseTableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.SimpleTable;
import org.hamcrest.Matchers;

public class SimpleTableAssert extends BaseTableAssert<SimpleTable, SimpleTableAssert> {

    public SimpleTableAssert and() {
        return super.and();
    }


    @JDIAction("Assert that {name} is dark theme")
    public SimpleTableAssert dark() {
        jdiAssert(element().isDark(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} is light theme")
    public SimpleTableAssert light() {
        jdiAssert(element().isLight(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has fixed header")
    public SimpleTableAssert fixedHeader() {
        jdiAssert(element().hasFixedHeader(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} has fixed height")
    public SimpleTableAssert fixedHeight() {
        jdiAssert(element().hasFixedHeight(), Matchers.is(true));
        return this;
    }

    @JDIAction("Assert that {name} first column has required element")
    public SimpleTableAssert cellHasValue(int colNum, int rowNum, String data) {
        jdiAssert(element().getCell(colNum, rowNum).getText(), Matchers.is(data));
        return this;
    }

    @JDIAction("Assert that {name} first column has required element")
    public SimpleTableAssert columnHasValue(int colNum, String data) {
        jdiAssert(element().getColumn(colNum).get(data).getText(), Matchers.is(data));
        return this;
    }

    @JDIAction("Assert that {name} column has title")
    public SimpleTableAssert columnTitle(int colNum, String reqTitle) {
        jdiAssert(element().columnTitle(colNum), Matchers.is(reqTitle));
        return this;
    }

}
