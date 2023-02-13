package io.github.com.custom.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

import java.util.List;

public class SimpleCheckboxDataTable extends DataTable {

    @UI("td i")
    private List<VueCheckbox> checkboxes;

    @JDIAction("Get all checkboxes")
    public List<VueCheckbox> checkboxes() {
        return checkboxes;
    }
}
