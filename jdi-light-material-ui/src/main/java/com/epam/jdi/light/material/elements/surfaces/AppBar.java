package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.inputs.TextField;
import com.epam.jdi.light.ui.html.elements.common.Text;

/**
 * Represents app bar MUI component on GUI. The app bar displays information and actions relating to the current screen.
 *
 * @see <a href="https://mui.com/components/app-bar/">App bar MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class AppBar extends Section {

    /**
     * Gets buttons.
     *
     * @return buttons as {@link ButtonGroup}
     */
    @JDIAction(value = "Get '{name}' navigation button")
    public ButtonGroup buttons() {
        return new ButtonGroup().setCore(ButtonGroup.class, this.core());
    }

    /**
     * Gets a title.
     *
     * @return title as {@link Text}
     */
    @JDIAction(value = "Get '{name}' title")
    public Text title() {
        return new Text().setCore(Text.class, core().find(".MuiTypography-root"));
    }

    /**
     * Gets an input - search text field.
     *
     * @return input as {@link TextField}
     * @throws RuntimeException AppBar does not have text field
     */
    @JDIAction(value = "Get '{name}' title")
    public TextField input() {
        return new TextField().setCore(TextField.class, core().find(".MuiInputBase-root"));
    }
}
