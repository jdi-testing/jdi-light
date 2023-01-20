package com.epam.jdi.light.material.elements.surfaces;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.composite.Section;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.material.elements.inputs.ButtonGroup;
import com.epam.jdi.light.material.elements.utils.enums.MUIColor;
import com.epam.jdi.light.material.elements.utils.enums.Position;
import com.epam.jdi.light.material.interfaces.HasColor;
import com.epam.jdi.light.material.interfaces.HasPosition;
import org.apache.commons.lang3.StringUtils;

/**
 * Represents app bar MUI component on GUI. The app bar displays information and actions relating to the current screen.
 *
 * @see <a href="https://mui.com/components/app-bar/">App bar MUI documentation</a>
 * @see <a href="https://jdi-testing.github.io/jdi-light/material">MUI test page</a>
 */
public class AppBar extends Section implements HasPosition, HasColor {

    @UI(".MuiToolbar-root")
    public UIElement content;

    public <T extends UIElement> T content(Class<T> clazz) {
        return this.content.with(clazz);
    }
    /**
     * Gets the button group with buttons in this app bar.
     *
     * @return button group as {@link ButtonGroup}
     */
    @JDIAction("Get '{name}' button group")
    public ButtonGroup buttonGroup() {
        return new ButtonGroup().setCore(ButtonGroup.class, core().find(".MuiButtonBase-root"));
    }

    @Override
    public Position position() {
        return getPositionFromClass(core(), "MuiAppBar-position");
    }

    public MUIColor color() {
        String stylePrefix = "MuiAppBar-color";
        String expColor = core().classLike(stylePrefix, StringUtils::startsWith);
        if (expColor.isEmpty()) {
            return MUIColor.DEFAULT;
        }
        return MUIColor.fromStyle(expColor, stylePrefix);
    }
}
