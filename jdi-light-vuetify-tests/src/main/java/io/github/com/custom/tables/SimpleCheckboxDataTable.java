package io.github.com.custom.tables;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

import java.util.List;
import java.util.Random;

public class SimpleCheckboxDataTable extends DataTable {

    @UI("td i")
    private List<Checkbox> checkboxes;

    private List<Checkbox> getCheckboxes() {
        return checkboxes;
    }

    public Checkbox getCheckedCheckbox() {
        return getCheckboxes().get(1);
    }

    public Checkbox getUncheckedCheckbox() {
        return getCheckboxes().get(2);
    }

    public Checkbox getRandomCheckbox() {
        Random rand = new Random();
        return getCheckboxes().get(rand.nextInt(getCheckboxes().size()));
    }
}
