package io.github.com.custom.tables;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.ProgressLinear;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

public class LoadingDataTable extends DataTable {

    @UI(".v-progress-linear")
    private ProgressLinear loadingLine;

    public ProgressLinear getLoadingLine() {
        return loadingLine;
    }
}
