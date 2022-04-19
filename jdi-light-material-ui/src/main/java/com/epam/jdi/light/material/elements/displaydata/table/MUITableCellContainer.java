package com.epam.jdi.light.material.elements.displaydata.table;

import com.epam.jdi.light.asserts.generic.HasAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.Exceptions;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;

import java.lang.reflect.Constructor;

public abstract class MUITableCellContainer<A extends UIAssert<?, ?>> extends UIBaseElement<A>
        implements HasAssert<A>  {

    private final int index;

    protected MUITableCellContainer(int index) {
        this.index = index;
    }

    @JDIAction("Get '{name}' index")
    public int index() {
        return index;
    }

    public abstract int size();

    protected <T extends MUITableCell<?>> T createCellInstance(int rowIndex, int columnIndex, Class<T> cellType) {
        try {
            Constructor<T> constructor = cellType.getDeclaredConstructor(int.class, int.class);
            return constructor.newInstance(rowIndex, columnIndex);
        } catch (Exception e) {
            throw Exceptions.runtimeException(e.getMessage());
        }
    }

}
