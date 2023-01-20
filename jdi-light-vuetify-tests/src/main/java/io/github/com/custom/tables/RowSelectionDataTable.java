package io.github.com.custom.tables;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

public class RowSelectionDataTable extends DataTable {

    @UI("th i[class*='checkbox']")
    private Checkbox headerCheckbox;

    public Checkbox getHeaderCheckbox() {
        return headerCheckbox;
    }
}
