package com.epam.jdi.light.vuetify.elements.complex;

import com.epam.jdi.light.common.JDIAction;

import static com.epam.jdi.light.common.Exceptions.exception;

public class FileInput extends TextField {

    public boolean isMultiply() {
        return textInputField().hasAttribute("multiple");
    }

    public boolean isHideInput() {
        return find("v-input__control").attr("style").contains("display: none;");
    }

    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        textInputField().getWebElement().sendKeys(path);
    }


}
