package com.epam.jdi.light.elements.complex.table;

import com.epam.jdi.light.asserts.generic.table.TableAssert;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.elements.interfaces.base.HasValue;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class Table extends BaseTable<Table, TableAssert> implements ISetup, HasValue {
    @Override
    public TableAssert is() {
        return new TableAssert().set(this);
    }
}
