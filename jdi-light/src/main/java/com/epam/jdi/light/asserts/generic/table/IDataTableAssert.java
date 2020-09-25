package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.asserts.generic.JAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.table.IGrid;
import com.epam.jdi.light.elements.complex.table.Row;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.asserts.generic.table.IDataTableAssert.CompareType.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static java.lang.String.format;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class IDataTableAssert<D, T extends IGrid, A extends UIAssert<?,?>> extends UIAssert<A, T> {
    protected T table() {
        return element();
    }
    Class<D> cl;
    public IDataTableAssert(Class<D> cl, T table) {
        this.element = table;
        this.cl = cl;
    } 
    /**
     * Check that the table has rows that meet expected condition
     * @param condition to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has at least one row that meet expected condition")
    public IDataTableAssert<D, T, A> row(JFunc1<D,Boolean> condition) {
        List<D> rows = map(table().rows(), row -> row.asData(cl));
        D firstRow = first(rows, condition);
        jdiAssert(firstRow, not(nullValue()));
        return this;
    }
    @JDIAction("Assert that '{name}' has at least one that meet expected condition")
    public IDataTableAssert<D, T, A> value(JFunc1<D,Boolean> condition, Row row) {
        jdiAssert(condition.execute(table().row(row.getIndex(table().header())).asData(cl)), Matchers.is(true));
        return this;
    }
    /**
     * Check that the table has row that has expected data
     * @param data to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has {0}")
    public IDataTableAssert<D, T, A> row(D data) {
        return row(d -> d.equals(data));
    }
    @JDIAction("Assert that '{name}' has {0}")
    public IDataTableAssert<D, T, A> value(D expected, Row row) {
        D actual = table().row(row.getIndex(table().header())).asData(cl);
        jdiAssert(actual, Matchers.is(expected));
        return this;
    }
    @JDIAction("Assert that '{name}' rows {0}")
    public IDataTableAssert<D, T, A> rows(Matcher<? super List<D>> condition) {
        jdiAssert(map(table().rows(), row -> row.asData(cl)), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted")
    public IDataTableAssert<D, T, A> dataSortedBy(JFunc2<D, D,Boolean> condition) {
        List<D> allRows = map(table().rows(), row -> row.asData(cl));
        for (int i = 1; i < allRows.size(); i++)
            if (!condition.execute(allRows.get(i-1), allRows.get(i)))
                jdiAssert("Table is not sorted at "+i+" row", Matchers.is(""));
        jdiAssert("Table is sorted", Matchers.is("Table is sorted"));
        return this;
    }

    public Compare exact(int count) {
        return new Compare(count, this, EXACT);
    }
    public Compare atLeast(int count) {
        return new Compare(count, this, ATLEAST);
    }
    public Compare no() {
        return exact(0);
    }
    public Compare all() {
        return new Compare(this);
    }
    public Compare onlyOne() {
        return exact(1);
    }

    public enum CompareType {
        EXACT("exactly"), ATLEAST("at least"), ALL("all");
        public String text;
        CompareType(String text) { this.text = text; }
    }

    public class Compare implements JAssert {

        public int count;
        public String name;
        public String printText;
        IDataTableAssert<D, T, A> dtAssert;
        CompareType compareType;
        public JDIBase base() { return IDataTableAssert.this.base(); }

        private Compare(IDataTableAssert<D, T, A> dtAssert) {
            this.dtAssert = dtAssert;
            this.compareType = ALL;
            this.printText = "all rows";
            this.name = dtAssert.name;
        }
        private Compare(int count, IDataTableAssert<D, T, A> dtAssert, CompareType compareType) {
            this.count = count;
            this.dtAssert = dtAssert;
            this.compareType = compareType;
            this.printText = format("has %s %s rows that", compareType.text, count);
            this.name = dtAssert.name;
        }

        /**
         * Check that the table has rows that meet expected condition
         * @param condition to compare
         * @return DataTableAssert
         */
        @JDIAction("Assert that '{name}' {printText} meet expected condition")
        public IDataTableAssert<D, T, A> rows(JFunc1<D, Boolean> condition) {
            List<D> allRows = map(table().rows(), row -> row.asData(cl));
            switch (compareType) {
                case EXACT:
                    jdiAssert(filter(allRows, condition), hasSize(count));
                    break;
                case ALL:
                    jdiAssert(LinqUtils.all(allRows, condition), Matchers.is(true));
                    break;
                case ATLEAST:
                    jdiAssert(filter(allRows, condition), hasSize(greaterThanOrEqualTo(count)));
                    break;
            }
            return dtAssert;
        }

        /**
         * Check that the table has rows that have expected data
         * @param data to compare
         * @return DataTableAssert
         */
        @JDIAction("Assert that '{name}' {printText} has '{0}'")
        public IDataTableAssert<D, T, A> rows(D data) {
            return rows(d -> d.equals(data));
        }

        public IDataTableAssert<D, T, A> row(JFunc1<D,Boolean> condition) {
            return rows(condition);
        }
        public IDataTableAssert<D, T, A> row(D data) {
            return rows(data);
        }
    }
}
