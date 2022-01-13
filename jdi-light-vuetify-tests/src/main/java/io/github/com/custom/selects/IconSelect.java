package io.github.com.custom.selects;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.Select;

public class IconSelect extends Select {

    protected String iconLocator = "//div[contains(@class, 'outer')]//div[contains(@class, 'v-input__icon')]";

    public UIElement icon() {
        return core().find(iconLocator);
    }
}
