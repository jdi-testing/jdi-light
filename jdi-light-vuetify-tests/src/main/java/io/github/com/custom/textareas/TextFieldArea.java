package io.github.com.custom.textareas;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.vuetify.elements.complex.TextArea;

import static com.epam.jdi.light.logger.LogLevels.DEBUG;

public class TextFieldArea extends TextArea {
    protected String TEXT_AREA = ".v-input__slot input";

    @JDIAction(value = "Get '{name}' textarea", level = DEBUG)
    public UIElement textArea() {
        return core().find(TEXT_AREA);
    }
}
