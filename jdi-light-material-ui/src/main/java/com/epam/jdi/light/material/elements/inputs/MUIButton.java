package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.interfaces.CanBeDisabled;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Image;
import com.epam.jdi.light.ui.html.interfaces.HasImage;

public class MUIButton extends Button
        implements HasIcon, HasLabel, HasImage, CanBeDisabled {

    private String labelLocator = ".MuiButton-label";

    /**
     * Gets MUIButton's label
     *
     * @return text as {@link Label}
     */
    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return new Label().setCore(Label.class, core().find(labelLocator));
    }

    /**
     * Gets complex button's background image element
     *
     * @return image element as {@link Image}
     */
    @Override
    public String imageLocator() {
        return "//*[contains(@style, 'background-image')]";
    }

    /**
     * Gets complex button's text
     *
     * @return text as {@link Typography}
     */
    @JDIAction("Get '{name}' typography")
    public Typography typography() {
        return new Typography().setCore(Typography.class, core().find(".MuiTypography-root"));
    }

    @Override
    public boolean isDisabled() {
        return core().hasClass("Mui-disabled");
    }

    @Override
    public boolean isEnabled() {
        return !this.isDisabled();
    }
}
