package com.epam.jdi.light.vuetify.asserts.tables;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

import com.epam.jdi.light.asserts.generic.table.BaseTableAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.SimpleTable;
import com.epam.jdi.light.vuetify.interfaces.asserts.DenseAssert;
import com.epam.jdi.light.vuetify.interfaces.asserts.ThemeAssert;
import org.hamcrest.Matchers;

public class SimpleTableAssert<T extends SimpleTable<T, A>, A extends SimpleTableAssert<T, A>>
    extends BaseTableAssert<T, A> implements DenseAssert<A, T>, ThemeAssert<A, T> {

    public A and() {
        return (A) this;
    }


    @JDIAction("Assert that {name} is dark theme")
    public A dark() {
        jdiAssert(element().isDark(), Matchers.is(true));
        return (A) this;
    }

    @JDIAction("Assert that {name} is light theme")
    public A light() {
        jdiAssert(element().isLight(), Matchers.is(true));
        return (A) this;
    }

    @JDIAction("Assert that {name} has fixed header")
    public A fixedHeader() {
        jdiAssert(element().hasFixedHeader(), Matchers.is(true));
        return (A) this;
    }

    @JDIAction("Assert that {name} has fixed height")
    public A fixedHeight() {
        jdiAssert(element().hasFixedHeight(), Matchers.is(true));
        return (A) this;
    }

    @JDIAction("Assert that {name} first column has required element")
    public A cellValue(int colNum, int rowNum, String data) {
        jdiAssert(element().getCell(colNum, rowNum).getText(), Matchers.is(data));
        return (A) this;
    }

    @JDIAction("Assert that {name} first column has required element")
    public A columnHasValue(int colNum, String data) {
        jdiAssert(element().getColumn(colNum).get(data).getText(), Matchers.is(data));
        return (A) this;
    }

    @JDIAction("Assert that {name} column has title")
    public A columnTitle(int colNum, String reqTitle) {
        jdiAssert(element().columnTitle(colNum), Matchers.is(reqTitle));
        return (A) this;
    }

    @JDIAction("Assert that {name} has {0} height")
    public A height(int height) {
        jdiAssert(element().height(), Matchers.is(height));
        return (A) this;
    }
}
