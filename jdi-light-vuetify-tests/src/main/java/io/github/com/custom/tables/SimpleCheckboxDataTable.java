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
    private List<VueCheckbox> getCheckboxes() {
        return checkboxes;
    }

    @JDIAction("Get random checkbox")
    public VueCheckbox getRandomCheckbox() {
        Random rand = new Random();
        int i = rand.nextInt(getCheckboxes().size());
        return i == 0 ? getCheckboxes().get(i + 1) : getCheckboxes().get(i);
    }
}
