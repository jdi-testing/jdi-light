package io.github.com.custom.tables;

import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.vuetify.elements.common.Chip;
import com.epam.jdi.light.vuetify.elements.complex.tables.DataTable;

import java.util.List;

public class ItemDataTable extends DataTable {
    @UI(".v-chip")
    private List<Chip> chips;

    public List<Chip> getChips() {return chips;}

    public String getColor(int calories) {
        if (calories > 400) {return "red";}
        else if (calories >= 200) {return "orange";}
        else return "green";
    }
}
