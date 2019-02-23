package com.epam.jdi.light.asserts;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.complex.table.DataTable;
import com.epam.jdi.tools.func.JFunc1;

import java.util.ArrayList;
import java.util.List;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.tools.LinqUtils.map;
import static com.epam.jdi.tools.PrintUtils.print;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class DataTableAssert<D> extends TableAssert {
    private DataTable<?,D> getTable() { return (DataTable<?,D>) table; }
    public DataTableAssert(DataTable<?,D> table) {
        super(table);
    }
    @JDIAction("Assert that '{name}' has rows that meet expected condition")
    public DataTableAssert row(JFunc1<D,Boolean> condition) {
        assertThat(getTable().data(condition), not(nullValue()));
        return this;
    }
    @JDIAction("Assert that '{name}' has {0}")
    public DataTableAssert row(D data) {
        return row(d -> d.equals(data));
    }
    public class Exact {
        public int count;
        DataTableAssert dtAssert;
        public boolean exact;
        private Exact(int count, DataTableAssert dtAssert, boolean exact) {
            this.count = count;
            this.dtAssert = dtAssert;
            this.exact = exact;
        }
        @JDIAction("Assert that '{name}' has '{count}' rows that meet expected condition")
        public DataTableAssert rows(JFunc1<D,Boolean> condition) {
            assertThat(exact
                ? getTable().datas(condition)
                : getTable().datas(condition, count),
            hasSize(count));
            return dtAssert;
        }
        @JDIAction("Assert that '{name}' at least '{count}' '{0}'")
        public DataTableAssert rows(D data) {
            return rows(d -> d.equals(data));
        }
    }
    @JDIAction("Assert that '{name}' has '{0}' rows that meet expected condition")
    public Exact exact(int count) {
        return new Exact(count, this, true);
    }
    @JDIAction("Assert that '{name}' has '{0}' rows that meet expected condition")
    public Exact atLeast(int count) {
        return new Exact(count, this, false);
    }
    @JDIAction("Assert that all '{name}' rows meet expected condition")
    public DataTableAssert allRows(JFunc1<D,Boolean> condition) {
        List<D> data = getTable().allData();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++)
            if (!condition.execute(data.get(i)))
                result.add(i+1);
        if (result.size() > 0)
            throw exception("Rows [%s] of the '%s' table doesn't match expected condition",
                    print(map(result, Object::toString)), name);
        return this;
    }
    @JDIAction("Assert that all '{name}' rows meet expected condition")
    public DataTableAssert noRows(JFunc1<D,Boolean> condition) {
        return allRows(d -> !condition.execute(d));
    }
}
