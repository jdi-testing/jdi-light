package com.epam.jdi.light.elements.common;

import com.epam.jdi.light.asserts.generic.TextAssert;
import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.JDIBase;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.elements.interfaces.base.HasLabel;
import com.epam.jdi.light.elements.interfaces.base.SetValue;
import com.epam.jdi.light.elements.interfaces.common.IsText;

import static com.epam.jdi.light.common.Exceptions.exception;
import static com.epam.jdi.light.common.TextTypes.VALUE;
import static com.epam.jdi.light.common.Marvin.pressKeys;
import static com.epam.jdi.light.common.Marvin.setClipboard;
import static java.awt.event.KeyEvent.*;

public class Upload extends UIBaseElement<TextAssert> implements HasLabel, IsText, SetValue {
    protected String browseLocator = "input[type=file]";
    protected UIElement browse() {
        return linked(browseLocator, "browse").setup(JDIBase::noValidation);
    }
    protected String uploadLocator = "input[type=submit],button";
    protected UIElement upload() {
        return linked(uploadLocator, "upload");
    }

    // region Actions
    @JDIAction("Upload file '{0}' for '{name}'")
    public void browseFile(String path) {
        canBeUsed();
        browse().sendKeys(path);
    }
    @JDIAction("Upload file '{0}' for '{name}'")
    public void uploadFile(String path) {
        browseFile(path);
        upload().click();
    }
    @JDIAction("Upload file '{0}' for '{name}'")
    public void robotUploadFile(String path) {
        canBeUsed();
        setClipboard(path);
        browse().click();
        pressKeys(VK_CONTROL, VK_V);
        pressKeys(VK_ENTER);
        upload().click();
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

    protected void canBeUsed() {
        if (isDisabled())
            throw exception("FileInput '%s' is disabled. Can't upload file", getName());
    }
}
