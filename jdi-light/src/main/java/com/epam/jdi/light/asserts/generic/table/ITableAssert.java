package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.Column;
import com.epam.jdi.light.elements.complex.table.IGrid;
import com.epam.jdi.light.elements.complex.table.Line;
import com.epam.jdi.tools.LinqUtils;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.isSorted;
import static com.epam.jdi.tools.LinqUtils.map;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class ITableAssert<T extends IGrid, A extends ITableAssert<?,?>> extends UIAssert<A, T> {
    protected T table() {
        return element();
    }
    /**
     * Check that the table is empty
     */
    @JDIAction("Assert is '{name}' empty")
    public A empty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return (A) this;
    }

    /**
     * Check that the table isn't empty
     */
    @JDIAction("Assert is '{name}' not empty")
    public A notEmpty() {
        jdiAssert(table().isEmpty() ? "is empty" : "is not empty", Matchers.is("is not empty"));
        return (A) this;
    }

    /**
     * Match passed value with table size
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' size '{0}'")
    public A size(Matcher<Integer> condition) {
        jdiAssert(table().count(), condition);
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
        jdiAssert(table().header(), hasItem(column));
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
        jdiAssert(table().header(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' row '{0}' equals to other row")
    public A rowVisualValidation(String rowName, Line row) {
        jdiAssert(table().row(rowName).visualCompareTo(row), Matchers.is(true));
        return (A) this;
    }
    private Line findRow(List<Line> rows, String name, String columnName) {
        Line line = LinqUtils.first(rows, l -> l.get(columnName).equals(name));
        if (line == null)
            throw exception("Can't find %s row with column %s", name, columnName);
        return line;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in ascending order")
    public A sortedByAsc(String columnName) {
        List<String> column = table().webColumn(columnName).values();
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1), column.get(i), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in descending order")
    public A sortedByDesc(String columnName) {
        List<String> column = table().webColumn(columnName).values();
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i), column.get(i-1), true, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in ascending order")
    public A sortedNumByAsc(String columnName) {
        List<String> column = map(table().webColumn(columnName).values(), el -> el.replaceAll("[^0-9.,]", ""));
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1), column.get(i), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in descending order")
    public A sortedNumByDesc(String columnName) {
        List<String> column = map(table().webColumn(columnName).values(), el -> el.replaceAll("[^0-9.,+\\-]", ""));
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i), column.get(i-1), true, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return (A)this;
    }

    // private Class<?> cl;
    // public A data(Class<?> cl) {
    //     this.cl = cl;
    //     return (A) this;
    // }
//
    // public Compare exact(int count) {
    //     return new Compare(count, (A) this, EXACT);
    // }
    // public Compare atLeast(int count) {
    //     return new Compare(count, (A) this, ATLEAST);
    // }
    // public Compare no() {
    //     return exact(0);
    // }
    // public Compare all() {
    //     return new Compare((A) this);
    // }
    // public Compare onlyOne() {
    //     return exact(1);
    // }
//
    // public enum CompareType {
    //     EXACT("exactly"), ATLEAST("at least"), ALL("all");
    //     public String text;
    //     CompareType(String text) { this.text = text; }
    // }
//
    // public class Compare implements JAssert {
    //     public int count;
    //     public String name;
    //     public String printText;
    //     A dtAssert;
    //     CompareType compareType;
    //     public JDIBase base() { return this.base(); }
//
    //     private Compare(A dtAssert) {
    //         this.dtAssert = dtAssert;
    //         this.compareType = ALL;
    //         this.printText = "all rows";
    //         this.name = dtAssert.name;
    //     }
    //     private Compare(int count, A dtAssert, CompareType compareType) {
    //         this.count = count;
    //         this.dtAssert = dtAssert;
    //         this.compareType = compareType;
    //         this.printText = format("has %s %s rows that", compareType.text, count);
    //         this.name = dtAssert.name;
    //     }
//
    //     /**
    //      * Check that the table has rows that meet expected condition
    //      * @param condition to compare
    //      * @return DataTableAssert
    //      */
    //     @JDIAction("Assert that '{name}' {printText} meet expected condition")
    //     public <D> A rows(JFunc1<?, Boolean> condition) {
    //         switch (compareType) {
    //             case EXACT:
    //                 jdiAssert(table().rows(cl, condition), hasSize(count));
    //                 break;
    //             case ALL:
    //                 List<D> rows = table().allData();
    //                 jdiAssert(LinqUtils.all(rows, condition), Matchers.is(true));
    //                 break;
    //             case ATLEAST:
    //                 jdiAssert(table().dataRows(condition, count), hasSize(count));
    //                 break;
    //         }
    //         return dtAssert;
    //     }
//
    //     /**
    //      * Check that the table has rows that have expected data
    //      * @param data to compare
    //      * @return DataTableAssert
    //      */
    //     @JDIAction("Assert that '{name}' {printText} has '{0}'")
    //     public A rows(D data) {
    //         return rows(d -> d.equals(data));
    //     }
    //     public A row(JFunc1<D,Boolean> condition) {
    //         return rows(condition);
    //     }
    //     public A row(D data) {
    //         return rows(data);
    //     }
    // }
}
