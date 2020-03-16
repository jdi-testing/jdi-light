package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.asserts.generic.JAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.complex.table.*;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.epam.jdi.light.elements.interfaces.composite.PageObject;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.*;
import static com.epam.jdi.light.asserts.generic.table.DataTableAssert.CompareType.*;
import static com.epam.jdi.light.elements.complex.table.TableMatcher.*;
import static com.epam.jdi.tools.LinqUtils.*;
import static java.lang.String.*;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class DataTableAssert<L extends PageObject, D>
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
        jdiAssert(condition.execute(table().dataRow(row.getIndex(table().header()))), Matchers.is(true));
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
        jdiAssert(actual, Matchers.is(expected));
        return this;
    }
    @JDIAction("Assert that '{name}' rows {0}")
    public DataTableAssert<L, D> rows(Matcher<? super List<D>> condition) {
        jdiAssert(table().allData(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted by ascending")
    public <C extends HasValue> DataTableAssert<L, D> sortedByAsc(String columnName, JFunc1<UIElement, Object> getValue) {
        WebList column = table().webColumn(columnName);
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(getValue.execute(column.get(i-1)), getValue.execute(column.get(i)), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted by descending")
    public <C extends HasValue> DataTableAssert<L, D> sortedByDesc(String columnName, JFunc1<UIElement, Object> getValue) {
        WebList column = table().webColumn(columnName);
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(getValue.execute(column.get(i-1)), getValue.execute(column.get(i)), false, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted by ascending")
    public <C extends HasValue> DataTableAssert<L, D> sortedByAsc(String columnName, Class<C> cl) {
        List<C> column = table().columnValues(columnName, cl);
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1).getValue(), column.get(i).getValue(), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted by descending")
    public <C extends HasValue> DataTableAssert<L, D> sortedByDesc(String columnName, Class<C> cl) {
        List<C> column = table().columnValues(columnName, cl);
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1).getValue(), column.get(i).getValue(), false, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted")
    public DataTableAssert<L, D> sortedBy(JFunc2<L, L,Boolean> condition) {
        List<L> allRows = table().allLines();
        for (int i = 1; i < allRows.size(); i++)
            if (!condition.execute(allRows.get(i-1), allRows.get(i)))
                jdiAssert("Table is not sorted at "+i+" row", Matchers.is(""));
        jdiAssert("Table is sorted", Matchers.is("Table is sorted"));
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted")
    public DataTableAssert<L, D> dataSortedBy(JFunc2<D, D,Boolean> condition) {
        List<D> allRows = table().allData();
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
        DataTableAssert<L, D> dtAssert;
        CompareType compareType;
        public JDIBase base() { return DataTableAssert.this.base(); }

        private Compare(DataTableAssert<L, D> dtAssert) {
            this.dtAssert = dtAssert;
            this.compareType = ALL;
            this.printText = "all rows";
            this.name = dtAssert.name;
        }
        private Compare(int count, DataTableAssert<L, D> dtAssert, CompareType compareType) {
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
        public DataTableAssert<L, D> rows(JFunc1<D, Boolean> condition) {
            switch (compareType) {
                case EXACT:
                    jdiAssert(table().dataRows(condition), hasSize(count));
                    break;
                case ALL:
                    List<D> rows = table().allData();
                    jdiAssert(LinqUtils.all(rows, condition), Matchers.is(true));
                    break;
                case ATLEAST:
                    jdiAssert(table().dataRows(condition, count), hasSize(count));
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
        public DataTableAssert<L, D> rows(D data) {
            return rows(d -> d.equals(data));
        }

        /**
         * Make sure that the table has at least a certain number of the specified line
         * @param matchers to compare
         */
        @JDIAction("Assert that '{name}' {printText} has {0}")
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
