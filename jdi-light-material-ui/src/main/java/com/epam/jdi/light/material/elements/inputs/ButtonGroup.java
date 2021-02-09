package com.epam.jdi.light.material.elements.inputs;

import com.epam.jdi.light.common.JDIAction;
import com.epam.jdi.light.elements.base.UIBaseElement;
import com.epam.jdi.light.material.asserts.inputs.ButtonGroupAssert;

public class ButtonGroup extends UIBaseElement<ButtonGroupAssert> {

    private static final String BUTTON_PATTERN = "//button[contains(@class, 'MuiButton-root')]";
    private static final String BUTTON_WITH_TEXT_PATTERN = BUTTON_PATTERN.concat("[span[contains(text(), '%s')]]");

    @JDIAction("Click '{name}'")
    public void click() {
        core().click();
    }

    @JDIAction("Get Button with index '{0}'")
    public Button buttonWithIndex(int index) {
        return new Button(core().finds(BUTTON_PATTERN).get(index));
    }

    @JDIAction("Get Button with text '{0}'")
    public Button buttonWithText(String text) {
        return new Button(core().find(String.format(BUTTON_WITH_TEXT_PATTERN, text)));
    }
}
