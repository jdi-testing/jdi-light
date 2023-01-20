package com.epam.jdi.light.material.interfaces;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.utils.enums.MUIColor;

public interface HasColor extends ICoreElement {
    default MUIColor color() {
        String stylePrefix = "-color";
        String expColor = core().classLike(stylePrefix);
        if (expColor.isEmpty()) {
            return MUIColor.DEFAULT;
        }
        return MUIColor.fromStyle(expColor.split(stylePrefix)[1], stylePrefix);
    }
}
