package io.github.com.custom.asserts;

import com.epam.jdi.light.vuetify.asserts.tables.DataTableAssert;
import io.github.com.custom.tables.DataTableLoadingLine;

public class DataTableLoadingLineAssert extends DataTableAssert {

    @Override
    public DataTableLoadingLine element() {
        return (DataTableLoadingLine) super.element();
    }

    @Override
    public DataTableLoadingLineAssert is() {
        return (DataTableLoadingLineAssert) super.is();
    }
}
