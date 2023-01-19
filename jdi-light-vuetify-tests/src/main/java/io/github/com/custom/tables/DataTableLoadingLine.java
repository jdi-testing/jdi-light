package io.github.com.custom.tables;

import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;
import io.github.com.custom.asserts.DataTableLoadingLineAssert;

public class DataTableLoadingLine extends DataTable {

    @Override
    public DataTableLoadingLineAssert is() {
        return (DataTableLoadingLineAssert) new DataTableLoadingLineAssert().set(this);
    }
}
