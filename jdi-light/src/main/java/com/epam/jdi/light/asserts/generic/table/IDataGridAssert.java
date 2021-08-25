package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.asserts.generic.JAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.table.IDataGrid;
import com.epam.jdi.light.elements.complex.table.Row;
import com.epam.jdi.tools.LinqUtils;
import com.epam.jdi.tools.func.JFunc1;
import com.epam.jdi.tools.func.JFunc2;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.asserts.generic.table.IDataGridAssert.CompareType.*;
import static com.epam.jdi.tools.LinqUtils.isSorted;
import static com.epam.jdi.tools.StringUtils.format;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class IDataGridAssert<D, T extends IDataGrid<?, D>, A extends IDataGridAssert<D, T, A>> extends UIAssert<A, T> {
    public T dataGrid() {
        return element();
    }
    public IDataGridAssert(T grid) {
        set(grid);
    }

    /**
     * Check that the table is empty
     */
    @JDIAction("Assert is '{name}' empty")
    public A empty() {
        jdiAssert(dataGrid().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return (A) this;
    }

    /**
     * Check that the table isn't empty
     */
    @JDIAction("Assert is '{name}' not empty")
    public A notEmpty() {
        jdiAssert(dataGrid().isEmpty() ? "is empty" : "is not empty", Matchers.is("is not empty"));
        return (A) this;
    }

    /**
     * Match passed value with table size
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' size '{0}'")
    public A size(Matcher<Integer> condition) {
        jdiAssert(dataGrid().count(), condition);
        return (A) this;
    }

    /**
     * Match passed value with table size
     * @param size to compare
     */
    @JDIAction("Assert that '{name}' size '{0}'")
    public A size(int size) {
        return size(Matchers.is(size));
    }

    /**
     * Check that the table has the specified column
     * @param column to compare
     */
    @JDIAction("Assert that '{name}' has column'{0}'")
    public A column(String column) {
        jdiAssert(dataGrid().header(), hasItem(column));
        return (A) this;
    }

    /**
     * Check that the table has the specified columns
     * @param columns to compare
     */
    @JDIAction("Assert that '{name}' has columns '{0}'")
    public A columns(List<String> columns) {
        for(String column : columns)
            column(column);
        return (A) this;
    }

    /**
     * Match passed value with table columns
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' columns '{0}'")
    public A columns(Matcher<Collection<? extends String>> condition) {
        jdiAssert(dataGrid().header(), condition);
        return (A) this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in ascending order")
    public A sortedByAsc(String columnName) {
        List<String> column = dataGrid().webColumn(columnName).values();
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1), column.get(i), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in descending order")
    public A sortedByDesc(String columnName) {
        List<String> column = dataGrid().webColumn(columnName).values();
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i), column.get(i-1), true, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in ascending order")
    public A sortedNumByAsc(String columnName) {
        List<String> column = LinqUtils.map(dataGrid().webColumn(columnName).values(), el -> el.replaceAll("[^0-9.,]", ""));
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1), column.get(i), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in descending order")
    public A sortedNumByDesc(String columnName) {
        List<String> column = LinqUtils.map(dataGrid().webColumn(columnName).values(), el -> el.replaceAll("[^0-9.,+\\-]", ""));
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i), column.get(i-1), true, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    /**
     * Check that the table has rows that meet expected condition
     * @param condition to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has at least one row that meet expected condition")
    public IDataGridAssert<D, T, A> row(JFunc1<D, Boolean> condition) {
        D firstRow = LinqUtils.first(dataGrid().allData(), condition);
        jdiAssert(firstRow, not(nullValue()));
        return this;
    }
    @JDIAction("Assert that '{name}' has at least one that meet expected condition")
    public IDataGridAssert<D, T, A> value(JFunc1<D,Boolean> condition, Row row) {
        D actual = dataGrid().data(row.getIndex(dataGrid().header(), dataGrid().getStartIndex()));
        jdiAssert(condition.execute(actual), Matchers.is(true));
        return this;
    }
    /**
     * Check that the table has row that has expected data
     * @param data to compare
     * @return DataTableAssert
     */
    @JDIAction("Assert that '{name}' has {0}")
    public IDataGridAssert<D, T, A> row(D data) {
        return row(d -> d.equals(data));
    }
    @JDIAction("Assert that '{name}' has {0}")
    public IDataGridAssert<D, T, A> value(D expected, Row row) {
        return value(d-> d.equals(expected), row);
    }
    @JDIAction("Assert that '{name}' rows {0}")
    public IDataGridAssert<D, T, A> rows(Matcher<? super List<D>> condition) {
        jdiAssert(dataGrid().allData(), condition);
        return this;
    }
    @JDIAction("Assert that '{name}' is sorted")
    public IDataGridAssert<D, T, A> dataSortedBy(JFunc2<D, D,Boolean> condition) {
        List<D> allRows = dataGrid().allData();
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
    public Compare moreThan(int count) {
        return atLeast(count + 1);
    }
    public Compare lessThan(int count) {
        return new Compare(count, this, LESSTHAN);
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
        EXACT("exactly"), LESSTHAN("less than"), ATLEAST("at least"), ALL("all");
        public String text;
        CompareType(String text) { this.text = text; }
    }

    public class Compare implements JAssert {

        public int count;
        public String name;
        public String printText;
        IDataGridAssert<D, T, A> dtAssert;
        CompareType compareType;
        public JDIBase base() { return IDataGridAssert.this.base(); }

        private Compare(IDataGridAssert<D, T, A> dtAssert) {
            this.dtAssert = dtAssert;
            this.compareType = ALL;
            this.printText = "all rows";
            this.name = dtAssert.name;
        }
        private Compare(int count, IDataGridAssert<D, T, A> dtAssert, CompareType compareType) {
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
        public IDataGridAssert<D, T, A> rows(JFunc1<D, Boolean> condition) {
            switch (compareType) {
                case EXACT:
                    jdiAssert(dataGrid().dataList(condition), hasSize(count));
                    break;
                case ALL:
                    jdiAssert(dataGrid().dataList(condition), hasSize(dataGrid().count()));
                    break;
                case ATLEAST:
                    jdiAssert(dataGrid().dataList(condition), hasSize(greaterThanOrEqualTo(count)));
                    break;
                case LESSTHAN:
                    jdiAssert(dataGrid().dataList(condition), hasSize(Matchers.lessThan(count)));
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
        public IDataGridAssert<D, T, A> rows(D data) {
            return rows(d -> d.equals(data));
        }

        public IDataGridAssert<D, T, A> row(JFunc1<D,Boolean> condition) {
            return rows(condition);
        }
        public IDataGridAssert<D, T, A> row(D data) {
            return rows(data);
        }
    }
}
