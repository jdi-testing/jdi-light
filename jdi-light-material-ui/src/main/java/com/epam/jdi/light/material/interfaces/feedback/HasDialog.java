package com.epam.jdi.light.material.interfaces.feedback;

import com.epam.jdi.light.elements.interfaces.base.ICoreElement;
import com.epam.jdi.light.material.elements.feedback.Dialog;

public interface HasDialog extends ICoreElement {

    default Dialog tooltip() {
        return new Dialog(core());
    }
}
