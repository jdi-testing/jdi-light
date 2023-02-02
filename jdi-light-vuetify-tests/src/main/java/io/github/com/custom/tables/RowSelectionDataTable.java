package io.github.com.custom.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.common.TableCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

import java.util.List;

public class RowSelectionDataTable extends DataTable {

    @UI("th")
    private VueCheckbox headerCheckbox;

    @UI("tbody [class*= 'v-simple-checkbox']")
    private List<TableCheckbox> tableCheckboxes;

    @JDIAction("Prepare header checkbox for color check")
    public VueCheckbox prepareHeaderCheckboxForCheckColor() {
        return new VueCheckbox().setCore(VueCheckbox.class, headerCheckbox().find("i[class*='checkbox']"));
    }

    @JDIAction("Get header checkbox")
    public VueCheckbox headerCheckbox() {
        return headerCheckbox;
    }

    @JDIAction("Get all table checkboxes")
    public List<TableCheckbox> getTableCheckboxes() {
        return tableCheckboxes;
    }
}
