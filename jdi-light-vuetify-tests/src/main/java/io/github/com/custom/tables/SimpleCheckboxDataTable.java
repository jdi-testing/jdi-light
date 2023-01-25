package io.github.com.custom.tables;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

import java.util.List;
import java.util.Random;

public class SimpleCheckboxDataTable extends DataTable {

    @UI("td i")
    private List<VueCheckbox> checkboxes;

    @JDIAction("Get all checkboxes")
    private List<VueCheckbox> checkboxes() {
        return checkboxes;
    }

    @JDIAction("Get random checkbox")
    public VueCheckbox randomCheckbox() {
        Random rand = new Random();
        int i = rand.nextInt(checkboxes().size());
        return i == 0 ? checkboxes().get(i + 1) : checkboxes().get(i);
    }
}
