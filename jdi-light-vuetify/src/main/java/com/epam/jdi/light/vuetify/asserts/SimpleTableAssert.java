package com.epam.jdi.light.vuetify.asserts;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import com.epam.jdi.light.asserts.generic.table.BaseTableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.Tables.SimpleTable;
import com.epam.jdi.light.vuetify.elements.enums.TableTestData;
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
    public SimpleTableAssert firstColumnHasElement(int elNum, TableTestData data) {
        jdiAssert(element().firstColumnElement(elNum), Matchers.is(data.value()));
        return this;
    }

    @JDIAction("Assert that {name} first column has required element")
    public SimpleTableAssert firstColumnHasElement(TableTestData data) {
        jdiAssert(element().firstColumnElement(data), Matchers.is(data.value()));
        return this;
    }

    @JDIAction("Assert that {name} second column has required element")
    public SimpleTableAssert secondColumnHasElement(int elNum, TableTestData data) {
        jdiAssert(element().secondColumnElement(elNum), Matchers.is(data.value()));
        return this;
    }

    @JDIAction("Assert that {name} second column has required element")
    public SimpleTableAssert secondColumnHasElement(TableTestData data) {
        jdiAssert(element().secondColumnElement(data), Matchers.is(data.value()));
        return this;
    }

    @JDIAction("Assert that {name} column has title")
    public SimpleTableAssert columnTitle(int colNum, String reqTitle) {
        jdiAssert(element().columnTitle(colNum), Matchers.is(reqTitle));
        return this;
    }

}
