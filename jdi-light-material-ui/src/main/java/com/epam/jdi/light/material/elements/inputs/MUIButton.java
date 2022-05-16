package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.material.interfaces.displaydata.HasIcon;
import com.epam.jdi.light.ui.html.elements.common.Button;

public class MUIButton extends Button
        implements HasIcon, HasLabel {

    /**
     * Gets MUIButton's label
     *
     * @return text as {@link Label}
     */
    @Override
    @JDIAction("Get '{name}' label")
    public Label label() {
        return new Label().setCore(Label.class, core().find(".MuiButton-label"));
    }
}
