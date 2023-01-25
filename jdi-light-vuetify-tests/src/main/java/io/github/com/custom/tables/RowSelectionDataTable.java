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

    @UI("tbody>tr i")
    private List<TableCheckbox> tableCheckboxes;

    @JDIAction("Get header checkbox for color check")
    public VueCheckbox headerCheckboxForCheckColor() {
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

    @JDIAction("Click on header checkbox")
    public void clickOnTheHeaderCheckbox() {
        headerCheckbox().core().click();
    }
}
