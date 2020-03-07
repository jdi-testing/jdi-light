package com.epam.jdi.light.ui.html.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.*;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.common.ElementArea.*;
import static com.epam.jdi.light.common.Exceptions.*;
import static com.epam.jdi.light.common.TextTypes.*;
import static com.epam.jdi.light.elements.common.Keyboard.*;

/**
 * Created by Roman Iovlev on 26.09.2019
 * Email: roman.iovlev.jdi@gmail.com; Skype: roman.iovlev
 */
public class FileInput extends UIBaseElement<TextAssert> implements HasLabel, IsText, SetValue {
    // region Actions
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        uiElement.sendKeys(path);
    }

    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFileWithRobot(String path, long mSec) {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
        uiElement.click(JS);
        pasteText(path, mSec);
    }
    // endregion

    // region Set and get value for Forms
    public void setValue(String value) {
        uploadFile(value);
    }
    @JDIAction("Get '{name}' file name ") @Override
    public String text() {
        return uiElement.text(VALUE);
    }
    public String getValue() {
        return text();
    }
    // endregion
    @Override
    public TextAssert is() { return new TextAssert().set(this); }
}
