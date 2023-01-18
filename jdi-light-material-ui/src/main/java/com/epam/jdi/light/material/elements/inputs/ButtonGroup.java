package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIListBase;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.material.asserts.inputs.ButtonGroupAssert;
import com.epam.jdi.light.ui.html.elements.common.Button;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Represents button group MUI component on GUI.
 *
 * @see <a href="https://mui.com/components/button-group/">Button group MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class ButtonGroup extends UIListBase<ButtonGroupAssert> {

    /**
     * Gets specific button of this button group using its index.
     *
     * @param index index of button to be found
     * @return button of this button group as {@link Button}
     */
    @JDIAction("Get button with index '{0}'")
    public Button button(int index) {
        return castToButton(get(index));
    }

    /**
     * Gets specific button of this button group using its text (full equality is used by searching).
     *
     * @param text full text content of button to be found
     * @return button of this button group as {@link Button}
     */
    @JDIAction("Get button with text '{0}'")
    public Button button(String text) {
        return castToButton(get(text));
    }

    /**
     * Gets all buttons of this button group.
     *
     * @return all buttons of this button group as {@link List}
     */
    @JDIAction("Get all buttons in '{name}'")
    public List<Button> getAllButtons() {
        return list().stream().map(this::castToButton).collect(Collectors.toList());
    }

    private Button castToButton(UIElement element) {
        return new Button().setCore(Button.class, element);
    }

    @Override
    public ButtonGroupAssert is() {
        return new ButtonGroupAssert().set(this);
    }
}
