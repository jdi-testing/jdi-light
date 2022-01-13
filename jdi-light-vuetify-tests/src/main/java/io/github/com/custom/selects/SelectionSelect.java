package io.github.com.custom.selects;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Select;

public class SelectionSelect extends Select {

    public UIElement selection() {
        return core().find(".text-caption");
    }
}
