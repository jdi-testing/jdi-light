package io.github.com.custom.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Input;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

public class ExternalPaginationTable extends UIElement {

    @UI(".v-input")
    Input itemPerPageInput;

    @UI(".v-data-table")
    public DataTable dataTable;

    @JDIAction("Switch {name} to page number {0}")
    public void goToPage(int pageNum) {
        find(String.format(".v-pagination__item[aria-label*='%d']", pageNum)).click();
    }

    @JDIAction("Switch {name} to the next page")
    public void nextPage() {
        find(".v-pagination__navigation[aria-label*='Next']").click();
    }

    @JDIAction("Switch {name} to the previous page")
    public void previousPage() {
        find(".v-pagination__navigation[aria-label*='Previous']").click();
    }

    @JDIAction("Show required items value in {name}")
    public void itemsPerPage(String value) {
        itemPerPageInput.text(value);
    }
}
