package com.epam.jdi.light.material.elements.displaydata;

import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.ISetup;
import com.epam.jdi.light.material.annotations.JDITable;
import com.epam.jdi.light.material.asserts.displaydata.TableAssert;

import java.lang.reflect.Field;

import static com.epam.jdi.light.elements.pageobjects.annotations.objects.FillFromAnnotationRules.fieldHasAnnotation;
import static com.epam.jdi.light.material.annotations.JDITable.columnNumber;

public class Table extends UIBaseElement<TableAssert> implements ISetup {
    private String rowColumn;

    public UIElement getHeader(int id){
        return this.finds(rowColumn).get(id);
    }

    public UIElement getRowColumn(int idRow, int idColumn){
        return this.finds(rowColumn).get(idRow * columnNumber + idColumn);
    }

    public String getTextOfColumn1(int idRow){
        return this.finds(rowColumn).get(idRow * columnNumber + 2).getText();
    }

    @Override
    public TableAssert is() {
        return new TableAssert().set(this);
    }

    public void setup(Field field) {
        if (!fieldHasAnnotation(field, JDITable.class, Table.class))
            return;
        JDITable j = field.getAnnotation(JDITable.class);
        rowColumn = j.rowColumn();
    }
}
