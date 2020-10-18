package com.epam.jdi.light.asserts.generic.table;

import com.epam.jdi.light.asserts.generic.JAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.complex.table.IGrid;
import com.epam.jdi.light.elements.complex.table.Line;
import com.epam.jdi.tools.func.JFunc1;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.util.Collection;
import java.util.List;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;
import static com.epam.jdi.light.asserts.generic.table.IGridAssert.CompareType.*;
import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.*;
import static java.lang.String.format;
import static org.hamcrest.Matchers.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class IGridAssert<D, T extends IGrid<D>, A extends IGridAssert<D, T, A>> extends UIAssert<A, T> {
    protected T grid() {
        return element();
    }
    public IGridAssert(T grid) { set(grid); }
    /**
     * Check that the table is empty
     */
    @JDIAction("Assert is '{name}' empty")
    public A empty() {
        jdiAssert(grid().isEmpty() ? "is empty" : "is not empty", Matchers.is("is empty"));
        return (A) this;
    }

    /**
     * Check that the table isn't empty
     */
    @JDIAction("Assert is '{name}' not empty")
    public A notEmpty() {
        jdiAssert(grid().isEmpty() ? "is empty" : "is not empty", Matchers.is("is not empty"));
        return (A) this;
    }

    /**
     * Match passed value with table size
     * @param condition to compare
     */
    @JDIAction("Assert that '{name}' size '{0}'")
    public A size(Matcher<Integer> condition) {
        jdiAssert(grid().count(), condition);
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
        jdiAssert(grid().header(), hasItem(column));
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
        jdiAssert(grid().header(), condition);
        return (A) this;
    }

    @JDIAction("Assert that '{name}' row '{0}' equals to other row")
    public A rowVisualValidation(String rowName, Line row) {
        jdiAssert(grid().row(rowName).visualCompareTo(row), Matchers.is(true));
        return (A) this;
    }
    private Line findRow(List<Line> rows, String name, String columnName) {
        Line line = first(rows, l -> l.get(columnName).equals(name));
        if (line == null)
            throw exception("Can't find %s row with column %s", name, columnName);
        return line;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in ascending order")
    public A sortedByAsc(String columnName) {
        List<String> column = grid().webColumn(columnName).values();
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1), column.get(i), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in descending order")
    public A sortedByDesc(String columnName) {
        List<String> column = grid().webColumn(columnName).values();
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i), column.get(i-1), true, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in ascending order")
    public A sortedNumByAsc(String columnName) {
        List<String> column = map(grid().webColumn(columnName).values(), el -> el.replaceAll("[^0-9.,]", ""));
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i-1), column.get(i), true, false))
                jdiAssert("Table is not by ascending at "+i+" row", Matchers.is(""));
        return (A)this;
    }
    @JDIAction("Assert that '{name}' is sorted by '{0}' in descending order")
    public A sortedNumByDesc(String columnName) {
        List<String> column = map(grid().webColumn(columnName).values(), el -> el.replaceAll("[^0-9.,+\\-]", ""));
        for (int i = 1; i < column.size(); i++)
            if (!isSorted(column.get(i), column.get(i-1), true, false))
                jdiAssert("Table is not by descending at "+i+" row", Matchers.is(""));
        return (A)this;
    }

     private Class<?> cl;
     public A data(Class<?> cl) {
         this.cl = cl;
         return (A) this;
     }

     public Compare exact(int count) {
         return new Compare(count, (A) this, EXACT);
     }
     public Compare atLeast(int count) {
         return new Compare(count, (A) this, ATLEAST);
     }
     public Compare no() {
         return exact(0);
     }
     public Compare all() {
         return new Compare((A) this);
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
         A dtAssert;
         CompareType compareType;
         public JDIBase base() { return this.base(); }

         private Compare(A dtAssert) {
             this.dtAssert = dtAssert;
             this.compareType = ALL;
             this.printText = "all rows";
             this.name = dtAssert.name;
         }
         private Compare(int count, A dtAssert, CompareType compareType) {
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
         public A rows(JFunc1<D, Boolean> condition) {
             switch (compareType) {
                 case EXACT:
                     jdiAssert(grid().filter(condition), hasSize(count));
                     break;
                 case ALL:
                     jdiAssert(grid().all(condition), Matchers.is(true));
                     break;
                 case ATLEAST:
                     jdiAssert(grid().filter(condition), hasSize(greaterThanOrEqualTo(count)));
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
         public A rows(D data) {
             return rows(d -> d.equals(data));
         }
         public A row(JFunc1<D,Boolean> condition) {
             return rows(condition);
         }
         public A row(D data) {
             return rows(data);
         }
     }
}
