package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.asserts.generic.JAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.light.elements.complex.table.Row;
import com.epam.jdi.light.elements.complex.table.TableMatcher;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import org.hamcrest.Matcher;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.TABLE_MATCHER;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataTableAssert<L extends Section, D>
        extends BaseTableAssert<DataTable<L, D>, DataTableAssert<L, D>> {

    /**
     * Check that the table has rows that meet expected condition
     * @param condition to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has rows that meet expected condition")
    public DataTableAssert<L, D> row(JFunc1<D,Boolean> condition) {
        jdiAssert(table().dataRow(condition), not(nullValue()));
        return this;
    }
    @JDIAction("Assert that '{name}' has rows that meet expected condition")
    public DataTableAssert<L, D> value(JFunc1<D,Boolean> condition, Row row) {
        jdiAssert(condition.execute(table().dataRow(row.getIndex(table().header()))), is(true));
        return this;
    }
    /**
     * Check that the table has row that has expected data
     * @param data to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has {0}")
    public DataTableAssert<L, D> row(D data) {
        return row(d -> d.equals(data));
    }
    @JDIAction("Assert that '{name}' has {0}")
    public DataTableAssert<L, D> value(D expected, Row row) {
        D actual = table().dataRow(row.getIndex(table().header()));
        jdiAssert(actual, is(expected));
        return this;
    }
    @JDIAction("Assert that '{name}' rows {0}")
    public DataTableAssert<L, D> rows(Matcher<? super List<D>> condition) {
        jdiAssert(table().allData(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted")
    public DataTableAssert<L, D> sortedBy(JFunc2<L, L,Boolean> condition) {
        List<L> allRows = table().allLines();
        for (int i = 1; i < allRows.size(); i++)
            if (!condition.execute(allRows.get(i-1), allRows.get(i)))
                jdiAssert("Table not sorted at "+i+" row", is(""));
        jdiAssert("Table is sorted", is("Table is sorted"));
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted")
    public DataTableAssert<L, D> dataSortedBy(JFunc2<D, D,Boolean> condition) {
        List<D> allRows = table().allData();
        for (int i = 1; i < allRows.size(); i++)
            if (!condition.execute(allRows.get(i-1), allRows.get(i)))
                jdiAssert("Table not sorted at "+i+" row", is(""));
        jdiAssert("Table is sorted", is("Table is sorted"));
        return this;
    }

    public Compare exact(int count) {
        return new Compare(count, this, true);
    }
    public Compare atLeast(int count) {
        return new Compare(count, this, false);
    }
    public Compare no() {
        return exact(0);
    }
    public Compare all() {
        return exact(table().count());
    }
    public Compare onlyOne() {
        return exact(1);
    }

    public class Compare implements JAssert {

        public int count;
        public String name;
        public String type;
        DataTableAssert<L, D> dtAssert;
        boolean exact;
        public JDIBase base() { return DataTableAssert.this.base(); }

        private Compare(int count, DataTableAssert<L, D> dtAssert, boolean exact) {
            this.count = count;
            this.dtAssert = dtAssert;
            this.exact = exact;
            this.type = exact ? "exactly" : "at least";
            this.name = dtAssert.name;
        }

        /**
         * Check that the table has rows that meet expected condition
         * @param condition to compare
         * @return DataTableAssert
         */
        @JDIAction("Assert that '{name}' has {type} '{count}' rows that meet expected condition")
        public DataTableAssert<L, D> rows(JFunc1<D, Boolean> condition) {
            jdiAssert(exact
                ? table().dataRows(condition)
                : table().dataRows(condition, count),
            hasSize(count));
            return dtAssert;
        }

        /**
         * Check that the table has rows that have expected data
         * @param data to compare
         * @return DataTableAssert
         */
        @JDIAction("Assert that '{name}' has {type} '{count}' '{0}'")
        public DataTableAssert<L, D> rows(D data) {
            return rows(d -> d.equals(data));
        }

        /**
         * Make sure that the table has at least a certain number of the specified line
         * @param matchers to compare
         */
        @JDIAction("Assert that '{name}' has at least '{0}' rows that {0}")
        public DataTableAssert<L, D> rows(TableMatcher... matchers) {
            jdiAssert(TABLE_MATCHER.execute(table(), matchers).size(),
                    greaterThan(table().header().size()*count-1));
            return dtAssert;
        }
        public DataTableAssert<L, D> row(JFunc1<D,Boolean> condition) {
            return rows(condition);
        }
        public DataTableAssert<L, D> row(D data) {
            return rows(data);
        }
        public DataTableAssert<L, D> row(TableMatcher... matchers) {
            return rows(matchers);
        }
    }
}
