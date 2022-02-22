package io.github.com.custom.bars;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;

public class ToolbarWithSearch extends ToolBar {

    public TextField searchField() {
        return new TextField().setCore(TextField.class, find(".v-text-field"));
    }
}
