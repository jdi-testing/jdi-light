package io.github.com.custom.bars;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import com.epam.jdi.light.vuetify.elements.complex.textfields.IconTextField;

public class ToolbarWithSearch extends ToolBar {

    public IconTextField searchField() {
        return new IconTextField().setCore(IconTextField.class, find(".v-text-field"));
    }
}
