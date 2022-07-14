package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.interfaces.HasImage;
import com.epam.jdi.light.ui.html.elements.common.Image;

public class ComplexMUIButton extends MUIButton
        implements HasImage, IsText {

    /**
     * Gets complex button's background image element
     *
     * @return image element as {@link Image}
     */
    @Override
    @JDIAction("Get '{name}' image")
    public Image image() {
        return new Image().setCore(Image.class, core().find("//*[contains(@style, 'background-image')]"));
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
}
