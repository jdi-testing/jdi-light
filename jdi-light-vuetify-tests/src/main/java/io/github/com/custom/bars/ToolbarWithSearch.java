package io.github.com.custom.bars;

import com.epam.jdi.light.vuetify.elements.complex.TextField;
import com.epam.jdi.light.vuetify.elements.complex.bars.ToolBar;
import com.epam.jdi.light.vuetify.elements.complex.textfields.IconEventTextField;

public class ToolbarWithSearch extends ToolBar {

    public IconEventTextField searchField() {
        return new IconEventTextField().setCore(IconEventTextField.class, find(".v-text-field"));
    }
}
