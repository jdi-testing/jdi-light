package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.interfaces.common.IsText;
import com.epam.jdi.light.material.elements.displaydata.Typography;
import com.epam.jdi.light.material.interfaces.base.HasImage;
import com.epam.jdi.light.ui.html.elements.common.Image;

public class ComplexMUIButton extends MUIButton
        implements HasImage, IsText {

    @Override
    @JDIAction("Get '{name}' image")
    public Image image() {
        return new Image().setCore(Image.class, find("//*[contains(@style, 'background-image')]"));
    }

    @JDIAction("Get '{name}' typography")
    public Typography typography() {
        return new Typography().setCore(Typography.class, find(".MuiTypography-root"));
    }
}
