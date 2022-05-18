package io.github.com.custom.bars;

import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import io.github.com.custom.textfields.IconTextField;

public class ToolbarWithSearch extends ToolBar {

    public IconTextField searchField() {
        return new IconTextField().setCore(IconTextField.class, find(".v-text-field"));
    }
}
