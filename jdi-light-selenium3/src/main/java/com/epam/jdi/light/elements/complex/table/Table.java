package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.table.TableAssert;
import com.epam.jdi.light.elements.complex.IList;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasValue;
import com.jdiai.tools.LinqUtils;

import java.util.List;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Table extends BaseTable<Table, TableAssert> implements ISetup, HasValue, IList<String> {
    @Override
    public TableAssert is() {
        return new TableAssert().set(this);
    }

    public List<String> elements(int minAmount) {
        return core().timer().getResultByCondition(
            () -> LinqUtils.map(rows(), Line::getValue),
            rows -> rows.size() >= minAmount);
    }
    public String get(String value) {
        return row(value).getValue();
    }
}
