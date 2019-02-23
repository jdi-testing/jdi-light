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
    public DataTableAssert hasRow(JFunc1<D,Boolean> condition) {
        assertThat(getTable().data(condition), not(nullValue()));
        return this;
    }
    @JDIAction("Assert that '{name}' has '{0}' rows that meet expected condition")
    public DataTableAssert hasExactRows(int count, JFunc1<D,Boolean> condition) {
        assertThat(getTable().datas(condition), hasSize(count));
        return this;
    }
    @JDIAction("Assert that all '{name}' rows meet expected condition")
    public DataTableAssert allRows(JFunc1<D,Boolean> condition) {
        List<D> data = getTable().datas();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < data.size(); i++)
            if (!condition.execute(data.get(i)))
                result.add(i+1);
        if (result.size() > 0)
            throw exception("Rows [%s] of the '%s' table doesn't match expected condition",
                    print(map(result, Object::toString)), name);
        return this;
    }
}
