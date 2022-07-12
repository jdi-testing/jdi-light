package io.github.com.custom.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;
import org.openqa.selenium.Keys;

public class ExternalPaginationTable extends DataTable {


    @JDIAction("Show required items value in {name}")
    public void itemsPerPage(String value) {
        UIElement input = find("input");
        while (input.isNotEmpty()) {
            input.sendKeys(Keys.BACK_SPACE);
        }
        input.sendKeys(value);
    }

    @JDIAction("Switch {name} to the first page")
    public void firstPage() {
        find("button[aria-label='Goto Page 1']").click();
    }

    @JDIAction("Switch {name} to the second page")
    public void secondPage() {
        find("button[aria-label='Goto Page 2']").click();
    }
}
