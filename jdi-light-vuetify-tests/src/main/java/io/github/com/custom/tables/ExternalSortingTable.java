package io.github.com.custom.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

public class ExternalSortingTable extends DataTable {

    @JDIAction("Sort {name}  with button by value in ascending order")
    public void sortWithButtonAsc(int elNum) {
        headerUI().select(elNum);
        while (headerUI().get(elNum).attr("aria-sort").equalsIgnoreCase("ascending")) {
            find("//span[contains(text(), 'Toggle sort order')]").click();
        }
    }

    @JDIAction("Sort {name}  with button by value in descending order")
    public void sortWithButtonDesc(int elNum) {
        headerUI().select(elNum);
        while (headerUI().get(elNum).attr("aria-sort").equalsIgnoreCase("descending")) {
            find("//span[contains(text(), 'Toggle sort order')]").click();
        }
    }

    @JDIAction("Sort next {name} column")
    public void sortNextColumn() {
        find("//span[contains(text(), 'Sort next column')]").click();
    }
}
