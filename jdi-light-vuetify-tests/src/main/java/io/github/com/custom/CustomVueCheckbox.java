package io.github.com.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.VueCheckbox;

public class CustomVueCheckbox extends VueCheckbox {

    public UIElement message() {
        return core().find(".v-messages__message");
    }
}
