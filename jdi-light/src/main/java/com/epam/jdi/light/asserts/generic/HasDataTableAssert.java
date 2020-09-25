package com.epam.jdi.light.asserts.generic;

import com.epam.jdi.light.asserts.generic.table.IDataTableAssert;
import com.epam.jdi.light.elements.complex.table.IGrid;

/**
 * Created by Roman Iovlev on 14.02.2018
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public interface HasDataTableAssert extends IGrid {
    default  <D> IDataTableAssert<D, IGrid, IDataTableAssert<D, IGrid,?>> assertData(Class<D> cl) {
        return new IDataTableAssert<>(cl, this);
    }
}