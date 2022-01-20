package io.github.com.custom;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.common.Checkbox;

public class CustomCheckbox extends Checkbox {

    public UIElement message() {
        return core().find(".v-messages__message");
    }
}
